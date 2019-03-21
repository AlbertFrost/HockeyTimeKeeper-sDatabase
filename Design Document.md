# Hockey Time Keeper's Database Design

This document explains the design for a hockey time keeper's database which allows us to simulate a database that holds players' roster information, including age, height, weight etc. Each players' play statistics including shots, goals, assists and power play actions. Additionally, it is also capable of recording shots, goals, power play goals and assists for either.

## Public Interface

There are three classes for this software. The first is the Player class which encapsulates a hockey player's roster and play information while providing derived statistics of the player's information when called upon. The second class is the Player List class which holds a list of the Player class which then can be rearranged into desired formats for the user to see. The final class is the Main class which the user interacts with to view the data within the PlayerList class.

Each of the classes described above will be expanded in the following sections, starting with the Player class, then PlayerList class and finally the Main class.

### Player

The Player class is a super class responsible of holding the roster information for the sub classes skater and goalie.

##### Constructor
* [String] Name, 
* [String] Date of Birth,
* [String] Home Town,
* [String] Weight,
* [String] Height,
* [String] Number,
* [String] POSITION.[forward (F), left wing (LW), right wing (RW), center (C), defense (D), or goalie (G)]

The Player class will need the following accessor methods:
* ```getName``` which returns the name of the Player [String]
* ```getDOB``` which returns the date of birth of the Player [String]
* ```getHomeTown``` which returns the home town of the Player [String]
* ```getWeight``` which returns the weight of the Player [String]
* ```getHeight``` which returns the height of the Player [String]
* ```getPosition``` which returns the position of the Player [String]

#### Skater

The Skater class is a sub class of the Player class that is responsible for holding the stats information of shots, goals, etc. and modifiying it appropraitly when needed.

The Skater class has two constuctors:

##### Only Roster Constructor
* [String] Name, 
* [String] Date of Birth,
* [String] Home Town,
* [String] Weight,
* [String] Height,
* [String] Number,
* [String] POSITION.[forward (F), left wing (LW), right wing (RW), center (C), defense (D), or goalie (G)]

#### Roster and Play Information
* [String] Name, 
* [String] Date of Birth,
* [String] Home Town,
* [String] Weight,
* [String] Height,
* [String] Number,
* [String] POSITION.[forward (F), left wing (LW), right wing (RW), center (C), defense (D), or goalie (G)],
* [int] Goals,
* [int] Assists,
* [int] Power Play Goals,
* [int] Power Play Assists,
* [int] Shots

The Skater class will have the following accessor methods:
* ```getPoints``` which returns the points (goals and assists together) of the Player [int]
* ```getGoals``` which returns the goals of the Player [int]
* ```getAssists``` which returns the assists of the Player [int]
* ```getPowerPlayPoints``` which returns the power play points (power play goals and assists together) of the Player [int]
* ```getPowerPlayGoals``` which returns the power play goals of the Player [int]
* ```getPowerPlayAssists``` which returns the power play assists of the Player [int]
* ```getShots``` which returns the total shots of the Player [int]
* ```getShootingPercentage``` which returns the percentage of Player goals to shots [double]

The Skater class will have the following mutator methods:
* ```incrementShot``` which will incease the Player's total shots by one
* ```incrementGoal``` which will increase the Player's total goals by one
* ```incrementAssist``` which will increase the Player's total assists by one
* ```incrementPowerGoal``` which will increase the Player's total Power Play Goals by one and their total goals by one
* ```incrementPowerAssist``` which will increase the Player's total Power Play Assists by one and their total assists by one

#### Goalie

The Goalie class is a sub class of the Player class that is responsible for holding the stats information of shots against, scored on, etc. and modifiying it appropraitly when needed.

The Goalie class has two constructors:

##### Only Roster Constructor
* [String] Name, 
* [String] Date of Birth,
* [String] Home Town,
* [String] Weight,
* [String] Height,
* [String] Number,
* [String] POSITION.[forward (F), left wing (LW), right wing (RW), center (C), defense (D), or goalie (G)]

