package com.momen.retrofitservice.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.momen.domain.interactor.GetDataUseCase
import com.momen.retrofitservice.model.DataMapper
import com.momen.retrofitservice.model.DataResponseModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class HomeViewModel(
    private val useCase: GetDataUseCase,
    private val mapper: DataMapper
) : ViewModel() {
    val liveData = MutableLiveData<Result>()
    private val disposables = CompositeDisposable()
    private var result: Result? = null
    private var currentPage = 1
    private var lastPage: Int = 0

    fun getBookmarks() {
        result = Result(null, State.LOADING_DATA, null)
        liveData.value = result

        val params = GetDataUseCase.Params.forGetData(1)
        val d: Disposable? = useCase.execute(params)
            ?.subscribe(
                { data ->
                    result = Result(
                        mapper.transform(data),
                        State.DATA_LOADED,
                        null
                    )
                    liveData.value = result
                },
                {
                    result = Result(null, State.LOAD_ERROR, it.message)
                    liveData.value = result
                }
            )
        d?.let { disposables.add(it) }
    }

    fun loadMorePage() {
        if (isMoreDataAvailable()) {
            val params = GetDataUseCase.Params.forGetData(++currentPage)
            val d: Disposable? = useCase.execute(params)
                ?.subscribe(
                    { data ->
                        result = Result(
                            mapper.transform(data),
                            State.MORE_DATA_LOADED,
                            null
                        )
                        liveData.value = result
                    },
                    {
                        result = Result(
                            null,
                            State.LOAD_MORE_ERROR,
                            it.message
                        )
                        liveData.value = result
                    }
                )
            d?.let { disposables.add(it) }
        }
    }

    private fun isMoreDataAvailable() = lastPage > currentPage


    data class Result(
        var data: ArrayList<DataResponseModel>?,
        var state: State,
        var error: String?
    )

    enum class State {
        LOADING_DATA,
        DATA_LOADED,
        MORE_DATA_LOADED,
        LOAD_ERROR,
        LOAD_MORE_ERROR
    }

}