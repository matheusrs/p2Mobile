package com.example.matheus.p2mobile.scenarios_main

import com.example.matheus.p2mobile.entities.Drink

interface MainContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(drinks: List<Drink>)
        fun showLoading()
        fun hideLoading()
    }

    interface Presenter {
        fun onLoadList()
    }

}