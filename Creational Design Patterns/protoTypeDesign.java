interface gameCharacter extends Cloneable{
    gameCharacter clone();
    void display();
}

class characterPrototype implements  gameCharacter{
    private String type;
    private int health;
    private int attackPower;
    private int defense;
    private int level;

    public characterPrototype(String type, int health, int attackPower, int defense, int level) {
        this.type = type;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
        this.level = level;
    }
    @Override
    public gameCharacter clone() {
        try {
            
        return (gameCharacter) super.clone();
        } catch (CloneNotSupportedException e) {
           throw new RuntimeException("not supported");
        }
    }

    @Override
    public void display() {
         System.out.println("Character Type: " + type +
                           ", Health: " + health +
                           ", Attack: " + attackPower +
                           ", Defense: " + defense +
                           ", Level: " + level);
    }
    public void setType(String type) {
        this.type = type;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
public class protoTypeDesign{
    public static void main(String[] args) {
        characterPrototype soilder=new characterPrototype("Soilder",100,60,55,5);
        characterPrototype general=new characterPrototype("General",100,85,90,8);

        characterPrototype soilder1=(characterPrototype) soilder.clone();
        soilder1.setHealth(80);
        soilder.setType("soilder 1");

        characterPrototype general1=(characterPrototype) general.clone();
        general1.setAttackPower(100);
        general1.setType("general 1");

        System.out.println("soilder types");
        soilder.display();
        soilder1.display();

        System.err.println("General type");
        general.display();
        general1.display();
    }
}