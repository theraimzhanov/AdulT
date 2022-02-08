package com.raimzhanov.adult.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raimzhanov.adult.R
import com.raimzhanov.adult.domain.AdultAdapter
import com.raimzhanov.adult.domain.MainViewModel

class MainActivity : AppCompatActivity() {

private lateinit var viewModel: MainViewModel
private lateinit var adultAdapter: AdultAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.adultList.observe(this){
adultAdapter.submitList(it)
        }
    }
    private fun setUpRecyclerView(){
      val adultRecyclerView = findViewById<RecyclerView>(R.id.recyclerViewAdultList)
with(adultRecyclerView){
adultAdapter = AdultAdapter()
    layoutManager = LinearLayoutManager(this@MainActivity)
adapter = adultAdapter
recycledViewPool.setMaxRecycledViews(
AdultAdapter.VIEW_TYPE_JUNIOR,
    AdultAdapter.MAX_POOL_SIZE
)
    recycledViewPool.setMaxRecycledViews(
        AdultAdapter.VIEW_TYPE_MIDDLE,
        AdultAdapter.MAX_POOL_SIZE
    )
    recycledViewPool.setMaxRecycledViews(
        AdultAdapter.VIEW_TYPE_SENIOR,
        AdultAdapter.MAX_POOL_SIZE
    )
}
        setUpOnClickListener()
        setupClickListener()
        setupSwipeListener(adultRecyclerView)
    }

    private fun setupSwipeListener(recyclerView: RecyclerView) {
val callBack =object: ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
       return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
      val adult =adultAdapter.currentList[viewHolder.adapterPosition]
viewModel.deleteAdultItem(adult)
    }
}
        val itemTouchHelper = ItemTouchHelper(callBack)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun setupClickListener() {
adultAdapter.onAdultItemClickListener={

}
    }

    private fun setUpOnClickListener() {
        adultAdapter.onAdultItemLongListener={
Toast.makeText(this,"LIKE",Toast.LENGTH_SHORT).show()
        }
    }

}