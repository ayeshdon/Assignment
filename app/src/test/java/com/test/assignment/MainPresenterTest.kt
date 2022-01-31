package com.test.assignment

import com.test.assignment.contract.MainContract
import com.test.assignment.presenter.MainPresenter
import com.test.assignment.api.API
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
    presenter?.onViewInit()
  }
}