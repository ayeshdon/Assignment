package com.test.sysco.component;
import com.test.sysco.MainAppClass
import com.test.sysco.module.AppModule
import com.test.sysco.module.NetModule
import com.test.sysco.presenter.MainPresenter
import com.test.sysco.ui.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, NetModule::class])
interface ApplicationComponent {

    fun inject(mewApplication: MainAppClass)
    fun inject(act: MainActivity)
    fun inject(presenter: MainPresenter)

}