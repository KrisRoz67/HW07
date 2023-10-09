import task1.Gender;
import task1.Person;
import task2.Car;
import task2.Fuel;
import task2.GearBox;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();
        try {
            person1.setAge(12);
        } catch (Exception e) {
            System.out.println("Ne vomozhno ");
        }
        person1.setName("Ed");
        person1.setGender(Gender.MALE);
        Person person2 = new Person(16, "Edd","Edson");
        Person person3 = new Person(34, "Eddy", Gender.MALE, "Edson");
        System.out.println("---------TASK 1-----------");
        System.out.println(person1.getInfo());
        System.out.println(person2.getInfo());
        System.out.println(person3.getInfo());
        System.out.println("---------TASK 2-----------");
        Car car1 = new Car.CarBuilder()
                .brand("Opel")
                .model("Astra")
                .regYear(2020)
                .regNr("UGH565")
                .fuel(Fuel.GASOLINE)
                .currentSpeed(44)
                .gearBox(GearBox.AUTOMATIC)
                .maxAllowedSpeed(60)
                .pastDistance(1234)
                .qtyOfDoors(4)
                .build();
        System.out.println(car1.getInfo());
        System.out.println("------------------------");
        car1.speedUp(10);
        car1.checkTheSpeed();
        System.out.println("------------------------");
        car1.speedUp(12);
        car1.checkTheSpeed();

    }

}