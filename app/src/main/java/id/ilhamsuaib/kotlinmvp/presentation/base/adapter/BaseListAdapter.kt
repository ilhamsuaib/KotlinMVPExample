package id.ilhamsuaib.kotlinmvp.presentation.base.adapter

import android.content.Context
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by ilham on 10/14/17.
 */
abstract class BaseListAdapter<T: Parcelable> : RecyclerView.Adapter<BaseListAdapter<T>.ViewHolder>() {

    private var items = ArrayList<T>()

    abstract fun getListItemView(context: Context) : BaseViewHolder<T>

    fun clearItem(){
        items.clear()
        notifyItemRangeRemoved(0, items.size)
    }

    fun addItems(itemsToAdd: List<T>){
        items.addAll(itemsToAdd)
        notifyItemRangeInserted(0, itemsToAdd.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(getListItemView(parent.context))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.view.bind(items[position])

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val view: BaseViewHolder<T>) : RecyclerView.ViewHolder(view)

}