##### Roster and Stats Information
* [String] Name, 
* [String] Date of Birth,
* [String] Home Town,
* [String] Weight,
* [String] Height,
* [String] Number,
* [String] POSITION.[forward (F), left wing (LW), right wing (RW), center (C), defense (D), or goalie (G)],
* [int] shotsAgainst,
* [int] goalsAgainst,
* [int] shutouts,
* [int] minutesPlayed

The Goalie class will need to following accessor methods:
* ```getShotsAgainst``` which returns the amount of times the Goalie has been shot. [int]
* ```getGoalsAgainst``` which returns the amount of times the Goalie has been scored on. [int]
* ```getShutouts``` which returns the amount of times the Goalie has played and not been scored on. [int]
* ```getMinutesPlayed``` which returns the amount of times the Goalie has played in the rink in minutes [int]
* ```getGoalsAgainstAverage``` which returns the average of Goalie scored on per game [double]
* ```getSavePercentage``` which returns the chance of the Goalie stopping a shot. [double]

The Goalie class will need to following mutator methods:
* ```incrementShotsAgainst``` which will increase the Goalie's total shots against by one.
* ```incrementGoalsAgainst``` which will increase the Goalie's total goals against by one and shots against by one.
* ```incrementShutouts``` which will increase the Goalie's total shutouts by one.
* ```increaseMinutedPlayed``` which will increase the Goalie's total minutes player by amount passed in.

### PlayerList

The PlayList class is responsible of managing an ArrayList of the Players who are identified by their jersey number. Additionally, the PlayerList class can increase the (power play) goals, assists and shots of any player and add a new player.

The PlayerList class mutator methods:
* ```incrementShot``` takes in a Skater number and increases the amount of shots for that Skater by one.
* ```incrementGoal``` takes in a Skater number to increase the amount of goals for that Skater by one. Additionally, can take up to two other Skater numbers to increment the Skaters assists for that goal by one.
* ```incrementPowerGoal``` takes in a Skater number to increase the amount of power goals for that Skater by one. Additionally, can take up to two other Skater numbers to increment the Skaters' power assists for that goal by one.
* ```incrementShotsAgainst``` takes in a Goalie number and will increase the Goalie's total shots against by one.
* ```incrementGoalsAgainst``` takes in a Goalie number and will increase the Goalie's total goals against by one.
* ```incrementShutouts``` takes in a Goalie number and will increase the Goalie's total shutouts by one.
* ```increaseMinutedPlayed``` takes in a Goalie number and minuted played and will increase the Goalie's total minutes player by amount passed in.

The PlayerList class has the following accessor method:
* ```findPlayer``` takes in a number and will return a Player with that number [Player].

### Table

The Table is an abstract class and reponsible for containing organized information of either stats or roster of the players to be printed to the console. This class is the super class of RosterTable, SkaterStatTable and GoalieStatTable.

The Table class has the following constuctor:
##### PlayerList
[PlayerList] playerList

The Table class has the following accessor methods:
* ```getPlayerList``` which returns the PlayerList in the Table class [PlayerList].
* ```createTabelString``` is an abstract method required from the sub class that has the PlayerList and returns a formatted String of a table [String].
* ```toString``` which calls upon the createTableString method and returns the String recieved from the called method [String].

### RosterTable Class

The RosterTable class is a sub class of the Table class which is responsible for creating a formatted String that organizes all Players in the PlayerList into said String.

The RosterTable class has the following constructor:
##### PLayerList
[PlayerList] playerList

The RosterTable has one accessor method:
* ```createTableString``` which fill the abstract method declared in the Table class. Will return a formatted String of an organized table of the roster information of each Player in the PlayerList. 

### SkaterStatTable Class

The SkaterStatTable class is a sub class of the Table class which is responsible for creating a formatted String that organizes all Skaters in the PlayerList into said String.

The SkaterStatTable class has the following constructor:
##### PLayerList
[PlayerList] playerList

The SkaterStatTable has one accessor method:
* ```createTableString``` which fill the abstract method declared in the Table class. Will return a formatted String of an organized table of the stat information of each Skater in the PlayerList. 

### GoalieStatTable Class

The GoalieStatTable class is a sub class of the Table class which is responsible for creating a formatted String that organizes all Goalies in the PlayerList into said String.

