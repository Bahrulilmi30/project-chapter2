package com.catnip.homepemesananmakanan.presentation.presentation.fragmenthome.adapter

import android.content.ClipData.Item
import android.view.View.OnClickListener
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.catnip.homepemesananmakanan.databinding.ItemGridMenuBinding
import com.catnip.homepemesananmakanan.databinding.ItemLinearMenuBinding
import com.catnip.homepemesananmakanan.presentation.core.ViewHolderBinder

class LinearMenuItemViewHolder(
    private val binding : ItemLinearMenuBinding,
    private val onClickListener: (com.catnip.homepemesananmakanan.presentation.model.Item)->Unit
) : RecyclerView.ViewHolder(binding.root),ViewHolderBinder<com.catnip.homepemesananmakanan.presentation.model.Item>{
    override fun bind(item: com.catnip.homepemesananmakanan.presentation.model.Item) {
        binding.ivPictMenu.load(item.imgUrl)
        binding.tvTextMenu.text = item.name
        binding.tvHargaMenu.text = item.harga
        binding.root.setOnClickListener{
            onClickListener.invoke(item)
        }
    }
}

class GridMenuItemViewHolder(
    private val binding : ItemGridMenuBinding,
    private val onClickListener: (com.catnip.homepemesananmakanan.presentation.model.Item)->Unit
) : RecyclerView.ViewHolder(binding.root),ViewHolderBinder<com.catnip.homepemesananmakanan.presentation.model.Item>{
    override fun bind(item: com.catnip.homepemesananmakanan.presentation.model.Item) {
        binding.ivPictMenu.load(item.imgUrl)
        binding.tvTextMenu.text = item.name
        binding.tvHargaMenu.text = item.harga
        binding.root.setOnClickListener{
            onClickListener.invoke(item)
        }
    }
}