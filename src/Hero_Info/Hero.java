package Hero_Info;

import Item_Info.*;
import Enemy_Info.*;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by nickg on 1/13/2017.
 */

//Possibly build an allegiance system as the type system? 5-6 different gods that heroes align with, different perks
// depending on which is picked
public class Hero {

    protected String name;
    protected int health, attackBonus, special;
    protected int maxHealth;
    protected int defense;
    protected Weapon mainWeapon;
    protected Scanner scan = new Scanner(System.in);
    protected int level, experience, expToNext, defendChance;
    public Sidekick partner;

    //ArrayList containing each item character has picked up

    protected ArrayList<Items> bag = new ArrayList<>();
    static WeaponList weaponList = new WeaponList();

    public Hero(){

        this.name = setName();
        chooseWeapon();
        this.health = 20;
        this.defense = 1;
        this.attackBonus = 1;
        this.special = 1;
        this.maxHealth = 20;
        this.level = 1;
        this.experience = 0;
        this.expToNext = 10;
        this.defendChance = 1;
        this.partner = new Sidekick();
    }
//The attack system. more or less gives you 3/5 chance of hitting a regular (weaker attack)
    //almost a 2/5 chance of hitting a better attack, and a 3 percent-ish chance of critical hit
    public int Attack1() {

        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        int attkpoints;

        if (n >= 1 && n <= 60) {
            //weak attack
            attkpoints = this.mainWeapon.getPower() + this.attackBonus;
            System.out.print(this.name + " used " + this.mainWeapon.getAttack1() + "! ");
            return attkpoints;
        } else if (n >= 61 && n <= 98) {
            //strong attack
            attkpoints = this.mainWeapon.getPower2() + this.attackBonus;
            System.out.print(this.name + " used " + this.mainWeapon.getAttack2() + "! ");
            return attkpoints;

        } else {
            //critical attack
            attkpoints = ((this.mainWeapon.getPower2()) * 2) + this.attackBonus;
            System.out.println(this.name + " used a critical strike! ");
            return attkpoints;

        }
    }

    //Another part of the battle system, computing whether your character would survive an attack.



    public void receiveDamage(int pain){

        //If your health and defense buff are greater than attack, you lose health

        if(this.health + this.defense > pain && this.defense < pain){
            this.health = (this.health) - (pain - this.defense);
            System.out.println(this.health + " health left!");
        }
        //If your defense buff is greater than the damage inflicted, take 1 damage

        else if (this.defense >= pain && (this.health - 1 != 0)){

            this.health = this.health - 1;
            System.out.println(this.health + " health left!");
        }

        // else, you are dead
        else{
            this.health = 0;
            System.out.println(this.name + " died.");
        }
    }

    ;

    public String setName(){

        System.out.println("Name your character" + ":");
        String name = scan.nextLine();
        return name;
    }

    //If a character gains enough exp to level up, they get to place an experience point into one of their buffs

    public int chooseBonus(){

        System.out.println(this.name + " earned a bonus point! Where would you like to spend this point?\n1. Attack\n2.Defense\n3.Special");
        int j = scan.nextInt();
        scan.nextLine();
        switch(j){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, or 3");
                return 0;
        }
    }

    //Reads out the characters buff.

    //NOTE: Once graphics are written, need to make this return the number

    public void giveBonus(int choice){

        switch(choice){
            case 1:
                this.attackBonus += 1;
                System.out.println("Attack power raised to " + this.attackBonus);

                break;
            case 2:
                this.defense += 1;
                System.out.println("Defense power raised to " + this.defense);
                break;
            case 3:
                this.special += 1;
                System.out.println("Special raised to " + this.special);
                break;
            default:
                break;
        }
    }

    public int getHealth(){

        return this.health;
    }

    //Adds experience points after a won battle

    public void gainXP(int XPoints){

        this.experience += XPoints;

        if(this.experience >= expToNext){

            //creating a temp to hold what excess XP there will be
            int temp = this.experience - expToNext;
            this.level += 1;
            expToNext *= 1.1;
            this.experience = temp;
            this.maxHealth += 1;
            this.health = this.maxHealth;
            System.out.println(this.name + " leveled up to level " + this.level + "! Health increased to " + this.maxHealth + "!");
            giveBonus(chooseBonus());

            //Just in case if the character gets so much XP that they level up multiple times
            if(this.experience >= expToNext){
                gainXP(0);
            }
            }

        }

    public int getDefendChance(){

        return defendChance;
    }

    public String getName() {
        return name;
    }


    // The battle function. Might make this its own class with params of Hero, Sidekick and Enemy
    public void battle(Enemy x){
        boolean fight = true;

        System.out.println ("The " + x.getType() + " is sharpening it's " + x.getMainWeapon() + " for battle!");

        while (fight) {

            fight = false;

            receiveDamage(x.Attack1());

            if (getHealth() > 0) {
                fight = true;
                int r = userChoice();

                switch(r) {

                    case 1:
                        x.receiveDamage(Attack1());
                        break;
                    case 2:
                        x.setDefender(this.defendChance);
                        System.out.println(getName() + " braces...");
                        break;
                    case 3:
                        x.setDodgeChance(15);
                        System.out.println(getName() + " prepares to dodge...");
                        break;
                }

                if(x.getHealth() <= 0){
                    fight = false;
                    gainXP(x.getXP());
                    x.isDefeated(partner);

                }
            }

        }
    }

    public int userChoice(){
        System.out.println("1. Attack || 2. Defend || 3. Dodge");
        int j = scan.nextInt();
        scan.nextLine();
        return j;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() +"\nAttack : " + this.attackBonus + "\nCurrent Weapon: " + this.mainWeapon.getName() + "\nHealth: " + this.getHealth() +
                "/" + this.maxHealth + "\nArmor: " + this.defense + "\nLevel: " + this.level + "\nExp: " + this.experience + "/" + this.expToNext;
    }


    // Starter weapons - currently revising weapons list.

    public void chooseWeapon(){

        System.out.println("Quick, grab a weapon! What do you choose?\n1. Basic Sword\n2. Basic Bow\n3. Basic Daggers.");
        int choice = scan.nextInt();
        scan.nextLine();
        switch(choice){

            case 1:
                this.mainWeapon = weaponList.getWeapon(0);
                break;
            case 2:
                this.mainWeapon = weaponList.getWeapon(0);
                break;
            case 3:
                this.mainWeapon = weaponList.getWeapon(0);
                break;
            default:
                break;
        }
    }

    public void setSpecial(int special) {
        this.special = special;
    }

    public void setDefendChance(int defendChance) {
        this.defendChance = defendChance;
    }

    public int getSpecial() {
        return special;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public int getAttackBonus() {
        return attackBonus;
    }
}
