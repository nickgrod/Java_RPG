package Item_Info;
import Enemy_Info.Enemy;
import Hero_Info.Hero;
import Hero_Info.Sidekick;

/**
 * Created by nickg on 1/14/2017.
 */
public class Attack {

    protected String name;
    protected int power;

    public Attack(String name, int power){

        this.name = name;
        this.power = 0;
    }
    public Attack(){
        this.name = "";
        this.power = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public static class specialAttk extends Attack{

        private int SpecCode;
        private int attkBuff, defBuff, specBuff, dodgeBuff, expBuff, attkNerf;
        //SpecCode will hold a value that tells Java where to implement the Special effect (if any) 0 will be no special
        // Even numbers will be buffs, Odds will be effects on enemies, negatives will be special case
        public specialAttk(){

            this.SpecCode = 0;

        }
        public specialAttk(String name, int power, int attkBuff, int attkNerf, int specBuff, int dodgeBuff, int expBuff, int SpecCode){
            this.name = name;
            this.power = power;
            this.attkBuff = attkBuff;
            this.attkNerf = attkNerf;
            this.specBuff = specBuff;
            this.dodgeBuff = dodgeBuff;
            this.expBuff = expBuff;
            this.SpecCode = SpecCode;
        }

        public int getSpecCode() {
            return SpecCode;
        }

        public void setSpecCode(int specCode) {
            SpecCode = specCode;
        }

        public void heroSpec(Hero x, Enemy y, Sidekick z){

            if(this.SpecCode%2 == 0){

                x.setSpecial(x.getSpecial()+specBuff);
                x.setAttackBonus(x.getAttackBonus()+attkBuff);
                x.setDefendChance(x.getDefendChance()+defBuff);

            }
            else if(this.SpecCode%2 != 0 && this.SpecCode > 0){
                y.setDodgeChance(15 + dodgeBuff);
                y.setExperience((int)(y.getExperience() + (y.getExperience() * (0.01 * expBuff))));
                y.setAttkBuff(y.getAttkBuff() - attkNerf);
            }
            else if(this.SpecCode < 0){

                z.setAttkBuff(z.getAttkBuff() + attkBuff);
                z.setDefendBuff(z.getDefendBuff() + defBuff);
                z.setSpecBuff(z.getSpecBuff()+specBuff);
            }

        }
    }
}
