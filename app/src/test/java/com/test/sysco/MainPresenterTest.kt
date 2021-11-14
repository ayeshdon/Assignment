package com.test.sysco

import com.test.sysco.contract.MainContract
import com.test.sysco.presenter.MainPresenter
import com.test.sysco.api.API
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainPresenterTest{

  @Mock
  private lateinit var mockMainActivity: MainContract.View

  @Mock
  lateinit var api: API

  private var presenter: MainPresenter? = null

  @Before
  fun setUp() {
    MockitoAnnotations.initMocks(this)

    presenter = MainPresenter(mockMainActivity, api)
  }

  @After
  fun tearDown() {
    presenter?.onDestroyView()
  }

  @Test
  fun testOnViewCreatedFlow() {
//    presenter?.onViewInit()
  }
}