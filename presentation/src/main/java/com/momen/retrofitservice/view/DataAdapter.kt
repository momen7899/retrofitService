package com.momen.retrofitservice.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.momen.retrofitservice.R
import com.momen.retrofitservice.model.DataResponseModel

class DataAdapter(private val context: Context) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    private val items = ArrayList<DataResponseModel>()

    class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtView: TextView = view.findViewById(R.id.textItem)
        val imgView: ImageView = view.findViewById(R.id.imageItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.data_item, parent, false)
        )

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        with(holder) {
            txtView.text = items[position].text
            loadImage(items[position].img, imgView)
        }
    }

    override fun getItemCount(): Int = items.count()


    private fun loadImage(icon: String, img: ImageView) =
        Glide.with(context)
            .load(icon)
            .placeholder(ColorDrawable(ContextCompat.getColor(context, R.color.light)))
            .centerCrop()
            .into(img)


    @SuppressLint("NotifyDataSetChanged")
    public fun setItem(items: ArrayList<DataResponseModel>){
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }


    @SuppressLint("NotifyDataSetChanged")
    public fun addItem(items: ArrayList<DataResponseModel>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

}