The GoalieStatTable class has the following constructor:
##### PLayerList
[PlayerList] playerList

The GoalieStatTable has one accessor method:
* ```createTableString``` which fill the abstract method declared in the Table class. Will return a formatted String of an organized table of the stat information of each Goalie in the PlayerList. 

### TableFactory Class

The TableFactory class is responsible for creating new sub class Table objects (RosterTable, SkaterStatTable & GoalieStatTable) through public-static methods.

The TableFactory class has no constuctors.

The TableFactory class has the following static accessor methods:
* ```listAllPlayersRoster``` takes in playerList [PlayerList] which then returns a RosterTable object.
* ```listAllSkaterStats``` takes in playerList [PlayerList] which then returns a SkaterStatTable object.
* ```listAllGoalieStats``` takes in playerList [PlayerList] which then returns a GoalieStatTable object.

### TeamReader Class

The TeamReader class is responsible for reading a file to differentite between Skaters and Goalies to be placed into the PlayerList class.

The TeamReader class has no constructor.

The TeamReader class has the only following static accessor method:
* ```getPlayerList``` takes in a file name which then returns a PlayerList that has been filled with information from a file [PlayerList].

### TeamWriter Class

The TeamWriter class is responsible for writing to a file in the same order as the TeamReader class would read it.

The TeamWriter class has no constructor.

The TeamWriter class has the only following static accessor method:
* ```writeToFile``` takes in a fileName [String] and playerList [PlayerList] which it then prints to the file of all the Player information including stats in the same format as TeamReader could use it.

## Private Implementation

### Player Class
The Player class needs to store:
* Their name [String]
* Their date of birth [String]
* Their home town [String]
* Their weight [String]
* Their height [String]
* Their number [String]
* Their POSITION [enum]

The Player class has only following constructor:
* ```getName``` which returns the name of the Player [String]
* ```getDOB``` which returns the date of birth of the Player [String]
* ```getHomeTown``` which returns the home town of the Player [String]
* ```getWeight``` which returns the weight of the Player [String]
* ```getHeight``` which returns the height of the Player [String]
* ```getPosition``` which returns the position of the Player [String]

### Skater Class
The Skater class is a sub class of Player class and it stores the following instances:
* [int] Goals
* [int] Assists
* [int] Power Play Goals
* [int] Power Play Assists
* [int] Shots

The Skater class has the following constructors:
##### Only Roster
* [String] Name, 
* [String] Date of Birth,
* [String] Home Town,
* [String] Weight,
* [String] Height,
* [String] Number,
* [String] POSITION.[forward (F), left wing (LW), right wing (RW), center (C), defense (D), or goalie (G)]
###### Super will be called and all information in constructor's parameters will be passed to the Player class

#### Roster and Stats
* [String] Name, 
* [String] Date of Birth,
* [String] Home Town,
* [String] Weight,
* [String] Height,
* [String] Number,
* [String] POSITION.[forward (F), left wing (LW), right wing (RW), center (C), defense (D), or goalie (G)],
###### Super will be called and all information in constructor's parameters will be passed to the Player class
* [int] Goals,
* [int] Assists,
* [int] Power Play Goals,
* [int] Power Play Assists,
* [int] Shots

The Skater class has the following accessor methods:
* ```getPoints``` which returns the total points (goals and assists together) of the Player [int]
* ```getGoals``` which returns the goals of the Player [int]
* ```getAssists``` which returns the assists of the Player [int]
* ```getPowerPlayPoints``` which returns the power play points (power play goals and assists together) of the Player [int]
* ```getPowerPlayGoals``` which returns the power play goals of the Player [int]
* ```getPowerPlayAssists``` which returns the power play assists of the Player [int]
* ```getShots``` which returns the total shots of the Player [int]
* ```getShootingPercentage``` which returns the derived percentage of Player goals to shots from the equation: `Player goal / Player shots * 100`[double]

The Skater class has the following mutator methods:
* ```incrementShot``` which will incease the Player's total shots by one.
* ```incrementGoal``` which will increase the Player's total goals by one and shots by one.
* ```incrementAssist``` which will increase the Player's total assists by one.
* ```incrementPowerGoal``` which will increase the Player's total Power Play Goals by one, their total goals by one and shots by one.
* ```incrementPowerAssist``` which will increase the Player's total Power Play Assists by one and their total assists by one.

