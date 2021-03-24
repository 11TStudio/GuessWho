package wieIsHet.model;

import wieIsHet.Log;

import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Vragen {
    List<Vraag> vragen;
    private final InputStream inputStream;

    public Vragen() {
        // We zeggen op voorhand hoeveel plaatsen we minstens nodig hebben
        vragen = new LinkedList<>();
        this.inputStream = this.getClass().getResourceAsStream("/game_assets/vragen.txt");
         this.readVragen();
        // this.writeVragen();
    }


    public List<Vraag> getVragen() {
        return vragen;
    }

    public int getSize() {
        return vragen.size();
    }
    // TODO: Deze werkt precies niet zo goed.
    public int getVragenOver() {
        int counter= (int) vragen.stream().filter(Vraag::isGevraagd).count();
        Log.debug("Counter voor gestelde vragen staat op: "+counter);
        return counter;
    }


    private void readVragen() {
        // Hier aanvullen...
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
            String line = reader.readLine();
            Vraag vraag;
            while(line != null) {
                String[] stukken = line.split(";");
                vraag = new Vraag(stukken[0], Boolean.parseBoolean(stukken[1]));
                vragen.add(vraag);
                line = reader.readLine(); // lees den volgende
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void writeVragen() {
//        // Hier aanvullen...
//        try (BufferedWriter bw = new BufferedWriter(new PrintWriter("testVragen.txt"))) {
//            for (Vraag vraag : vragen) {
//                bw.write(vraag.toString());
//                bw.newLine();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    public void removeVraag(Personage pers) {
//        vragen.remove(pers);
//    }



    @Override
    public String toString() {
        return "Vragen{" +
                "vragen=" + vragen +
                '}';
    }
}
