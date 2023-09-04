package transport;

import java.time.LocalDate;

public class Car {
    public static class Key {
        private final boolean remoteStart;
        private final boolean keylessAccess;


        public Key(boolean remoteStart, boolean keylessAccess) {
                this.remoteStart = remoteStart;
                this.keylessAccess = keylessAccess;
        }

        public boolean isRemoteStart() {
            return remoteStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }

        @Override
        public String toString() {
            return String.format("%n" +
                            "Remote start: %s%n" +
                            "Keyless access: %s",
                    remoteStart ? "On" : "Off",
                    keylessAccess ? "On" : "Off");
        }
    }

    private final String brand;
    private final String model;
    private float engineVolume;
    private String color;
    private final int year;
    private final String country;
    private String transmission;
    private final String carcaseType;
    private String registrationNumber;
    private final int seats;
    private boolean isWinterTires;
    private Key key;

    public Car(String brand, String model, int year, String country, String carcaseType, int seats) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.country = country;
        this.carcaseType = carcaseType;
        this.seats = seats;
        this.isWinterTires = checkTires(LocalDate.now().getMonthValue());
    }

    public Car(String brand, String model, float engineVolume, String color, int year, String country, String transmission, String carcaseType, String registrationNumber, int seats, Key key) {
        this.brand = (brand != null && !brand.isEmpty() && !brand.isBlank()) ? brand : "default";
        this.model = (model != null && !model.isEmpty() && !model.isBlank()) ? model : "default";
        setEngineVolume(engineVolume);
        setColor(color);
        this.year = (year > 0) ? year : 2000;
        this.country = (country != null && !country.isEmpty()) ? country : "default";
        setTransmission(transmission);
        this.carcaseType = (carcaseType != null && !carcaseType.isEmpty() && !carcaseType.isBlank()) ? carcaseType : "Sedan";
        setRegistrationNumber(registrationNumber);
        this.seats = Math.max(seats, 0);
        this.isWinterTires = checkTires(LocalDate.now().getMonthValue());
        setKey(key);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getCountry() {
        return country;
    }

    public String getCarcaseType() {
        return carcaseType;
    }

    public int getSeats() {
        return seats;
    }

    public float getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(float engineVolume) {
        this.engineVolume = (engineVolume > 0) ? engineVolume : 1.5f;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = (color != null && !color.isEmpty()) ? color : "White";
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = (transmission != null &&
                !transmission.isEmpty() &&
                !transmission.isBlank() &&
                !transmission.equals("Unknown")) ?
                transmission : "Manual";
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = (registrationNumber != null &&
                !registrationNumber.isEmpty() &&
                !registrationNumber.isBlank()) ?
                registrationNumber : "AA 0000 RU";
    }

    private boolean checkTires(int month) {
        isWinterTires = month < 5 || month > 9;
        return isWinterTires;
    }

    @Override
    public String toString() {
        return String.format(
                "Brand: %s%n" +
                        "Model: %s%n" +
                        "Engine volume: %.1f%n" +
                        "Color: %s%nYear: %d%n" +
                        "Country: %s%n" +
                        "Transmission: %s%n" +
                        "Carcase type: %s%n" +
                        "Registration number: %s%n" +
                        "Seats: %d%n" +
                        "Tires: %s%n" +
                        "Key: %s",
                brand, model,
                engineVolume, color,
                year, country, transmission,
                carcaseType, registrationNumber,
                seats, (isWinterTires ? "winter" : "summer"),
                key);
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        if (key == null) {
            key = new Key(false, false);
        }
        this.key = key;
    }
}
