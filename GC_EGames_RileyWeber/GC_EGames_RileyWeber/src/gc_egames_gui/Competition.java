/*

    Filename:   Competition.java
    Purpose:    Class to hold data for each competition event
                Methods include all get() and set() and an override toString()
    Author:     Hans Telford --- provided to Riley Weber for ICTPRG430 AT2
    Date:       10-Mar-2022
    Version:    1.0
    License:    
    NOTES:      
 */
package gc_egames_gui;


public class Competition 
{
    // private data fields
    private String Game;
    private String Date;
    private String Location;
    private String Team;
  
    private int points;
    
    // public constructor method (with input parameters)
    public Competition (String Game, String CompetitionDate, String Location, String Team, int Points)
    {
        this.Game = Game;
        this.Date = CompetitionDate;
        this.Location = Location;
        this.Team = Team;
        this.points = points;
    }
    
    // public get() methods for each of the 5 private data fields
    public String getGame()
    {
        return Game;
    }
    
    public String getDate()
    {
        return Date;
    }
    
    public String getLocation()
    {
        return Location;
    }
    
    public String getTeamName()
    {
        return Team;
    }
    
    public int getPoints()
    {
        return points;
    }
    
    // public set() methods for each of the 5 private data fields
    public void setGame(String game)
    {
        this.Game = game;
    }
    
    public void setDate(String competitionDate)
    {
        this.Date = competitionDate;
    }
    
    public void setLocation(String location)
    {
        this.Location = location;
    }
    
    public void setTeamName(String team)
    {
        this.Team = team;
    }
    
    public void setPoints (int points)
    {
        this.points = points;
    }
    
    // override Object toString() method
    @Override
    public String toString()
    {
        return "Game: " + Game + "\nDate: " + Date + "\nLocation: " + Location + "\nTeam: " + Team + "\nPoints: " + points;
    }
    public String toCSVString()
    {
        return Game + "," + Date + "," + Location + "," + Team + "," + points;
    }
}
