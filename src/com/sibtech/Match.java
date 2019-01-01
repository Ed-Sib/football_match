package com.sibtech;

import java.util.HashMap;
import java.util.Random;

public class Match {

    int homeScore = 0,awayScore = 0;
    String homeTeamName, awayTeamName;
    String matchResult;
    String homeResult, awayResult;
    Random random = new Random();

    //weighting values for random event, % chance each minute
    private HashMap<String, Double> eventWeights = new HashMap<String, Double>() {{
        put("goal", 9.0);                                  //% chance of a goal occurring
        put("card", 3.0);                                  //% chance of card being awarded
        put("redCardChance", 25.0);                        //% chance of awarded card being red
        put("freeKick", 4.0);                              //% chance of free kick being awarded
        put("penalty", 2.0);                               //% chance of penalty being awarded
        put("penaltyScoreChance", 80.0);                   //% chance of penalty being scored
    }};

    public Match() {
        //create variables and list of possible names
        String[] teams = {"Pegasus United", "Toton Tigers", "Stapleford Swans", "Long Eaton Lazybones", "Beeston Bulldogs"};

        //gets random team names from the list
        homeTeamName = teams[random.nextInt(4)];
        awayTeamName = teams[random.nextInt(4)];
        //if the same team is picked twice, re-roll the away team until it is different
        while (awayTeamName.equals(homeTeamName)) {
            awayTeamName = teams[random.nextInt(4)];
        }
        System.out.println("Match: " + homeTeamName + " vs " + awayTeamName);
    }

    public void MatchEvent (int min, Team homeTeam, Team awayTeam) {
        String timestamp = (min + "' - ");
        Team eventTeam;

        //determine which team the event happens to, 50/50
        if ((random.nextInt(2) + 1) == 1) {
            eventTeam = homeTeam;
        } else {
            eventTeam = awayTeam;
        }

        //goals
        if ((Math.random() * 100) < eventWeights.get("goal")) {
            if (eventTeam.equals(homeTeam)) {
                homeScore++;
            } else {
                awayScore++;
            }
            Player goalScorer = eventTeam.GetScorer();
            System.out.println(timestamp + "GOAL! (" + goalScorer.playerName + ") - " + homeTeam.teamName + " " + homeScore + " - " + awayScore + " " + awayTeam.teamName);
        }
        //cards
        if ((Math.random() * 100) < eventWeights.get("card")) {
            if (Math.random() > 0.25) {
                eventTeam.getYellowCard();
                System.out.println(timestamp + "Yellow card for " + eventTeam.teamName);
            } else {
                eventTeam.getRedCard();
                System.out.println(timestamp + "Red card for " + eventTeam.teamName);
            }
        }
        //throw-in
        if ((Math.random() * 100) < eventWeights.get("freeKick")) {
            System.out.println(timestamp + "Free kick awarded to " + eventTeam.teamName);
        }
        //penalty - duplicates "goal" code - remember to replace if functionality updated
        if ((Math.random() * 100) < eventWeights.get("penalty")) {
            if (Math.random() > eventWeights.get("penaltyScoreChance")) {
                if (eventTeam.equals(homeTeam)) {
                    homeScore++;
                } else {
                    awayScore++;
                }
                Player goalScorer = eventTeam.GetScorer();
                System.out.println(timestamp + "GOAL! (pen)(" + goalScorer.playerName + ") - " + homeTeam.teamName + " " + homeScore + " - " + awayScore + " " + awayTeam.teamName);
            } else {
                System.out.println(timestamp + "Missed Penalty for " + eventTeam.teamName + "!");
            }
        }
    }

    public void MatchResult() {
        int scoreDiff = homeScore - awayScore;
        if (scoreDiff > 0) {
            matchResult = "Home Win";
            homeResult = "win";
            awayResult = "loss";
        } else if (scoreDiff < 0) {
            matchResult = "Away Win";
            homeResult = "loss";
            awayResult = "win";
        } else {
            matchResult = "Draw";
            homeResult = "draw";
            awayResult = "draw";
        }

        if (matchResult.equals("Home Win")) {
            System.out.println("Result: " + homeTeamName + " Win " + homeScore + "-" + awayScore);
        } else if (matchResult.equals("Away Win")) {
            System.out.println("Result: " + awayTeamName + " Win " + awayScore + "-" + homeScore);
        } else {
            System.out.println("Result: " + homeScore + "-" + awayScore + " Draw");
        }
    }
}
