package com.StarRailDmg;

import java.util.*;

/**
 * Class implements the interaction between elemental types within the game to
 * account for elemental resistances and weaknesses
 */

public class AttackType {

    public static enum MultiplierType {
        FIRE, ICE, WIND, LIGHTNING, PHYSICAL, QUANTUM, IMAGINARY
    }

    private List<AttackType> resistance;
    private List<AttackType> weakness;
    private MultiplierType type;
    private Double strength;

    public AttackType() {
        resistance = new ArrayList<>();
        weakness = new ArrayList<>();
    }

    public AttackType(MultiplierType type, double strength) {
        super();
        this.type = type;
        this.strength = strength;
    }

    public void addResistance(MultiplierType type, double strength) {
        resistance.add(new AttackType(type, strength));
    }

    public void addWeakness(MultiplierType type, double strength) {
        weakness.add(new AttackType(type, strength));
    }

    public double getStrength(AttackType a) {
        return a.strength;
    }

}
