package com.sparta.ak;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ATM newATM = new ATM();

        // Define a new collection of notes to be put into our ATM.
        // Should load the notes in descending order, so 50s first
        BankNoteStack[] bankNoteStackArray = new BankNoteStack[6];
        bankNoteStackArray[0] = new BankNoteStack(50,12);
        bankNoteStackArray[1] = new BankNoteStack(20,20);
        bankNoteStackArray[2] = new BankNoteStack(10,50);
        bankNoteStackArray[3] = new BankNoteStack(5,100);
        bankNoteStackArray[4] = new BankNoteStack(2,250);
        bankNoteStackArray[5] = new BankNoteStack(1,500);

        // Set the ATM stack
        newATM.setNoteStack(bankNoteStackArray);

        newATM.printNoteStack();
        newATM.withdrawValue(157);
        newATM.printNoteStack();
        newATM.withdrawValue(999999999);



    }
}
