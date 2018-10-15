package robertapikyan.com.paging_totorial.paging

import android.arch.paging.PositionalDataSource
import android.util.Log
import robertapikyan.com.paging_totorial.model.ItemModel
import robertapikyan.com.paging_totorial.services.ApiService

/*
 * Created by Robert Apikyan on 8/13/2018.
 */

class ModelDataSource : PositionalDataSource<ItemModel>() {

    companion object {
        const val TAG = "ModelDataSource";
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<ItemModel>) {
        Log.d("paging","ModelDataSource:loadRange startPosition= ${params.startPosition} loadSize= ${params.loadSize}")
        val items = ApiService.getItems(params.startPosition, params.loadSize)
        callback.onResult(items)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<ItemModel>) {
        Log.d("paging","ModelDataSource:loadInitial startPosition= ${params.requestedStartPosition} loadSize= ${params.pageSize}")
        // sometimes params.requestedStartPosition value is 9, that's why we replaced params.requestedStartPosition with 0
        val items = ApiService.getItems(0, params.pageSize) // *here changed params.requestedStartPosition to 0
        callback.onResult(items,0)// *and here changed params.requestedStartPosition to 0
    }
}