package task1;

public class Person {

    private int age;
    private String name;
    private String surname;
    private Gender gender;
    public final int MAX_AGE = 100;
    public final int MIN_AGE = 0;

    public Person() {
    }

    public Person(int age, String name, String surname) {
        this.age = age;
        this.name = name;
        this.surname =surname;
    }

    public Person(int age, String name, Gender gender, String surname) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.surname = surname;

    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) throws Exception {
        if (age > MIN_AGE && age < MAX_AGE) {
            this.age = age;
        } else {
            throw new Exception("Age is not correct");
        }
    }

    public void setName(String name) {
        if ( name !=null && name.length() > 1 ) {
            this.name = name;
        } else throw new RuntimeException("Name can't be so short or empty");
    }
    public void setSurName(String surname) {
        if ( surname !=null && surname.length() > 1 ) {
            this.surname = surname;
        } else throw new RuntimeException("Lastname can't be so short or empty");
    }

    public void setGender(Gender gender) {
        if (Gender.FEMALE.equals(gender) || Gender.MALE.equals(gender)) {
            this.gender = gender;
        } else throw new RuntimeException("Gender can't be set");
    }

    public String getInfo() {
        if (surname != null) {
            if (gender != null) {
                return String.format("Your person name is %s %s. Person is %s and is %s years old.",name,surname,gender,age);
            } else {
                return String.format("Your person name is %s %s, who is %s years old.",name,surname,age);
            }
        }else if  (gender != null) {
            return String.format("Your person name is %s. Person is %s and is %s years old.", name, gender, age);
        }
        return String.format("Your person name is %s, who is %s years old.", name,age);
    }
}
