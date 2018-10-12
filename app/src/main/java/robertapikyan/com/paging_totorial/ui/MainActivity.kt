package robertapikyan.com.paging_totorial.ui

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import robertapikyan.com.paging_totorial.R

class MainActivity : AppCompatActivity() {

    val pagedAdapter = ItemsAdapter()

    lateinit var viewModel: MainViewModel

    val rv  by lazy { findViewById<RecyclerView>(R.id.rv) }
    val srl by lazy { findViewById<SwipeRefreshLayout>(R.id.srl) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this)[MainViewModel::class.java]

        rv.layoutManager = LinearLayoutManager(this)

        rv.adapter = pagedAdapter

        srl.setOnRefreshListener {
            viewModel.refresh()
        }

        viewModel.uiList.observe(this, Observer{
            srl.isRefreshing = false
            pagedAdapter.submitList(it)
        })

        getInitialData()
    }

    // First data load
    private fun getInitialData() {
        srl.isRefreshing = true
        viewModel.refresh()
    }
}
