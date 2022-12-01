public class GameTester extends BattleGame {
    public static void main(String[] args){
        int seed = 123;
        //new BattleGame("player.txt", "monster.txt", "spells.txt", seed);
        BattleGame object = new BattleGame();
        object.playGame("Shubham", "Karan","Kriti");
    }
}