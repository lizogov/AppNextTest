package com.example.appnexttestapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels


import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_details.*


class DetailsFragment : Fragment() {
    private var appModel: AppModel? = null
    private val picasso = Picasso.get()
    private val activityViewModel: DetailsActivityViewModel by viewModels()


    companion object {

        private val ARG_APP = "MovieModel-data"

        fun newInstance(appModel: AppModel): DetailsFragment {
            val fragment = DetailsFragment()
            val args = Bundle()
            args.putParcelable(ARG_APP, appModel)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        appModel = arguments?.getParcelable(ARG_APP)
        logD("movieModel: " + appModel!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        setClickListeners()
        setApp()
    }



    private fun setApp() {
        appModel?.let {
            picasso.load(it.icon).into(details_app_icon)
            details_app_title.text = it.title
            details_app_developer.text = it.developer
            details_app_description_text.text = it.description
        }
    }



}
