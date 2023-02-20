package com.antonin.examproject

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class RayonAdapter (val rayons: ArrayList<Rayon>): RecyclerView.Adapter<RayonAdapter.ViewHolder>() {

    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val textButtonRayon = view.findViewById<Button>(R.id.buttonDisplayRayon)
        val layoutContent= view.findViewById<LinearLayout>(R.id.layoutContent)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_rayon, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rayon = rayons.get(position)
        holder.textButtonRayon.text=rayon.title
        holder.textButtonRayon.setOnClickListener(View.OnClickListener {

            val newIntent = Intent(holder.layoutContent.context, ProductsActivity::class.java)
            newIntent.putExtra("rayon_title", rayon.title)
            newIntent.putExtra("products_url", rayon.products_url)
            holder.layoutContent.context.startActivity(newIntent)

        })
    }

    override fun getItemCount(): Int {
        return rayons.size
    }
}