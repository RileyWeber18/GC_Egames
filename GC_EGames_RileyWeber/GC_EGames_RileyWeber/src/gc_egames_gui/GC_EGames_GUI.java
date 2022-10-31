/*
    Filename:   GC_EGames_GUI.java
    Purpose:    Set up GUI and functionality for the Gold Coast E-Games teams and competitions
                Constructor reads in data from 3 external files - competitions.csv, teams.csv and players.csv
                Uses Competition, Team and Player classes to store data (Team class aggregates an instance of the Player class)
                Array lists are used to store team and competition intances
    Author:     Riley Weber
    Date:       10-Mar-2022
    Version:    1.0
    License:    
    NOTES:      

*/
package gc_egames_gui;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;



public class GC_EGames_GUI extends javax.swing.JFrame 
{
    // Default table model used to customise columns for JTable
    private DefaultTableModel resultsTableModel;
    // ArrayLists of team and competition instances (dynamic data structures)
    private ArrayList<Team> teams;
    private ArrayList<Competition> competitions;
    private ArrayList<Player> player;
    // NOTE: This prevents the combo box event handlers from being triggered when adding new data to them
    private boolean comboBoxStatus;
    private int row;
   

    /***************************************************************************************************
    Method:     GC_EGames_GUI() 
    Purpose:    Constructor method - creates new form GC_EGames_GUI (instantiates form object
                and initialises private data and GUI components
    Inputs:     void
    Outputs:    none as constructor methods have no return type
    ****************************************************************************************************/
  public void writeToCSV(String fileName, String values)
    {
        try
        {
            //WRITES NEW LINE TO CSV FILE
            //FileWriter(fileName, append = true), so it adds to the file
            // rather than replacing all the data
            FileWriter writer = new FileWriter(fileName, true);
            writer.append("\n" + values);
            writer.close();
            
            //if writing to the teams file
            if(fileName.equals("teams.csv"))
            {
                //clears the teams array
                teams.clear();
                //re-reads team data (populates teams array)
                readTeamData();
                //fills drop-down boxes with team data
              updateTeam_JComboBox.removeAllItems();
            }
            
            //if writing to the competitions file
            if(fileName.equals("competitions.csv"))
            {
                //clears the competitions array
                competitions.clear();
                //re-reads competitions data
                readCompetitionData();
                //re-displays JTable
                displayJTable();
            }
            
        }
        catch(Exception e)
        {
            System.out.println("ERROR: Unable to write to CSV!");
        }
        
    }
    
    
    
    
    public GC_EGames_GUI() 
    {
        /*********** CUSTOM JTABLE USING DEFAULT TABLE MODEL ***********/
        // customised column names for movie JTable
        String [] columnNames_Results = new String[] {"Date", "Location", "Game", "Team", "Points"};
        // default row for movie JTable
        //Object[] defaultData_Results = {"NA", "NA", "NA", "NA", "0"};
        // set up customisation for competition results JTable
        resultsTableModel = new DefaultTableModel();
        
        String [] coloumnNames_Results
                = new String[] {"Date", "Location", "Game", "Team", "Points"};
        resultsTableModel.setColumnIdentifiers(columnNames_Results);
        //resultsTableModel.addRow(defaultData_Results);
        
        /*********** INITIALISE PRIVATE DATA FIELDS ***********/
        // initialise array lists
        teams = new ArrayList<Team>();
        competitions = new ArrayList<Competition>();
        player = new ArrayList<Player>();
        
        /*********** SET comboBoxStatus boolean to false ***********/
        comboBoxStatus = false;

  
        /*********** INITIALISE ALL SWING CONTROLS ***********/
        initComponents();
        
        /*********** CUSTOMISE TABLE COLUMNS FOR JTABLE ***********/
        resizeTableColumns();
        
        /*********** READ IN EXTERNAL CSV FILES TO GET DATA FOR teams and competitions ***********/
        readTeamData();
       
        readCompetitionData();
        
        // Test only
        
        if (teams.size() > 0)
        {
            for (int i = 0; i < teams.size(); i++)
            {
                System.out.println(i + " " + teams.get(i).toString());
            }
        }
        
        System.out.println("-----------------------------------------");
        if (competitions.size() > 0)
        {
            for (int i = 0; i < competitions.size(); i++)
            {
                System.out.println(i + " " + competitions.get(i).toCSVString());
            }
        }
        System.out.println("-----------------------------------------");
        
        
        /*********** DISPLAY COMPETITION DATE IN JTABLE ***********/
        displayJTable();
        
       
        
        
        
        
        /*********** SET UP STRING VALUES IN JCOMBO-BOXES ***********/
        // set up string values for JComboBox (team names)
        // for addNewCompTeam_JComboBox and updateTeam_JComboBox
        resetComboBoxes();
        

        /*********** SET comboBoxStatus boolean to true ***********/
        comboBoxStatus = true;
        
        /*********** DISPLAY DEFAULT-SELECTED TEAM INFO ***********/
        // display the default-selected team info (for update an existing team tab panel)
        displayTeamInfo();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header_JPanel = new javax.swing.JPanel();
        title_JLabel = new javax.swing.JLabel();
        body_JPanel = new javax.swing.JPanel();
        body_JTabbedPane = new javax.swing.JTabbedPane();
        teamCompetitionResultsTab_JPanel = new javax.swing.JPanel();
        teamCompetitionResults_JLabel = new javax.swing.JLabel();
        teamCompetitionResults_JScrollPane = new javax.swing.JScrollPane();
        results_JTable = new javax.swing.JTable();
        displayTopTeams_JButton = new javax.swing.JButton();
        addTeamTab_JPanel = new javax.swing.JPanel();
        newTeamName_JLabel = new javax.swing.JLabel();
        newContactPerson_JLabel = new javax.swing.JLabel();
        newContactPhone_JLabel = new javax.swing.JLabel();
        newContactEmail_JLabel = new javax.swing.JLabel();
        titleAddNewTeam_JLabel = new javax.swing.JLabel();
        newTeamName_JTextField = new javax.swing.JTextField();
        newContactPhone_JTextField = new javax.swing.JTextField();
        newContactPerson_JTextField = new javax.swing.JTextField();
        newContactEmail_JTextField = new javax.swing.JTextField();
        saveNewTeam_JButton = new javax.swing.JButton();
        playerNames_JLabel = new javax.swing.JLabel();
        newPlayerNames_JScrollPane = new javax.swing.JScrollPane();
        newPlayerNames_JTextArea = new javax.swing.JTextArea();
        addNewCompetitionResultTab_JPanel = new javax.swing.JPanel();
        addGame_JLabel = new javax.swing.JLabel();
        addDate_JLabel = new javax.swing.JLabel();
        addLocation_JLabel = new javax.swing.JLabel();
        titleCompetitions_JLabel = new javax.swing.JLabel();
        addNewCompDate_JTextField = new javax.swing.JTextField();
        addNewCompLocation_JTextField = new javax.swing.JTextField();
        addNewCompGame_JTextField = new javax.swing.JTextField();
        saveNewCompetitionResult_JButton = new javax.swing.JButton();
        addNewCompTeam_JLabel = new javax.swing.JLabel();
        addNewCompTeam_JComboBox = new javax.swing.JComboBox<>();
        addNewCompPoints_JLabel = new javax.swing.JLabel();
        addNewCompPoints_JTextField = new javax.swing.JTextField();
        updateExistingTeamTab_JPanel = new javax.swing.JPanel();
        addResultTitle_JLabel = new javax.swing.JLabel();
        AddResultTeam_JLabel = new javax.swing.JLabel();
        updateTeam_JComboBox = new javax.swing.JComboBox<>();
        saveUpdateTeam_JButton = new javax.swing.JButton();
        updateContactPerson_JLabel = new javax.swing.JLabel();
        updateContactPerson_JTextField = new javax.swing.JTextField();
        updateContactPhone_JLabel = new javax.swing.JLabel();
        updateContactPhone_JTextField = new javax.swing.JTextField();
        updateContactEmail_JLabel = new javax.swing.JLabel();
        updateContactEmail_JTextField = new javax.swing.JTextField();
        updatePlayerNames_JLabel = new javax.swing.JLabel();
        updatePlayerNames_JScrollPane = new javax.swing.JScrollPane();
        updatePlayerNames_JTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        header_JPanel.setBackground(new java.awt.Color(255, 102, 51));
        header_JPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        title_JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title_JLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GoldCoastESports_Header.jpg"))); // NOI18N

        javax.swing.GroupLayout header_JPanelLayout = new javax.swing.GroupLayout(header_JPanel);
        header_JPanel.setLayout(header_JPanelLayout);
        header_JPanelLayout.setHorizontalGroup(
            header_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title_JLabel)
        );
        header_JPanelLayout.setVerticalGroup(
            header_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title_JLabel)
        );

        body_JPanel.setBackground(new java.awt.Color(255, 255, 255));

        body_JTabbedPane.setBackground(new java.awt.Color(255, 255, 255));

        teamCompetitionResultsTab_JPanel.setBackground(new java.awt.Color(255, 255, 255));

        teamCompetitionResults_JLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        teamCompetitionResults_JLabel.setText("Team Competition Results");

        results_JTable.setAutoCreateRowSorter(true);
        results_JTable.setModel(resultsTableModel);
        teamCompetitionResults_JScrollPane.setViewportView(results_JTable);

        displayTopTeams_JButton.setText("Display top teams");
        displayTopTeams_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayTopTeams_JButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout teamCompetitionResultsTab_JPanelLayout = new javax.swing.GroupLayout(teamCompetitionResultsTab_JPanel);
        teamCompetitionResultsTab_JPanel.setLayout(teamCompetitionResultsTab_JPanelLayout);
        teamCompetitionResultsTab_JPanelLayout.setHorizontalGroup(
            teamCompetitionResultsTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamCompetitionResultsTab_JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(teamCompetitionResults_JScrollPane)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamCompetitionResultsTab_JPanelLayout.createSequentialGroup()
                .addContainerGap(95, Short.MAX_VALUE)
                .addGroup(teamCompetitionResultsTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamCompetitionResultsTab_JPanelLayout.createSequentialGroup()
                        .addComponent(teamCompetitionResults_JLabel)
                        .addGap(474, 474, 474))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, teamCompetitionResultsTab_JPanelLayout.createSequentialGroup()
                        .addComponent(displayTopTeams_JButton)
                        .addContainerGap())))
        );
        teamCompetitionResultsTab_JPanelLayout.setVerticalGroup(
            teamCompetitionResultsTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(teamCompetitionResultsTab_JPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(teamCompetitionResults_JLabel)
                .addGap(18, 18, 18)
                .addComponent(teamCompetitionResults_JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(displayTopTeams_JButton)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        body_JTabbedPane.addTab("Team competition results", teamCompetitionResultsTab_JPanel);

        addTeamTab_JPanel.setBackground(new java.awt.Color(255, 255, 255));

        newTeamName_JLabel.setText("Team Name:");

        newContactPerson_JLabel.setText("Contact Person:");

        newContactPhone_JLabel.setText("Contact Phone:");

        newContactEmail_JLabel.setText("Contact Email:");

        titleAddNewTeam_JLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleAddNewTeam_JLabel.setText("Add new team");

        saveNewTeam_JButton.setText("SAVE NEW TEAM");
        saveNewTeam_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNewTeam_JButtonActionPerformed(evt);
            }
        });

        playerNames_JLabel.setText("Player names:");

        newPlayerNames_JScrollPane.setHorizontalScrollBar(null);

        newPlayerNames_JTextArea.setColumns(20);
        newPlayerNames_JTextArea.setRows(5);
        newPlayerNames_JScrollPane.setViewportView(newPlayerNames_JTextArea);

        javax.swing.GroupLayout addTeamTab_JPanelLayout = new javax.swing.GroupLayout(addTeamTab_JPanel);
        addTeamTab_JPanel.setLayout(addTeamTab_JPanelLayout);
        addTeamTab_JPanelLayout.setHorizontalGroup(
            addTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTeamTab_JPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(addTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(saveNewTeam_JButton)
                    .addGroup(addTeamTab_JPanelLayout.createSequentialGroup()
                        .addGroup(addTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titleAddNewTeam_JLabel)
                            .addComponent(newContactEmail_JLabel)
                            .addComponent(newContactPhone_JLabel)
                            .addComponent(newContactPerson_JLabel)
                            .addComponent(newTeamName_JLabel)
                            .addComponent(playerNames_JLabel))
                        .addGap(33, 33, 33)
                        .addGroup(addTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newTeamName_JTextField)
                            .addComponent(newContactPhone_JTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(newContactPerson_JTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(newContactEmail_JTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(newPlayerNames_JScrollPane))))
                .addContainerGap(300, Short.MAX_VALUE))
        );
        addTeamTab_JPanelLayout.setVerticalGroup(
            addTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addTeamTab_JPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(titleAddNewTeam_JLabel)
                .addGap(18, 18, 18)
                .addGroup(addTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTeamName_JLabel)
                    .addComponent(newTeamName_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newContactPerson_JLabel)
                    .addComponent(newContactPerson_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newContactPhone_JLabel)
                    .addComponent(newContactPhone_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newContactEmail_JLabel)
                    .addComponent(newContactEmail_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(addTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerNames_JLabel)
                    .addComponent(newPlayerNames_JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveNewTeam_JButton)
                .addGap(52, 52, 52))
        );

        body_JTabbedPane.addTab("Add new team", addTeamTab_JPanel);

        addNewCompetitionResultTab_JPanel.setBackground(new java.awt.Color(255, 255, 255));

        addGame_JLabel.setText("Game:");

        addDate_JLabel.setText("Date:");

        addLocation_JLabel.setText("Location:");

        titleCompetitions_JLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleCompetitions_JLabel.setText("Add new competition result");

        saveNewCompetitionResult_JButton.setText("SAVE NEW COMPETITION RESULT");
        saveNewCompetitionResult_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveNewCompetitionResult_JButtonActionPerformed(evt);
            }
        });

        addNewCompTeam_JLabel.setText("Team:");

        addNewCompTeam_JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        addNewCompTeam_JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewCompTeam_JComboBoxActionPerformed(evt);
            }
        });

        addNewCompPoints_JLabel.setText("Points");

        addNewCompPoints_JTextField.setText("0");

        javax.swing.GroupLayout addNewCompetitionResultTab_JPanelLayout = new javax.swing.GroupLayout(addNewCompetitionResultTab_JPanel);
        addNewCompetitionResultTab_JPanel.setLayout(addNewCompetitionResultTab_JPanelLayout);
        addNewCompetitionResultTab_JPanelLayout.setHorizontalGroup(
            addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNewCompetitionResultTab_JPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleCompetitions_JLabel)
                    .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(saveNewCompetitionResult_JButton)
                        .addGroup(addNewCompetitionResultTab_JPanelLayout.createSequentialGroup()
                            .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addNewCompPoints_JLabel)
                                .addComponent(addNewCompTeam_JLabel))
                            .addGap(53, 53, 53)
                            .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addNewCompTeam_JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addNewCompPoints_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(addNewCompetitionResultTab_JPanelLayout.createSequentialGroup()
                            .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addLocation_JLabel)
                                .addComponent(addDate_JLabel)
                                .addComponent(addGame_JLabel))
                            .addGap(53, 53, 53)
                            .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addNewCompDate_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addNewCompGame_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addNewCompLocation_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(354, Short.MAX_VALUE))
        );
        addNewCompetitionResultTab_JPanelLayout.setVerticalGroup(
            addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addNewCompetitionResultTab_JPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(titleCompetitions_JLabel)
                .addGap(18, 18, 18)
                .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDate_JLabel)
                    .addComponent(addNewCompDate_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLocation_JLabel)
                    .addComponent(addNewCompLocation_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addGame_JLabel)
                    .addComponent(addNewCompGame_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewCompTeam_JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNewCompTeam_JLabel))
                .addGap(18, 18, 18)
                .addGroup(addNewCompetitionResultTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addNewCompPoints_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNewCompPoints_JLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(saveNewCompetitionResult_JButton)
                .addGap(104, 104, 104))
        );

        body_JTabbedPane.addTab("Add new competition result", addNewCompetitionResultTab_JPanel);

        updateExistingTeamTab_JPanel.setBackground(new java.awt.Color(255, 255, 255));

        addResultTitle_JLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addResultTitle_JLabel.setText("Update an existing team");

        AddResultTeam_JLabel.setText("Team:");

        updateTeam_JComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        updateTeam_JComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTeam_JComboBoxActionPerformed(evt);
            }
        });

        saveUpdateTeam_JButton.setText("SAVE UPDATE FOR THIS TEAM");
        saveUpdateTeam_JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveUpdateTeam_JButtonActionPerformed(evt);
            }
        });

        updateContactPerson_JLabel.setText("Contact Person:");

        updateContactPhone_JLabel.setText("Contact Phone:");

        updateContactEmail_JLabel.setText("Contact Email:");

        updatePlayerNames_JLabel.setText("Player names:");

        updatePlayerNames_JScrollPane.setHorizontalScrollBar(null);

        updatePlayerNames_JTextArea.setColumns(20);
        updatePlayerNames_JTextArea.setRows(5);
        updatePlayerNames_JScrollPane.setViewportView(updatePlayerNames_JTextArea);

        javax.swing.GroupLayout updateExistingTeamTab_JPanelLayout = new javax.swing.GroupLayout(updateExistingTeamTab_JPanel);
        updateExistingTeamTab_JPanel.setLayout(updateExistingTeamTab_JPanelLayout);
        updateExistingTeamTab_JPanelLayout.setHorizontalGroup(
            updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateExistingTeamTab_JPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, updateExistingTeamTab_JPanelLayout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addComponent(AddResultTeam_JLabel)
                            .addGap(33, 33, 33)
                            .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(saveUpdateTeam_JButton)
                                .addComponent(updateTeam_JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(updateExistingTeamTab_JPanelLayout.createSequentialGroup()
                                .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(updateContactEmail_JLabel)
                                    .addComponent(updateContactPhone_JLabel)
                                    .addComponent(updatePlayerNames_JLabel)
                                    .addComponent(updateContactPerson_JLabel))
                                .addGap(33, 33, 33)
                                .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(updateContactPhone_JTextField)
                                    .addComponent(updateContactEmail_JTextField)
                                    .addComponent(updatePlayerNames_JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(updateContactPerson_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addResultTitle_JLabel))
                .addContainerGap(342, Short.MAX_VALUE))
        );
        updateExistingTeamTab_JPanelLayout.setVerticalGroup(
            updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(updateExistingTeamTab_JPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(addResultTitle_JLabel)
                .addGap(18, 18, 18)
                .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddResultTeam_JLabel)
                    .addComponent(updateTeam_JComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateContactPerson_JLabel)
                    .addComponent(updateContactPerson_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateContactPhone_JLabel)
                    .addComponent(updateContactPhone_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateContactEmail_JLabel)
                    .addComponent(updateContactEmail_JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(updateExistingTeamTab_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updatePlayerNames_JLabel)
                    .addComponent(updatePlayerNames_JScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(saveUpdateTeam_JButton)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        body_JTabbedPane.addTab("Update an existing team", updateExistingTeamTab_JPanel);

        javax.swing.GroupLayout body_JPanelLayout = new javax.swing.GroupLayout(body_JPanel);
        body_JPanel.setLayout(body_JPanelLayout);
        body_JPanelLayout.setHorizontalGroup(
            body_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body_JTabbedPane)
        );
        body_JPanelLayout.setVerticalGroup(
            body_JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body_JTabbedPane)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body_JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header_JPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(body_JPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /***************************************************************************************************
    Method:     updateTeam_JComboBoxActionPerformed() 
    Purpose:    Event handler method for update team JComboBox (when choice is made)
                User selects option from JComboBox and this method is called (triggered from user choice)
    Inputs:     ActionEvent evt --- the event object which contains info about the JComboBox source
    Outputs:    void
    ****************************************************************************************************/
    private void updateTeam_JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTeam_JComboBoxActionPerformed
        // display team details when combo-box selection for team name is changed
        // check if tab click already made
       
        if (comboBoxStatus == true)
        {
            displayTeamInfo();
        }
        

    }//GEN-LAST:event_updateTeam_JComboBoxActionPerformed

    /***************************************************************************************************
    Method:     saveNewTeam_JButtonActionPerformed() 
    Purpose:    Event handler method for Save new team button (when clicked)
                User clicks button to save a new team (details entered into a number of JTextField objects
                and this method is called (triggered from user button mouse-click)
    Inputs:     ActionEvent evt --- the event object which contains info about the JButton source
    Outputs:    void
    ****************************************************************************************************/
    private void saveNewTeam_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNewTeam_JButtonActionPerformed
        // saves a new team
        // 1. GET ALL DATA REQUIRED
        String newTeamName = newTeamName_JTextField.getText();
        String newContactPerson = newContactPerson_JTextField.getText();
        String newContactPhone = newContactPhone_JTextField.getText();
        String newContactEmail = newContactEmail_JTextField.getText();
        String [] newPlayerNames = newPlayerNames_JTextArea.getText().split("\\n");
        
        

        
        // 2. CHECK IF ALL NEW TEAM DATA IS PRESENT AND ACCURATE
        System.out.println("New Team Data");

        
        
        
        
        // 3. CONFIRM TO PROCEED OR NOT
        int yesOrNo = javax.swing.JOptionPane.showConfirmDialog(null,
    "You are about to save a new team for:  " + newTeamName + "\nDo you wish to continue?", "ADD NEW TEAM", javax.swing.JOptionPane.YES_NO_OPTION);
        if (yesOrNo == javax.swing.JOptionPane.NO_OPTION)
        {
            // exit
            System.out.println("ADD NEW TEAM: " + newTeamName + " cancelled");
        }
        else
        {
            System.out.println("ADD NEW TEAM: " + newTeamName + " proceeding");
            
            // booleans to track weather any file write was successful or not
            boolean teamsWriteStatus = false;
            boolean playersWriteStatus = true;
            
            
            // write to external file(teams.csv - append mode)
            
               try
            {
                FileOutputStream outputStream = new FileOutputStream("teams.csv", true);
                
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                
                bufferedWriter.write(newTeamName + "," + newContactPerson + "," + newContactPhone + "," +newContactEmail );
                bufferedWriter.newLine();
                
                bufferedWriter.close();
                
                
            }
            catch (Exception e)
            {
                
                
                e.printStackTrace();
            }
            
               try
               {
                    FileOutputStream outputStream = new FileOutputStream("players.csv", true);
                
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
               
               for (int i = 0; i < newPlayerNames.length; i++)
               {
               bufferedWriter.write(newPlayerNames[i] + "," + newTeamName);
               bufferedWriter.newLine();
               }
               bufferedWriter.close();
              
               }
               catch (IOException e)
               {
                    e.printStackTrace();
               }
              
          
            
            
        }
  
    }//GEN-LAST:event_saveNewTeam_JButtonActionPerformed

    /***************************************************************************************************
    Method:     saveNewCompetitionResult_JButtonActionPerformed() 
    Purpose:    Event handler method for Save new competition result button (when clicked)
                User clicks button to save a new competition result (details entered into a number of JTextField objects
                and this method is called (triggered from user button mouse-click)
    Inputs:     ActionEvent evt --- the event object which contains info about the JButton source
    Outputs:    void
    ****************************************************************************************************/
    private void saveNewCompetitionResult_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveNewCompetitionResult_JButtonActionPerformed
        // save new competition result
        // 1. GET ALL DATA REQUIRED
        String competitionDate = addNewCompDate_JTextField.getText();
        String competitionLocation = addNewCompLocation_JTextField.getText();
        String competitionGame = addNewCompGame_JTextField.getText();
        String teamName = addNewCompTeam_JComboBox.getItemAt(addNewCompTeam_JComboBox.getSelectedIndex());
        String pointsStr = addNewCompPoints_JTextField.getText();
        int pointsInt = -1;

        // 2. CHECK IF ALL NEW TEAM DATA IS PRESENT AND ACCURATE
        System.out.println("New Team Data");
        
        
        
        // 3. CONFIRM TO PROCEED OR NOT
        int yesOrNo = javax.swing.JOptionPane.showConfirmDialog(null,
    "You are about to save a new competition entry for team:  " + teamName + "\nDo you wish to continue?", "ADD NEW COMPETITION RESULT", javax.swing.JOptionPane.YES_NO_OPTION);
        if (yesOrNo == javax.swing.JOptionPane.NO_OPTION)
        {
            // exit
            System.out.println("ADD NEW COMPETITION RESULT for team: " + teamName + " cancelled");
        }
        else
        {
            System.out.println("ADD NEW COMPETITION RESULT for team: " + teamName + " proceeding");
            
            // write to external file(competitions.csv - append mode)
            
        }   
        
    }//GEN-LAST:event_saveNewCompetitionResult_JButtonActionPerformed

    /***************************************************************************************************
    Method:     saveUpdateTeam_JButtonActionPerformed() 
    Purpose:    Event handler method for update existing team button (when clicked)
                User clicks button to save changes to the existing team selected (details entered into a number of JTextField objects
                and this method is called (triggered from user button mouse-click)
    Inputs:     ActionEvent evt --- the event object which contains info about the JButton source
    Outputs:    void
    ****************************************************************************************************/
    private void saveUpdateTeam_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveUpdateTeam_JButtonActionPerformed
        // save update for existing team
        // 1. GET ALL DATA REQUIRED
        String teamName = updateTeam_JComboBox.getItemAt(updateTeam_JComboBox.getSelectedIndex());
        String updateContactPerson = updateContactPerson_JTextField.getText();
        String updateContactPhone = updateContactPhone_JTextField.getText();
        String updateContactEmail = updateContactEmail_JTextField.getText();
        String [] updatePlayerNames = updatePlayerNames_JTextArea.getText().split("\\n");
        
        
        
        
        
        // 2. CHECK IF ALL UPDATE TEAM DATA IS PRESENT AND ACCURATE
        System.out.println("Update Team Data");
        
        
        // 3. CONFIRM TO PROCEED OR NOT
        int yesOrNo = javax.swing.JOptionPane.showConfirmDialog(null,
    "You are about to save an update to team: " + teamName + "\nDo you wish to continue?", "UPDATE EXISTING TEAM", javax.swing.JOptionPane.YES_NO_OPTION);
        if (yesOrNo == javax.swing.JOptionPane.NO_OPTION)
        {
            // exit
            System.out.println("UPDATE to team: " + teamName + " cancelled");
        }
        else
        {
            System.out.println("UPDATE to team: " + teamName + " proceeding");
            
            // change entry in teams ArrayList and player name listing for the updated team
            
          
            
            // write to external file(teams.csv - over-write mode)
           
            try
            {
                FileOutputStream outputStream = new FileOutputStream("teams.csv", true);
                
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");
                
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                
                bufferedWriter.write( updateContactPerson + "," + updateContactPhone + "," +updateContactEmail );
                bufferedWriter.newLine();
                
                bufferedWriter.close();
                 
                
            }
            catch (Exception e)
            {
                
                
                e.printStackTrace();
            }
            
            
            
        }

    }//GEN-LAST:event_saveUpdateTeam_JButtonActionPerformed

    /***************************************************************************************************
    Method:     displayTopTeams_JButtonActionPerformed() 
    Purpose:    Event handler method for display top teams button (when clicked)
                User clicks button to view top team details with total points of all games played
                and this method is called (triggered from user button mouse-click)
    Inputs:     ActionEvent evt --- the event object which contains info about the JButton source
    Outputs:    void
    ****************************************************************************************************/
    private void displayTopTeams_JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayTopTeams_JButtonActionPerformed
        
        // Display top teams by total points (highest scores to lowest scores in all games)
    //bubble sort
    
