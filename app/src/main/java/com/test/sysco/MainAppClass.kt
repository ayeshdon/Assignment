package com.test.sysco

import android.app.Application
import com.test.sysco.component.ApplicationComponent
import com.test.sysco.component.DaggerApplicationComponent
import com.test.sysco.module.NetModule

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