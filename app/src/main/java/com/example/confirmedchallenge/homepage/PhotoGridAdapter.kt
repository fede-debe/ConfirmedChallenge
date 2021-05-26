package com.example.confirmedchallenge.homepage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.confirmedchallenge.databinding.GridProductItemBinding
import com.example.confirmedchallenge.network.Product

class PhotoGridAdapter(private val onClickListener: OnClickListener) : ListAdapter<Product, PhotoGridAdapter.ProductListViewHolder>(DiffCallback) {
    class ProductListViewHolder(private var binding: GridProductItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(productItem: Product) {
            binding.product = productItem
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        return ProductListViewHolder(GridProductItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val productItem = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(productItem)
        }
        holder.bind(productItem)
    }

    class OnClickListener(val clickListener: (productItem: Product) -> Unit) {
        fun onClick(productItem:Product) = clickListener(productItem)
    }

}