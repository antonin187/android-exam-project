package com.antonin.examproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class RayonAdapter (val rayons: ArrayList<Rayon>): RecyclerView.Adapter<RayonAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
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
        holder.layoutContent.setOnClickListener(View.OnClickListener {
            Toast.makeText(holder.layoutContent.context,rayon.title, Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount(): Int {
        return rayons.size
    }
}