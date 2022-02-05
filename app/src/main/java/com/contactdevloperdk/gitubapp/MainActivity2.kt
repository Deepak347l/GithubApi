package com.contactdevloperdk.gitubapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class MainActivity2 : AppCompatActivity() {
    private lateinit var myImage:Bitmap
    companion object{
        val NAME_EXTRA="name_extra"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val riciving=intent.getStringExtra(NAME_EXTRA)
        //image
         //retrofit start
        val quotesApi = apigit.getInstance().create(api::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getQuotes(user = riciving.toString())
            // Checking the results
            i1.setText(result.body()?.name.toString())
            i2.setText(result.body()?.id.toString())
            textView5.setText(result.body()?.following.toString())
            textView6.setText(result.body()?.followers.toString())
            textView8.setText(result.body()?.public_repos.toString())
            textView11.setText(result.body()?.twitter_username.toString())
            t11.setText(result.body()?.location.toString())
            textView19.setText(result.body()?.company.toString())
            i1110.setText(result.body()?.hireable.toString())
            textView21.setText(result.body()?.blog.toString())
            i958.setText(result.body()?.email.toString())
           //for profile img
        }
        //rep button click
        repbtn.setOnClickListener {
            val rep=Intent(this, Repositories::class.java)
                rep.putExtra(Repositories.NAME_EXTRA2, riciving.toString())
                rep.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(rep)
        }
    }
}