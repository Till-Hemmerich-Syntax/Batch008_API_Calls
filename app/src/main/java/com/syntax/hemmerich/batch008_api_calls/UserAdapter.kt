package com.syntax.hemmerich.batch008_api_calls

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax.hemmerich.batch008_api_calls.data.model.User
import com.syntax.hemmerich.batch008_api_calls.databinding.UserItemBinding

class UserAdapter(val dataSet: List<User>) : RecyclerView.Adapter<UserAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.emailTV.text = dataSet[position].email
        holder.binding.nameTV.text = dataSet[position].name
    }


}