package com.antonin.examproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class StudentInfosActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_infos)

        val firstname = intent.extras!!.getString("firstname")
        val lastname = intent.extras!!.getString("lastname")
        val urlImage = intent.extras!!.getString("urlImage")
        val email = intent.extras!!.getString("email")
        val group = intent.extras!!.getString("group")



        /*val url=intent.extras!!.getString("url")
        val image=findViewById<ImageView>(R.id.imageViewDetails)
        Picasso.get().load(url).into(image);
        val title=intent.extras!!.getString("title")*/

        setHeaderTitle(firstname)
        showBack()
    }
}