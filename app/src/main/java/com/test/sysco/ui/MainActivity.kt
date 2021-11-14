package com.test.sysco.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.test.sysco.MainAppClass
import com.test.sysco.R
import com.test.sysco.adapter.PlanetItemAdapter
import com.test.sysco.base.BaseActivity
import com.test.sysco.contract.MainContract
import com.test.sysco.listener.PlanetItemClickListener
import com.test.sysco.model.Result
import com.test.sysco.presenter.MainPresenter
import com.test.sysco.api.API
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() ,MainContract.View, PlanetItemClickListener {

    @Inject
    lateinit var api: API
    private lateinit var presenter:MainPresenter

    override fun setLayout(): Int {
        return R.layout.activity_main;
    }

    override fun init(savedInstanceState: Bundle?) {
        (application as MainAppClass).applicationComponent.inject(this)
        presenter = MainPresenter(this,api)
        if (isNetworkAvailable()){
            showLoading()
            presenter.onViewInit()
        }else{
            loadError("No Internet")
        }

    }

    override fun getAllPlanetData(planetList: List<Result>) {
        hideLoading()
        var linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        planetListRecyclerView.layoutManager = linearLayoutManager
        var adapter = PlanetItemAdapter(planetList, this,this)
        planetListRecyclerView.adapter = adapter
    }

    override fun onPostItemClick(planetItem: Result) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("name", planetItem.name)
        intent.putExtra("orbital_period", planetItem.orbitalPeriod)
        intent.putExtra("gravity", planetItem.gravity)
        startActivity(intent)
    }


}