abstract class Pasient {
    protected final String fnr, navn;
    protected Pasient neste;
    public final static int MAXPASPRIO = 10;
    protected int prioritet; // 0  <= prioritet <= MAXPASPRIO
    protected int sengNr = -1;

    public Pasient(String fnr, String navn, int prioritet) {
        this.fnr = fnr;
        this.navn = navn;
        this.prioritet = prioritet;
    }
}
