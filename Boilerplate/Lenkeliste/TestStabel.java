public class TestStabel {
    static Lenkeliste<String> stabel = new Stabel<>();

    public static void main(String[] args) {
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "test3";
        String test4 = "test4";

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

    }

    // skriver ut storrelse til stabel
    static void hentStorrelse() { System.out.println(stabel.storrelse()); }

    // legger til node i stabel, og skriver ut antall og alle noder i stabel
    static void leggTilNode(String data) {
        // legger til nytt element
        stabel.leggTil(data);

        // skriver ut data til stabel
        System.out.println("Alle element i stabel:\n");
        for (int i = 0; i < stabel.storrelse(); i++) {
            System.out.println("Indeks: " + i + ", data: " + stabel.hent(i));
        }

        // skriver ut storrelse
        System.out.println("\nStorrelse: " + stabel.storrelse());
    }

    // fjerner node fra stabel, og skriver ut antall og alle noder i stabel
    static void fjernNode() {
        // fjerner siste element i stabel
        stabel.fjern();

        // skriver ut data til stabel
        System.out.println("Alle element i stabel:\n");
        for (int i = 0; i < stabel.storrelse(); i++) {
            System.out.println("Indeks: " + i + ", data: " + stabel.hent(i));
        }

        // skriver ut storrelse
        System.out.println("\nStorrelse: " + stabel.storrelse());
    }

    // setter inn node i gitt posisjon, og skriver ut antall og alle noder i stabel
    static void sett(int pos, String data) {
        // setter inn node i gitt posisjon
        stabel.sett(pos, data);

        // skriver ut data til stabel
        System.out.println("Alle element i stabel:\n");
        for (int i = 0; i < stabel.storrelse(); i++) {
            System.out.println("Indeks: " + i + ", data: " + stabel.hent(i));
        }

        // skriver ut storrelse
        System.out.println("\nStorrelse: " + stabel.storrelse());
    }

    // fjerner node fra gitt posisjon, og skriver ut antall og alle noder i stabel
    static void fjern(int pos) {
        // fjerner node fra gitt posisjon
        stabel.fjern(pos);

        // skriver ut data til stabel
        System.out.println("Alle element i stabel:\n");
        for (int i = 0; i < stabel.storrelse(); i++) {
            System.out.println("Indeks: " + i + ", data: " + stabel.hent(i));
        }

        // skriver ut storrelse
        System.out.println("\nStorrelse: " + stabel.storrelse());
    }
}
