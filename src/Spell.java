import java.util.Random;

public class Spell {
    private String name;
    private double minDamage;
    private double maxDamage;
    private double chanceSuccess;
    Spell(String n, double min, double max, double ch){
        this.name = n;
        this.minDamage = min;
        this.maxDamage = max;
        this.chanceSuccess = ch;
        try {
            if (minDamage<0 || minDamage>maxDamage || chanceSuccess<0 || chanceSuccess>1);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    String getName(){
        return name;
    }
    double getMagicDamage(int magicDamage){
        Random random = new Random(magicDamage);
        double x = random.nextDouble(0.0, 1.0);
        if(x>chanceSuccess){
            return 0;
        }
        return random.nextDouble(minDamage,maxDamage);
    }
}
