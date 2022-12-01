import java.util.ArrayList;
import java.util.Random;

public class Character {
    String name;
    double attackValue;
    double maxHealth;
    double currentHealth;
    int numberofPWins = 0;
    int numberofWWins = 0;
    private static ArrayList<String> spells = new ArrayList<>();

    Character(String a, double b, double c){
        this.name = a;
        this.attackValue = b;
        this.maxHealth = c;
        // same max health as new character
        this.currentHealth = c;
    }
    String getName(){
        return name;
    }
    double getAttackValue(){
        return attackValue;
    }
    double getMaxHealth(){
        return maxHealth;
    }
    double getCurrentHealth(){
        return currentHealth;
    }
    int getNumberofPWins(){
        return numberofPWins;
    }
    int getNumberofMWins(){
        return numberofWWins;
    }

    String toSttring(){
        return "Character Name = " + getName() +
                " Current Health = " + getCurrentHealth();
    }
    // calculates how much attack damage does one character do when they attack
    double getAttackDamage(int attackDamage){
        Random random = new Random(attackDamage);
        double x = (getAttackValue() * random.nextDouble(0.7, 1.0));
        return x;
    }
    double takeDamage(double damage){
        double newCurrentHealth = getCurrentHealth() - damage;
        return newCurrentHealth;
    }
    void increasePWins(){
        numberofPWins++;
    }
    void increaseMWins(){
        numberofWWins++;
    }

    //    void setSpells(ArrayList<String> sp){
//        Character.spells = sp;
//    }
    void displaySpells(){
//        for(int i=0;i<Character.spells.size();i++){
//            System.out.println("Spell " + (i+1) + " = " + Character.spells.get(i));
//        }
        System.out.println("Spell 1 - Fire Ball, Attack - 5.0 - 10.0, Chance - 50.0%");
        System.out.println("Spell 2 - Ice Storm, Attack - 1.0 - 7.0, Chance - 90.0%");
        System.out.println("Spell 3 - Meteor Strike, Attack - 10.0 - 10.0, Chance - 5.0%");
        System.out.println("Spell 4 - Surge Of Frostfire, Attack - 7.0 - 10.0, Chance - 30.0%");
    }
    double castSpells(String spl, int ran){
        if(spl == "fireball"){
            Spell fb = new Spell("fireball", 5,10,0.5);
            return fb.getMagicDamage(ran);
        }
        else if(spl == "icestorm"){
            Spell is = new Spell("icestorm", 1,7,0.9);
            return is.getMagicDamage(ran);
        }
        else if(spl == "meteorstrike"){
            Spell ms = new Spell("meteorstrike", 10,10,0.05);
            return ms.getMagicDamage(ran);
        }
        else if (spl == "surgeoffrostfire") {
           Spell sf =  new Spell("surgeoffrostfire", 7,10,0.3);
            return sf.getMagicDamage(ran);
        }
        return -1;
    }
}
