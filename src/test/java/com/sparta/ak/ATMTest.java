package com.sparta.ak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ATMTest {

    @Test
    @DisplayName("Check cannot withdraw a crazy amount")
    public void withdraw100000() {
        ATM newATM = new ATM();

        // Define a new collection of notes to be put into our ATM.
        BankNoteStack[] bankNoteStackArray = new BankNoteStack[2];
        bankNoteStackArray[0] = new BankNoteStack(50,12);
        bankNoteStackArray[1] = new BankNoteStack(20,20);
        // Set the ATM stack
        newATM.setNoteStack(bankNoteStackArray);
        newATM.withdrawValue(100000);

        // Amount of notes should stay the same
        Assertions.assertEquals(12, bankNoteStackArray[0].getTotalNotes());
        Assertions.assertEquals(20, bankNoteStackArray[1].getTotalNotes());
    }

    @Test
    @DisplayName("Check appropriate number of notes have been taken out")
    public void withdraw140() {
        ATM newATM = new ATM();

        // Define a new collection of notes to be put into our ATM.
        BankNoteStack[] bankNoteStackArray = new BankNoteStack[2];
        bankNoteStackArray[0] = new BankNoteStack(50,12);
        bankNoteStackArray[1] = new BankNoteStack(20,20);
        // Set the ATM stack
        newATM.setNoteStack(bankNoteStackArray);
        newATM.withdrawValue(140);

        // Should have 2 less £50, 2 less £20
        Assertions.assertEquals(10, bankNoteStackArray[0].getTotalNotes());
        Assertions.assertEquals(18, bankNoteStackArray[1].getTotalNotes());
    }

    @Test
    @DisplayName("Check cannot withdraw 2 for an ATM with one £50 and one £1")
    public void checkCannotWithdraw2For50and1() {
        ATM newATM = new ATM();

        // Define a new collection of notes to be put into our ATM.
        BankNoteStack[] bankNoteStackArray = new BankNoteStack[2];
        bankNoteStackArray[0] = new BankNoteStack(50,1);
        bankNoteStackArray[1] = new BankNoteStack(1,1);
        // Set the ATM stack
        newATM.setNoteStack(bankNoteStackArray);
        newATM.withdrawValue(2);

        // Should have 2 less £50, 2 less £20
        Assertions.assertEquals(1, bankNoteStackArray[0].getTotalNotes());
        Assertions.assertEquals(1, bankNoteStackArray[1].getTotalNotes());
    }




}