// Optimized java implementation
// of Bubble sort

  
 

       
     



   
       int arr[] ={22,15,15,18,16,13};  
       
     
     
                
                 
              
        // display string
        String displayString  = "TEAMS LEADER BOARD\n\nPoints     \t\tTeams\n";
         
        
                   
        
        

        javax.swing.JOptionPane.showMessageDialog(null,displayString, "TEAMS LEADER BOARD", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                  
        
    }//GEN-LAST:event_displayTopTeams_JButtonActionPerformed

    private void addNewCompTeam_JComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewCompTeam_JComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addNewCompTeam_JComboBoxActionPerformed

    /***************************************************************************************************
    Method:     main() 
    Purpose:    Entry point to the program --- sets up GUI form instance
                DO NOT EDIT
    Inputs:     String [] args --- an array of string values which can be used to set up customisations
                when run from the command line
    Outputs:    void
    ****************************************************************************************************/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GC_EGames_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GC_EGames_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GC_EGames_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GC_EGames_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GC_EGames_GUI().setVisible(true);
            }
        });
    }
    
    /***************************************************************************************************
    Method:     resizeTableColumns() 
    Purpose:    Resizes the customisation of the JTable (with use of DefaultTableModel)
    Inputs:     void
    Outputs:    void
    ****************************************************************************************************/
    public void resizeTableColumns()
    {
        // Columns: Date, Location, Competition, Platform, Team, Points
        // (total numeric values must = 1)
        double[] columnWidthPercentage = {0.2f, 0.2f, 0.3f, 0.2f, 0.1f};
        int tableWidth = results_JTable.getWidth();
        TableColumn column;
        TableColumnModel tableColumnModel = results_JTable.getColumnModel();
        int cantCols = tableColumnModel.getColumnCount();
        for (int i = 0; i < cantCols; i++) 
        {
            column = tableColumnModel.getColumn(i);
            float pWidth = Math.round(columnWidthPercentage[i] * tableWidth);
            column.setPreferredWidth((int)pWidth);
        }
    }
    
    /***************************************************************************************************
    Method:     readTeamData() 
    Purpose:    Reads external csv file data of teams.csv
                Sets up in the teams ArrayList<Team> object
                Also reads external csv file data of players.csv
                Sets up in the players names into the Team class (players ArrayList<String> data field)
    Inputs:     void
    Outputs:    void
    ****************************************************************************************************/
    public void readTeamData()
    {
        // get data from teams.csv file
     
    {
        try
        {
            //1. Create FileReader object to designate name of external CSV file
            FileReader reader = new FileReader("teams.csv");
            //2. Create bufferedReader which uses the reader object
            BufferedReader bufferedReader = new BufferedReader(reader);
            //3. Declare line string (used to read and store each
            // line read from external file
            String line;
            //4. Loop through each line in the external file
            //   until the EOF (end of file)
            while ((line = bufferedReader.readLine()) != null)
            {
                //System.out.println(line);
                if(line.length() > 0)
                {
                    //split the line by the comma delimiter
                    String[] splitData = line.split(",");
                   
                    
                    String teamName = splitData[0];
                    String contactName = splitData[1];
                    String contactPhone = splitData[2];
                    String contactEmail = splitData[3];
                    //create new Team object
                    Team team = new Team(teamName, contactName, 
                                         contactPhone, contactEmail);
                    //add the instance to ArrayList teams
                    teams.add(team);
                }
            }
            
            //5. Close the reader object
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println("ERROR: Unable to read file!");
        }
    }
        
    }
    
    /***************************************************************************************************
    Method:     readCompetitionData() 
    Purpose:    Reads the competitions.csv external file and
                sets up all read data into the competitions ArrayList<Competition> object
    Inputs:     void
    Outputs:    void
    ****************************************************************************************************/
    public void readCompetitionData()
    {
        // get data from competitons.csv file
        try 
        {
            // 1. Create reader and designate external file to read from
            FileReader reader = new FileReader("competitions.csv");
            // 2. Create bufferedReader which uses the reader object
            BufferedReader bufferedReader = new BufferedReader(reader);
            // 3. Declare line string (used to read and store each 
            //    line read from the external file)
            String line;
                        
                        
            // 4. Loop through each line in the external file 
            //    until the EOF (end of file)
            while ((line = bufferedReader.readLine()) != null)
            {
                
                // System.out.println(line);
                // Check if line is not empty and contains something
                if (line.length() > 0)
                {
                    // split the line by its delimiter comma 
                    // and set up each value in the lines array
                    String [] lines = line.split(",");
                    
                    // set up individual variables for each split line component
                    String game = lines[0];
                    String competitionDate = lines[1];
                    String location = lines[2];
                    String team = lines[3];
                    int points = Integer.parseInt(lines[4]);
                    
                    // add competition to ArrayList<Competition> competitions
                    competitions.add(new Competition(game, competitionDate, location, team, points));
                }
                
            }
            // 5. Close the reader object
            reader.close();
            
        }
        catch (FileNotFoundException e)
        {
            // catch any file not found exception
            System.out.println("ERROR: competitions.csv file not found!");
            //e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR!", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (IOException e)
        {
            // catch any File IO-related exception
            System.out.println("ERROR: competitions.csv file found, but there is a read problem!");
            //e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR!", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (NumberFormatException e)
        {
            // catch any number format exception
            System.out.println("ERROR: Number format exception - trying to covert a string to an integer!");
            //e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR!", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
        catch (Exception e)
        {
            // catch any other exception
            //e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(null,e.getMessage(), "ERROR!", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /***************************************************************************************************
    Method:     displayJTable() 
    Purpose:    Sets up the display of all competition data (from the competitions ArrayList<Competition> object)
                using an Object[][] array
    Inputs:     void
    Outputs:    void
    ****************************************************************************************************/
    public void displayJTable()
    {
        // populate team competition data into results_JTable
         {
       if (competitions.size() >0)
       {
           Object [][] competitions2DArray = new Object[competitions.size()][];
           // populate array
           for (int i = 0; i <competitions2DArray.length; i++)
           {
               Object[] competition = new Object[5];
               competition[0] = competitions.get(i).getDate();
               competition[1] = competitions.get(i).getLocation();
               competition[2] = competitions.get(i).getPoints();
               competition[3] = competitions.get(i).getTeamName();
               competition[4] = competitions.get(i).getGame();
               //add competiton to comeptition2DArray
               competitions2DArray[i] = competition;
           }
           System.out.println(competitions2DArray.length);
           if (resultsTableModel.getRowCount() > 0)
           {
               
               for (int i = resultsTableModel.getRowCount() - 1; i > -1; i--)
               {
                   resultsTableModel.removeRow(i);
               }
           }
      
           for (int row = 0; row < competitions2DArray.length; row++)
           {
               resultsTableModel.addRow(competitions2DArray[row]);
           }
           resultsTableModel.fireTableDataChanged();
       }
      
    }
    }
    /***************************************************************************************************
    Method:     resetComboBoxes() 
    Purpose:    Sets up string values for all JComboBox controls
                (names of teams) as options to select
    Inputs:     void
    Outputs:    void
    ****************************************************************************************************/
    public void resetComboBoxes()
    {
        // set up string values for JComboBox (team names)
        // these are for addNewCompTeam_JComboBox and updateTeam_JComboBox
   
    {
        //clears the combo boxes
        addNewCompTeam_JComboBox.removeAllItems();
        updateTeam_JComboBox.removeAllItems();
        
        //loops through all teams
        for(int i = 0; i < teams.size(); i++)
        {
            //adds team names to combo boxes
            addNewCompTeam_JComboBox.addItem(teams.get(i).getTeamName());
            updateTeam_JComboBox.addItem(teams.get(i).getTeamName());
        }
        
    }
        
    }
    
    /***************************************************************************************************
    Method:     displayTeamInfo() 
    Purpose:    Sets up JTextFields with a default team selection in the team tab panel
    Inputs:     void
    Outputs:    void
    ****************************************************************************************************/
    public void displayTeamInfo()
    {
        // for update existing team tab panel
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddResultTeam_JLabel;
    private javax.swing.JLabel addDate_JLabel;
    private javax.swing.JLabel addGame_JLabel;
    private javax.swing.JLabel addLocation_JLabel;
    private javax.swing.JTextField addNewCompDate_JTextField;
    private javax.swing.JTextField addNewCompGame_JTextField;
    private javax.swing.JTextField addNewCompLocation_JTextField;
    private javax.swing.JLabel addNewCompPoints_JLabel;
    private javax.swing.JTextField addNewCompPoints_JTextField;
    private javax.swing.JComboBox<String> addNewCompTeam_JComboBox;
    private javax.swing.JLabel addNewCompTeam_JLabel;
    private javax.swing.JPanel addNewCompetitionResultTab_JPanel;
    private javax.swing.JLabel addResultTitle_JLabel;
    private javax.swing.JPanel addTeamTab_JPanel;
    private javax.swing.JPanel body_JPanel;
    private javax.swing.JTabbedPane body_JTabbedPane;
    private javax.swing.JButton displayTopTeams_JButton;
    private javax.swing.JPanel header_JPanel;
    private javax.swing.JLabel newContactEmail_JLabel;
    private javax.swing.JTextField newContactEmail_JTextField;
    private javax.swing.JLabel newContactPerson_JLabel;
    private javax.swing.JTextField newContactPerson_JTextField;
    private javax.swing.JLabel newContactPhone_JLabel;
    private javax.swing.JTextField newContactPhone_JTextField;
    private javax.swing.JScrollPane newPlayerNames_JScrollPane;
    private javax.swing.JTextArea newPlayerNames_JTextArea;
    private javax.swing.JLabel newTeamName_JLabel;
    private javax.swing.JTextField newTeamName_JTextField;
    private javax.swing.JLabel playerNames_JLabel;
    private javax.swing.JTable results_JTable;
    private javax.swing.JButton saveNewCompetitionResult_JButton;
    private javax.swing.JButton saveNewTeam_JButton;
    private javax.swing.JButton saveUpdateTeam_JButton;
    private javax.swing.JPanel teamCompetitionResultsTab_JPanel;
    private javax.swing.JLabel teamCompetitionResults_JLabel;
    private javax.swing.JScrollPane teamCompetitionResults_JScrollPane;
    private javax.swing.JLabel titleAddNewTeam_JLabel;
    private javax.swing.JLabel titleCompetitions_JLabel;
    private javax.swing.JLabel title_JLabel;
    private javax.swing.JLabel updateContactEmail_JLabel;
    private javax.swing.JTextField updateContactEmail_JTextField;
    private javax.swing.JLabel updateContactPerson_JLabel;
    private javax.swing.JTextField updateContactPerson_JTextField;
    private javax.swing.JLabel updateContactPhone_JLabel;
    private javax.swing.JTextField updateContactPhone_JTextField;
    private javax.swing.JPanel updateExistingTeamTab_JPanel;
    private javax.swing.JLabel updatePlayerNames_JLabel;
    private javax.swing.JScrollPane updatePlayerNames_JScrollPane;
    private javax.swing.JTextArea updatePlayerNames_JTextArea;
    private javax.swing.JComboBox<String> updateTeam_JComboBox;
    // End of variables declaration//GEN-END:variables
}
