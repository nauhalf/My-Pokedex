package com.dicoding.naufal.mypokedex.utils

import com.dicoding.naufal.mypokedex.model.PokemonType
import com.dicoding.naufal.mypokedex.model.pokemonTypeList

fun <T> List<T>.getPokemonType(): List<PokemonType?> {
    return this.map {
        pokemonTypeList.find { pokemonType ->
            pokemonType.typeId == it
        }
    }
}