### Goalie Class
The Goalie class is a sub class of the Player class and it stores the following instances:
* [int] shotsAgainst
* [int] goalsAgainst
* [int] shutouts
* [int] minutesPlayed

The Goalie class has the following two constuctors:
##### Only Roster
* [String] Name, 
* [String] Date of Birth,
* [String] Home Town,
* [String] Weight,
* [String] Height,
* [String] Number,
* [String] POSITION.[forward (F), left wing (LW), right wing (RW), center (C), defense (D), or goalie (G)]
###### Super will be called and all information in constructor's parameters will be passed to the Player class

##### Roster and Stats
* [String] Name, 
* [String] Date of Birth,
* [String] Home Town,
* [String] Weight,
* [String] Height,
* [String] Number,
* [String] POSITION.[forward (F), left wing (LW), right wing (RW), center (C), defense (D), or goalie (G)],
###### Super will be called and all information in constructor's parameters will be passed to the Player class
* [int] shotsAgainst,
* [int] goalsAgainst,
* [int] shutouts,
* [int] minutesPlayed

The Goalie class has the following accessor methods:
* ```getShotsAgainst``` which returns the amount of times the Goalie has been shot. [int]
* ```getGoalsAgainst``` which returns the amount of times the Goalie has been scored on. [int]
* ```getShutouts``` which returns the amount of times the Goalie has played and not been scored on. [int]
* ```getMinutesPlayed``` which returns the amount of times the Goalie has played in the rink in minutes [int]
* ```getGoalsAgainstAverage``` which returns the derived average of Goalie scored on per game through the equation `goalsAgainst * 60 / minutes`[double]
* ```getSavePercentage``` which returns the derived percentage of the Goalie stopping a shot through the equation of `1 - (goalsAgainst/shotsAgainst)` [double]

The Goalie class has the following mutator methods:
* ```incrementShotsAgainst``` which will increase the Goalie's total shots against by one.
* ```incrementGoalsAgainst``` which will increase the Goalie's total goals against by one and shots against by one.
* ```incrementShutouts``` which will increase the Goalie's total shutouts by one.
* ```increaseMinutedPlayed``` which will increase the Goalie's total minutes player by amount passed in.

### PlayerList Class
The PlayerList class needs to store:

* An ArrayList of Player class

##### Important Methods
* ```incrementShot``` takes a jersey number to increment the Player's total shots by one.
* ```incrementGoal``` takes a jersey number to increment the Player's goal and shot by one. Optionally, it can take two additional jersey numbers to increase the Players' assist by one to account for their help in the goal.
* ```incrementPowerGoal``` takes a jersey number to increment the Player's power play goal and shot by one. Optionally, it can take two additional jersey numbers to increase the Players' power play assist by one to account for their help in the power play goal.
* ```incrementShotsAgainst``` takes in a Goalie number and will increase the Goalie's total shots against by one.
* ```incrementGoalsAgainst``` takes in a Goalie number and will increase the Goalie's total goals against by one.
* ```incrementShutouts``` takes in a Goalie number and will increase the Goalie's total shutouts by one.
* ```increaseMinutedPlayed``` takes in a Goalie number and minuted played and will increase the Goalie's total minutes player by amount passed in.
* ```findPlayer``` takes a number and searches the ArrayList to find a Player and return that Player to a method

### Table

The Table is an abstract class and reponsible for containing organized information of either stats or roster of the players to be printed to the console. This class is the super class of RosterTable, SkaterStatTable and GoalieStatTable.

The Table class has the following constuctor:
##### PlayerList
[PlayerList] playerList

The Table class has the following accessor methods:
* ```getPlayerList``` which returns the PlayerList in the Table class [PlayerList].
* ```createTabelString``` is an abstract method required from the sub class that has the PlayerList and returns a formatted String of a table [String].
* ```toString``` which calls upon the createTableString method and returns the String recieved from the called method [String], overriding the Object class' toString method.

