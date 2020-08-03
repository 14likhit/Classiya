package com.likhit.classiya.ui.home

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.likhit.classiya.R
import com.likhit.classiya.adapter.ClassListRecyclerAdapter
import com.likhit.classiya.base.BaseActivity
import com.likhit.classiya.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var adapter: ClassListRecyclerAdapter
    private var listClass = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        setupToolbar(getString(R.string.app_name), false)

        val drawerToggle =
            ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.homeToolbar.toolbar,
                R.string.open,
                R.string.close
            )
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        initView()

    }


    private fun initView() {

        adapter = ClassListRecyclerAdapter()

        listClass = mutableListOf()
        listClass.add("Science")
        listClass.add("Math")
        listClass.add("English")
        listClass.add("Science")
        listClass.add("Math")
        listClass.add("English")

        adapter.listClass = listClass

        binding.homeContentLayout.classListRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.homeContentLayout.classListRecyclerView.adapter = adapter

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listClass)
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice)

        binding.homeContentLayout.classSelectCard.cardSpinner.adapter = arrayAdapter

        binding.homeContentLayout.classSelectCard.cardSpinner.onItemSelectedListener = this
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        showMessage("Item Selected")
    }
}