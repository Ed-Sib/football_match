package com.sibtech;

public class Match {

    int homeScore = 0,awayScore = 0;
    String homeTeamName, awayTeamName;
    String[] teamNames;
    String result;
    String homeResult, awayResult;

    public Match() {
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
        String timestamp = (min + "' - ");
        String event;
        Team eventTeam;
        double eventRoll = Math.random() * 100;
        double teamRoll = Math.round(Math.random());

        //determine the type of event - fix later
        if (eventRoll > 20) {event = "Goal";}
        else {event = "Card";}

        //determine which team the event happens to
        if (teamRoll == 0) {
            eventTeam = homeTeam;
        } else {
            eventTeam = awayTeam;
        }

        //make the event happen
        switch (event) {
            case "Goal":
                if (eventTeam.equals(homeTeam)) {
                    homeScore++;
                } else {
                    awayScore++;
                }
                System.out.println(timestamp + "GOAL! - " + homeTeam.teamName + " " + homeScore + " - " + awayScore + " " + awayTeam.teamName);
                break;
            case "Card":
                eventTeam.getYellowCard();
                System.out.println(timestamp + "Yellow card for " + eventTeam.teamName);
                break;
        }
    }

    public String MatchResult() {
        int scoreDiff = homeScore - awayScore;
        if (scoreDiff > 0) {
            result = "Home Win";
            homeResult = "win";
            awayResult = "loss";
        } else if (scoreDiff < 0) {
            result = "Away Win";
            homeResult = "loss";
            awayResult = "win";
        } else {
            result = "Draw";
            homeResult = "draw";
            awayResult = "draw";
        }
        return result;
    }
}
