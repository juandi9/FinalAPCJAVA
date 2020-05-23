/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.navigation.adapter.TeamAdapter
import com.example.android.navigation.databinding.ActivityMainBinding
import com.example.android.navigation.model.TeamList
import com.example.android.navigation.network.RetrofitInstance
import com.example.android.navigation.network.SoccerService
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        @Suppress("UNUSED_VARIABLE")

        val retrofit = RetrofitInstance.getRetrofitInstrance()
        val request = retrofit.create(SoccerService::class.java)
        val call = request.getAllTeams()

        call.enqueue(object : Callback<TeamList> {
            override fun onFailure(call: retrofit2.Call<TeamList>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has ocurred -- ${t.message}", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: retrofit2.Call<TeamList>, response: Response<TeamList>) {
                binding.recyclerView.apply {
                    setHasFixedSize(true)
                    adapter = TeamAdapter(response.body()!!.teams.take(10))
                    layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

        })


    }
}
