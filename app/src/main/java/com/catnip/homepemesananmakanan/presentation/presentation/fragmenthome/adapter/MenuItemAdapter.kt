package com.catnip.homepemesananmakanan.presentation.presentation.fragmenthome.adapter

import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.catnip.homepemesananmakanan.databinding.ItemGridMenuBinding
import com.catnip.homepemesananmakanan.databinding.ItemLinearMenuBinding
import com.catnip.homepemesananmakanan.presentation.core.ViewHolderBinder
import com.catnip.homepemesananmakanan.presentation.model.Item

class MenuItemAdapter (
    var adapterlayoutMode : LayoutMode,
    private val onClickListener: (Item)-> Unit
) : RecyclerView.Adapter<ViewHolder>() {

    private val dataDiffer = AsyncListDiffer(this, object : DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id  &&
                    oldItem.position == newItem.position &&
                    oldItem.name == newItem.name &&
                    oldItem.imgUrl == newItem.imgUrl &&
                    oldItem.harga == newItem.harga
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean{
            return oldItem.hashCode() == newItem.hashCode()
        }

    })
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when(viewType){
            LayoutMode.GRID.ordinal->{
                GridMenuItemViewHolder(
                    binding = ItemGridMenuBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), onClickListener
                )
            }

            else ->{
                LinearMenuItemViewHolder(
                    binding = ItemLinearMenuBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    ), onClickListener
                )
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as ViewHolderBinder<Item>).bind(dataDiffer.currentList[position])
    }

    override fun getItemCount(): Int = dataDiffer.currentList.size

    override fun getItemViewType(position: Int): Int {
        return adapterlayoutMode.ordinal
    }
    fun submitData(data : List<Item>){
        dataDiffer.submitList(data)
    }

    fun refreshlist() {
        notifyItemRangeChanged(0, dataDiffer.currentList.size)
    }
}