package com.antonin.examproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class InfosActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infos)

        val buttonStudent1 = findViewById<Button>(R.id.buttonStudent1)
        val buttonStudent2 = findViewById<Button>(R.id.buttonStudent2)
        val buttonStudent3 = findViewById<Button>(R.id.buttonStudent3)

        buttonStudent1.setOnClickListener(View.OnClickListener {
            val firstname = "Maxime"
            val lastname = "BAUDOIN"
            val urlImage = "https://avatars.githubusercontent.com/u/42619561?v=4"
            val email = "maxime.baudoin@epsi.fr"
            val group = "Groupe 1"
            showStudentInfosActivity(firstname, lastname, urlImage, email, group)
        })

        buttonStudent2.setOnClickListener(View.OnClickListener {
            val firstname = "Matis"
            val lastname = "GALVIN"
            val urlImage = "https://media.licdn.com/dms/image/C4D03AQHBal2M82KH9g/profile-displayphoto-shrink_800_800/0/1644958973360?e=1681948800&v=beta&t=yuqksaoC56ITPQ3IiRU7XlpwGNODq_AXG1mBvM5w0tE"
            val email = "matis.galvin@epsi.fr"
            val group = "Groupe 1"
            showStudentInfosActivity(firstname, lastname, urlImage, email, group)
        })

        buttonStudent3.setOnClickListener(View.OnClickListener {
            val firstname = "Antonin"
            val lastname = "SIMON"
            val urlImage = "https://avatars.githubusercontent.com/u/63653412?v=4"
            val email = "antonin.simon@epsi.fr"
            val group = "Groupe 1"
            showStudentInfosActivity(firstname, lastname, urlImage, email, group)
        })

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