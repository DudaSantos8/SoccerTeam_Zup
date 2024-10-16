package com.soccer.soccer_team.controllers.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public class TeamRegisterDTO {

    @Size(min = 3, message = "name not valid")
    private String name;

    @NotEmpty(message = "This field cant be blank")
    @Size(max = 5, message = "this team can't have more than  five payers")
    private List<String> players;

    public TeamRegisterDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

}
