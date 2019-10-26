import Enemy_Info.*;
import Hero_Info.*;

import java.util.Scanner;

/**
 * Created by nickg on 1/13/2017.
 */
public class Main {
    Scanner scan = new Scanner(System.in);


    public static void main(String[] args) {


        //Weapon system currently under re-write, converting weapons into a Map, assigning Hero
        //Teeth and Werewolf claws for time being

        Werewolf sampleEnemy = new Werewolf();
        Hero newhero = new Hero();
        newhero.battle(sampleEnemy);

        //Need to next these into the battle function. Possibly make battle it's own class?
        newhero.partner.setSoul();
        newhero.partner.printStats();



    }
}
