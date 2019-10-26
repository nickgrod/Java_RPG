package Item_Info;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nickg on 1/20/2017.
 */
public class AttackList {

    static Map<Integer, Attack> attackList = new HashMap<>();


    // Make a list and use a Buffered Reader here as well
    public AttackList()

    {

        attackList.put(0, new Attack("Bite", 2));
        attackList.put(1, new Attack("Scratch", 2));
    }

    public Attack getAttack(int attkNum) {

        return attackList.get(attkNum);
    }
}

