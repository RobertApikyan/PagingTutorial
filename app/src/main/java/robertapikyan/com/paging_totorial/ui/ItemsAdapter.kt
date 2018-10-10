package robertapikyan.com.paging_totorial.ui

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import robertapikyan.com.paging_totorial.R
import robertapikyan.com.paging_totorial.model.ItemModel

/*
 * Created by Robert Apikyan on 8/13/2018.
 */

class ItemsAdapter : PagedListAdapter<ItemModel, ItemsAdapter.ViewHolder>(REPO_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder.create(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.onBind(item)
        }
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val idTv = itemView?.findViewById<TextView>(R.id.idTv)
        val nameTv = itemView?.findViewById<TextView>(R.id.nameTv)

        fun onBind(model: ItemModel) {
            idTv?.text = model.id.toString()
            nameTv?.text = model.name
        }

        companion object {
            fun create(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_model, parent, false)
                return ViewHolder(view)
            }
        }
    }

    companion object {
        private val REPO_COMPARATOR = object : DiffUtil.ItemCallback<ItemModel>() {
            override fun areItemsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean =
                    oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ItemModel, newItem: ItemModel): Boolean =
                    oldItem == newItem
        }
    }
}