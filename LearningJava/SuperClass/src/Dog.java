public class Dog extends Animal{
    private boolean floppyEars;
    private double tailLength;

    public Dog(){}

    public Dog(boolean floppyEars, double tailLength, double age, double mass) {
        super(age, mass);
        this.floppyEars = floppyEars;
        this.tailLength = tailLength;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "floppyEars=" + floppyEars +
                ", tailLength=" + tailLength +
                ", age=" + super.getAge() +
                ", mass=" + super.getMass() +'}';
    }

    public boolean isFloppyEars() {
        return floppyEars;
    }

    public void setFloppyEars(boolean floppyEars) {
        this.floppyEars = floppyEars;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }


    public void eat() {
        super.eat();
        System.out.println("the dog eats all the food");
    }
}
