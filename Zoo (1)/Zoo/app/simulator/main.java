package app.simulator;
import Domain.*;
import java.util.ArrayList;
import java.util.List;
import service.Simulation;

public class main {
    public static void main(String[] args) { 
    List<Animal> zooAnimals = new ArrayList<>();

        Mammal slon = new Mammal("Elephant", 20, "szary");
        Mammal lew = new Mammal("Lion", 12, "brązowy");
        Mammal krok = new Mammal("Crocodile", 1, "zielony");
        Mammal orz = new Mammal("Eagle", 2, "brązowy");
        Mammal pin = new Mammal("Penguin", 5, "czarny");
     
        zooAnimals.add(slon);
        zooAnimals.add(lew);
        zooAnimals.add(krok);
        zooAnimals.add(orz);
        zooAnimals.add(pin);

        Simulation s = new Simulation(zooAnimals);
        s.RunSimulation(10);

        service.ReportingService raport = new service.ReportingService();
        raport.export("raport_aktywnosci.csv", s.getLogs());
    }
}
