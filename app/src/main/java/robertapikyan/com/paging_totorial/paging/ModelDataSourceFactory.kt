package robertapikyan.com.paging_totorial.paging

import android.arch.paging.DataSource
import robertapikyan.com.paging_totorial.model.ItemModel

/*
 * Created by Robert Apikyan on 8/13/2018.
 */

class ModelDataSourceFactory : DataSource.Factory<Int, ItemModel>() {

    lateinit var dataSource: ModelDataSource

    override fun create(): DataSource<Int, ItemModel> {
        dataSource = ModelDataSource()
        return dataSource
    }
}