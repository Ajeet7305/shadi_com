package com.shaadi.assignment.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.shaadi.assignment.R
import com.shaadi.assignment.databinding.ItemUserBinding
import com.shaadi.assignment.model.UserStats

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    private val items = mutableListOf<UserStats>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemUserBinding>(
                inflater,
                R.layout.item_user,
                parent,
                false
        )
        return UserViewHolder(binding).apply {

            binding.decline.setOnClickListener { view ->
                binding.decline.text = "Declined"
                binding.accept.text = "Accept"

            }

            binding.accept.setOnClickListener { view ->
                binding.accept.text = "Accepted"
                binding.decline.text = "Decline"

            }
        }
    }

    fun updateUserList(users: List<UserStats>) {
        items.clear()
        items.addAll(users)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.apply {
            user = items[position]
            veil = itemVeilLayout
            executePendingBindings()
        }
    }

    fun getUsers(index: Int): UserStats = items[index]

    class UserViewHolder(val binding: ItemUserBinding) :
            RecyclerView.ViewHolder(binding.root)
}
