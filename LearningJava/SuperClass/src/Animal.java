public abstract class Animal
{
    private double age;
    private double mass;
    private String speases = null;

    public Animal(){}

    public Animal(double age, double mass) {
        this.age = age;
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", mass=" + mass +
                '}';
    }


    public String getSpeases() {
        return speases;
    }

    public void setSpeases(String speases) {
        this.speases = speases;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void eat() {
        System.out.println("its meal time");
    }
}
