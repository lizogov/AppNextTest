package com.example.appnexttestapp

import android.os.Bundle
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ITEM_POSITION = "init-position-data"
    }

    private val viewModel: DetailsActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        observeApps()
    }

    private fun observeApps() {
        viewModel.getApps().observe(this, Observer {
            it?.let { setSectionsPagerAdapter(it) }
        })
    }



    private fun setSectionsPagerAdapter(it: List<AppModel>) {
        details_vp_container.adapter = SectionsPagerAdapter(supportFragmentManager, it)
        val startPosition = intent.getIntExtra(EXTRA_ITEM_POSITION, 0)
        details_vp_container.setCurrentItem(startPosition, false)
    }
}