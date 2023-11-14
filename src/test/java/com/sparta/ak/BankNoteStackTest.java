package com.sparta.ak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

public class BankNoteStackTest {

    @Test
    @DisplayName("Check correct string for 20 £50 notes")
    public void checkBankNoteStackString() {
    BankNoteStack newStack = new BankNoteStack(50,20);

    String expectedString = "£50: x20";
        Assertions.assertEquals(expectedString, newStack.toString());
    }

    @Test
    @DisplayName("Check total is £1000 for 20 £50 notes")
    public void check20x50Total() {
        BankNoteStack newStack = new BankNoteStack(50,20);

        int expectedInt = 1000;
        Assertions.assertEquals(expectedInt, newStack.getTotal());
    }

    @Test
    @DisplayName("Check that 3 x£50 notes gives returns correct max notes")
    public void checkCorrectMaxTotal() {
        BankNoteStack newStack = new BankNoteStack(50,3);

        Assertions.assertEquals(3, newStack.getMaxNotes(217));
        Assertions.assertEquals(1, newStack.getMaxNotes(68));
    }

}
