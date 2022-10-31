/*
    Filename:   Team.java
    Purpose:    Class to hold data for each team (Gold Coast E-Sports)
                Methods include all get() and set() an override toString() and a toCSVString()
    Author:     Hans Telford --- provided to Riley Weber for ICTPRG430 AT2
    Date:       10-Mar-2022
    Version:    1.0
    License:    
    NOTES:      
 */
package gc_egames_gui;

import java.util.ArrayList;


public class Team 
{
    // private data fields
    private String TeamName;
    private String ContactPerson;
    private String ContactPhone;
    private String ContactEmail;
    private ArrayList<String> players;
    
    // public constructor method (with input parameters)
    public Team (String TeamName, String ContactPerson, String ContactPhone, String ContactEmail)
    {
        this.TeamName = TeamName;
        this.ContactPerson = ContactPerson;
        this.ContactPhone = ContactPhone;
        this.ContactEmail = ContactEmail;
        this.players = new ArrayList<String>();
    }
    
    // public get() methods
    public String getTeamName()
    {
        return TeamName;
    }
    
    public String getContactPerson()
    {
        return ContactPerson;
    }
    
    public String getContactPhone()
    {
        return ContactPhone;
    }
    
    public String getContactEmail()
    {
        return ContactEmail;
    }
    
    public ArrayList<String> getPlayers()
    {
        return players;
    }
    
    // public set() methods
    public void setTeam(String team)
    {
        this.TeamName = TeamName;
    }
    
    public void setContactPerson(String contactPerson)
    {
         this.ContactPerson = contactPerson;
    }
    
    public void setContactPhone(String contactPhone)
    {
        this.ContactPhone = contactPhone;
    }
    
    public void setContactEmail(String contactEmail)
    {
        this.ContactEmail = contactEmail;
    }
    
    public void setPlayer (String playerName)
    {
        this.players.add(playerName);
    }
    
    public void removePlayers ()
    {
        if (players.size() > 0)
        {
            players.clear();
        }
    }
    
    // override Object class toString() method
    @Override
    public String toString()
    {
        String playersNames = "";
        if (players.size() > 0)
        {
            for (int i = 0; i < players.size(); i++)
            {
                playersNames += players.get(i) + ", ";
            }
        }
        return "Team: " + TeamName + "\nContact Person: " + ContactPerson + "\nContact Phone: " + ContactPhone + "\nContact Email: " + ContactEmail + "\nPlayer Names: " + playersNames;
    }
    
    // method that returns a CSV string format of the private data - used for writing to an external file
    public String toCSVString()
    {
        return TeamName + "," + ContactPerson + "," + ContactPhone + "," + ContactEmail;
    }

   
    
}
