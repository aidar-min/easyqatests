package com.easyqa.qa.page.util;

public class CardData {
    private String cardName;
    private String cardDescription;

    public CardData(String cardName, String cardDescription){
        this.cardName=cardName;
        this.cardDescription=cardDescription;
    }

    public String getCardName(){
        return this.cardName;
    }

    public String getCardDescription(){
        return this.cardDescription;
    }
}
