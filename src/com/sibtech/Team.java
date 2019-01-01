package com.sibtech;

import java.util.ArrayList;
import java.util.Random;

public class Team {

    String teamName;
    int goalsScored, goalsConceeded;
    int wins, losses, draws;
    int points, yellowCards, redCards;
    ArrayList<Player> teamPlayers;
    Random rand = new Random();

    //Constructor to set the given parameter as the team name
    public Team (String team) {
        teamName = team;
        Player []players = new Player[11];
        teamPlayers = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            players[i] = new Player(teamName);
            teamPlayers.add(players[i]);
        }
    }

    public Player GetScorer() {
        Player scorer = teamPlayers.get(rand.nextInt(10));
        scorer.PlayerGoal();
        return scorer;
    }

    public void getYellowCard() {
        yellowCards++;
    }

    public void getRedCard() {
        redCards++;
    }

    //Saves the result of a match to the Team object's fields
    public void EnterResult (String result, int goalsFor, int goalsAgainst) {
        switch (result) {
            case "win":
                wins++;
                break;
            case "loss":
                losses++;
                break;
            case "draw":
                draws++;
                break;
        }
        goalsScored = goalsScored + goalsFor;
        goalsConceeded = goalsConceeded + goalsAgainst;
    }

    public String GetTeamStats () {
        int totalPoints = (wins * 3) + (draws);
        points = totalPoints;
        return ("W:" + wins + " | D:" + draws + " | L:" + losses + " | P:" + totalPoints);
    }
}
