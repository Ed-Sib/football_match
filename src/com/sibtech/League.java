package com.sibtech;

import java.util.ArrayList;
import java.util.Random;

public class League {

    String[] teamNames = { "Pegasus United"
                          ,"Toton Tigers"
                          ,"Stapleford Swans"
                          ,"Long Eaton Lazybones"
                          ,"Beeston Bulldogs"
                          ,"Sandiacre Sandstorms"
                         };
    Team[] teams;
    Random random = new Random();
    Player goldenBootWinner;

    public League() {
        //generates teams and players
        ArrayList<Team> teamArrayList = new ArrayList<>();
        for (int i = 0; i< teamNames.length; i++) {
            Team newTeam = new Team(teamNames[i]);
            teamArrayList.add(newTeam);
        }
        teams = teamArrayList.toArray(new Team[teamArrayList.size()]); //converts ArrayList<Team> to Team[]

        System.out.println("Teams in the league are: ");
        for (int i=0;i<teamNames.length;i++){
            System.out.println((i+1) + ": " + teams[i].teamName);
        }
    }

    //OBSELETE - used when triggering limited matches between random teams
    public void PlayMatch(int matchID) {
        Team[] teamsForMatch = SetTeamsForMatch(matchID);
        new Match(teamsForMatch[0], teamsForMatch[1]);
    }

    public void PlayMatch(int matchID, Team homeTeam, Team awayTeam) {
        System.out.println("-----------------------------------------");
        System.out.println("Match " + matchID + ": " + homeTeam.teamName + " vs " + awayTeam.teamName);
        new Match(homeTeam, awayTeam);
    }

    private Team[] SetTeamsForMatch(int matchID) {
        //gets random teams from the list
        Team homeTeam = teams[random.nextInt(4)];
        Team awayTeam = teams[random.nextInt(4)];
        //if the same team is picked twice, re-roll the away team until it is different
        while (awayTeam.teamName.equals(homeTeam.teamName)) {
            awayTeam = teams[random.nextInt(4)];
        }
        System.out.println("-----------------------------------------");
        System.out.println("Match " + matchID + ": " + homeTeam.teamName + " vs " + awayTeam.teamName);

        Team[] matchTeams = {homeTeam, awayTeam};
        return matchTeams;
    }

    public Team[] GetLeagueResults() {
        ArrayList<Team> orderedTeamsArray = new ArrayList<>();
        Team[] orderedTeams;

        for (Team a : teams) {
            a.leaguePosition = 1;
            for (Team b : teams) {
                if (a != b) {
                    if (a.points < b.points) {
                        a.leaguePosition++;
                    } else if (a.points == b.points && a.goalDifference < b.goalDifference) {
                        a.leaguePosition++;
                    } else if (a.points == b.points && a.goalDifference == b.goalDifference && a.goalsScored < b.goalsScored) {
                        a.leaguePosition++;
                    }
                }
            }
        }
        for (int i=1;i<(teams.length + 1);i++){
            for (Team team : teams) {
                if (team.leaguePosition == i) {
                    orderedTeamsArray.add(team);
                }
            }
        }
        orderedTeams = orderedTeamsArray.toArray(new Team[orderedTeamsArray.size()]);
        return orderedTeams;
    }

    public void PlayerAwards() {
        int maxGoalsScored = 0;
        for (Team t : teams) {
            for (Player p : t.teamPlayers) {
                if (p.goalsScored > maxGoalsScored) {
                    goldenBootWinner = p;
                    maxGoalsScored = goldenBootWinner.goalsScored;
                }
            }
        }
        System.out.println("----------------------------------");
        System.out.println("PLAYER AWARDS");
        System.out.println("The winner of the Golden Boot is " + goldenBootWinner.playerName + " (" + goldenBootWinner.playerTeam + "), with " + goldenBootWinner.goalsScored + " goals!");
    }
}
