
public class TestKoe {
    static Lenkeliste<String> koe = new Koe<>();
    public static void main(String[] args) {
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "test3";
        String test4 = "test4";
        String test5 = "test5";

        hentStorrelse();
        leggTilNode(test1);
        System.out.println();
        leggTilNode(test2);
        System.out.println();
        leggTilNode(test3);
        System.out.println();
        fjernNode();
        System.out.println();
        sett(1, test4);
        System.out.println();
        fjern(1);
        System.out.println();
        bytt(1, test5);
    }

    // skriver ut storrelse til koe
    static void hentStorrelse() { System.out.println(koe.storrelse()); }

    // legger til node i koe, og skriver ut antall og alle noder i koe
    static void leggTilNode(String data) {
        // legger til nytt element paa slutten av koe
        koe.leggTil(data);

        // skriver ut data til stabel
        System.out.println("Alle element i koe:\n");
        for (int i = 0; i < koe.storrelse(); i++) {
            System.out.println("Indeks: " + i + ", data: " + koe.hent(i));
        }

        // skriver ut storrelse
        System.out.println("\nStorrelse: " + koe.storrelse());
    }

    // fjerner node fra koe, og skriver ut antall og alle noder i koe
    static void fjernNode() {
        // fjerner forste element i koe
        koe.fjern();

        // skriver ut data til stabel
        System.out.println("Alle element i koe:\n");
        for (int i = 0; i < koe.storrelse(); i++) {
            System.out.println("Indeks: " + i + ", data: " + koe.hent(i));
        }

        // skriver ut storrelse
        System.out.println("\nStorrelse: " + koe.storrelse());
    }

    // setter inn node i gitt posisjon, og skriver ut antall og alle noder i koe
    static void sett(int pos, String data) {
        // setter inn node i gitt posisjon
        koe.sett(pos, data);

        // skriver ut data til koe
        System.out.println("Alle element i koe:\n");
        for (int i = 0; i < koe.storrelse(); i++) {
            System.out.println("Indeks: " + i + ", data: " + koe.hent(i));
        }

        // skriver ut storrelse
        System.out.println("\nStorrelse: " + koe.storrelse());
    }

    // bytter inn node i gitt posisjon, og skriver ut antall og alle noder i koe
    static void bytt(int pos, String data) {
        // bytter inn node i gitt posisjon
        koe.bytt(pos, data);

        // skriver ut data til koe
        System.out.println("Alle element i koe:\n");
        for (int i = 0; i < koe.storrelse(); i++) {
            System.out.println("Indeks: " + i + ", data: " + koe.hent(i));
        }

        // skriver ut storrelse
        System.out.println("\nStorrelse: " + koe.storrelse());
    }
 
    // fjerner node fra gitt posisjon, og skriver ut antall og alle noder i koe
    static void fjern(int pos) {
        // fjerner node fra gitt posisjon
        koe.fjern(pos);

        // skriver ut data til koe
        System.out.println("Alle element i koe:\n");
        for (int i = 0; i < koe.storrelse(); i++) {
            System.out.println("Indeks: " + i + ", data: " + koe.hent(i));
        }

        // skriver ut storrelse
        System.out.println("\nStorrelse: " + koe.storrelse());
    }
}
