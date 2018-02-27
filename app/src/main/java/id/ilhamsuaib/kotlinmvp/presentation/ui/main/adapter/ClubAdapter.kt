package id.ilhamsuaib.kotlinmvp.presentation.ui.main.adapter

import android.content.Context
import id.ilhamsuaib.kotlinmvp.di.scope.PerActivity
import id.ilhamsuaib.kotlinmvp.presentation.base.adapter.BaseListAdapter
import id.ilhamsuaib.kotlinmvp.presentation.base.adapter.BaseViewHolder
import javax.inject.Inject
import id.ilhamsuaib.kotlinmvp.R
import id.ilhamsuaib.kotlinmvp.presentation.model.Club
import kotlinx.android.synthetic.main.adapter_club.view.*

/**
 * Created by ilham on 10/14/17.
 */

@PerActivity
class ClubAdapter @Inject constructor() : BaseListAdapter<Club>() {

    override fun getListItemView(context: Context): BaseViewHolder<Club> = ViewHolder(context)

    inner class ViewHolder(context: Context?) : BaseViewHolder<Club>(context) {

        override fun layoutResId(): Int = R.layout.adapter_club

        override fun bind(item: Club) {
            tvName.text = item.name
            tvKey.text = item.key
            tvCode.text = item.code
        }
    }
}