package Enemy_Info;

import Hero_Info.Sidekick;
import Item_Info.Weapon;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by nickg on 1/13/2017.
 */
public abstract class Enemy {

    protected String type;
    protected Weapon mainWeapon;
    protected int health;
    protected int maxHealth;
    protected int experience;
    protected int dodgeChance;
    protected int defender;
    protected int soulSize;
    protected int attkBuff;
    protected Scanner scan = new Scanner(System.in);


    /*
    NOTE TO SELF:

    Currently, each individual enemy type branches from this abstract. Maybe make 2 - 3 tiers of enemies
    and just make data files with buffered readers for each?

    Grunt, MiniBoss, Boss?


     */
    public Enemy(){

        this.type = "Enemy";
        this.mainWeapon = null;
        this.health = 10;
        this.maxHealth = 10;
        this.experience = 10;
        this.dodgeChance = 1;
        this.defender = 0;
        this.soulSize = 1;
        this.attkBuff = 0;
    }
    public int Attack1() {

        Random rand = new Random();
        int n = rand.nextInt(100) + dodgeChance;
        int attkpoints;

        if (n >= 4 && n <= 60) {

            attkpoints = this.mainWeapon.getPower() - defender + attkBuff;
            System.out.println(this.type + " used " + this.mainWeapon.getAttack1() + "!");
            turnOver();
            attkpoints = normalizeAttk(attkpoints);
            return attkpoints;
        } else if (n >= 61 && n <= 94) {

            attkpoints = this.mainWeapon.getPower2() - defender + attkBuff;
            System.out.println(this.type + " used " + this.mainWeapon.getAttack2() + "!");
            turnOver();
            attkpoints = normalizeAttk(attkpoints);
            return attkpoints;

        }
        else if(n >=0 && n <= 3){

            attkpoints = ((this.mainWeapon.getPower2()) * 2) - defender + attkBuff;
            System.out.println("The " + this.type + " used a devastating strike!");
            turnOver();
            attkpoints = normalizeAttk(attkpoints);
            return attkpoints;

        }
        else {
            System.out.println(this.type + "'s attack missed!");
            this.dodgeChance = 1;
            turnOver();
            return 0;

        }
    }

    public void receiveDamage(int pain){

        Random rand = new Random();
        int n = rand.nextInt(10) + 1;

        if(n <= 9) {

            if (this.health > pain && (this.health - pain) > 5) {
                this.health = (this.health) - (pain);
                System.out.println(this.type + " was injured!");
            }
            else if(this.health > pain && (this.health - pain) <= 5){
                this.health = (this.health) - (pain);
                System.out.println("The " + this.type + " is looking weak!");
            }
            else {
                this.health = 0;
                System.out.println("The " + this.type + " was defeated!");
            }
        }
        else{

            System.out.println("The " + this.type + " evaded the attack!");
        }
    }

    public int getHealth(){

        return this.health;
    }

    public int getXP(){

        return experience;
    }

    public void setDefender(int def){

        this.defender = def;
    }

    public void turnOver(){

        setDefender(0);
        this.dodgeChance = 1;
    }

    public void setDodgeChance(int DC){

        this.dodgeChance = DC;
    }


    //Normalizer incase if a special attack or debuff made it negative

    public int normalizeAttk(int attk){

        if (attk <= 0){
            attk = 1;
            return attk;
        }
        else{
            return attk;
        }
    }

    public String getType() {

        return type;
    }

    public String getMainWeapon(){

        return this.mainWeapon.getName();
    }

    public String getAttack1(){

        return this.mainWeapon.getAttack1();
    }

    public String getAttack2(){

        return this.mainWeapon.getAttack2();
    }

    public int getSoulSize() {
        return soulSize;
    }



    /*
    The soul system. The sidekick will have a limited number of "souls" it can hold onto
    that it can take the form of. Stronger souls take up more space and therefore give less
    overall variety to the sidekicks abilities. MiniBosses will take up at least half of the space,
    bosses will take up almost the entire space.

    Need to adjust this code to check the sidekick's inventory to look to see if the soul is already there
    If it is already there, need to decide on one of two viable options:

    1. Can replace a weaker soul with a stronger one of the same type
    2. Get a small boost in XP to the soul type they already have.


    MULL IT OVER




     */
    public void isDefeated(Sidekick x){
        System.out.println(this.type + " was defeated");
        boolean alreadyHave = false;
        while (!(alreadyHave)) {
            for (int i = 0; i < x.numOfSouls(); i++) {

                if(this.getType().equals(x.singleSoul(i))){
                    alreadyHave = true;
                    System.out.println("");
                }

            }
            if(alreadyHave == false){

                System.out.println("Absorb the soul of the " + this.type + "?\n1. Yes\n2. No");
                int j = scan.nextInt();
                scan.nextLine();
                if(j ==1) {
                    x.absorbSoul(this);
                }else{
                    System.out.println("Soul skipped");
                }

            }
        }
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAttkBuff() {
        return attkBuff;
    }

    public void setAttkBuff(int attkBuff) {
        this.attkBuff = attkBuff;
    }
}
