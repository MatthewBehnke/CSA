import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>();

        humans.add(new Man());
        humans.add(new Women());

        humans.forEach((n) ->  humans.get(humans.indexOf(n)).useRestroom());


    }
}

