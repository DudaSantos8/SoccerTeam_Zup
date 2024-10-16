package com.soccer.soccer_team.service;

import com.soccer.soccer_team.controllers.dtos.TeamUpdateDTO;
import com.soccer.soccer_team.models.Team;
import com.soccer.soccer_team.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team findTeamById(Long teamId){
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        return optionalTeam.orElseThrow(()-> new RuntimeException("this team don't exist"));
    }

    public Team createTeam(Team team){
        return teamRepository.save(team);
    }

    public Team updateTeam(Long teamId, TeamUpdateDTO teamUpdateDTO){
        Team teamBD = findTeamById(teamId);

        if(!teamBD.getName().equals(teamUpdateDTO.getName())){
            teamBD.setName(teamUpdateDTO.getName());
        }
        if(!teamBD.getPlayers().equals(teamUpdateDTO.getPlayers())){
            teamBD.setPlayers(teamUpdateDTO.getPlayers());
        }

        return createTeam(teamBD);
    }

}
