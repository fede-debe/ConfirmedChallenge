package com.example.confirmedchallenge

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.confirmedchallenge.homepage.PhotoGridAdapter
import com.example.confirmedchallenge.homepage.ProductsApiStatus
import com.example.confirmedchallenge.network.Product
import com.example.confirmedchallenge.review.ReviewApiStatus

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Product>?) {
    val adapter = recyclerView.adapter as PhotoGridAdapter
    adapter.submitList(data)
}

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("setName")
fun TextView.setNameOfProduct(item: Product?) {
    item?.let {
        text = item.name
    }

}

@BindingAdapter("setDescription")
fun TextView.setDescriptionProduct(item: Product?) {
    item?.let {
        text = item.description
    }
}

@BindingAdapter("setPrice")
fun TextView.setPriceProduct(item: Product?) {
    item?.let {
        text = item.price.toString()
    }
}

@BindingAdapter("productsApiStatus")
fun bindStatus(statusImageView: ImageView, status: ProductsApiStatus?) {
    when(status) {
        ProductsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ProductsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ProductsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("reviewApiStatus")
fun bindStatus(statusImageView: ImageView, status: ReviewApiStatus?) {
    when(status) {
        ReviewApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        ReviewApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        ReviewApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}