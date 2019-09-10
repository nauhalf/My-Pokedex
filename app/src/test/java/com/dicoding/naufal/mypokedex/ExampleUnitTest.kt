package com.dicoding.naufal.mypokedex

import com.dicoding.naufal.mypokedex.model.Pokedex
import com.dicoding.naufal.mypokedex.model.pokemonTypeList
import com.dicoding.naufal.mypokedex.utils.getPokemonType
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun checkFunctionalUtilsGetPokemonType(){
        val pokemon = Pokedex.Pokemon(1, "A", listOf(1, 2), "", "", "", "")
        val pokemonType = pokemon.types?.getPokemonType()

        assertArrayEquals(pokemonTypeList.filter { it.typeId == 1 || it.typeId == 2 }.toTypedArray(), pokemonType?.toTypedArray())
    }
}
