package com.dicoding.naufal.mypokedex.model

import com.dicoding.naufal.mypokedex.R

data class PokemonType(
    var typeId: Int = 0,
    var typeName: String? = null,
    var typeResColor: Int = 0
)

val pokemonTypeList: List<PokemonType> = listOf(
    PokemonType(1, "Normal", R.color.colorTypeNormal),
    PokemonType(2, "Fire", R.color.colorTypeFire),
    PokemonType(3, "Water", R.color.colorTypeWater),
    PokemonType(4, "Electric", R.color.colorTypeElectric),
    PokemonType(5, "Grass", R.color.colorTypeGrass),
    PokemonType(6, "Ice", R.color.colorTypeIce),
    PokemonType(7, "Fighting", R.color.colorTypeFighting),
    PokemonType(8, "Poison", R.color.colorTypePoison),
    PokemonType(9, "Ground", R.color.colorTypeGround),
    PokemonType(10, "Flying", R.color.colorTypeFlying),
    PokemonType(11, "Psychic", R.color.colorTypePsychic),
    PokemonType(12, "Bug", R.color.colorTypeBug),
    PokemonType(13, "Rock", R.color.colorTypeRock),
    PokemonType(14, "Ghost", R.color.colorTypeGhost),
    PokemonType(15, "Dragon", R.color.colorTypeDragon),
    PokemonType(16, "Dark", R.color.colorTypeDark),
    PokemonType(17, "Steel", R.color.colorTypeSteel),
    PokemonType(18, "Fairy", R.color.colorTypeFairy)
)
