package com.example.matheus.p2mobile.scenarios_main

import com.example.matheus.p2mobile.entities.DrinkList
import com.example.matheus.p2mobile.network.RetrofitInicializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view : MainContract.View) : MainContract.Presenter {

    override fun onLoadList(){

        view.showLoading()

        val drinksService = RetrofitInicializer().createDrinkService()

        val call = drinksService.searchDrink("")

        call.enqueue(object : Callback<DrinkList> {
            override fun onFailure(call: Call<DrinkList>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<DrinkList>, response: Response<DrinkList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showList(response.body()!!.drinks)
                }else {
                    view.showMessage("Sem drinks")
                }
            }
        })

    }

}