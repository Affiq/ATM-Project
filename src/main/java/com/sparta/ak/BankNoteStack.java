package com.sparta.ak;

public class BankNoteStack {

    private int singleValue;
    private int totalNotes;

    public BankNoteStack(int singleValue, int totalNotes) {
        this.singleValue = singleValue;
        this.totalNotes = totalNotes;
    }

    public int getSingleValue() {
        return singleValue;
    }

    public int getTotalNotes() {
        return totalNotes;
    }

    public void setTotalNotes(int totalNotes) {
        this.totalNotes = totalNotes;
    }

    @Override
    public String toString() {
        return
                "£" + singleValue +
                ": x" + totalNotes;

    }

    // Get aggregate value for stack of notes
    public int getTotal() {
        return this.totalNotes * this.singleValue;
    }

    // Given an amount, return the maximum amount of notes you can give
    public int getMaxNotes(int amount) {
        int requiredNotes = amount/singleValue; // Type int will truncate the decimals off

        if (requiredNotes > this.totalNotes) {
            return totalNotes;
        } else {
            return requiredNotes;
        }


    }
}
