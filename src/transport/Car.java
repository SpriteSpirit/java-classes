package transport;

import java.time.LocalDate;

public class Car {
    public static class Key {
        private final boolean remoteStart;
        private final boolean keylessAccess;

        public Key(boolean remoteStart) {
            if (isValid(remoteStart) ) {
                if (remoteStart) {
                    this.remoteStart = true;
                    this.keylessAccess = false;
                } else {
                    this.remoteStart = false;
                    this.keylessAccess = true;
                }
            } else {
                throw new IllegalArgumentException("Invalid key parameters");
            }
        }

        public Key(boolean remoteStart, boolean keylessAccess) {
            if (isValid(remoteStart) && isValid(keylessAccess)) {
                if (remoteStart) {
                    this.remoteStart = true;
                    this.keylessAccess = false;
                } else {
                    this.remoteStart = false;
                    this.keylessAccess = true;
                }
            } else {
                throw new IllegalArgumentException("Invalid key parameters");
            }
        }

        private boolean isValid(boolean value) {
            return true;
        }

        public boolean isRemoteStart() {
            return remoteStart;
        }

        public boolean isKeylessAccess() {
            return keylessAccess;
        }

        @Override
        public String toString() {
            return String.format("Key: %nRemote start: %s%nKeyless access: %s%n", remoteStart, keylessAccess);
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

    public Car(String brand, String model, float engineVolume, String color, int year, String country, String transmission, String carcaseType, String registrationNumber, int seats) {
        this.brand = (brand != null && !brand.isEmpty() && !brand.isBlank()) ? brand : "default";
        this.model = (model != null && !model.isEmpty() && !model.isBlank()) ? model : "default";
        this.engineVolume = (engineVolume > 0) ? engineVolume : 1.5f;
        this.color = (color != null && !color.isEmpty()) ? color : "White";
        this.year = (year > 0) ? year : 2000;
        this.country = (country != null && !country.isEmpty()) ? country : "default";
        this.transmission = (transmission != null && !transmission.isEmpty() && !transmission.isBlank()) ? transmission : "Manual";
        this.carcaseType = (carcaseType != null && !carcaseType.isEmpty() && !carcaseType.isBlank()) ? carcaseType : "Sedan";
        this.registrationNumber = (registrationNumber != null && !registrationNumber.isEmpty() && !registrationNumber.isBlank()) ? registrationNumber : "AA 0000 RU";
        this.seats = Math.max(seats, 0);
        this.isWinterTires = checkTires(LocalDate.now().getMonthValue());
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
        if (engineVolume > 0) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.2f;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color != null && !color.isEmpty() && !color.isBlank()) {
            this.color = color;
        } else {
            this.color = "Black";
        }
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        if (transmission != null && !transmission.isEmpty() && !transmission.isBlank()) {
            this.transmission = transmission;
        } else {
            this.transmission = "Manual";
        }
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber != null && !registrationNumber.isEmpty() && !registrationNumber.isBlank()) {
            this.registrationNumber = registrationNumber;
        } else {
            this.registrationNumber = "AA 0000 RU";
        }
    }

    private boolean checkTires(int month) {
        isWinterTires = month < 5 || month > 9;
        return isWinterTires;
    }

    @Override
    public String toString() {
        return String.format("Brand: %s%nModel: %s%nEngine volume: %.1f%nColor: %s%nYear: %d%nCountry: %s%nTransmission: %s%nCarcase type: %s%nRegistration number: %s%nSeats: %d%nWinter tires: %s%n", this.brand, this.model, this.engineVolume, this.color, this.year, this.country, this.transmission, this.carcaseType, this.registrationNumber, this.seats, this.isWinterTires);
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }
}
