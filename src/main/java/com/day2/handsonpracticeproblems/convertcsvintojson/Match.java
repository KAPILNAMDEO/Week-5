package com.day2.handsonpracticeproblems.convertcsvintojson;

import com.opencsv.bean.CsvBindByName;

public class Match {
    @CsvBindByName(column = "match_id")
    private int matchId;

    @CsvBindByName(column = "team1")
    private String team1;

    @CsvBindByName(column = "team2")
    private String team2;

    @CsvBindByName(column = "score_team1")
    private int scoreTeam1;

    @CsvBindByName(column = "score_team2")
    private int scoreTeam2;

    @CsvBindByName(column = "winner")
    private String winner;

    @CsvBindByName(column = "player_of_match")
    private String playerOfMatch;

    public Match() {
    }

    public int getMatchId() { return matchId; }
    public void setMatchId(int matchId) { this.matchId = matchId; }
    public String getTeam1() { return team1; }
    public void setTeam1(String team1) { this.team1 = team1; }
    public String getTeam2() { return team2; }
    public void setTeam2(String team2) { this.team2 = team2; }
    public int getScoreTeam1() { return scoreTeam1; }
    public void setScoreTeam1(int scoreTeam1) { this.scoreTeam1 = scoreTeam1; }
    public int getScoreTeam2() { return scoreTeam2; }
    public void setScoreTeam2(int scoreTeam2) { this.scoreTeam2 = scoreTeam2; }
    public String getWinner() { return winner; }
    public void setWinner(String winner) { this.winner = winner; }
    public String getPlayerOfMatch() { return playerOfMatch; }
    public void setPlayerOfMatch(String playerOfMatch) { this.playerOfMatch = playerOfMatch; }
}
