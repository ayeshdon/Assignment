package com.test.assignment.component;
import com.test.assignment.MainAppClass
import com.test.assignment.module.AppModule
import com.test.assignment.module.NetModule
import com.test.assignment.presenter.MainPresenter
import com.test.assignment.ui.MainActivity
import dagger.Component

@Component(modules = [AppModule::class, NetModule::class])
interface ApplicationComponent {

    fun inject(mewApplication: MainAppClass)
    fun inject(act: MainActivity)
    fun inject(presenter: MainPresenter)

}