# ATM Project

NOTE: When declaring the array of BankNoteStack, they should be defined in descending order such that the largest notes (£50) are the first in array at index 0.

A basic ATM project built on an OOP manner. This project was also attempted in a TDD style, in which I was a little unfamiliar with, which made it a little bit more time consuming.
Perhaps TDD should stand for Time Draining Development.

Nevertheless, some light unit tests have been performed on the 
system. Some error testing has been performed to ensure the user cannot withdraw more funds than the ATM has available,
or a withdrawal in which the machine cannot provide sufficient notes for. However, I have missed the basic elements such as a negative withdrawal and so I should try and be more meticulous for future projects.

Bank notes did not differ much in terms 
of methods and variables, and hence it was better to just instantiate separate instances of the BankNotesStack rather than extending them as individual subclasses.

Some basic things could also be done better - the bulk of the calculation occurs twice, once for checking and then once to perform the actual withdrawal operation. This could be solved by having
a temporary array or cache during the checking phase, which would eliminate the need for recalculation.

The BankNoteStack class has been logically separated in such a way that it governs only information and methods about itself - it is the job of the ATM to access the data and make the decision from there.

## Classes

BankNoteStack
- getSingleValue() - get the monetary value of the note
- getTotalNotes() - gets the number of notes in the stack
- getTotal() - returns the product of single value and total notes
- getMaxNotes(int amount) - returns either the integer division of amount/single value or the total amount of notes in the system.
Works by iteratively taking the largest divisor, calculating how much they can withdraw and deducts amount, before moving onto the next divisor.


ATM
-getNoteStackTotal() - returns the available funds within the ATM
-printNoteStack() - prints the values x quantity of notes in the stack
-withdrawValue(int amount) - where the bulk of the calculation takes place. Checks if it is first able to 
accommodate the withdrawal, before performing the actual withdrawal. Works by 
