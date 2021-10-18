# Advance Programming Techniques (Homework 2)

### Mann Prajapati | U52609954

- The indiegogo dataset is in the dataset directory.

- The starting point of code is in the Main.java file.

- All Objects are placed in the Main class which will point to their respective classes.
- There is a Package called constants which contains all the constant strings for the path of the directories which are
  used in the program.
- There is a separate package for the huffman encoding as it uses multiple classes to implement.
- The bruteForce approach will read the files line by line and search for the robot keyword in every line.
- The Lucene search will create an Index of the lines and will parse the query provided by the user and will execute the
  query from the underlying dataset(Index). After performing all these steps the output will be given to the user.
- The Hoffman encoding will firstly make count the occurrence of all the characters. Now a binary tree will be generated
  with the help of the Node.java file where the most used character will be on the top of the tree and the once with the
  lowest will be on the bottom.
- Now the Encoding process will start where the codes for the characters are assigned and a HashMap is generated which
  will be used to encode the input from the user.
- The input will be searched in the file.

# Execution of the program.

- I have used jFree chart in my assignment-3. So, make sure that you have jFree chart dependency installed/added in your
  IDE. I will include the jar file in the zip file.
- Also make sure that for lucene you have lucene-core-8.2.0.jar and lucene-queryparser-8.2.0.jar installed.
- So you just have to run the file give some time for execution and 6 charts will be there on the screen.
- They will overlap each other so, you will have to drag them and place them around your screen to see the results.
- I will also be attaching a screenshot of the charts in the read me file.

# Note

- The search results for the wearable keyword will be empty as there is no keyword wearable in the first 1000 lines of
  the dataset.
