import java.util.Random;
import java.util.Scanner;

public class BattleGame {
    // can fix a seed for helping you debug your program if you want
    private static Random random =  new Random();
    public static void playGame(String player, String monster, String spell){
        Character newPlayer = new Character("Odin",
                10.0, 30.0);
        Character newMonster = new Character("Fenrir",
                12.0, 30.0);
        System.out.println("Player's Name = " + newPlayer.getName());
        System.out.println("Player's Current Health = " + newPlayer.getCurrentHealth());
        System.out.println("Player's Attack Value = " + newPlayer.getAttackValue());
        System.out.println("Player's Number Of Wins = " + newPlayer.getNumberofPWins());
        System.out.println();
        System.out.println("The Player has the following spells - ");
        newPlayer.displaySpells();
        System.out.println();
        System.out.println("Monster's Name = " + newMonster.getName());
        System.out.println("Monster's Current Health = " + newMonster.getCurrentHealth());
        System.out.println("Monster's Attack Value = " + newMonster.getAttackValue());
        System.out.println("Monster's Number Of Wins = " + newMonster.getNumberofMWins());
        System.out.println();

        Scanner scan = new Scanner(System.in);
        while (newPlayer.currentHealth>0 || newMonster.currentHealth>0){
            System.out.println("What do you want to do? Attack or Quit? ");
            System.out.print ("Say 1 for attack and 0 for quit ");
            int response = scan.nextInt();
            System.out.println();
            if(response == 1){
                System.out.println("Player wants to attack with spells or physically? ");
                System.out.print("Say 1 for spells and anything otherwise for physically ");
                int ans = scan.nextInt();
                System.out.println();
                if(ans == 1){
                    int randomIntPS = random.nextInt();
                    newPlayer.displaySpells();
                    System.out.print("Which spell do you want to cast? Say 1, 2, 3, 4 - ");
                    int which = scan.nextInt();
                    System.out.println();
                    if(which == 1){
                        double a = newPlayer.castSpells("fireball",randomIntPS);
                        if(a<=0){
                            System.out.println("Player tried to cast Fire Ball spell but failed!");
                        }
                        else {
                            double z = newMonster.takeDamage(a);
                            System.out.printf(newPlayer.getName() + " attacks " + newMonster.getName() + " with %.2f"  + " spell damage",a);
                            System.out.println();
                            System.out.printf(newMonster.getName() + " survives the attack and now has %.2f" + " health remaining",z);
                            System.out.println();
                            System.out.println();
                        }
                    }
                    else if(which == 2){
                        double b = newPlayer.castSpells("icestorm",randomIntPS);
                        if(b<=0){
                            System.out.println("Player tried to cast Ice Storm spell but failed!");
                        }
                        else {
                            double y = newMonster.takeDamage(b);
                            System.out.printf(newPlayer.getName() + " attacks " + newMonster.getName() + " with %.2f" + " spell damage",b);
                            System.out.println();
                            System.out.printf(newMonster.getName() + " survives the attack and now has %.2f" + " health remaining",y);
                            System.out.println();
                            System.out.println();
                        }
                    }
                    else if(which == 3){
                        double c = newPlayer.castSpells("meteorstrike",randomIntPS);
                        if(c<=0){
                            System.out.println("Player tried to cast Meteor Strike spell but failed!");
                        }
                        else {
                            double x = newMonster.takeDamage(c);
                            System.out.printf(newPlayer.getName() + " attacks " + newMonster.getName() + " with %.2f" + " spell damage",c);
                            System.out.println();
                            System.out.printf(newMonster.getName() + " survives the attack and now has %.2f"+ " health remaining",x);
                            System.out.println();
                            System.out.println();
                        }
                    }
                    else if(which == 4){
                        double d = newPlayer.castSpells("surgeoffrostfire",randomIntPS);
                        if(d<=0){
                            System.out.println("Player tried to cast Surge Off Frost Fire spell but failed!");
                        }
                        else {
                            double w = newMonster.takeDamage(d);
                            System.out.printf(newPlayer.getName() + " attacks " + newMonster.getName() + " with %.2f" + " spell damage",d);
                            System.out.println();
                            System.out.printf(newMonster.getName() + " survives the attack and now has %.2f" + " health remaining",w);
                            System.out.println();
                            System.out.println();
                        }
                    }
                }
                else if (ans == 0){
                    int randomIntP = random.nextInt();
                    double playerattackdamage = newPlayer.getAttackDamage(randomIntP);
                    //System.out.println("Player's Name = " + newPlayer.getName());
                    //System.out.println("Player's Attack Damage = " + playerattackdamage);
                    //System.out.println();
                    newMonster.currentHealth = newMonster.currentHealth - playerattackdamage;

                    if (newMonster.getCurrentHealth() > 0) {
                        System.out.printf(newPlayer.getName() + " attacks " + newMonster.getName() + " with %.2f" + " damage",playerattackdamage);
                        System.out.println();
                        System.out.printf(newMonster.getName() + " survives the attack and now has %.2f" + " health remaining",newMonster.getCurrentHealth());
                        System.out.println();
                        System.out.println();
                    } else {
                        System.out.println("Congratulations to the Player");
                        System.out.println("The Monster was knocked out");
                        System.out.printf("The current health of player is %.2f", newPlayer.getCurrentHealth());
                        System.out.println();
                        System.out.printf("The current health of monster is %.2f", newMonster.getCurrentHealth());
                        System.out.println();
                        System.out.println();
                        newPlayer.increasePWins();
                        System.out.println("Would you like to play again? ");
                        System.out.print("Say 1 for yes or 0 for no - ");
                        int q = scan.nextInt();
                        if(q==1){
                            System.out.println();
                            System.out.println("------------ New Game ------------");
                            playGame("Shubham", "Karan","Kriti");
                        }
                        else{
                            System.out.println("Thankyou for playing");
                            System.out.println("Here are the Statistics - ");
                            System.out.println("Player won - " + newPlayer.getNumberofPWins() + " times");
                            System.out.println("Monster won - " + newMonster.getNumberofMWins() + " times");
                            break;
                        }
                    }
                }

                int randomIntM = random.nextInt();
                double monsterattackdamage = newMonster.getAttackDamage(randomIntM);
                //System.out.println("Monster's Name = " + newMonster.getName());
                //System.out.println("Monster's Attack Damage = " + monsterattackdamage);
                //System.out.println();
                newPlayer.currentHealth = newPlayer.currentHealth - monsterattackdamage;
                if(newPlayer.getCurrentHealth()>0){
                    System.out.printf(newMonster.getName() + " attacks " + newPlayer.getName() + " with %.2f" + " damage",monsterattackdamage);
                    System.out.println();
                    System.out.printf(newPlayer.getName() + " survives the attack and now has %.2f" + " health remaining", newPlayer.getCurrentHealth());
                    System.out.println();
                    System.out.println();
                }
                else{
                    System.out.println("Congratulation to the Monster");
                    System.out.println("The Player was knocked out");
                    System.out.printf("The current health of monster is %.2f", newMonster.getCurrentHealth());
                    System.out.println();
                    System.out.printf("The current health of player is %.2f", newPlayer.getCurrentHealth());
                    System.out.println();
                    System.out.println();
                    newMonster.increaseMWins();
                    System.out.println("Would you like to play again? ");
                    System.out.print("Say 1 for yes or 0 for no - ");
                    int q = scan.nextInt();
                    if(q==1){
                        System.out.println();
                        System.out.println("------------ New Game ------------");
                        playGame("Shubham", "Karan","Kriti");
                    }
                    else{
                        System.out.println("Thankyou for playing");
                        System.out.println("Here are the Statistics - ");
                        System.out.println("Player won - " + newPlayer.getNumberofPWins() + " times");
                        System.out.println("Monster won - " + newMonster.getNumberofMWins() + " times");
                        break;
                    }
                }
            }
            else if (response == 0){
                System.out.println("Thankyou for participating! ");
                System.out.println();
                return;
            }
            else{
                System.out.println("Invalid Input! Please Try Again!");
                System.out.print ("Say 1 for Try again");
                response = scan.nextInt();
                System.out.println();
            }
        }
    }
}
