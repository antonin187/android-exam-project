package com.antonin.examproject

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.*
import okio.IOException
import org.json.JSONObject

class RayonsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rayons)
        showBack()
        setHeaderTitle(getString(R.string.header_rayons_title))

        val rayons= arrayListOf<Rayon>()

        val recyclerviewRayons=findViewById<RecyclerView>(R.id.recycleviewRayons)
        recyclerviewRayons.layoutManager= LinearLayoutManager(this)
        val rayonAdapter=RayonAdapter(rayons)
        recyclerviewRayons.adapter=rayonAdapter

        val okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
        val mRequestURL="https://www.ugarit.online/epsi/categories.json"
        val request = Request.Builder()
            .url(mRequestURL)
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
                    val jsRayons = JSONObject(data)
                    val jsArrayRayons = jsRayons.getJSONArray("items")
                    for (i in 0 until jsArrayRayons.length()) {
                        val js = jsArrayRayons.getJSONObject(i)
                        val rayon = Rayon(
                            js.optString("category_id", "not found"),
                            js.optString("title", "not found"),
                            js.optString("products_url", "not found")
                        )
                        rayons.add(rayon)
                        runOnUiThread(Runnable {
                            rayonAdapter.notifyDataSetChanged()
                        })
                    }
                }
            }

        })



    }
}