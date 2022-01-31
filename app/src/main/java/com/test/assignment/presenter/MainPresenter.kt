package com.test.assignment.presenter

import com.test.assignment.api.API
import com.test.assignment.contract.MainContract
import com.test.assignment.model.ImageDataModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler

class MainPresenter(var view: MainContract.View, var api: API) : MainContract.Presenter {

    var page: Int = 0
    var search:String = "";
    lateinit var currentSearch: ImageDataModel

    override fun onViewInit() {
        page = 0;
        getImageDataFromAPI()
    }

    override fun getImageDataFromAPI() {
        page++
        var planetDataObserver = api.getImageDataFromAPI(search, page)

        planetDataObserver.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    currentSearch = it
                    view.getAllPhotoData(it)
                }

    }



    override fun onDestroyView() {
        /**
         * if any want to destroy when view getting destroy, use this function
         */

    }
}