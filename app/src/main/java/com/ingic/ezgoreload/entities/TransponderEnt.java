package com.ingic.ezgoreload.entities;

/**
 * Created on 9/8/2017.
 */

public class TransponderEnt {
    private String ID;
    private String CardName;
    private int CardStatus;

    public TransponderEnt(String id, String cardName, int cardStatus) {
        ID = id;
        CardName = cardName;
        CardStatus = cardStatus;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public int getCardStatus() {
        return CardStatus;
    }

    public void setCardStatus(int cardStatus) {
        CardStatus = cardStatus;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
