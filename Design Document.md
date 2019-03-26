# Hockey Time Keeper's Database Design Changes

* Table 
  * Modify the class to be an Interface with two abstract methods:
  * public String createTableString()
  * public String toString()

* RosterTable, GoalieStatTable, SkaterStatTable 
  * No longer function as sub classes of Table but instead implement the Table interface. 
  * Have the classes contain an instance of PlayerList which is taken through the constructor. 
  * Classes must have createTableString and toString methods to meet the requirments of the Table Interface. the toSting method will simply call the createTableString method which generates a table String for the required format.

* PlayerList 
  * Will no longer have an ArrayList as the collection to hold Players, instead it will be Map<String, Player> where the String as the key is the value's Player's jersey number.
  * Change the findPlayer method to work with the Map collection and return a null value if there is no Player with the requested jersey number.
