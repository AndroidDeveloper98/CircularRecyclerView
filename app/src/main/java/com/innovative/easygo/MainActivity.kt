package com.innovative.easygo

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.tabs.TabLayout
import com.innovative.easygo.databinding.ActivityMainBinding
import com.innovative.easygo.databinding.OptionBottomSheetBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mContext: Context
    private var mAdapter: StudentGoListAdapter? = null
    private var mTaskListAdapter: MyTaskListAdapter? = null
    private var optionBottomSheetBottomSheetDialog: BottomSheetDialog? = null
    private var optionBottomSheetBinding: OptionBottomSheetBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mContext = this
        initSetup()
    }

    private fun initSetup() {
        val list: ArrayList<StudentGoData> = ArrayList()
        list.add(StudentGoData("Sleep","6.5 hours",50))
        list.add(StudentGoData("Computer","9.7 hours",60))
        list.add(StudentGoData("Workout","1.3 hours",30))
        initStudentGORecyclerView(list)
        tabLayout()

        binding.fabOption.setOnClickListener {
            openOptionBottomSheetBinding()
        }
    }


    private fun initStudentGORecyclerView(it: ArrayList<StudentGoData>) {
        mAdapter = StudentGoListAdapter(mContext, it)
        /*binding.rvStudentGoList.apply {
            layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter
        }*/
        binding.rvStudentGoList.apply {
            layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
            adapter = mAdapter
        }
        mAdapter?.setOnClickListener(object : StudentGoListAdapter.OnClickListener {
            override fun onClick(
                position: Int
            ) {

            }
        })
    }

    private fun initMyTaskRecyclerView(it: ArrayList<StudentGoData>) {
        mTaskListAdapter = MyTaskListAdapter(mContext, it)
        binding.rvTabList.apply {
            layoutManager = GridLayoutManager(mContext, 2)
            adapter = mTaskListAdapter
        }
        mTaskListAdapter?.setOnClickListener(object : MyTaskListAdapter.OnClickListener {
            override fun onClick(
                position: Int
            ) {

            }
        })
    }


    private fun initBottomOptionRecyclerView(it: ArrayList<StudentGoData>) {
        val mTaskListAdapter = OptionListAdapter(mContext, it)
        optionBottomSheetBinding?.rvList?.apply {
            layoutManager = CircleLayoutManager(mContext)
            adapter = mTaskListAdapter
        }
        mTaskListAdapter?.setOnClickListener(object : OptionListAdapter.OnClickListener {
            override fun onClick(
                position: Int
            ) {

            }
        })
    }

    private fun tabLayout() {

        val list: ArrayList<StudentGoData> = ArrayList()
        list.add(StudentGoData("Sleep","6.5 hours",50))
        list.add(StudentGoData("Computer","9.7 hours",60))
        list.add(StudentGoData("Workout","1.3 hours",30))
        initMyTaskRecyclerView(list)

        binding.tabLayout.addTab(
            binding.tabLayout.newTab().setText("My Tasks")
        )
        binding.tabLayout.addTab(
            binding.tabLayout.newTab().setText("Habits")
        )
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 -> {
                        val list: ArrayList<StudentGoData> = ArrayList()
                        list.add(StudentGoData("Sleep","6.5 hours",50))
                        list.add(StudentGoData("Computer","9.7 hours",60))
                        list.add(StudentGoData("Workout","1.3 hours",30))
                        initMyTaskRecyclerView(list)
                    }
                    1 -> {
                        val list: ArrayList<StudentGoData> = ArrayList()
                        initMyTaskRecyclerView(list)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }


    private fun openOptionBottomSheetBinding() {
        try {
            optionBottomSheetBottomSheetDialog =
                BottomSheetDialog(mContext, R.style.AppBottomSheetDialogTheme)
            optionBottomSheetBinding =
                OptionBottomSheetBinding.inflate(layoutInflater)
            optionBottomSheetBinding?.root?.let {
                optionBottomSheetBottomSheetDialog?.setContentView(
                    it
                )
            }

            val list: ArrayList<StudentGoData> = ArrayList()
            list.add(StudentGoData("Sleep","6.5 hours",50))
            list.add(StudentGoData("Computer","9.7 hours",60))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            list.add(StudentGoData("Workout","1.3 hours",30))
            initBottomOptionRecyclerView(list)

            optionBottomSheetBottomSheetDialog?.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}