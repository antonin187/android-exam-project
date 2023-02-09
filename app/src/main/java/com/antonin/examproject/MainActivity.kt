package com.antonin.examproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setHeaderTitle(getString(R.string.header_main_title))

        val buttonInfos=findViewById<Button>(R.id.buttonInfos)
        buttonInfos.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, InfosActivity::class.java)
            startActivity(newIntent)
        })
        val buttonProduits=findViewById<Button>(R.id.buttonProduits)
        buttonProduits.setOnClickListener(View.OnClickListener {
            val newIntent = Intent(application, RayonsActivity::class.java)
            startActivity(newIntent)
        })
    }
}