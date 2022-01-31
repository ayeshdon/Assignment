package com.test.assignment.contract

import com.test.assignment.base.BasePresenter
import com.test.assignment.base.BaseView
import com.test.assignment.model.ImageDataModel

/**
 * This is the Contract interface between MainView and MainPresenter ,
 * purpose is decoupling two component
 */
interface MainContract {

    interface Presenter : BasePresenter {
        fun onViewInit()
        fun getImageDataFromAPI()
    }

    interface View : BaseView {
        fun getAllPhotoData(imageDataModel : ImageDataModel)
    }
}