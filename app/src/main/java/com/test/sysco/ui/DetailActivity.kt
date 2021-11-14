package com.test.sysco.ui

import android.os.Bundle
import com.squareup.picasso.Picasso
import com.test.sysco.R
import com.test.sysco.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    override fun setLayout(): Int {
       return R.layout.activity_detail
    }

    override fun init(savedInstanceState: Bundle?) {
        val name:String = intent.getStringExtra("name").toString()
        val orbital:String = intent.getStringExtra("orbital_period").toString()
        val gravity:String = intent.getStringExtra("gravity").toString()

        Picasso.get()
            .load("https://picsum.photos/500/700")//dummy image url
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .into(detailsImageView);
        nameTextView.text = name;
        desTextView.text = "$orbital | $gravity";
    }
}