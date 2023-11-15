package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemFruitBinding
import com.squareup.picasso.Picasso

typealias OnClickFruit = (Fruit) -> Unit

class FruitAdapter (private val listFruit: List<Fruit>, private val onClickFruit: OnClickFruit) : RecyclerView.Adapter<FruitAdapter.ItemFruitViewHolder>() {

    inner class ItemFruitViewHolder (private val binding: ItemFruitBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind (data : Fruit){
            with(binding){
                fruitName.text = data.name
                fruitColor.text = data.color
                fruitBgColor.setCardBackgroundColor(data.colorCode)
                fruitTaste.text = data.taste
                Picasso.get().load(data.linkImg).into(fruitImg)
                itemView.setOnClickListener{
                    val bundle = Bundle()
                    bundle.putString("NAME", data.name)
                    bundle.putString("COLOR", data.color)
                    bundle.putString("TASTE", data.taste)
                    bundle.putInt("CODE", data.colorCode)
                    bundle.putString("LINK", data.linkImg)

                    val intent = Intent(binding.root.context, FruitDescActivity::class.java).apply { putExtras(bundle) }
                    binding.root.context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemFruitViewHolder {
        val binding = ItemFruitBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemFruitViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listFruit.size
    }

    override fun onBindViewHolder(holder: ItemFruitViewHolder, position: Int) {
        holder.bind(listFruit[position])
    }

}