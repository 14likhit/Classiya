package com.likhit.classiya.ui.home

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.RadioButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.likhit.classiya.R
import com.likhit.classiya.adapter.ClassListRecyclerAdapter
import com.likhit.classiya.base.BaseActivity
import com.likhit.classiya.data.Classe
import com.likhit.classiya.databinding.ActivityHomeBinding
import com.likhit.classiya.viewmodel.ClassViewModel
import com.likhit.classiya.viewmodelfactory.ClassViewModelFactory


/**
 * Main Home Activity to show drawer item and list fo classes.
 */
class HomeActivity : BaseActivity(), AdapterView.OnItemSelectedListener,
    DatePickerDialog.OnDateSetListener {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var adapter: ClassListRecyclerAdapter
    private var listClass = mutableListOf<Classe>()
    private var listSubject = mutableListOf<String>()
    private var subjectSelected: String? = null

    private lateinit var classViewModel: ClassViewModel
    private lateinit var classViewModelFactory: ClassViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        classViewModelFactory = ClassViewModelFactory()
        classViewModel =
            ViewModelProvider(this, classViewModelFactory).get(ClassViewModel::class.java)

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

        setObservers()

        initView()

    }

    private fun setObservers() {
        classViewModel.getClassList().observe(this, Observer {
            if (it != null) {
                listClass = it as MutableList<Classe>
                updateFilterList()
            }
        })
        classViewModel.getSubjectList().observe(this, Observer {
            if (it != null) {
                listSubject = it as MutableList<String>
                setDropDownItems()
                classViewModel.getClasses()
            }
        })
    }

    /**
     * Method to initiate view
     */
    private fun initView() {

        adapter = ClassListRecyclerAdapter()

        binding.homeContentLayout.classListRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.homeContentLayout.classListRecyclerView.adapter = adapter

        classViewModel.getSubjects()

        val datePickerDialog = DatePickerDialog(this, this, 2020, 2, 1)

        binding.homeContentLayout.dateRangeSelectCard.containerCardView.setOnClickListener { datePickerDialog.show() }
    }

    /**
     * Method to set Drop down items.
     */
    private fun setDropDownItems() {
        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listSubject)
        arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice)

        binding.homeContentLayout.classSelectCard.cardSpinner.adapter = arrayAdapter

        binding.homeContentLayout.classSelectCard.cardSpinner.onItemSelectedListener = this
        val menu = binding.homeNavigationView.menu
        setMenuListener(menu)
    }

    /**
     * Methods to set listeners for drawer items.
     */
    private fun setMenuListener(menu: Menu) {
        val actionView = menu.findItem(R.id.menu_radios).actionView
        actionView.findViewById<AppCompatImageView>(R.id.cancel_button)
            .setOnClickListener {
                showMessage("option cancel selected")
                closeDrawer()
            }
        actionView.findViewById<RadioButton>(R.id.option_zero_radio)
            .setOnClickListener {
                showMessage("option zero selected")
                closeDrawer()
            }
        actionView.findViewById<RadioButton>(R.id.option_one_radio)
            .setOnClickListener {
                showMessage("option one selected")
                closeDrawer()
            }
        actionView.findViewById<RadioButton>(R.id.option_two_radio)
            .setOnClickListener {
                showMessage("option two selected")
                closeDrawer()
            }
        actionView.findViewById<RadioButton>(R.id.option_three_radio)
            .setOnClickListener {
                showMessage("option three selected")
                closeDrawer()
            }
        actionView.findViewById<RadioButton>(R.id.option_four_radio)
            .setOnClickListener {
                showMessage("option four selected")
                closeDrawer()
            }
        actionView.findViewById<RadioButton>(R.id.option_five_radio)
            .setOnClickListener {
                showMessage("option five selected")
                closeDrawer()
            }
        actionView.findViewById<RadioButton>(R.id.option_six_radio)
            .setOnClickListener {
                showMessage("option six selected")
                closeDrawer()
            }
        actionView.findViewById<RadioButton>(R.id.option_seven_radio)
            .setOnClickListener {
                showMessage("option seven selected")
                closeDrawer()
            }
        actionView.findViewById<RadioButton>(R.id.option_eight_radio)
            .setOnClickListener {
                showMessage("option eight selected")
                closeDrawer()
            }

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
            closeDrawer()
        } else {
            super.onBackPressed()
        }
    }

    /**
     * Method to close drawers
     */
    private fun closeDrawer() {
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    /**
     * OnItemSelected listener for drawer item.
     */
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        showMessage(listSubject[p2] + " Selected")
        subjectSelected = listSubject[p2]
        updateFilterList()
    }

    /**
     * Method to updated filter list
     */
    private fun updateFilterList() {
        val filteredList = mutableListOf<Classe>()
        if (listClass.size > 0) {
            for (i in 0 until listClass.size) {
                if (listClass[i].className == subjectSelected) {
                    filteredList.add(listClass[i])
                }
            }
        }
        adapter.listClass = filteredList
        adapter.notifyDataSetChanged()
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        showMessage("DateSelected: " + p3 + "/" + p2)
    }
}