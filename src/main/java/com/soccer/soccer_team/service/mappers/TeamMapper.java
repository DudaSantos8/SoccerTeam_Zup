package com.soccer.soccer_team.service.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soccer.soccer_team.controllers.dtos.TeamRegisterDTO;
import com.soccer.soccer_team.controllers.dtos.TeamResponseDTO;
import com.soccer.soccer_team.models.Team;

public class TeamMapper {
    public static Team fromTeamResponseDto(TeamRegisterDTO teamRegisterDTO){
        Team team = new Team();
        team.setName(teamRegisterDTO.getName());
        team.setPlayers(teamRegisterDTO.getPlayers());

        return team;
    }

    public static TeamResponseDTO fromTeamResponseDto(Team team){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(team, TeamResponseDTO.class);
    }
}
