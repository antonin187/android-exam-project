package com.antonin.examproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class ProductActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
        val title = intent.extras!!.getString("name")
        val url = intent.extras!!.getString("picture_url")
        val description = intent.extras!!.getString("description")

        showBack()
        setHeaderTitle(title)

        val descriptionText = findViewById<TextView>(R.id.textDescription)
        descriptionText.text = description
        val productImage = findViewById<ImageView>(R.id.productImage)
        Picasso.get().load(url).into(productImage);
    }
}