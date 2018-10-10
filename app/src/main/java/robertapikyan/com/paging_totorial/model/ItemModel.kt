package robertapikyan.com.paging_totorial.model

/*
 * Created by Robert Apikyan on 8/13/2018.
 */

class ItemModel(
        val id: Long = -1,
        val name: String = ""
) {
    companion object {
        fun generate(id: Long) = ItemModel(id, System.nanoTime().toString())
    }
}