/*
    Filename:   Player.java
    Purpose:    Class to hold data for a single player participating in Gold Coast E-Sports within a team
                Methods include all get() and set() and an override toString()
    Author:     Hans Telford --- provided to Riley Weber for ICTPRG430 AT2
    Date:       10-Mar-2022
    Version:    1.0
    License:    
    NOTES:      
 */
package gc_egames_gui;


public class Player 
{
    // private data fields
    private String playerName;
    private String teamName;
    
    // public constructor method (default - no input parameters)
    public Player()
    {
        this.playerName = "Default player";
        this.teamName = "Default team";
    }
    // public constructor method (with input parameters)
    public Player(String playerName, String teamName)
    {
        this.playerName =  playerName;
        this.teamName = teamName;
    }
    
    // get() methods for both private data fields
    public String getPlayerName()
    {
        return playerName;
    }
    
    public String getTeamName()
    {
        return teamName;
        
    }
    
    // set() methods for both private data fields
    public void setPlayerName (String playerName)
    {
        this.playerName = playerName;
    }
    
    public void setTeamName (String teamName)
    {
        this.teamName = teamName;
    }

    
    // override Object class toString() method
    @Override
    public String toString()
    {
        return "Player: " + playerName + "\nTeam: " + teamName;
        
    }
    
       
} // end class Team
