package com.sibtech;

/*TODO
    - Loop the match logic to be able to play multiple matches and simulate a league
    - Add more match events (red cards, penalties)
    - Add players to the teams
    - Sort out Goal-as-separate-object logic
 */

public class Main {

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

        //Determine the final result
        if (match.MatchResult().equals("Home Win")) {
            System.out.println("Result: " + homeTeam.teamName + " Win!");
        } else if (match.MatchResult().equals("Away Win")) {
            System.out.println("Result: " + awayTeam.teamName + " Win!");
        } else {
            System.out.println("Result: Draw!");
        }
        //Enters the result to the team object
        homeTeam.EnterResult(match.homeResult, match.homeScore, match.awayScore);
        awayTeam.EnterResult(match.awayResult, match.awayScore, match.homeScore);

        //Print new stats
        System.out.println(homeTeam.teamName + " standings: " + homeTeam.GetTeamStats());
        System.out.println(awayTeam.teamName + " standings: " + awayTeam.GetTeamStats());
    }
}
