package Domain;
import java.io.File;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public abstract class Animal {
    Random random = new Random();
    public String name;
    public int age;
    private int hunger = random.nextInt(11);
    private boolean sleep = false;
    
    public String eat(){
        if(hunger>0){
            this.hunger--;
        }
        else if(hunger==0)
        {
            hunger = hunger+random.nextInt(10 - 4 + 1) + 4;
            System.out.println("Animal "+name+" satisfies hunger");
            switch (name) {
        case "Elephant":
            play("slon.wav");
            break;

        case "Lion":
            play("lew.wav");
            break;

        case "Eagle":
            play("orzel.wav");
            break;

        case "Penguin":
            play("pingwin.wav");
            break;

        case "Crocodile":
            play("krokodyl.wav");
            break;

        default:
            System.out.println("Brak dźwięku dla: " + name);           
    }
        
        }
        return  name +" hunger:"+hunger;
    }

    private int energy = random.nextInt(10) + 1;

    public String sleep() {
        if (energy > 0) {
            this.energy--;
        } else if(energy==0){
            energy = energy+random.nextInt(10) + 1; 
            System.out.println("Animal "+name+" fell asleep");
        }
        return " energy:"+energy;
    }
    
    

    private void play(String fileName) {
    String filePath = "dzwieki/" + fileName;
    PlayMusic(filePath);
    }

public static void PlayMusic(String location){
//    System.out.println("PRÓBA ODTWORZENIA DŹWIĘKU");
//    System.out.println("Oczekiwana ścieżka pliku: " + location);
    try
    {
        File musicPath = new File(location);

        if(musicPath.exists())
        {
//           System.out.println("Plik znaleziony. Rozpoczynam odtwarzanie..."); 
            
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();

            long duration = clip.getMicrosecondLength() / 1000;
            
            Thread.sleep(duration + 500); 

            clip.close(); 
//            System.out.println("Odtwarzanie zakończone.");
        }
        else
        {
            System.out.println("BŁĄD ŚCIEŻKI: Plik dźwiękowy NIE istnieje pod tą ścieżką!");
        }
    }
    catch(Exception e)
    {
        System.out.println("BŁĄD JAVAX.SOUND: Wystąpił błąd podczas ładowania/odtwarzania klipu.");
        System.out.println("Szczegóły błędu: " + e.getMessage());
        e.printStackTrace();
    }
}
}