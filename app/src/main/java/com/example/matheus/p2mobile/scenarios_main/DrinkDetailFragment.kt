package com.example.matheus.p2mobile.scenarios_main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.matheus.p2mobile.R
import com.example.matheus.p2mobile.entities.Drink
import com.example.matheus.p2mobile.utils.GlideApp
import kotlinx.android.synthetic.main.fragment_drink_detail.*
import java.lang.NullPointerException

class DrinkDetailFragment : Fragment() {

    companion object {
        private val ARG_DRINK = "arg_drink"

        fun newInstance(drink: Drink) =
            DrinkDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_DRINK, drink)
                }
            }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drink = getDrink()

        activity?.let {that ->
            GlideApp.with(that)
                .load(drink.strDrinkThumb)
                .placeholder(R.drawable.no_image)
                .centerCrop()
                .into(imgDrink)
        }


        txStrDrink.text = drink.strDrink
        txStrCategory.text = drink.strCategory
        txStrAlcoholic.text = drink.strAlcoholic
        txStrGlass.text = drink.strGlass
        txStrInstructions.text = drink.strInstructions
        txStrIngredient1.text = drink.strIngredient1
        txStrIngredient2.text = drink.strIngredient2
        txStrIngredient3.text = drink.strIngredient3
        txStrMeasure1.text = drink.strMeasure1
    }

    fun getDrink(): Drink{
        val drink = arguments?.getSerializable(ARG_DRINK) as Drink?
        if(drink == null){
            throw NullPointerException("Drink can not be null")
        }

        return drink
    }


}
