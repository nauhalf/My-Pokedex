package com.dicoding.naufal.mypokedex.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.naufal.mypokedex.R
import com.dicoding.naufal.mypokedex.model.PokemonType

class PokemonTypeAdapter(private val list: List<PokemonType?> = emptyList()) :
    RecyclerView.Adapter<PokemonTypeAdapter.TypeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        return TypeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pokemon_type, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        list[position]?.let { holder.bind(it) }
    }

    class TypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(p: PokemonType) {
            val chip = (itemView as TextView)
            chip.text = p.typeName
            chip.backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, p.typeResColor))
        }

    }

}