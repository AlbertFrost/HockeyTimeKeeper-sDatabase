# Hockey Time Keeper's Database Design Changes

* Modify the Table class to be an Interface with two abstract methods:
  * public String createTableString()
  * public String toString()

* Change RosterTable, GoalieStatTable, SkaterStatTable to function as not sub classes of Table but instead implement the Table interface. Have the classes conbtain an instance of PlayerList which is taken through the constructor. 
