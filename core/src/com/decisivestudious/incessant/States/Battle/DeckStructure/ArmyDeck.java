package com.decisivestudious.incessant.States.Battle.DeckStructure;

import java.util.ArrayList;

/**
 * Created by Immortan on 8/15/2016.
 */
public class ArmyDeck {

    private String name;
    private String faction;
    private UnitCard general;
    private ArrayList<UnitCard> unitCards;
    private ArrayList<EquipmentCard> equipmentCards;
    private ArrayList<TacticCard> tacticCards;

    public ArmyDeck(String name){
        this.name=name;
    }


    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }

    public UnitCard getGeneral() {
        return general;
    }

    public void setGeneral(UnitCard general) {
        this.general = general;
    }

    public ArrayList<UnitCard> getUnitCards() {
        return unitCards;
    }

    public void setUnitCards(ArrayList<UnitCard> unitCards) {
        this.unitCards = unitCards;
    }

    public ArrayList<EquipmentCard> getEquipmentCards() {
        return equipmentCards;
    }

    public void setEquipmentCards(ArrayList<EquipmentCard> equipmentCards) {
        this.equipmentCards = equipmentCards;
    }

    public ArrayList<TacticCard> getTacticCards() {
        return tacticCards;
    }

    public void setTacticCards(ArrayList<TacticCard> tacticCards) {
        this.tacticCards = tacticCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
