package robertapikyan.com.paging_totorial.services

import android.util.Log
import robertapikyan.com.paging_totorial.model.ItemModel

/*
 * Created by Robert Apikyan on 8/13/2018.
 */

object ApiService {

    private const val TAG = "ApiService"

    private val items = List(134) {
        ItemModel.generate(it.toLong())
    }

    fun getItems(row: Int, number: Int): List<ItemModel> {
        Log.d(TAG,"Get row $row, number $number")
        var end = row + number
        Thread.sleep(1000)
        if (end > items.size)
            end = items.size

            return items.subList(row, end)
    }
}