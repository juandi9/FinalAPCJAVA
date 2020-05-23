package com.example.android.navigation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentTeamItemLayoutBinding
import com.example.android.navigation.model.SoccerTeam

import com.squareup.picasso.Picasso


class TeamAdapter(val teamList: List<SoccerTeam>) : RecyclerView.Adapter<TeamAdapter.TeamHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FragmentTeamItemLayoutBinding>(layoutInflater, R.layout.fragment_team_item_layout,parent,false)
        return TeamHolder(binding)

    }
    override fun getItemCount(): Int {
        return teamList.size
    }
    override fun onBindViewHolder(holder: TeamHolder, position: Int) {
        holder.bind(teamList[position])
    }


    inner class TeamHolder(val binding: FragmentTeamItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(team : SoccerTeam){
            binding.teamNameText.text = team.strTeam
            Picasso.get().load(team.strTeamBadge).into(binding.teamBadgeImage)
            binding.teamStadiumText.text = team.strStadium
            binding.teamButton.setOnClickListener{
                Toast.makeText(binding.root.context,team.strTeam,Toast.LENGTH_LONG).show()
              //  it.findNavController().navigate()
            }
        }
    }



}