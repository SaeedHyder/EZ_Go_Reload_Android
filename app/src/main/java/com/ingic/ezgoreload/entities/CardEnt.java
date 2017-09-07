package com.ingic.ezgoreload.entities;

/**
 * Created on 9/7/2017.
 */

public class CardEnt {
    private String CardName;
    private String CardStatus;

    public CardEnt(String cardName, String cardStatus) {
        CardName = cardName;
        CardStatus = cardStatus;
    }

    public String getCardName() {
        return CardName;
    }

    public void setCardName(String cardName) {
        CardName = cardName;
    }

    public String getCardStatus() {
        return CardStatus;
    }

    public void setCardStatus(String cardStatus) {
        CardStatus = cardStatus;
    }
}
