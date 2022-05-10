public class Subsekvens {
    private final String SUBSEKVENS;
    private int antall = 1;

    public Subsekvens(String subsekvens) {
        SUBSEKVENS = subsekvens;
    }

    // henter antall 
    public int hentAntall() { return antall; }

    // endrer antall
    public void endreAntall(int tall) { antall = tall; }

    // henter subsekvens
    public String hentSubsekvens() { return SUBSEKVENS; }


    @Override
    public String toString() { return "(" + SUBSEKVENS + "," + antall + ")"; }
}