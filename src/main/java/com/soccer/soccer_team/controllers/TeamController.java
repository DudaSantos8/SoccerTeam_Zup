package com.soccer.soccer_team.controllers;

import com.soccer.soccer_team.controllers.dtos.TeamRegisterDTO;
import com.soccer.soccer_team.controllers.dtos.TeamUpdateDTO;
import com.soccer.soccer_team.service.TeamService;
import com.soccer.soccer_team.service.mappers.TeamMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/{teamId}")
    public ResponseEntity<?> showAllTeams(@PathVariable Long teamId){
        try{
            return ResponseEntity.status(200).body(TeamMapper.fromTeamResponseDto(teamService.findTeamById(teamId)));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeam(@RequestBody @Valid TeamRegisterDTO teamRegisterDTO){
        teamService.createTeam(TeamMapper.fromTeamResponseDto(teamRegisterDTO));
    }

    @PutMapping("/{teamId}")
    public ResponseEntity<?> updateTeam(@RequestBody @Valid TeamUpdateDTO teamUpdateDTO,@PathVariable Long teamId){
        try{
            teamService.updateTeam(teamId, teamUpdateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }
}
