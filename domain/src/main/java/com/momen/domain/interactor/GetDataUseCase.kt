package com.momen.domain.interactor

import com.momen.domain.executor.PostExecutionThread
import com.momen.domain.executor.ThreadExecutor
import com.momen.domain.interactor.type.UseCase
import com.momen.domain.model.DataResponse
import com.momen.domain.repository.GetHomeData
import io.reactivex.Single
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread,
    private val repository: GetHomeData
) : UseCase<ArrayList<DataResponse>, GetDataUseCase.Params>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(inputs: GetDataUseCase.Params): Single<ArrayList<DataResponse>>? =
        repository.getData(inputs.pagination)

    class Params private constructor(val pagination: Int) {
        companion object {
            fun acceptTrip(pagination: Int) = Params(pagination)
        }
    }
}