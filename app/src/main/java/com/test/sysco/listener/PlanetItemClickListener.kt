package com.test.sysco.listener

import com.test.sysco.model.Result


interface PlanetItemClickListener {
    fun onPostItemClick(planetItem: Result)
}