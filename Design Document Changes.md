# Hockey Time Keeper's Database Design Changes

* Player
  * Add an override for equals, hashCode and implement Comparable for the new collection object to use
  
* Skater and Goalie
  * Implement Comparable 

* Table 
  * Modify the class to be an Interface with two abstract methods:
  * public String createTableString()
  * public String toString()

* RosterTable, GoalieStatTable, SkaterStatTable 
  * No longer function as sub classes of Table but instead implement the Table interface. 
  * Have the classes contain an instance of PlayerList which is taken through the constructor. 
  * Classes must have createTableString and toString methods to meet the requirments of the Table Interface. the toSting method will simply call the createTableString method which generates a table String for the required format.
  * The createTableString() method must sort the Players in the desired fashion, depending on Stats and/or roster information.

* HomeTownTable
  * Create the HomeTown class that has the responsibility of creating a table String that sorts the Players in a collection into order by their home town.
   * Class must implement the Table Interface, therefore also creating the createTableString and toString methods.
   * Have the format and header for the table initialized as private static final.
   * Create method getFormattedHometown(Player) which returns a formatted String of the Player's roster information.

* PlayerList 
  * Will no longer have an ArrayList as the collection to hold Players, instead it will be Map<String, Player> where the String as the key is the value's Player's jersey number.
  * Change the findPlayer method to work with the Map collection and return a null value if there is no Player with the requested jersey number.
  
* TeamWriter and TeamReader 
  * Implement exceptions to avoid file errors and have the user fix the issue.
  * Function with the new collection of Players.

* Implement exception handling for any input of data from the user and when errors occur, have the user resolve the issue.

[Class Diagram](https://docs.google.com/document/d/1X3cOFmPUCrwf5LSZTKsGYsU0nBhWavDufErovgCfOa0/edit?usp=sharing)
IMPORTANT: Make sure to double click the diagram to see it completely and zoom out
