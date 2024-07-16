package com.example.marvelfandom

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class ListMarvelAdapter(private val listMarvel: ArrayList<Marvel>) :
    RecyclerView.Adapter<ListMarvelAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgAvatar: CircleImageView = itemView.findViewById(R.id.img_avatar)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvAliases: TextView = itemView.findViewById(R.id.tv_item_alias)
        val tvCategory: TextView = itemView.findViewById(R.id.tv_item_category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_marvel, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMarvel.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val name = listMarvel[position].name
        val aliases = listMarvel[position].alias
        val category = listMarvel[position].category
        val avatar = listMarvel[position].photo

//        Glide req image
        Glide.with(holder.itemView.context).load(avatar).into(holder.imgAvatar)

        holder.tvName.text = name
        holder.tvAliases.text = aliases
        holder.tvCategory.text = category

//        Listener CLick
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.MARVEL_DATA, listMarvel[holder.adapterPosition])
            holder.itemView.context.startActivity(intent)
        }
    }
}