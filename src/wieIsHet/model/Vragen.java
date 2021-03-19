//package wieIsHet.model;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Vragen {
//        private List<Vragen> vragen;
//        private final InputStream inputStream;
//
//        public Vragen() {
//            vragen = new ArrayList<>();
//            this.inputStream = this.getClass().getResourceAsStream("vragen.txt");
//            this.readStudenten();
//        }
//
//        public List<Vragen> getVragen() {
//            return vragen;
//        }
//
//        private void readStudenten() {
//            // Hier aanvullen...
//            try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))){
//                String line = reader.readLine(); // Vermeulen;Jos;12;INF103A
//                Vragen student;
//                while(line != null) {
//                    String[] stukken = line.split(";");
//                    // TODO: structuur vragen file
//                    student = new Vragen(stukken[0], stukken[1], Integer.parseInt(stukken[2]), stukken[3]);
//                    vragen.add(student);
//                    line = reader.readLine(); // lees den volgende
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//
//
//
//
//}
