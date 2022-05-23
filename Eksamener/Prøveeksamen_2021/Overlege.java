public class Overlege extends Lege {
    private final String spesialisering;
    private String ansvarskode;
    private boolean erAdmin;

    public Overlege(int ansattID, String navn, int legeNummer, String spesialisering, String ansvarskode, boolean erAdmin) {
        super(ansattID, navn, legeNummer);
        this.spesialisering = spesialisering;
        this.ansvarskode = ansvarskode;
        this.erAdmin = erAdmin;
    }

    public String hentAnsvarskode() {
        if (erAdmin && ansvarskode != null) return ansvarskode;
    }
}
