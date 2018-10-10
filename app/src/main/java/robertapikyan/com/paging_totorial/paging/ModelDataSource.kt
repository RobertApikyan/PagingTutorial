package robertapikyan.com.paging_totorial.paging

import android.arch.paging.PositionalDataSource
import android.util.Log
import robertapikyan.com.paging_totorial.model.ItemModel
import robertapikyan.com.paging_totorial.services.ApiService

/*
 * Created by Robert Apikyan on 8/13/2018.
 */

class ModelDataSource : PositionalDataSource<ItemModel>() {

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ItemModel>) {
        Log.d("paging","ModelDataSource:loadRange ")
        val items = ApiService.getItems(params.startPosition, params.loadSize)
        callback.onResult(items)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<ItemModel>) {
        Log.d("paging","ModelDataSource:loadInitial ")
        val items = ApiService.getItems(params.requestedStartPosition, params.pageSize)
        callback.onResult(items,params.requestedStartPosition)
    }
}