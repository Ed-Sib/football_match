package com.sibtech;

/*TODO
    - Add more match events (red cards, penalties, throw-ins, corners, good save)
        -add match stats (saves, tackles etc.)
        -add random number of injury time minutes;
    - Add functionality to players
        -make all relevant events happen to a specific player
        -track events which happen to players so logic makes sense (no events after red cards etc.)
        -do "end of season awards"
        -work out MVP - fantasy league points scoring?
    - Sort out Goal-as-separate-object logic
 */

public class Main {

    public static void main(String[] args) {
        //set how many matches to be played
        //int numberOfMatches = 5;
        int matchID = 1; //starting value

        //Start new match
        League league1 = new League();

        //loop which causes each team to play each other twice
        for (int i=0; i<league1.teams.length; i++) {
            for (int j=0; j<league1.teams.length; j++) {
                if (i != j) { //stops the team playing itself
                    league1.PlayMatch(matchID, league1.teams[i], league1.teams[j]);
                    matchID++;
                }
            }
        }

        //for (int i=0; i < numberOfMatches; i++){
        //    league1.PlayMatch(i+1);
        //}

        //Print out the league table
        System.out.println("-----------------------------------------");
        System.out.println("League Table:");
        for (Team team : league1.GetLeagueResults()) {
            System.out.println(team.GetTeamStats());
        }

        //work out end-of-season awards
        league1.PlayerAwards();
    }
}
