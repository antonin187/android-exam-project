package com.antonin.examproject

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ProductsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        showBack()
        val rayonTitle = intent.extras!!.getString("rayon_title")
        setHeaderTitle(rayonTitle.toString())

        val products = arrayListOf<Product>()

        val recyclerviewProducts=findViewById<RecyclerView>(R.id.recycleviewProducts)
        recyclerviewProducts.layoutManager= LinearLayoutManager(this)
        val productAdapter=ProductAdapter(products)
        recyclerviewProducts.adapter=productAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()

        val mRequestURL = intent.extras!!.getString("products_url")
        val request = Request.Builder()
            .url(mRequestURL.toString())
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        okHttpClient.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                val data = response.body?.string()

                if(data!=null) {
                    val jsProducts = JSONObject(data)
                    val jsArrayProducts = jsProducts.getJSONArray("items")
                    for (i in 0 until jsArrayProducts.length()) {
                        val js = jsArrayProducts.getJSONObject(i)
                        val product = Product(
                            js.optString("name", "not found"),
                            js.optString("description", "not found"),
                            js.optString("picture_url", "not found")
                        )
                        products.add(product)
                        runOnUiThread(Runnable {
                            productAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }

        })
    }
}