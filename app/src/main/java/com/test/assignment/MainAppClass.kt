package com.test.assignment

import android.app.Application
import com.test.assignment.component.ApplicationComponent
import com.test.assignment.component.DaggerApplicationComponent
import com.test.assignment.module.NetModule

open class MainAppClass : Application() {


    lateinit var applicationComponent: ApplicationComponent


    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .netModule(NetModule())
                .build()

        applicationComponent.inject(this)
    }

}