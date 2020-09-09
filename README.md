Overview
----------
This program consists of the logic to accept the inputs from the user and design the crossword puzzle based on it.
In this program, the user enters the grid dimensions and number of words the user wants to enter into the grid.
Based on this, the space structure is entered for the grid. The program then accepts the input words and allocates the words to the respective positions on the grid.
The allocation of spaces and positions to the words is done on the grid and the grid is printed. The number of choices required to make for filling the words is printed as well.

Files and external data
-------------------------
There are the following main files:
1) External Data file which consists of the test cases for the problem.
2) FillInPuzzle.java - Java class where the puzzle is loading, the operations and logic for solving the puzzle is written.
3) mainClass.java - Main class for the problem which passes the input as BufferedReader and prints the output of puzzle as PrintWriter along with printing the number of choices made while solving. 

Data structures and their relations to each other
---------------------------------------------------
1) I am using the collection framework in Java to implement the concept.
2) String Tokenizer is used to accept the input strings and validate them.
3) ArrayList and various abstract data types are used to calculate and perform internal operations in the program. 
4) Strings, Integers, Booleans, Arrays for comparing and performing the operations. 
5) BufferedReader, PrintWriter operations are used for input and output.

Assumptions
-------------
While developing the program, I have made the following assumptions:
1) No word is repeated in the set of inputs words.
2) The puzzle is case invariant.
3) The words in the puzzle all fill from left to right or from top to bottom.

Key algorithms and design elements ( Strategy and Algorithm to solve the puzzle)
----------------------------------------------------------------------------------
LoadPuzzle Method:
1) Accept the input using Buffered Reader and command-line arguments.
2) String Tokenizer is used to accept the input and validate it.
3) Store the spaces inserted, in an Arraylist, by separating them based on 'h' and 'v' for horizontal and vertical, respectively.
4) Accept the words as input and store them in an ArrayList.
5) Design an empty grid structure based on the number of rows and columns inserted at the start.
6) Fill the empty grid with '-' where the words are to be filled. This is done using the spaces which are stored in Arraylist.
7) Return true for the loadPuzzle method if the grid is loaded properly. 
8) Calling the solve method and pass the required parameters for solving the crossword puzzle.

solve Method:
1) The solve method contains the logic implemented in solving the puzzle. It calls solvePuzzle method where the logic and calls are implemented.
2) Initially, a word is taken, and spaces are searched. Based on the match with space and word length a word gets populated.
3) Sequentially, as per the words entered through the input, they are tried to fit in the respective spaces on the grid where the words are to be filled.
4) Horizontal words spacing and Vertical words spacing are stored in different arraylist and iterations are done separately over them.
5) HorizontalCheck method checks for Horizontal word in the spacings. It returns the grid by adding the new word if satisfying the conditions.
6) VerticalCheck method checks for Vertical word in spacings. It returns the grid by adding the word vertically if matching the spacings and conditions.
7) The traversed spaces and words are pushed into the stack so that while recursive calling they are not encountered repeatedly.
8) A function for spacesAndWordCheck is implemented for checking the overlapping spaces and words. 
9) In case of collision of an element of word with the existing one on the grid, we check if the character is the same or different.
10) For the same characters, we proceed ahead with filling while in case of collision of characters we will not be filling the word in the grid.
11) Previously populated word is at incorrect position, therefore collision is occurring, so we remove the previously populated word as well and increment the guess count.
12) Similar operations are performed till the situation where the grid is filled and we get a final solution for the puzzle.
13) If we are not able to solve the puzzle with the given set of words, we return false from the solve function.
14) The guessing count is based on the popping of the incorrectly filled words from the grid.
15) The guessing count is returned using the choices function, this count is printed at the end.

Print Method:
1) The grid is printed using the print function which is parameterized by PrintWriter for printing the grid.

Limitations
-------------
1) The current version of the code is working fine with the inputs entered such that the overlapping characters are the same or there aren't any overlapping characters. 
If any character having overlapping space and have different characters, then the word is not filled in the grid.
