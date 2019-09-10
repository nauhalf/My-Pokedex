package com.dicoding.naufal.mypokedex.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dicoding.naufal.mypokedex.itemdecoration.ChipPokemonTypeItemDecoration
import com.dicoding.naufal.mypokedex.R
import com.dicoding.naufal.mypokedex.model.Pokedex
import com.dicoding.naufal.mypokedex.utils.getPokemonType

class PokedexAdapter : RecyclerView.Adapter<PokedexAdapter.PokemonViewHolder>(){
    private var list: List<Pokedex.Pokemon> = emptyList()
    var listener: ((Pokedex.Pokemon) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_pokemon, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(list[position])
    }

    internal fun setPokemonList(listPokemon: List<Pokedex.Pokemon>){
        this.list = listPokemon
        notifyDataSetChanged()
    }

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val txtNationalId = itemView.findViewById<TextView>(R.id.txt_national_id)
        private val txtPokemonName = itemView.findViewById<TextView>(R.id.txt_pokemon_name)
        private val imgPokemon = itemView.findViewById<ImageView>(R.id.img_pokemon_image)
        private val recyclerView = itemView.findViewById<RecyclerView>(R.id.recycler_pokemon_type)
        fun bind(p : Pokedex.Pokemon) {
            txtNationalId.text = itemView.resources.getString(R.string.national_id, p.nationalId)
            txtPokemonName.text = p.name
            Glide.with(itemView.context)
                .load(p.imageUrl)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(imgPokemon)
            recyclerView.apply {
                adapter = p.types?.getPokemonType()?.let {
                    PokemonTypeAdapter(
                        it
                    )
                }
                layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
                addItemDecoration(ChipPokemonTypeItemDecoration(2))
            }

            itemView.setOnClickListener {
                listener?.let { it1 -> it1(p) }
            }
        }
    }
}