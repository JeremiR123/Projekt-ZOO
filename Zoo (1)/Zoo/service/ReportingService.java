package service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ReportingService implements Exportable {

    @Override
    public void export(String filename, List<String> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            
            writer.println("Tura;Zwierze;Aktywnosc");

            for (String row : data) {
                writer.println(row);
            }

            System.out.println("Raport aktywności zapisany do: " + filename);

        } catch (IOException e) {
            System.out.println("Błąd zapisu: " + e.getMessage());
        }
    }
}