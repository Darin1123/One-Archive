package com.example.shopping.adt;

import com.example.shopping.util.Utility;

public class Item implements Comparable<Item> {
    private String name;
    private String amount;
    private boolean done;
    private Utility.Category category;

    public Item(String input) {
        this.name = input;
        this.amount = "0";
        this.done = false;
        this.category = Utility.categorize(input);
    }

    public Item(String input, String amount) {
        this.name = input;
        this.amount = amount;
        this.done = false;
        this.category = Utility.categorize(input);
    }

    public Item(String name, String amt, boolean done) {
        this.name = name;
        this.amount = amt;
        this.done = done;
        this.category = Utility.categorize(name);
    }

    public String name() { return this.name; }
    public String amount() { return this.amount; }
    public boolean isdone() { return this.done; }
    public Utility.Category category() { return this.category; }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAmount(String newAmount) {
        try {
            int amt = Integer.valueOf(newAmount);
            if (newAmount.equals(""))
                this.amount = "0";
            else if (amt>=0)
                this.amount = newAmount;
            else
                this.amount = String.valueOf(-1*amt);
        }catch (Exception e) {}
    }

    public void undone() { this.done=false; }
    public void done() { this.done=true; }

    public int compareTo(Item that) {
        if (this.done && !that.done)
            return 1;
        else if (!this.done && that.done)
            return -1;
        else if ((compareString(this.category().toString(), that.category().toString()) == -1))
            return -1;
        else if (compareString(this.category().toString(), that.category().toString()) == 1)
            return 1;
        else
            return compareString(this.name, that.name);
    }

    public static int compareString(String a, String b) {
        int length;
        int atob;
        if (a.length()<b.length()) {
            length = a.length();
            atob = -1;
        }
        else if (a.length()>b.length()) {
            length = b.length();
            atob = 1;
        }
        else {
            length = a.length();
            atob = 0;
        }
        //compare the common part
        for (int i=0; i<length; i++) {
            if (a.charAt(i)<b.charAt(i))
                return -1;
            else if (a.charAt(i)>b.charAt(i))
                return 1;
        } //end of commom part
        //common part the same
        return atob;
    }



    public static void main(String[] args) {
        System.out.println(""+true);
    }
}


