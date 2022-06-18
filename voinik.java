import java.util.ArrayList;

public class voinik {
    String name;
    String attack;
    int HPmax;
    private int HPmax_modif;
    int HPcurrent;
    private int HP_modif;
    int attackDMG;
    private int attackDMG_modif;
    private int all_att;
    int armor_melee;
    private int armor_melee_modif;
    private int all_armor_melee;
    int armor_range;
    private int armor_range_modif;
    private int all_armor_range;
    private int archer_bonusDMG;
    private int warrior_bonusDMG;
//    int archer_bonus_armor_range;
//    int archer_bonus_armor_melee;
//    int warrior_bonus_armor_range;
//    int warrior_bonus_armor_melee;
    ArrayList<String> tags = new ArrayList<String>();
    private ArrayList<modifiers> modifiers = new ArrayList<modifiers>();

    public voinik(String name, String attack, int HPmax, int HPcurrent, int attackDMG, int armor_melee, int armor_range)
    {
        this.name = name;
        this.attack = attack;
        this.HPmax = HPmax;
        this.attackDMG = attackDMG;
        this.armor_melee = armor_melee;
        this.armor_range = armor_range;
        this.HPcurrent = HPcurrent;
        all_att += attackDMG;
        all_armor_melee += armor_melee;
        all_armor_range += armor_range;
    }
    void addmodifiers(modifiers promenliva){
            modifiers.add(promenliva);
            if(modifiers.get(modifiers.size() - 1).getmodifiertype().equals("attack")){
                attackDMG_modif += modifiers.get(modifiers.size() - 1).modifier();
                all_att += attackDMG_modif;
            }
            if(modifiers.get(modifiers.size() - 1).getmodifiertype().equals("HP_max")){
                HPmax_modif += modifiers.get(modifiers.size() - 1).modifier();
                HPmax += HPmax_modif;
            }
            if(modifiers.get(modifiers.size() - 1).getmodifiertype().equals("HP")){
                HP_modif += modifiers.get(modifiers.size() - 1).modifier();
            }
            if(modifiers.get(modifiers.size() - 1).getmodifiertype().equals("armor_melee")){
                armor_melee_modif += modifiers.get(modifiers.size() - 1).modifier();
                all_armor_melee += armor_melee_modif;
            }
            if(modifiers.get(modifiers.size() - 1).getmodifiertype().equals("armor_range")){
                armor_range_modif += modifiers.get(modifiers.size() - 1).modifier();
                all_armor_range += armor_range_modif;
            }
            if(modifiers.get(modifiers.size() - 1).getmodifiertype().equals("archer")){
                archer_bonusDMG += modifiers.get(modifiers.size() - 1).modifier();
                tags.add("archer");
            }
            if(modifiers.get(modifiers.size() - 1).getmodifiertype().equals("warrior")){
                warrior_bonusDMG += modifiers.get(modifiers.size() - 1).modifier();
                tags.add("warrior");
            }
    }
    voinik chooseTarget(ArrayList<voinik> enemies){
        voinik tmp = null;
        for (voinik obj : enemies) {
            if(obj.name.equals(tags.get(tags.size() - 1))) {
                tmp = obj;
                break;
            }
        }return tmp;
    }
    int getDamageAgainst(voinik enemy){
        if(enemy.name.equals("archer") && modifiers.get(modifiers.size() - 1).getmodifiertype().equals("archer")){
            all_att += archer_bonusDMG;
        }
        if(enemy.name.equals("warrior") && modifiers.get(modifiers.size() - 1).getmodifiertype().equals("warrior")){
            all_att += warrior_bonusDMG;
        }
        return all_att;
    }
    int getDamageFrom(voinik enemy, int value, String type){
        int getDMGfrom = 0;
        if(type.equals("melee")){
            getDMGfrom = value - all_armor_melee;
            if(getDMGfrom < 1){
                getDMGfrom = 1;
            }
        }
        if(type.equals("range")){
            getDMGfrom = value - all_armor_range;
            if(getDMGfrom < 1){
                getDMGfrom = 1;
            }
        }
        return getDMGfrom;
    }
    void receiveAttack(voinik enemy, int value, String type){
        if(type.equals("melee")){
            HPcurrent -= value - all_armor_melee;
            if(HPcurrent < 0){
                HPcurrent = 0;
            }
        }
        if(type.equals("range")){
            HPcurrent -= value - all_armor_range;
            if(HPcurrent < 0){
                HPcurrent = 0;
            }
        }
        System.out.println("current HP: " + HPcurrent);
    }

    public int getHPmax() {
        return HPmax + HPmax_modif;
    }

    public int getHPcurrent() {
        return HPcurrent + HP_modif;
    }

    public int getAttackDMG() {
        return attackDMG + attackDMG_modif;
    }

    public int getArmor_melee() {
        return armor_melee + armor_melee_modif;
    }

    public int getArmor_range() {
        return armor_range + armor_range_modif;
    }

    @Override
    public String toString() {
        return  name +
                "\n     HP:" + HPcurrent + "/" + HPmax +
                "\n     DMG:" + attackDMG + " + " + attackDMG_modif +
                "\n     DEF:" + armor_melee + " + " + armor_melee_modif + " / " + armor_range + " + " + armor_range_modif +
                "\nModifiers:" +
                "\n     Extra HPmax +" + HPmax_modif +
                "\n     Extra HP +" + HP_modif +
                "\n     Extra Attack +" + attackDMG_modif +
                "\n     Extra armor_melee_defence +" + armor_melee_modif +
                "\n     Extra armor_range_defence +" + armor_range_modif +
                "\n     bonus dng against archer +" + archer_bonusDMG +
                "\n     bonus dmg against warrior +" + warrior_bonusDMG ;
//                "\n     bonus melee_armor against archer +" + archer_bonus_armor_melee +
//                "\n     bonus range_armor against warrior +" + warrior_bonus_armor_range +
//                "\n     bonus range_armor against archer +" + archer_bonus_armor_range +
//                "\n     bonus melee_armor against warrior +" + warrior_bonus_armor_melee;

    }
}