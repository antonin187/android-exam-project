package com.antonin.examproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RayonsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rayons)

        setHeaderTitle(getString(R.string.header_rayons_title))
        showBack()

        (application as ExamApplication).showToast("Bienvenue dans le rayon")

    }
}