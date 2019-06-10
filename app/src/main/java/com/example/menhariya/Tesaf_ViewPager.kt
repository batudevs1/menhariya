package com.example.menhariya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.viewpager.view.*

class Tesaf_ViewPager:Fragment() {
    var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.tesafari_viewpager, container, false)
        tabLayout=view.tabLayout
        viewPager=view.viewPager

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Ticket"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("View"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Search"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL


        return view
    }
}