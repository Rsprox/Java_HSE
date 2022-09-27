package ru.hse.middle.my;



public class Ticket {
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (value.length()  % 2 == 0) {
            this.value = value;
        } else {
            throw new IllegalArgumentException();
        }

    }

    public boolean isLucky(){
        int firstPart = 0;
        int lastPart = 0;
        for (int i = 0; i < this.value.length()/2; i++) {
            firstPart += this.value.charAt(i);
            lastPart += this.value.charAt(this.value.length()-(i+1));
        }
        return firstPart == lastPart;
    }

    public Ticket(String value) {
        setValue(value);
    }

    public boolean equals(Ticket ticket){
        return this.value.equals(ticket.getValue());
    }

    private String value;

}
