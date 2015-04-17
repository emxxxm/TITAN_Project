CS 3733 
team: TITAN
Group Project #1 Deliverable

======================================
Sixes Wild

---------------
Player:

>>How to run (in Eclipse):
	
  GUI/src/sixesWild.view/SixesWildViewDemo
  in run configurations, set VM arguments as:
	-splash:New.png

  on execution, a splash screen with team
  credits should show up, then the interface
  for players to choose level to play will 
  appear.


>>Buttons:

 >in choolse level interface:   

  Help: pops up a window to show how 
  to play the game. (Specific rules 
  will be added later.)
 
  Record: pops up a window to show the player's
  record of each level. The records include 
  highest scores and stars achieved.

  Level[n] (n=1,2,3,4,5): click to show the game
  view. Only the first five levels are unlocked.
  No move is available right now.


 =>Clarification: each color stands for a type of level.
  A type is one of the following: Puzzle, Lightning,
  Release and Elimination. When level number n%4=1,
  the type of that level is Puzzle. n%4=2 is Lightning, 
  n%4 =3 is Release and n%4=0 is Elimination.

 >in help interface:
  
  Quit: return to the previous interface


 >in score board interface:

  Return: return to choose level interface.

 >in game interface:
  Quit: return to choose level interface.


-------------------------
>Builder:

>>How to run (in Eclipse):

  GUI/src/level_builder/RequestScreenDemo
  in run configurations, set VM arguments as:
	-splash:New.png	
  
  on execution, a splash screen with team
  credits should show up, then a pop-up window
  will show up to allow builder to request to
  create new level. On clicking that button, 
  building interface will appear, but no action
  is available right now.


>>Buttons:

 >in request window:

  Start building levels!: click to enter building
  interface.


 >in building window:
  Preview: pops up a window and show preview of 
  the level.

  Quit: pops up a window and ask if the builder
  wants to quit without saving.

  Save: save the settings. (Yet to be implemented.)


 >in quit window:
  
  Save and quit: save the settings and quit.
  
  Quit without saving: quit level builder without 
  saving the changes made.

-----------------------------------------------

Thank you for your time! :)

--Titan
=================================================
  




