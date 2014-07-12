Chutes and Ladder Game (Simulator)
===================================

A simple simulator of Chutes and Ladder Board Game (Desktop Version). 

In it's current state, this is just a simulation and it runs on the console, it doesn't have any UI. 

Assumptions: 
•	At least two player names need to be provided to begin the game from command line.
•	Maximum of 4 players are allowed in this game.
•	At one time, only one game can be opened or started. This is maintained by using the Singleton Design Pattern. This is on the lines of most of the Windows Desktop games.
•	If a players’s score goes over 100, then his/her score is kept at the previous total score and then he/she needs to wait for his/her next turn until other players are done with their turns.
•	Ladders and Chutes are designed based on the provided picture of Chutes and Ladders game
•	The simulator or client class has a main() method which calls the Game API to simulate the whole game.
•	Game stops as soon as the first player reached the score of 100. 

Design:
•	This Chutes and Ladders game is designed using Object Oriented Programming technique.
•	Every noun in the game like player, ladders, chutes, Spinner etc are all represented using classes. Behaviors are represented using various methods.
•	Static Factory method is used for instantiation over the public constructors.
•	Game class is designed based on Singleton Design Pattern in order to control the instantiation of this class and hence, at one time, only one game can be played.
•	This game is exposed via an interface called IGame.java which is a contract for this Game API.
•	Throughout the project, composition is preferred over inheritance as a good design principle.
•	Exceptions are thrown as soon as an issue is discovered in input or any other operations.
•	Constants are kept separate in a different class in order to centralize and reuse constants throughput the project.
•	Flexibility is provided by reading players names from command line while running this game.
•	Spinner or Dice throw output is generated using java.util.Random Java API from the range of 1 to 6 as Spinner can only generate outcomes from 1 to 6.
Possible Unit Tests:
1.	Validate game doesn’t start for 1 player.
2.	Validate game doesn’t start for more than 4 players.
3.	Make sure the winner is announced and game is terminated as soon as any player reaches a score of 100.
4.	Spinner result should be between 1 and 6.
5.	On squares with chute, player should slide down to the end of chute.
6.	On squares with ladder, player should move up to the top of the ladder.

Things which can be implemented in Future:
•	Use Logger framework like Log4j instead of System.out.println to improve logging and flexibility.
•	Customize Exception classes as per the game requirements.
•	Reorganize some of the objects like ladders, boards and chutes into different package in order to have better code organization.
•	Write automated unit test cases to regress any future changes to this project.
•	Persist player’s score as a record and track the player’s name who have won the game most number of times. This will demand the Serialization of the some of the objects.
•	Create event driven user interface for this game so that this game could be played using UI. 
Project Details:
•	Interface: IGame.java
•	Implementation Class: Game.java
•	Simulator or Client or Main Class: ChutesAndLadders.java
 

Environment Details:
•	JDK version: JavaSE-1.7
•	JRE Version: JavaSE-1.7
•	Tool – Eclipse Kepler Service Release 1
•	How to run the game (after compiling the project with javac compiler):
o	java com.prabhash.java.games.chutesandladders.ChutesAndLadders Amber Ricky
Output of the Test Run:
1: Amber: 0 --> 1 -- LADDER --> 38

2: Ricky: 0 --> 3

3: Amber: 38 --> 42

4: Ricky: 3 --> 7

5: Amber: 42 --> 47 -- CHUTE --> 26

6: Ricky: 7 --> 11

7: Amber: 26 --> 30

8: Ricky: 11 --> 15

9: Amber: 30 --> 36 -- LADDER --> 43

10: Ricky: 15 --> 18

11: Amber: 43 --> 48

12: Ricky: 18 --> 19

13: Amber: 48 --> 54

14: Ricky: 19 --> 20

15: Amber: 54 --> 57

16: Ricky: 20 --> 23

17: Amber: 57 --> 61

18: Ricky: 23 --> 28 -- LADDER --> 84

19: Amber: 61 --> 63

20: Ricky: 84 --> 88

21: Amber: 63 --> 69

22: Ricky: 88 --> 93 -- CHUTE --> 73

23: Amber: 69 --> 73

24: Ricky: 73 --> 79

25: Amber: 73 --> 74

26: Ricky: 79 --> 82

27: Amber: 74 --> 80 -- LADDER --> 100

The Winner is Amber!

