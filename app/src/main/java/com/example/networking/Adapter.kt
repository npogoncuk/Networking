package com.example.networking
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.networking.databinding.ViewItemBinding
import com.example.networking.network.User

class Adapter : ListAdapter<User, Adapter.UserViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.UserViewHolder {
        return UserViewHolder(ViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: Adapter.UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class UserViewHolder(private val binding: ViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.nameSurnameTextView.text = user.name.first + " " + user.name.last
            binding.picture = user.picture
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean = oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean = oldItem.name == newItem.name && oldItem.picture == newItem.picture

    }
}
