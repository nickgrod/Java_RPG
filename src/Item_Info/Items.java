package Item_Info;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nickg on 1/14/2017.
 */

//Need to buffered reader this stuff too


public class Items {

    protected String name;
    protected String type;
    protected String descrip;

    public Items(){

        this.name = "Item";
        this.type = "Generic";
        this.descrip = "Just a regular item.";
    }

    public String getName(){

        return this.name;
    }

}
