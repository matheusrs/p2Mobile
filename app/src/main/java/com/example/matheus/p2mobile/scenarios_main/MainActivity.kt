package com.example.matheus.p2mobile.scenarios_main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.Toast
import com.example.matheus.p2mobile.R
import com.example.matheus.p2mobile.entities.Drink
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, DrinkListFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter : MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList()

    }

    override fun showList(drinks: List<Drink>) {

        val fragmentDrinkList = DrinkListFragment.newInstance(drinks as ArrayList<Drink>)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fmMaster, fragmentDrinkList)
            .commit()

    }

    override fun onFragmentInteraction(drink: Drink) {
        val fragmentDetail = DrinkDetailFragment.newInstance(drink)

        if(fmDetail != null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fmDetail, fragmentDetail)
                .commit()
        }else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fmMaster, fragmentDetail)
                .addToBackStack(null)
                .commit()
        }

    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        pbLoading.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = ProgressBar.INVISIBLE
    }

}
