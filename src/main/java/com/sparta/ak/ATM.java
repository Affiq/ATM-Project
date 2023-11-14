package com.sparta.ak;

import java.sql.SQLOutput;

public class ATM {
    private BankNoteStack[] noteStackArray;
    public BankNoteStack[] getNoteStack() {
        return noteStackArray;
    }

    public void setNoteStack(BankNoteStack[] noteStackArray) {
        this.noteStackArray = noteStackArray;
    }

    public void printNoteStack() {
        System.out.println("ATM Details [Value: xAmount]");
        for (BankNoteStack noteStack: noteStackArray) {
            System.out.println(noteStack.toString());
        }
        System.out.println("");
    }

    // Core functionality of code
    public void withdrawValue(int amount) {
        System.out.println("Attempting to withdraw " + amount);
        int availableFunds = getNoteStackTotal();

        // Check if enough funds
        if (amount > availableFunds) {
            System.out.println("Not enough money in ATM. Available funds: £" + availableFunds);

        } else {
            // Check if enough notes - Begin to decompose amount with highest stack first
            int currentAmount = amount;
            for (BankNoteStack noteStack: noteStackArray) {
                // Subtract the amount by largest multiple of current bank note.
                currentAmount = currentAmount - (noteStack.getSingleValue() * noteStack.getMaxNotes(currentAmount));
            }

            // If the final amount is not 0, it means that we don't have sufficient notes to satisfy the withdrawal
            if (currentAmount != 0) {
                System.out.println("Not enough notes in ATM for withdrawal.");
                System.out.println("");
                return;

            } else { // We can perform the withdrawal, we simply deduct the max notes.
                currentAmount = amount;

                System.out.println("Withdrawing...");
                for (BankNoteStack noteStack: noteStackArray) {
                    // Calculate number of notes to withdraw
                    int numberToWithdraw = noteStack.getMaxNotes(currentAmount);
                    // Print Value x Amount to user
                    System.out.println(numberToWithdraw + " x £" + noteStack.getSingleValue());
                    // Perform notestack deduction, and total amount deduction
                    noteStack.setTotalNotes(noteStack.getTotalNotes() - numberToWithdraw);
                    currentAmount = currentAmount -
                            (noteStack.getSingleValue() * numberToWithdraw);
                }
                System.out.println("");
            }
        }
    }

    // Gets total amount inside ATM
    public int getNoteStackTotal() {
        int total = 0;
        for (BankNoteStack noteStack: noteStackArray) {
            total = total + noteStack.getTotal();
        }
        return total;
    }

    // Checks if ATM has enough money
    public boolean hasEnoughMoney(int amount) {
        return (this.getNoteStackTotal() > amount);
    }


}
