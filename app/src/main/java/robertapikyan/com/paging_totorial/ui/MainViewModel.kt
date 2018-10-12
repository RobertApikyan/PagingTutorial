package robertapikyan.com.paging_totorial.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import robertapikyan.com.paging_totorial.model.ItemModel
import robertapikyan.com.paging_totorial.paging.ModelDataSourceFactory

/*
 * Created by Robert Apikyan on 8/13/2018.
 */

class MainViewModel : ViewModel() {

    val uiList = MediatorLiveData<PagedList<ItemModel>>();

    private lateinit var pagedList: LiveData<PagedList<ItemModel>>

    private val factory = ModelDataSourceFactory()

    private val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(30)
            .setPageSize(20)
            .build()

    fun refresh() = if (::pagedList.isInitialized)
        // just refresh
        factory.dataSource.invalidate()
    else
    {
        // initialize
        pagedList = LivePagedListBuilder(factory, config).build();
        uiList.addSource(pagedList) {
            uiList.value = it
        };
    }
}