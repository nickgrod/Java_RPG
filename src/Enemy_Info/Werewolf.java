package Enemy_Info;

import Item_Info.WeaponList;

/**
 * Created by nickg on 1/13/2017.
 */
public class Werewolf extends Enemy {



    // a sample enemy class. Might just make all enemies data files and Buffered Reader them
    static WeaponList weaponList = new WeaponList();

    public Werewolf(){

        this.mainWeapon = weaponList.getWeapon(1);
        this.health = 15;
        this.type = "Werewolf";
        this.maxHealth = 15;
    }

}
