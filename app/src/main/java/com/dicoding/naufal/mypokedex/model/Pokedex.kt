package com.dicoding.naufal.mypokedex.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Pokedex(
    @SerializedName("Pokemon")
    var pokemon: List<Pokedex.Pokemon>? = null
){
    @Parcelize
    data class Pokemon(
        @SerializedName("NationalId")
        var nationalId: Int = 0,

        @SerializedName("Name")
        var name: String? = null,

        @SerializedName("Type")
        var types: List<Int>? = null,

        @SerializedName("Height")
        var height: String? = null, //feet

        @SerializedName("Weight")
        var weight: String? = null, //lbs

        @SerializedName("Description")
        var description: String? = null,

        @SerializedName("ImageUrl")
        var imageUrl: String? = null
    ) : Parcelable
}

