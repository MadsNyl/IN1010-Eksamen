public class Lege extends Ansatt {
    protected final int legeNummer;

    public Lege(int ansattID, String navn, int legeNummer) {
        super(ansattID, navn);
        this.legeNummer = legeNummer;
    }

}
