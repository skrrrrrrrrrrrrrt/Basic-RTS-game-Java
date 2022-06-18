import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<voinik> voinici = new ArrayList<voinik>();
        voinik Joe = new voinik("warrior", "melee", 80, 80, 15, 5, 4);
        voinik fatneek = new voinik("archer", "range", 50, 50, 21, 4, 3);
        voinik allowitman = new voinik("warrior", "melee", 500, 500, 34, 40, 30);

        voinici.add(Joe);
        voinici.add(fatneek);
        voinici.add(allowitman);

        modifiers mod = new atributes_modifier("attack", 5);
        modifiers mod2 = new atributes_modifier("HP_max", 5);
        modifiers mod3 = new atributes_modifier("armor_range", 5);
        modifiers mod4 = new atributes_modifier("armor_melee", 5);
        modifiers mod5 = new attack_modifier("archer", 11);

        Joe.addmodifiers(mod);
        Joe.addmodifiers(mod2);
        Joe.addmodifiers(mod3);
        Joe.addmodifiers(mod4);
        Joe.addmodifiers(mod5);

        System.out.println(Joe.chooseTarget(voinici));
        System.out.println(Joe.getDamageAgainst(fatneek));
        System.out.println(Joe.getDamageFrom(allowitman,allowitman.attackDMG, allowitman.attack));
        Joe.receiveAttack(fatneek,fatneek.attackDMG, fatneek.attack);
        System.out.println(Joe);
    }
}
