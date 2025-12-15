package service;

import Domain.*;
import java.util.ArrayList; // Potrzebne do listy logów
import java.util.List;

public class Simulation {
    private List<Animal> animals;
    // Lista do przechowywania historii: "Tura 1;Lew;Zjadł"
    private List<String> simulationLogs = new ArrayList<>(); 

    public Simulation(List<Animal> animals) {
        this.animals = animals;
    }

    public void RunSimulation(int liczba_tur) {
        int tury = 0;
        while (liczba_tur > tury) {
            tury += 1;
            System.out.println("=-=-=-=-=-=TURA " + tury + "=-=-=-=-=-=");

            for (Animal animal : animals) {
                String eatAction = animal.eat(); 
                System.out.println(eatAction);
                simulationLogs.add(tury + " ;" + animal.name + " ;Jedzenie: " + eatAction);

                String sleepAction = animal.sleep();
                System.out.println(animal.name + ": " + sleepAction);
                simulationLogs.add(tury + " ;" + animal.name + " ;Energia: " + sleepAction);
                try { Thread.sleep(200); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            }
            System.out.println("");
            try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }

    public List<String> getLogs() {
        return simulationLogs;
    }
}