package com.dicoding.naufal.mypokedex.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.dicoding.naufal.mypokedex.R
import com.dicoding.naufal.mypokedex.adapter.PokedexAdapter
import com.dicoding.naufal.mypokedex.detail.DetailActivity
import com.dicoding.naufal.mypokedex.itemdecoration.PokedexItemDecoration
import com.dicoding.naufal.mypokedex.model.Pokedex
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: PokedexAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_about -> {
                Toast.makeText(this, "Created by Naufal for Dicoding x GDK 2019", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setUp() {
        val jsonString = resources.openRawResource(R.raw.pokedex)
            .bufferedReader().use { it.readText() }
        val pokedex = Gson().fromJson(jsonString, Pokedex::class.java)
        adapter = PokedexAdapter().apply {
            listener = {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra("pokemon", it)
                startActivity(intent)
            }
        }
        pokedex.pokemon?.let { adapter.setPokemonList(it) }
        recycler_pokedex.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = this@MainActivity.adapter
            addItemDecoration(PokedexItemDecoration(16))
        }
    }
}
