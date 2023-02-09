package com.antonin.examproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InfosActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infos)

        setHeaderTitle(getString(R.string.header_infos_title))
        showBack()
    }
}