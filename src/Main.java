import transport.Car;
import transport.Car.Key;


public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    static void task1() {
        System.out.println("TASK 1");
        separator("||");
        Car oka = new Car(
                "OKA",
                "Swallow",
                1.5f,
                "Black",
                1965,
                "Russia",
                "",
                "Hatchback",
                "",
                4,
                new Key(true, false));
        oka.setRegistrationNumber("GR 0245 PO");
        oka.setEngineVolume(0);

        System.out.println(oka);
        separator("=");
        oka.setTransmission("Unknown");

        System.out.println("Car brand: " + oka.getBrand());
        System.out.println("Car model: " + oka.getModel());
        System.out.println("Car color: " + oka.getColor());
        System.out.println("Car country: " + oka.getCountry());
        System.out.println("Car transmission: " + oka.getTransmission());
        System.out.println("Car production year: " + oka.getYear());
        System.out.println("Car body type: " + oka.getCarcaseType());
        System.out.println("Car engine volume: " + oka.getEngineVolume());
        System.out.println("Car seats: " + oka.getSeats());
        System.out.println("Car registration number: " + oka.getRegistrationNumber());
        separator("||");
    }

    static void task2() {
        System.out.println("TASK 2");
        separator("||");
        Car bmw = new Car(
                "BMW",
                "i8",
                1.5f,
                "Red",
                1965,
                "German",
                "Auto",
                "Coupe ",
                "",
                4,
                new Car.Key(true, true));
//        Key key = new Key(true);
//        bmw.setKey(key);
        System.out.println(bmw);
//        System.out.println("Car key: " + bmw.getKey());
        separator("||");
    }


    static void separator(String sep) {
        System.out.println(sep.repeat(50));
    }
}