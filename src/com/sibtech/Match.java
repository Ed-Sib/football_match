package com.sibtech;

public class Match {

    int homeScore,awayScore;
    String homeTeamName, awayTeamName;
    String[] teamNames;

    public Match() {
        //initialise scores at start of match
        homeScore = 0;
        awayScore = 0;

        //Get home and away team names
        teamNames = GetTeamNames();
        homeTeamName = teamNames[0];
        awayTeamName = teamNames[1];
    }

    private static String[] GetTeamNames () {
        //create variables and list of possible names
        String homeTeamName, awayTeamName;
        String[] teams = {"Pegasus United", "Toton Tigers", "Stapleford Swans", "Long Eaton Lazybones", "Beeston Bulldogs"};

        //gets random team names from the list
        homeTeamName = teams[(int) Math.ceil((Math.random() * teams.length) - 1)];
        awayTeamName = teams[(int) Math.ceil((Math.random() * teams.length) - 1)];
        //if the same team is picked twice, re-roll the away team
        while (awayTeamName.equals(homeTeamName)) {
            awayTeamName = teams[(int) Math.ceil((Math.random() * teams.length) - 1)];
        }
        String[] teamNames = {homeTeamName, awayTeamName};
        System.out.println("Match: " + teamNames[0] + " vs " + teamNames[1]);
        return teamNames;
    }

    public void MatchEvent (int min, Team homeTeam, Team awayTeam) {
        String event = "Goal";
        Team eventTeam;
        //double eventRoll = Math.random() * 100;
        double teamRoll = Math.round(Math.random());

        ////determine the type of event - fix later
        //if (eventRoll > 20) {event = "Goal";}
        //else if (eventRoll <= 20) {event = "Card";}

        //determine which team the event happens to
        if (teamRoll == 0) {
            eventTeam = homeTeam;
        } else {
            eventTeam = awayTeam;
        }

        switch (event) {
            case "Goal":
                eventTeam.scoreGoal();
                System.out.println(min + "' - " + "GOAL! - " + homeTeam.teamName + " " + homeTeam.goals + " - " + awayTeam.goals + " " + awayTeam.teamName);
                break;
            case "Card":
                break;
        }
    }
}
