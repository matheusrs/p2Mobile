package com.example.matheus.p2mobile.entities

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Drink (@SerializedName("idDrink")
                  val idDrink : Integer,
                  val strDrink : String,
                  val strCategory : String,
                  val strAlcoholic : String,
                  val strGlass : String,
                  val strInstructions : String,
                  val strDrinkThumb : String,
                  val strIngredient1 : String,
                  val strIngredient2 : String,
                  val strIngredient3 : String,
                  val strMeasure1 : String) : Serializable