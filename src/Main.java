import transport.Car;
import transport.Car.Key;


public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    static void task1() {
        System.out.println("TASK 1");
        separator();

        Car oka = new Car("OKA", "Swallow", 1.5f, "White",1965 , "Russia", "Unknown","Hatchback","", 4 );
        oka.setRegistrationNumber("GR 0245 PO");
        oka.setTransmission("");
        oka.setEngineVolume(0);
        System.out.println(oka);

        separator();
    }

    static void task2() {
        System.out.println("TASK 2");
        separator();

        Car oka = new Car("OKA", "Swallow", 1.5f, "White",1965 , "Russia", "Unknown","Hatchback","", 4 );
        Key key = new Key(true);
        oka.setKey(key);
        System.out.println(key);

        separator();
    }


    static void separator() {
        System.out.println("***********************************************");
    }

}