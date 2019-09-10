package com.dicoding.naufal.mypokedex.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.dicoding.naufal.mypokedex.R
import com.dicoding.naufal.mypokedex.adapter.PokemonTypeAdapter
import com.dicoding.naufal.mypokedex.itemdecoration.ChipPokemonTypeItemDecoration
import com.dicoding.naufal.mypokedex.model.Pokedex
import com.dicoding.naufal.mypokedex.utils.getPokemonType
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    lateinit var pokemon: Pokedex.Pokemon
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        pokemon = intent.getParcelableExtra("pokemon")
        setUp()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUp(){

        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        txt_pokemon_name.text = pokemon.name
        txt_pokemon_height.text = pokemon.height
        txt_pokemon_weight.text = resources.getString(R.string.weight_pokemon, pokemon.weight)
        txt_description.text = pokemon.description
        Glide.with(this)
            .load(pokemon.imageUrl)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(img_pokemon)

        recycler_pokemon_type.apply {
            adapter = pokemon.types?.getPokemonType()?.let { PokemonTypeAdapter(it) }
            layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
            addItemDecoration(ChipPokemonTypeItemDecoration(3))
        }
    }
}
