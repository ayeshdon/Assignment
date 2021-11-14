package com.test.sysco.contract

import com.test.sysco.base.BasePresenter
import com.test.sysco.base.BaseView
import com.test.sysco.model.Result

/**
 * This is the Contract interface between MainView and MainPresenter ,
 * purpose is decoupling two component
 */
interface MainContract {

    interface Presenter : BasePresenter {
        fun onViewInit()
        fun onLoadAllPlanetData()
    }

    interface View : BaseView {
        fun getAllPlanetData(planetList : List<Result>)
    }
}