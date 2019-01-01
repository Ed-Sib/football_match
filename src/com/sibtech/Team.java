package com.sibtech;

import java.util.ArrayList;
import java.util.Random;

public class Team {

    String teamName;
    int goalsScored, goalsConceeded, goalDifference;
    int wins, losses, draws, matchesPlayed;
    int points, yellowCards, redCards;
    int leaguePosition;
    ArrayList<Player> teamPlayers;
    //Player[] players;
    Random rand = new Random();

    //Constructor to set the team name and generate player list
    public Team (String team) {
        teamName = team;
        Player[] players = new Player[11];
        teamPlayers = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            players[i] = new Player(teamName);
            teamPlayers.add(players[i]);
        }
        //players = teamPlayers.toArray(new Player[teamPlayers.size()]); //doesn't work for some reason
    }

    public Player GetRandomPlayer() {
        return teamPlayers.get(rand.nextInt(10));
    }

    public void TeamGoal(String timestamp) {
        Player scorer = teamPlayers.get(rand.nextInt(10));
        scorer.PlayerGoal();
        System.out.print(timestamp + "GOAL! (" + scorer.playerName + ", " + teamName + ")");
    }

    public void GetYellowCard(String timestamp) {
        yellowCards++;
        Player cardedPlayer = GetRandomPlayer();
        cardedPlayer.PlayerYellowCard();
        System.out.print(timestamp + "Yellow card for " + cardedPlayer.playerName + " (" + teamName + ").");
        if (cardedPlayer.redCard) {
            System.out.println(" Player has been sent off for 2nd yellow card!");
        } else {
            System.out.println("");
        }
    }

    public void GetRedCard(String timestamp) {
        redCards++;
        Player cardedPlayer = GetRandomPlayer();
        cardedPlayer.PlayerRedCard();
        System.out.println(timestamp + "Red card for " + cardedPlayer.playerName + " (" + teamName + "). Player has been sent off!");
    }

    //Saves the result of a match to the Team object's fields
    public void EnterResult (String result, int goalsFor, int goalsAgainst) {
        matchesPlayed = matchesPlayed + 1;
        switch (result) {
            case "win":
                wins++;
                points = points + 3;
                break;
            case "loss":
                losses++;
                break;
            case "draw":
                draws++;
                points = points + 1;
                break;
        }
        goalsScored = goalsScored + goalsFor;
        goalsConceeded = goalsConceeded + goalsAgainst;
        goalDifference = goalsScored - goalsConceeded;

    }

    public String GetTeamStats () {
        String games =  "MP" + String.format("%-2s", matchesPlayed) +
                        "  W" + String.format("%-2s", wins) +
                        " D" + String.format("%-2s", draws) +
                        " L" + String.format("%-2s", losses);
        String statistics = "GS:" + String.format("%-3s", goalsScored) +
                           " GC:" + String.format("%-3s", goalsConceeded) +
                           " GD:" + String.format("%-3s", goalDifference) +
                           " P:" + String.format("%-3s", points);
        return (leaguePosition + ". " + String.format("%-22s", teamName) + ": " + games + " |  " + statistics);
    }
}