### RosterTable Class

The RosterTable class is a sub class of the Table class which is responsible for creating a formatted String that organizes all Players in the PlayerList into said String.

The RosterTable class has the following constructor:
##### PLayerList
[PlayerList] playerList
###### Super will be called in the constructor and the playerList will be passed to the Table class constructor

The RosterTable has one public accessor method:
* ```createTableString``` which fill the abstract method declared in the Table class. Will return a formatted String of an organized table of the roster information of each Player in the PlayerList. 

The RosterTable has one private method:
* ```rosterToString``` takes in a number [String] to find the Player possesing that number. Then creates a String that formats all roster information of the Player into a formatted String. The formatted String is returned [String].

### SkaterStatTable Class

The SkaterStatTable class is a sub class of the Table class which is responsible for creating a formatted String that organizes all Skaters in the PlayerList into said String.

The SkaterStatTable class has the following constructor:
##### PLayerList
[PlayerList] playerList
###### Super will be called in the constructor and the playerList will be passed to the Table class constructor

The SkaterStatTable has one public accessor method:
* ```createTableString``` which fill the abstract method declared in the Table class. Will return a formatted String of an organized table of the stat information of each Skater in the PlayerList. 

The SkaterStatTable has one private method:
* ```skaterToString``` takes in a number [String] to find the Skater possesing that number. Then creates a String that formats all stat information of the Skater into a formatted String. The formatted String is returned [String].

### GoalieStatTable Class

The GoalieStatTable class is a sub class of the Table class which is responsible for creating a formatted String that organizes all Goalies in the PlayerList into said String.

The GoalieStatTable class has the following constructor:
##### PLayerList
[PlayerList] playerList
###### Super will be called in the constructor and the playerList will be passed to the Table class constructor

The GoalieStatTable has one public accessor method:
* ```createTableString``` which fill the abstract method declared in the Table class. Will return a formatted String of an organized table of the stat information of each Goalie in the PlayerList. 

The GoalieStatTable has one private method:
* ```goalieToString``` takes in a number [String] to find the Goalie possesing that number. Then creates a String that formats all stat information of the Goalie into a formatted String. The formatted String is returned [String].

### TableFactory Class

The TableFactory class is responsible for creating new sub class Table objects (RosterTable, SkaterStatTable & GoalieStatTable) through public-static methods.

The TableFactory class has no constuctors.

The TableFactory class has the following static accessor methods:
* ```listAllPlayersRoster``` takes in playerList [PlayerList] which then returns a RosterTable object.
* ```listAllSkaterStats``` takes in playerList [PlayerList] which then returns a SkaterStatTable object.
* ```listAllGoalieStats``` takes in playerList [PlayerList] which then returns a GoalieStatTable object.

### TeamReader Class

The TeamReader class is responsible for reading a file to differentite between Skaters and Goalies to be placed into the PlayerList class.

The TeamReader class has no constructor.

The TeamReader class has the only following static accessor method:
* ```getPlayerList``` takes in a file name which then returns a PlayerList that has been filled with information from a file [PlayerList].

### TeamWriter Class

The TeamWriter class is responsible for writing to a file in the same order as the TeamReader class would read it.

The TeamWriter class has no constructor.

The TeamWriter class has the only following static accessor method:
* ```writeToFile``` takes in a fileName [String] and playerList [PlayerList] which it then prints to the file of all the Player information including stats in the same format as TeamReader could use it.

## File Format

The file format must stay consistent to continously work for both TeamReader and TeamWriter classes to function properly. Between each value will be a comma with no white space between commas and values.

All Skaters will be formatted in the following:
* $ [String]
* Name [String]
* Position [String]
* Jersey Number [String]
* Date of Birth [String]
* Home Town [String]
* Height [String]
* Goals [int]
* Assists [int]
* Power Play Goals [int]
* Power Play Assists [int]
* Shots [int]

All Goalies will be formatted in the following:
* @ [String]
* Name [String]
* Position [String]
* Jersey Number [String]
* Date of Birth [String]
* Home Town [String]
* Height [String]
* Shots Against [int]
* Goals Against [int]
* Shutouts [int]
* Minutes [int]
