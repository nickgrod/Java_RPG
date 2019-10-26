package Item_Info;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nickg on 1/20/2017.
 */
public class SpecAttacks {

    static Map<Integer, Attack.specialAttk> specialAttackList = new HashMap<>();
    public SpecAttacks(){

        specialAttackList.put(0, new Attack.specialAttk("Fatal Fangs", 4, 2,0,0,0,0,2));
        specialAttackList.put(1, new Attack.specialAttk("Deathly Claws", 4,0,2,0,0,0,2));
        specialAttackList.put(2, new Attack.specialAttk("Fury Slash", 5, 0, 0, 2, 0,0,2));
        specialAttackList.put(3, new Attack.specialAttk("Iron Punch", 3, 2, 0, 0, 3, 0, 2));
        specialAttackList.put(4, new Attack.specialAttk("Strangle",6,0,0,2,0,2,1));

    }

    public Attack.specialAttk getSpecAttk(int key){

        return specialAttackList.get(key);
    }

}
