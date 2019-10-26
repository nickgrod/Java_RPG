package Item_Info;

/**
 * Created by nickg on 1/13/2017.
 */
public class Weapon extends Items{

    protected int power;
    protected int power2;
    protected String description;
    protected Attack attack1;
    protected Attack.specialAttk attack2;

    public Weapon(String name, Attack attack1, Attack.specialAttk attack2) {
        this.name = name;
        this.attack1 = attack1;
        this.attack2 = attack2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return attack1.getPower();
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPower2() {
        return attack2.getPower();
    }

    public void setPower2(int power2) {
        this.power2 = power2;
    }

    public String getAttack1() {
        return attack1.getName();
    }

    public String getAttack2() {
        return attack2.getName();
    }


    public String getDescription(){

        return this.description;
    }

    public Weapon getWeapon(){

        return this;
    }
}
