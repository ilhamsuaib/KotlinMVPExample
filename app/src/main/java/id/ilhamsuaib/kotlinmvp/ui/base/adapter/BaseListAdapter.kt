package id.ilhamsuaib.kotlinmvp.ui.base.adapter

import android.content.Context
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by ilham on 10/14/17.
 */
abstract class BaseListAdapter<T: Parcelable> : RecyclerView.Adapter<BaseListAdapter<T>.ViewHolder>() {

    protected var items = ArrayList<T>()

    abstract fun getListItemView(context: Context) : BaseViewHolder<T>

    fun clearItem(){
        val itemCount = items.size
        items.clear()
        notifyItemRangeRemoved(0, itemCount)
    }

    fun addItems(itemToAdd: List<T>){
        items.addAll(itemToAdd)
        notifyItemRangeInserted(0, itemToAdd.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ViewHolder(getListItemView(parent?.context!!))

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) = holder?.view?.bind(items[position])!!

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(val view: BaseViewHolder<T>) : RecyclerView.ViewHolder(view)

}