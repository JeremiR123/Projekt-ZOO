package Domain;

public class Reptile extends Animal implements Swimable { 
    public String scalesColor;
    public int Max_age_Reptile = 100;

    public Reptile(String name, int age, String scalesColor) {
        this.name = name;
        this.scalesColor = scalesColor;

        if (age >= 0) {
            if (age < Max_age_Reptile) {
                this.age = age;
            } else {
                System.out.println("Wiek " + age + " jest niepoprawny dla gada");
                this.age = 0;
            }
        } else {
            System.out.println("Wiek " + age + " jest niepoprawny");
        }
    }
}