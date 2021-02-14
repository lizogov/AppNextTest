package com.example.appnexttestapp


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_applications.*


class AppsListActivity : AppCompatActivity(), OnAppClickListener {

    private lateinit var appsAdapter: AppsViewAdapter

    private val appsListViewModel: AppsListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_applications)

        initRecyclerView()
        observeState()
        observeApps()
        observerOpenDetails()
    }

    private fun initRecyclerView() {
        appsList.layoutManager = GridLayoutManager(this,3)

        // Create Movies Adapter
        appsAdapter = AppsViewAdapter(this, this)

        // Attach Adapter to RecyclerView
        appsList.adapter = appsAdapter
    }

    private fun observeState() {
        appsListViewModel.getState().observe(this, Observer {
            if (it == null) return@Observer

            logD("State: ${it.name}")
            when (it) {
                State.LOADING -> mainProgress.visibility = View.VISIBLE
                State.LOADED -> mainProgress.visibility = View.GONE
                State.ERROR -> {
                    mainProgress.visibility = View.GONE
                    Toast.makeText(this, "Something went wrong :\\", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun observeApps() {
        logD("getAppsList called")
        appsListViewModel.getAppsList().observe(this, Observer {
            appsAdapter.setData(it)
        })
    }

    private fun observerOpenDetails() {
        appsListViewModel.getOpenDetails().observe(this, Observer {
            logD("open details called")
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.EXTRA_ITEM_POSITION, it)
            startActivity(intent)
        })
    }


    override fun onAppClicked(itemPosition: Int) {
        appsListViewModel.onAppsClicked(itemPosition)
    }
}