package Enemy_Info;

import Item_Info.Weapon;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nickg on 1/31/2017.
 */


// current iteration of the weapon sets, probably gonna drop this piece altogether once i can get the buffered reader
    // and data file combos up and running.
public class WeaponSet {

    private final String name;
    private final WeaponType weaponType;
    private final Set<Weapon> weaponList;

    public enum WeaponType{
        Sword,
        Bow,
        Staff,
        Axe,
        Body_Part,
        Other,
    }

    public WeaponSet(String name, WeaponType weaponType){

        this.name = name;
        this.weaponType = weaponType;
        this.weaponList = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public Set<Weapon> getWeaponList() {
        return weaponList;
    }
}
