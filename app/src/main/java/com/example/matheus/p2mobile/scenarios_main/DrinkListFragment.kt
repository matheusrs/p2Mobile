package com.example.matheus.p2mobile.scenarios_main

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.matheus.p2mobile.R
import com.example.matheus.p2mobile.entities.Drink
import kotlinx.android.synthetic.main.fragment_drink_list.*
import java.lang.NullPointerException
import java.lang.RuntimeException

class DrinkListFragment : Fragment() {

    companion object {

        private val ARG_LIST = "arg_list"

        fun newInstance(list: ArrayList<Drink>) =
            DrinkListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_LIST, list)
                }
            }
    }

    var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_drink_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val drinks = getDrinkList()

        activity?.let{ that ->
            val adapter = DrinkAdapter(that, drinks)
            adapter.setOnItemClickListener {position ->
                listener?.onFragmentInteraction(drinks[position])
            }

            

            rvDrinks.adapter = adapter
            rvDrinks.layoutManager = LinearLayoutManager(that)

        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if(context is DrinkListFragment.OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement NewsListFragment.OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun getDrinkList(): ArrayList<Drink>{
        val drinks = arguments?.getSerializable(ARG_LIST) as ArrayList<Drink>?
        if(drinks == null){
            throw NullPointerException("Articles list can not be null")
        }

        return drinks
    }

    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(drink: Drink)
    }

}
