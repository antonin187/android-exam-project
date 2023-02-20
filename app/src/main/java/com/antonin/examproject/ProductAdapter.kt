package com.antonin.examproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ProductAdapter (val products: ArrayList<Product>): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val imageViewPictureProduct = view.findViewById<ImageView>(R.id.imageViewPictureProduct)
        val textViewNameProduct = view.findViewById<TextView>(R.id.textViewNameProduct)
        val textViewDescriptionProduct = view.findViewById<TextView>(R.id.textViewDescriptionProduct)
        val layoutProduct= view.findViewById<LinearLayout>(R.id.layoutProduct)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_button, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)
        holder.textViewNameProduct.text=product.name
        holder.textViewDescriptionProduct.text=product.description

        val imageView = holder.imageViewPictureProduct
        Picasso.get().load(product.picture_url).into(imageView);

        holder.layoutProduct.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(holder.layoutProduct.context, ProductActivity::class.java)
            newIntent.putExtra("name", product.name)
            newIntent.putExtra("description", product.description)
            newIntent.putExtra("picture_url", product.picture_url)
            holder.layoutProduct.context.startActivity(newIntent)
        })
    }

    override fun getItemCount(): Int {
        return products.size
    }
}