package com.sibtech;

public class Main {
    //TODO - make a league to record the result of multiple matches

    public static void main(String[] args) {
        //Start new match
        Match match = new Match();

        //creates the teams as objects
        Team homeTeam = new Team(match.homeTeamName);
        Team awayTeam = new Team(match.awayTeamName);

        //roll every minute for chance of an event happening
        for (int min=0;min<=90;min++) {
            if (Math.random() < 0.1) {
                match.MatchEvent(min, homeTeam, awayTeam);
            }
            if (min == 45) {
                System.out.println("HALF TIME");
            } else if (min == 90) {
                System.out.println("FULL TIME");
            }
        }
    }
}
