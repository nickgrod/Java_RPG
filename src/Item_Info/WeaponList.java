package Item_Info;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nickg on 1/20/2017.
 */
public class WeaponList {

    static Map<Integer, Weapon> weaponsList = new HashMap<>();
    static AttackList attackList  = new AttackList();
    static SpecAttacks specList = new SpecAttacks();


    // Have to create the weapons list and use a Buffered Reader to input all of them, make my life easier
    public WeaponList(){
        weaponsList.put(0, new Weapon("Teeth", attackList.getAttack(0), specList.getSpecAttk(0)));
        weaponsList.put(1, new Weapon("Claws", attackList.getAttack(1),specList.getSpecAttk(1)));
    }

    public Weapon getWeapon(int key){

        return weaponsList.get(key);
    }
}
