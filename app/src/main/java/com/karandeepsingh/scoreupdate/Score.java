package com.karandeepsingh.scoreupdate;

/**
 * Created by Karandeep Singh on 17-07-2018.
 */

public class Score {
    String team1Name;
    String team1Score;
    String team1Foul;
    String team2Name;
    String team2Score;
    String team2Foul;
    String escore1;
    String escore2;

    public void setEscore1(String escore1) {this.escore1 = escore1;}

    public void setEscore2(String escore2) { this.escore2 = escore2;}

    public void setTeam1Name(String team1Name) {
        this.team1Name = team1Name;
    }

    public String getTeam1Name() {
        return team1Name;
    }

    public String getTeam2Name() {
        return team2Name;
    }

    public void setTeam1Score(String team1Score) {
        this.team1Score = team1Score;
    }

    public void setTeam1Foul(String team1Foul) {
        this.team1Foul = team1Foul;
    }

    public void setTeam2Name(String team2Name) {
        this.team2Name = team2Name;
    }

    public void setTeam2Score(String team2Score) {
        this.team2Score = team2Score;
    }

    public void setTeam2Foul(String team2Foul) {
        this.team2Foul = team2Foul;
    }
}
