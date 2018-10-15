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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ItemModel

        if (id != other.id) return false
        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }


}