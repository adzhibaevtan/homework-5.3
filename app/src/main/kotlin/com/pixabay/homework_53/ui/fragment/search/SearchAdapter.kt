package com.pixabay.homework_53.ui.fragment.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.pixabay.homework_53.data.model.ImageModel

import com.pixabay.homework_53.databinding.ItemImageBinding

class SearchAdapter (var list: List<ImageModel>) : Adapter<SearchAdapter.SearchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
   holder.onBind(list.get(position))
    }

    override fun getItemCount() =list.size


    inner class SearchViewHolder(private val binding: ItemImageBinding) :ViewHolder(binding.root) {
fun onBind(image: ImageModel) {
binding.pixaImage.load(image.largeImageURL)
}
    }
}