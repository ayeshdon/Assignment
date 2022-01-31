package com.test.assignment.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.test.assignment.MainAppClass
import com.test.assignment.R
import com.test.assignment.adapter.PhotoItemAdapter
import com.test.assignment.api.API
import com.test.assignment.base.BaseActivity
import com.test.assignment.contract.MainContract
import com.test.assignment.listener.PlanetItemClickListener
import com.test.assignment.model.ImageDataModel
import com.test.assignment.model.Photos
import com.test.assignment.presenter.MainPresenter
import com.test.assignment.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity() ,MainContract.View, PlanetItemClickListener {

    @Inject
    lateinit var api: API
    private lateinit var presenter:MainPresenter
    private lateinit var gridLayoutManager:GridLayoutManager
    private lateinit var adapter:PhotoItemAdapter
     private var photoList: ArrayList<Photos?> = arrayListOf()

    override fun setLayout(): Int {
        return R.layout.activity_main;
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.grid2Menu -> {
                setSpanCount(2)
                true
            }
            R.id.grid3Menu -> {
                setSpanCount(3)
                return true
            }
            R.id.grid4Menu -> {
                setSpanCount(4)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    /**
     * dynamically change grid span
     */
    private fun setSpanCount(count: Int) {
        gridLayoutManager.spanCount = count
    }

    /**
     * init references and views
     */
    override fun init(savedInstanceState: Bundle?) {
        (application as MainAppClass).applicationComponent.inject(this)

        doneButton.setOnClickListener{
            var searchTet = searchEditText.text.toString()
            presenter.search = searchTet
            photoList.clear()
            adapter.notifyDataSetChanged()
            loadFromApi()

        }
        gridLayoutManager =  GridLayoutManager(applicationContext, 2);
        photoListRecyclerView.layoutManager = gridLayoutManager
        adapter = PhotoItemAdapter(photoList, this,this)
        photoListRecyclerView.adapter = adapter


        presenter = MainPresenter(this, api)
        presenter.search = "Sri Lanka"
        loadFromApi()

    }

    /**
     * load search query with API.
     */
    private fun loadFromApi() {
        if (isNetworkAvailable()){
            showLoading()
            presenter.onViewInit()
        }else{
            loadError("No Internet")
        }
    }


    /**
     * get response data from presenter and update grid view accordingly
     */
    override fun getAllPhotoData(imageModel: ImageDataModel) {
        hideLoading()
        paginationProgressLayout.visibility = View.GONE

        photoList.addAll(imageModel.photos)
        adapter.notifyDataSetChanged()
    }

    /**
     * load pagination data
     */
    override fun onPagination() {
        if (isNetworkAvailable()){
            if (presenter.currentSearch.next_page != null) {
                paginationProgressLayout.visibility = View.VISIBLE
                presenter.getImageDataFromAPI()
            }
        }else{
            loadError("No Internet")
        }
    }

}