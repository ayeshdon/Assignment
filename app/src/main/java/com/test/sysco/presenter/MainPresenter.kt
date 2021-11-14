package com.test.sysco.presenter

import com.test.sysco.contract.MainContract
import com.test.sysco.api.API
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler

class MainPresenter(var view: MainContract.View,var api: API):MainContract.Presenter{


    override fun onViewInit() {
        onLoadAllPlanetData()
    }

    override fun onLoadAllPlanetData() {
        var planetDataObserver = api.getAllPlanetFromAPI()

        planetDataObserver.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.getAllPlanetData(it.results)
            }

    }

    override fun onDestroyView() {
        /**
         * if any want to destroy when view getting destroy, use this function
         */

    }
}