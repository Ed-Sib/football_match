package com.sibtech;

public class Team {

    String teamName;
    int goalsScored, goalsConceeded;
    int wins, losses, draws;
    int points, yellowCards;

    //Constructor to set the given parameter as the team name
    public Team (String team) {
        teamName = team;
    }

    public void getYellowCard() {
        yellowCards++;
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
        return ("W" + wins + " D" + draws + " L" + losses + " - " + totalPoints + " points.");
    }
}
