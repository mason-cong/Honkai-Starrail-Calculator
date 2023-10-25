package com.StarRailDmg;

public class DamageCalculations {


    /**
    *Damage is calculated after taking into account individual multipliers
     */

    private double baseDmg(double skillMulitplier, int scalingAttribute, double extraDmg) {
        double baseDMG = (skillMulitplier*scalingAttribute) + extraDmg;
        return baseDMG;
    }

    private double dmgMultiplier(double elementalDmgMulti, double extraDmgMulti) {
        double dmgMultiplier = 1.0 + (elementalDmgMulti/100) + (extraDmgMulti/100);
        return dmgMultiplier;
    }

    private double defMultiplier(int enemyLevel, int attackerLevel, double defReduce) {
        double defMultiplier = (attackerLevel + 20) / ((enemyLevel + 20) * ((1 - defReduce) + attackerLevel + 20));
        return defMultiplier;
    }

    private double resMultiplier(AttackType.MultiplierType attacker, AttackType.MultiplierType defender, double resPen) {
        double resMultiplier = 1.0 - (1.0 - 0.0 - (resPen/100));
        return resMultiplier;
    }

    private double dmgTaken(double elementalDmgTaken, double alltypeDmgTaken) {
        double dmgTaken = 1.0 + (elementalDmgTaken/100) + (alltypeDmgTaken/100);
        return dmgTaken;
    }

    private double universalDmgReduc(boolean toughness, int toughnessCount) {
        double universalDmgReduc = 1.0;
        if (toughness) {
            for (int i = 0; i < toughnessCount; i++) {
                universalDmgReduc *= (0.9);
            }
        }
        return universalDmgReduc;
    }

    private double weaken(double weakenStatus) {
        double weaken = 1.0 - (weakenStatus)/100;
        return weaken;
    }


    public double getFlatDmg() {
        double finalDamage = 0;
        return finalDamage;
    }

    public double getCritDmg(double critDamage) {
        double finalDamage = getFlatDmg()*(1.0 + critDamage/100);
        return finalDamage;
    }

}
