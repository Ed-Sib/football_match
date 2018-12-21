package com.sibtech;

public class Team {

    String teamName;
    int goals = 0;
    int wins, losses, draws;
    int points;

    public Team (String team) {
        teamName = team;
    }

    public void scoreGoal () {
        goals = goals + 1;
    }
}
