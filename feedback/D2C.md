# Deliverable **D2C**

## Group Name: **tue12q**

## Criteria

##### Criteria for gaining 0.5 / 4

* The required admin files have been correctly filled in, committed and pushed, passing the CI compliance test.  **yes**
* The git log reveals healthy use of Git.  **yes**

##### Criteria for gaining 1.5 / 4

The previous criteria plus...
* Completion of the Pass level requirements for Part One of the game.  **yes**

##### Criteria for gaining 2.5 / 4

The previous criteria plus...
* Completion of the Credit level requirements for Part One of the game. **yes**
* Your design shows evidence of modification or further reflection based on feedback received from your tutor for deliverable D2B.  **no**

##### Criteria for gaining 3 / 4

The previous criteria plus...
* Completion of the Distinction level requirements for Part One of the game.  **yes**

##### Criteria for gaining 4 / 4

The previous criteria plus...
* The work is exceptional.  **no**

## Group Feedback

- Congratulations on completing all the tasks for Part 1! I can see a lot of effort has gone into your implementation.
- The purpose of the skeleton seems a bit confused. It shouldn't just be used to support the GUI - it was intended to be used to implement all the rules of the game (including those rules which are tasks for the assignment through the `Azul` class). In addition, it would be a bad idea to have GUI-related code in the classes that represent the game components. My recommendation is:
  * Move all the GUI classes in `skeleton` into the GUI package, and keep them as specifically GUI-related classes (with graphical representations).
  * Create a new set of classes (with similar names) based on your original (non-GUI) skeleton, and use these to implement the game rules. None of these classes should have anything to do with the user interface.
  * Move as much as possible of the code for the tasks in the `Azul` class into appropriate classes representing the game components. 

## Mark: **2.5/4**
