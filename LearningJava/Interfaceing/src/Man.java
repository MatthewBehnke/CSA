public class Man implements Human {

    @Override
    public void eat() {
        System.out.println("Man eats food");
    }

    @Override
    public void talk() {
        System.out.println("man talks to friends");
    }

    @Override
    public void useRestroom() {
        System.out.println("Man uses the restroom");
    }
}
