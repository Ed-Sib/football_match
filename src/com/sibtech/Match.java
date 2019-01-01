package com.sibtech;

import java.util.HashMap;
import java.util.Random;

public class Match {

    int homeScore = 0,awayScore = 0;
    Team homeTeam, awayTeam;
    String matchResult;
    String homeResult, awayResult;
    Random random = new Random();

    //weighting values for random event, % chance each minute
    private HashMap<String, Double> eventWeights = new HashMap<String, Double>() {{
        put("goal", 7.0);                                  //% chance of a goal occurring
        put("card", 4.0);                                  //% chance of card being awarded
        put("redCardChance", 10.0);                        //% chance of awarded card being red
        put("freeKick", 5.0);                              //% chance of free kick being awarded
        put("penalty", 1.5);                               //% chance of penalty being awarded
        put("penaltyScoreChance", 80.0);                   //% chance of penalty being scored
    }};

    //Constructor resets stats (cards etc.), kicks off the match and records the result
    public Match(Team matchHomeTeam, Team matchAwayTeam) {
        homeTeam = matchHomeTeam;
        awayTeam = matchAwayTeam;
        for (Player p : matchHomeTeam.teamPlayers) {
            p.PlayerReset();
        }
        for (Player p : matchAwayTeam.teamPlayers) {
            p.PlayerReset();
        }
        MatchEventTrigger(homeTeam, awayTeam);
        MatchResult();
    }

    public void MatchEventTrigger (Team homeTeam, Team awayTeam) {
        //chance for each event once per minute
        for (int min=1;min<=90;min++) {
            if (min == 0) {
                System.out.println("KICK OFF");
            }
            MatchEvent(min, homeTeam, awayTeam);
            if (min == 45) {
                System.out.println("HALF TIME");
            } else if (min == 90) {
                System.out.println("FULL TIME");
            }
        }
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
            eventTeam.TeamGoal(timestamp);
            System.out.println(" - " + homeTeam.teamName + " " + homeScore + " - " + awayScore + " " + awayTeam.teamName);
        }
        //cards
        if ((Math.random() * 100) < eventWeights.get("card")) {
            if (Math.random() > 0.25) {
                eventTeam.GetYellowCard(timestamp);
            } else {
                eventTeam.GetRedCard(timestamp);
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
                eventTeam.TeamGoal(timestamp);
                System.out.println(" - " + homeTeam.teamName + " " + homeScore + " - " + awayScore + " " + awayTeam.teamName);
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
            System.out.println("Result: " + homeTeam.teamName + " Win " + homeScore + "-" + awayScore);
        } else if (matchResult.equals("Away Win")) {
            System.out.println("Result: " + awayTeam.teamName + " Win " + awayScore + "-" + homeScore);
        } else {
            System.out.println("Result: " + homeScore + "-" + awayScore + " Draw");
        }
        //Enters the result to the team object
        homeTeam.EnterResult(homeResult, homeScore, awayScore);
        awayTeam.EnterResult(awayResult, awayScore, homeScore);
    }
}
