package cyberguard;

public class KorisnickiNalog {

 
    private String username;
    private String lozinka;
    private int brojNeuspelihPrijava;
    private String statusRizika;

    
    public KorisnickiNalog(String username, String lozinka, int brojNeuspelihPrijava) {
        this.username = username;
        this.lozinka = lozinka;
        this.brojNeuspelihPrijava = brojNeuspelihPrijava;
        
        
        this.statusRizika = proceniBezbednost();
    }

    
    public void prikaziIzvestaj() {
        System.out.println("Korisnik: " + this.username 
                + " | Neuspele prijave: " + this.brojNeuspelihPrijava 
                + " | Status: " + this.statusRizika);
    }

    public boolean jeSiguran() {
        return this.statusRizika.equals("SIGURAN");
    }

    private String proceniBezbednost() {
        boolean slaba = !jeDovoljnoDuga() || !imaVelikoSlovo() 
                        || !imaCifru() || jeUListiSlabih();
        boolean napad = jeBruteForceRizik();

        if (slaba && napad) {
            return "KRITICAN (Slaba lozinka + Brute-Force napad!)";
        } else if (napad) {
            return "VISOK RIZIK (Detektovan Brute-Force napad!)";
        } else if (slaba) {
            return "RIZICAN (Slaba lozinka)";
        } else {
            return "SIGURAN";
        }
    }

    private boolean jeDovoljnoDuga() {
        return this.lozinka.length() >= 8;
    }

    private boolean imaVelikoSlovo() {
        for (int i = 0; i < this.lozinka.length(); i++) {
            if (Character.isUpperCase(this.lozinka.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean imaCifru() {
        for (int i = 0; i < this.lozinka.length(); i++) {
            if (Character.isDigit(this.lozinka.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean jeUListiSlabih() {
        String[] slabeLozinke = {"123456", "password", "admin", "qwerty", "12345678"};
        for (int i = 0; i < slabeLozinke.length; i++) {
            if (this.lozinka.equalsIgnoreCase(slabeLozinke[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean jeBruteForceRizik() {
        return this.brojNeuspelihPrijava >= 5;
    }
}