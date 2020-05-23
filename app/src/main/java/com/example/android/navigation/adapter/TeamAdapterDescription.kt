package com.example.android.navigation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.navigation.R
import com.example.android.navigation.databinding.FragmentTeamDescriptionLayoutBinding
import com.example.android.navigation.model.SoccerTeamDescription
import com.squareup.picasso.Picasso




class TeamAdapterDescription(val teamList: List<SoccerTeamDescription>) : RecyclerView.Adapter<TeamAdapterDescription.TeamHolderDescription>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamHolderDescription{
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<FragmentTeamDescriptionLayoutBinding>(layoutInflater, R.layout.fragment_team_description_layout,parent,false)
        return TeamHolderDescription(binding)
    }

    override fun getItemCount(): Int {
       return teamList.size
    }
    override fun onBindViewHolder(holder: TeamHolderDescription, position: Int) {
        holder.bind(teamList[position])
    }

    inner class TeamHolderDescription(val binding: FragmentTeamDescriptionLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(team : SoccerTeamDescription){
            binding.teamNameText2 .text = team.strTeam
            Picasso.get().load(team.strTeamBadge).into(binding.teamBadgeImage2)
            binding.teamDescriptionText2.text = team.DescriptionEN
            Picasso.get().load(team.strTeamJersey).into(binding.teamShirtImage2)

        }

    }


}