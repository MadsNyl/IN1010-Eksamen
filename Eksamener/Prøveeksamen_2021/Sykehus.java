public class Sykehus {
    private static Avdeling akutten = new Akutten();
    private static Avdeling sengepost = new Sengepost(10);
    private static AnalyseBuffer faresone = new AnalyseBuffer();
    private static PasientPrio register = new PasientPrio();

    public static void main(String[] args) {
        Pasient pasient1 = new Pasient("22424242", "Mads", 4);
        Pasient pasient2 = new Pasient("5353535", "Sander", 3);

        skrivInn(pasient1, akutten);
        skrivInn(pasient2, sengepost);
        overfor(pasient1, akutten, sengepost);
        skrivUt(pasient2, sengepost);

        // oppgave 5
        int 
    }

    private static void skrivInn(Pasient p, Avdeling avdeling) {
        avdeling.settInnPasient(p);
    }

    private static void overfor(Pasient p, Avdeling fra, Avdeling til) {
        Pasient pasient = fra.hentUt(p);
        if (pasient != null) til.settInnPasient(pasient);
    }

    private static void skrivUt(Pasient p, Avdeling avdeling) {
        avdeling.hentUt(p);
    }

    public static boolean iFaresonenMann(Pasient p) {
        if
    }

    public static boolean iFaresonenKvinne(Pasient p) {}
}
