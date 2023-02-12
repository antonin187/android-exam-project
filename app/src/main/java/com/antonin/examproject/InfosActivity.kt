package com.antonin.examproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class InfosActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infos)

        setHeaderTitle(getString(R.string.header_infos_title))
        showBack()
    }

    fun showStudentInfosActivity(firstname: String, lastname: String, urlImage: String, email: String, group: String) {

        val newIntent = Intent(application, StudentInfosActivity::class.java)
        newIntent.putExtra("firstname", firstname)
        newIntent.putExtra("lastname", lastname)
        newIntent.putExtra("urlImage", urlImage)
        newIntent.putExtra("email", email)
        newIntent.putExtra("group", group)
        startActivity(newIntent)

        /*val newIntent = Intent(application, DetailsActivity::class.java)
        newIntent.putExtra("url", url)
        newIntent.putExtra("title", tilte)
        startActivity(newIntent)*/
    }
}