package Domain;

public class Bird extends Animal implements Flyable, Trainable { 
    public int wingspan;
    public int Max_age_Bird = 50;

    public Bird(String name, int age, int wingspan) {
        this.name = name;
        this.wingspan = wingspan;

        if (age >= 0) {
            if (age < Max_age_Bird) {
                this.age = age;
            } else {
                System.out.println("Wiek " + age + " jest niepoprawny dla ptaka");
                this.age = 0;
            }
        } else {
            System.out.println("Wiek " + age + " jest niepoprawny");
        }
    }
}