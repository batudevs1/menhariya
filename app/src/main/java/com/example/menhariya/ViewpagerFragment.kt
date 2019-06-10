package com.example.menhariya

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.viewpager.view.*

class ViewpagerFragment:Fragment() {
     var tabLayout: TabLayout? = null
    var viewPager: ViewPager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view= inflater.inflate(R.layout.viewpager, container, false)
         tabLayout=view.tabLayout
         viewPager=view.viewPager

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Add Ticket"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("View"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("Movie"))
        tabLayout!!.tabGravity = TabLayout.GRAVITY_FILL


        return view
    }
}