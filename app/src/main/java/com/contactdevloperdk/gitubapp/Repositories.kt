package com.contactdevloperdk.gitubapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_repositories.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.util.*

class Repositories : AppCompatActivity() {
    private lateinit var mAdapter:Repadapter
    companion object{
        val NAME_EXTRA2="name_extra2"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repositories)
        val riciving2=intent.getStringExtra(NAME_EXTRA2)
        val mydata :List<Repmodel> = ArrayList()
          rcv.layoutManager=LinearLayoutManager(this)
            mAdapter= Repadapter(baseContext,mydata)
            rcv.adapter = mAdapter

        val questapi = Repapigit().getInstancerep().create(Repapi::class.java)
        val retrofitr=questapi.getQuotesr(user = riciving2.toString())
        retrofitr.enqueue(object :Callback<List<Repmodel>>{
            override fun onResponse(
                call: Call<List<Repmodel>>,
                response: Response<List<Repmodel>>
            ) {
               // val result = response.body()?.size
                mAdapter.setdata(response.body()!!)
            }

            override fun onFailure(call: Call<List<Repmodel>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }

}