package com.sibtech;

/*TODO
    - Loop the match logic to be able to play multiple matches and simulate a league
    - Add more match events (red cards, penalties, throw-ins, corners, good save)
        -add match stats (saves, tackles etc.)
    - Add functionality to players
        -make all relevant events happen to a specific player
        -track events which happen to players so logic makes sense (no events after red cards etc.)
    - Sort out Goal-as-separate-object logic
 */

public class Main {

    public static void main(String[] args) {
        //Start new match
        Match match = new Match();

        //creates the teams as objects
        Team homeTeam = new Team(match.homeTeamName);
        Team awayTeam = new Team(match.awayTeamName);

        //chance for each event once per minute
        for (int min=0;min<=90;min++) {
            match.MatchEvent(min, homeTeam, awayTeam);
            if (min == 45) {
                System.out.println("HALF TIME");
            } else if (min == 90) {
                System.out.println("FULL TIME");
            }
        }

        match.MatchResult();

        //Enters the result to the team object
        homeTeam.EnterResult(match.homeResult, match.homeScore, match.awayScore);
        awayTeam.EnterResult(match.awayResult, match.awayScore, match.homeScore);

        //Print new stats
        System.out.println(homeTeam.teamName + " standings: " + homeTeam.GetTeamStats());
        System.out.println(awayTeam.teamName + " standings: " + awayTeam.GetTeamStats());
    }
}
