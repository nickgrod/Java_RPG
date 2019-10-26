package Hero_Info;

import java.util.ArrayList;
import java.util.Scanner;
import Enemy_Info.*;


//soul system will work with companions. max 10 soul burdens, different burden value depending on strength
/**
 * Created by nickg on 1/14/2017.
 */
public class Sidekick {

    private String name;
    private String type;
    private int attack, currentSouls;
    private int maxHealth;
    private int health;
    private Scanner scan = new Scanner(System.in);
    private String attackName;
    private String attack1, attack2;
    private ArrayList<Enemy> souls = new ArrayList<>();
    private int maxSouls, attkBuff, defendBuff, specBuff;


    public Sidekick() {

        setName();
        this.type = "Generic";
        this.attack = 1;
        this.maxHealth = 5;
        this.health = 5;
        this.maxSouls = 10;
        this.currentSouls = 0;
        this.attkBuff = 0;
        this.defendBuff = 0;
        this.specBuff = 0;
    }

    public String getName() {
        return name;
    }

    public void setName() {

        System.out.println("Name your companion: ");
        String name = scan.nextLine();
        this.name = name;
        System.out.println("Your companion has accepted the name " + this.name + "");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int Attack() {
        System.out.println(this.name + " used " + this.attackName + "!");
        return attack;

    }

   /* public int specialAttk() {
        System.out.println(this.name + " used " + this.specialAttack + "!");
        return 0;
    }

    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    public void setSpecialAttack(String specialAttack) {
        this.specialAttack = specialAttack;
    }

    public String getAttackName() {
        return attackName;
    }

    public String getSpecialAttack() {
        return specialAttack;
    }*/


    public void absorbSoul(Enemy x) {
        if (x.getSoulSize() < this.maxSouls - this.currentSouls) {

            souls.add(x);
        } else {
            System.out.println("Out of space! Choose souls to clear to continue...");
        }
    }

    public void seeSouls(){

        System.out.println("Current Souls in Collection:");
        if(souls.size() > 0) {
            for (int i = 0; i < souls.size(); i++) {

                System.out.println((i + 1) + " " + souls.get(i).getType());

            }
        }
        else{
            System.out.println("No souls in collection!");
        }
    }

    public void setSoul(){
        if(this.currentSouls > 0) {
            System.out.println("Pick a soul to set as active.");
            seeSouls();
            int j = (scan.nextInt() - 1);
            scan.nextLine();
            this.type = souls.get(j).getType();
            this.attack1 = souls.get(j).getAttack1();
            this.attack2 = souls.get(j).getAttack2();
            System.out.println(this.name + " transformed into a " + this.type + "!");
        }
    }

    public void printStats(){

        System.out.println("Stats:\nName:" + this.name + "\nCurrent Form:" + this.type + "\nAttack 1:" + this.attack1
        + "\nAttack 2:" + this.attack2);
    }

    public int numOfSouls(){

        return souls.size();
    }

    public String singleSoul(int i){

        return souls.get(i).getType();
    }

    public int getAttkBuff() {
        return attkBuff;
    }

    public void setAttkBuff(int attkBuff) {
        this.attkBuff = attkBuff;
    }

    public int getDefendBuff() {
        return defendBuff;
    }

    public void setDefendBuff(int defendBuff) {
        this.defendBuff = defendBuff;
    }

    public int getSpecBuff() {
        return specBuff;
    }

    public void setSpecBuff(int specBuff) {
        this.specBuff = specBuff;
    }
}
