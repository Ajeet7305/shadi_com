package com.shaadi.assignment.binding

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.shaadi.assignment.model.UserStats
import com.shaadi.assignment.view.adapter.UserAdapter
import com.skydoves.whatif.whatIfNotNull
import com.skydoves.whatif.whatIfNotNullAs
import com.skydoves.whatif.whatIfNotNullOrEmpty
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.transform.ScaleTransformer

object RecyclerViewBinding {
    @JvmStatic
    @BindingAdapter("adapter")
    fun bindAdapter(view: RecyclerView, baseAdapter: RecyclerView.Adapter<*>) {
        view.adapter = baseAdapter
    }

    @JvmStatic
    @BindingAdapter("toast")
    fun bindToast(view: RecyclerView, text: String?) {
        text.whatIfNotNullOrEmpty {
            Toast.makeText(view.context, it, Toast.LENGTH_SHORT).show()
        }
    }

    @JvmStatic
    @BindingAdapter("adapterUserList")
    fun bindAdapterUserList(view: DiscreteScrollView, users: List<UserStats>?) {
        users.whatIfNotNullOrEmpty { items ->
            view.adapter.whatIfNotNullAs<UserAdapter> { adapter ->
                adapter.updateUserList(items)
            }
        }
        view.setItemTransformer(
                ScaleTransformer.Builder()
                        .setMaxScale(1.25f)
                        .setMinScale(0.8f)
                        .build()
        )
    }

    @JvmStatic
    @BindingAdapter("bindOnItemChanged", "bindOnItemChangedBackground")
    fun bindOnItemChanged(view: DiscreteScrollView, adapter: UserAdapter, pointView: View) {
        view.addOnItemChangedListener { viewHolder, _ ->
            viewHolder?.adapterPosition.whatIfNotNull {
//        pointView.circularRevealedAtCenter(Color.parseColor(adapter.getPoster(it).color))
            }
        }
    }

}
