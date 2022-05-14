public class TestPrioritetskoe {
    static Lenkeliste<String> prioritetskoe = new Prioritetskoe<>();

    public static void main(String[] args) {
        String test1 = "test1";
        String test2 = "test2";
        String test3 = "test3";
        String test4 = "test4";

        hentStorrelse();
        leggTilNode(test2);
        leggTilNode(test4);
        leggTilNode(test3);
        leggTilNode(test1);
        iterer();
    }

    // skriver ut storrelse til koe
    static void hentStorrelse() { System.out.println(prioritetskoe.storrelse()); }

    // legger til node i koe etter sortert orden, og skriver ut antall og alle noder i koe
    static void leggTilNode(String data) {
        // legger til nytt element paa slutten av koe
        prioritetskoe.leggTil(data);

        // skriver ut data til stabel
        System.out.println("Alle element i prioritetskoe:\n");
        for (int i = 0; i < prioritetskoe.storrelse(); i++) {
            System.out.println("Indeks: " + i + ", data: " + prioritetskoe.hent(i));
        }

        // skriver ut storrelse
        System.out.println("\nStorrelse: " + prioritetskoe.storrelse());
    }

    // tester for each lokke
    static void iterer() {
        for (String e : prioritetskoe) {
            System.out.println(e);
        }
    }
}
