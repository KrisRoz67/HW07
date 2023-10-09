package task2;

public class Car {
    private String brand;
    private String model;
    private int currentSpeed;
    private int maxAllowedSpeed;
    private Fuel fuel;
    private int qtyOfDoors;
    private int pastDistance;

    private String regNr;

    private int regYear;
    private final static int MIN_SPEED = 0;
    private final static int MAX_SPEED = 200;


    private GearBox gearbox;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if (brand==null || brand.isEmpty()){
            throw new IllegalArgumentException("Car brand can't be empty.");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public int regYear() {
        return regYear;
    }

    public void setRegYear(int regYear) {
        if (regYear > 1950 && regYear < 2024) {
            this.regYear = regYear;
        } else throw new IllegalArgumentException("This reg.year is impossible!");
    }

    public String getRegNr() {
        return getRegNr();
    }

    public void setRegNr(String regNr) {
        if (regNr != null && regNr.length() == 6 ) {
            this.regNr = regNr;
        } else
            throw new RuntimeException("Ordinary car reg.number has to be 6 sybmbols."); //бывают заказные номера, опустим.
    }

    public void setModel(String model) {
        if (model==null || model.isEmpty()){
            throw new IllegalArgumentException("Car model can't be empty.");
        }
        this.model = model;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        if (currentSpeed > MIN_SPEED && currentSpeed <= MAX_SPEED) {
            this.currentSpeed = currentSpeed;
        } else {
            throw new RuntimeException("Speed of car is not correct");
        }
    }

    public int getMaxAllowedSpeed() {
        return maxAllowedSpeed;
    }

    public void setMaxAllowedSpeed(int maxAllowedSpeed) {
        if (maxAllowedSpeed > MIN_SPEED && maxAllowedSpeed <=MAX_SPEED) {
            this.maxAllowedSpeed = maxAllowedSpeed;
        } else {
            throw new RuntimeException("Speed of car is not correct");
        }
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        if (Fuel.DIESEL.equals(fuel)|| Fuel.GAS.equals(fuel)|| Fuel.ELECTRIC.equals(fuel)|| Fuel.GASOLINE.equals(fuel)) {
            this.fuel = fuel;
        }else {
            throw new IllegalStateException( "No such option of fuel type!");
        }
    }

    public int getQtyOfDoors() {
        return qtyOfDoors;
    }

    public void setQtyOfDoors(int qtyOfDoors) throws IllegalArgumentException {
        if (qtyOfDoors > 1 && qtyOfDoors < 6 && qtyOfDoors % 2 == 0) {
            this.qtyOfDoors = qtyOfDoors;
        } else
            throw new IllegalArgumentException("Quantity of ordinary car is not correct. It has to be 2 or 4 excl. trunk");
    }

    public int getPastDistance() {
        return pastDistance;
    }

    public void setPastDistance(int pastDistance) throws IllegalArgumentException {
        if (pastDistance > 0) {
            this.pastDistance = pastDistance;
        } else throw new IllegalArgumentException("Past distance can't be less than 0");

    }

    public GearBox getGearbox() {
        return gearbox;
    }

    public void setGearbox(GearBox gearbox) throws IllegalStateException {
        if (GearBox.AUTOMATIC.equals(gearbox) || GearBox.SEMI_AUTOMATIC.equals(gearbox) || GearBox.MANUAL.equals(gearbox)) {
            this.gearbox = gearbox;
        } else throw new IllegalStateException("This box of gear doesn't exist!");
    }

    public void checkTheSpeed() {
        while (currentSpeed >= maxAllowedSpeed) {
            System.out.println("\nYou speed is to high. You have to slow down!");
            currentSpeed = slowDown();
        }
        System.out.println("\nYour speed is checked. It's ok.");
    }

    public int slowDown() {
        setCurrentSpeed(currentSpeed - 5);
        System.out.printf("\nYour speed after slowing down is %s km/h", currentSpeed);
        return currentSpeed;
    }

    public void speedUp(int x) {
        setCurrentSpeed(currentSpeed + x);
        System.out.printf("\nYou have increased your speed for %s km/h and now your speed is %s km/h. ", x, currentSpeed);
    }

    public String getInfo() {
        return String.format("""
                Your car brand is %s.\s
                The car model is %s.
                The car has %s gearbox.
                There are %s doors inside.
                The car so far has past %s km.
                The car has registered on year %s.
                The car reg.number is %s.
                The car fuel type is %s.
                The current speed is %s km/h.
                """, brand, model, gearbox, qtyOfDoors, pastDistance, regYear, regNr, fuel, currentSpeed);
    }

    public static class CarBuilder {
        private final Car car = new Car();

        public CarBuilder brand(String brand) {
            car.setBrand(brand);
            return this;
        }

        public CarBuilder model(String model) {
            car.setModel(model);
            return this;
        }

        public CarBuilder regNr(String regNr) {
            car.setRegNr(regNr);
            return this;
        }

        public CarBuilder regYear(int regYear) {
            car.setRegYear(regYear);
            return this;
        }

        public CarBuilder currentSpeed(int currentSpeed) {
            car.setCurrentSpeed(currentSpeed);
            return this;
        }

        public CarBuilder gearBox(GearBox gearBox) {
            car.setGearbox(gearBox);
            return this;
        }

        public CarBuilder maxAllowedSpeed(int maxAllowedSpeed) {
            car.setMaxAllowedSpeed(maxAllowedSpeed);
            return this;
        }

        public CarBuilder fuel(Fuel fuel) {
            car.setFuel(fuel);
            return this;
        }

        public CarBuilder qtyOfDoors(int qtyOfDoors) {
            car.setQtyOfDoors(qtyOfDoors);
            return this;
        }

        public CarBuilder pastDistance(int pastDistance) {
            car.setPastDistance(pastDistance);
            return this;
        }

        public Car build() {
            return this.car;
        }
    }
}
