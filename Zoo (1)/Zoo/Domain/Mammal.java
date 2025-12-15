package Domain;

public class Mammal extends Animal implements Swimable, Trainable, Flyable{
    public String furColor;
    public int Max_age_Mammal = 200; 

    public Mammal(String name,int age,String furColor){
        this.name = name;
        if(age >=0){
            if(age < Max_age_Mammal){
                this.age = age;
            }
            else{
                System.out.println("Wiek"+age+"jest nie poprawny");
            }
        }
        else{
            System.out.println("Wiek"+age+"jest nie poprawny");
        }
        this.furColor = furColor;
    }

     
    public String getMammal(){
        return "Nazwa"+name+"Wiek:"+age+"Kolor futra:"+furColor;
    } 

}
