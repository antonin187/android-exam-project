package com.antonin.examproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class StudentInfosActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_infos)

        val firstname = intent.extras!!.getString("firstname")
        val lastname = intent.extras!!.getString("lastname")
        val urlImage = intent.extras!!.getString("urlImage")
        val email = intent.extras!!.getString("email")
        val group = intent.extras!!.getString("group")



        val nameTextView = findViewById<TextView>(R.id.textStudentName)
        val imageStudent = findViewById<ImageView>(R.id.imageStudent)
        val emailTextView = findViewById<TextView>(R.id.textStudentEmail)
        val groupTextView = findViewById<TextView>(R.id.textStudentGroup)

        nameTextView.text = lastname + " " + firstname
        emailTextView.text = email
        groupTextView.text = group

        Picasso.get().load(urlImage).into(imageStudent);

        /*val url=intent.extras!!.getString("url")
        val image=findViewById<ImageView>(R.id.imageViewDetails)
        Picasso.get().load(url).into(image);
        val title=intent.extras!!.getString("title")*/

        setHeaderTitle(firstname)
        showBack()

        val linkToClick = findViewById<TextView>(R.id.textLink)

        linkToClick.setOnClickListener(View.OnClickListener {
            val openURL = Intent(android.content.Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.epsi.fr/campus/campus-de-bordeaux/")
            startActivity(openURL)
        })
    }
}