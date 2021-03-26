package wieIsHet;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Deze log class wordt gebruikt om alles te volgen en te debuggen.
 * Het schrijft elk regel op de debug console maar ook in een file in de root van het spel met het tijdstip.
 * Deze maakt de leven van iedereen makkelijker bij een fout of issue.
 *
 * @author LeventHAN
 */
public class Log {
    public static final boolean DEBUG_ON = true;
    public static final boolean append = true;
    public static final boolean fullLog = true;


    public static void debug(String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtfAdvanced = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        if (DEBUG_ON) System.out.println(message);

        if (fullLog) {
            try (BufferedWriter bw = new BufferedWriter(new PrintWriter(new FileWriter("logger-" + dtf.format(now) + ".log", append)))) {
                bw.append("[" + dtfAdvanced.format(now) + "] " + message);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void error(String message) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dtfAdvanced = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH.mm.ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(message);
        if (fullLog) {
            try (BufferedWriter bw = new BufferedWriter(new PrintWriter(new FileWriter("logger-" + dtf.format(now) + ".log", append)))) {
                bw.append("[" + dtfAdvanced.format(now) + "] " + message);
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
