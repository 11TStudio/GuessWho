package wieIsHet;

import java.util.Arrays;

public class Personage {
    private boolean heeftBaard;
    private String kleurOog;
    private boolean heeftBril;
    private boolean heeftSnor;
    private String geslacht;
    private boolean isKaal;


    private String personageNaam[] = {
            "Levent",
            "Liam",
            "Alex",
            "Peeter",
            "Anniek",
            "Dirk",
            "Hasti",
            "Antoon",
            "Mauro",
            "Milan",
            "Eli",
            "Ruben",
            "Berat",
            "Maxim",
            "Mediha",
            "Sam",
            "Anass",
            "Peter",
            "Yari",
            "Murtadha",
            "Michel",
            "Arne",
            "Tim",
            "Shari"
    };

    private String vragen[] = {
            "Is het een vrouw?",
            "Draagt de persoon een bril?",
            "Heeft je persoon blauwe ogen?",
            "Heeft je persoon bruine ogen?",
            "Heeft je persoon grijze ogen?",
            "Heeft hij een baard?",
            "Heeft hij een snor?",
            "Is je persoon kaal?",
            "Heeft je persoon blond haar?",
            "Heeft je persoon zwart haar?",
            "Heeft je persoon bruin haar?",
            "Heeft je persoon iets op zijn hoofd?"
    };

/*
    public void getAllePersonages() {
        for (int i = 0; i < this.personageNaam.length; i++) {
            if (i > 10) {
                System.out.printf(i+" %-8s",personageNaam[i]);
            } else {
                System.out.printf(i + " %-9s", personageNaam[i]);
            }
            if ((i+1) % 3 == 0) {
                System.out.println( );
            }

        }
    }

    public String getPersonage(int index) {
        String personage = this.personageNaam[index];
        return personage;
    }
    public String getPersonage() {
        int randomInt = (int)(Math.random() * personageNaam.length + 1);
        String personage = this.personageNaam[randomInt];
        return personage;
    }

    public String[] getPersonageNaam() {
        return this.personageNaam;
    }

    public String[] getVragen() {
        return this.vragen;
    }
    */

}
