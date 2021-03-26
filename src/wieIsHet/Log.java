package wieIsHet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
    public static final boolean DEBUG_ON = true;
    public static final boolean append = true;
    public static final boolean fullLog = true;




    public static void debug(String message){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtfAdvanced = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        if (DEBUG_ON) System.out.println(message);

        if(fullLog) {
            try (BufferedWriter bw = new BufferedWriter(new PrintWriter(new FileWriter("logger-"+dtf.format(now)+".log", append)))){
                bw.append("["+dtfAdvanced.format(now)+"] "+message);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void error(String message){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtfAdvanced = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(message);
        if(fullLog) {
            try (BufferedWriter bw = new BufferedWriter(new PrintWriter(new FileWriter("logger-"+dtf.format(now)+".log", append)))){
                bw.append("["+dtfAdvanced.format(now)+"] "+message);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
