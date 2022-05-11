import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubsekvensRegister {
    ArrayList<HashMap<String, Subsekvens>> register = new ArrayList<>();

    // hent storrelse til register
    public int storrelse() { return register.size(); }

    // legg til hashmap i register
    public void leggTil(HashMap<String, Subsekvens> kart) { register.add(kart); }

    // ta ut hashmap
    public HashMap<String, Subsekvens> hentUt(int pos) { return register.get(pos); }

    // leser inn fil og oppretter hashmap med subsekvenser
    static HashMap<String, Subsekvens> lesFil(String filvei) {
        HashMap<String, Subsekvens> kart = new HashMap<>();
        try {
            Scanner sc = new Scanner(new File(filvei));
            while (sc.hasNextLine()) {
                String linje = sc.nextLine();
                for (int i = 0; i < linje.length(); i++) {
                    if (i + 1 < linje.length() - 1 && i + 2 < linje.length()) {
                        String streng = "";
                        char del1 = linje.charAt(i);
                        char del2 = linje.charAt(i + 1);
                        char del3 = linje.charAt(i + 2);
                        streng = "" + del1 + del2 + del3;
                        Subsekvens subsekvens = new Subsekvens(streng);
                        kart.put(streng, subsekvens);
                    }
                }
            }

        } catch (FileNotFoundException e) { 
            e.printStackTrace();
        }
        return kart;
    }

    // slaar sammen to hashmaps til ett
    static HashMap<String, Subsekvens> flett(HashMap<String, Subsekvens> kart1, HashMap<String, Subsekvens> kart2) {
        HashMap<String, Subsekvens> retur_kart = new HashMap<>();

        // itererer gjennom kart nummer to og fyller inn verdier inn i retur kart
        for (Subsekvens x : kart2.values()) {
            retur_kart.put(x.hentSubsekvens(), x);
        }

        // itererer gjennom forste kart og sammenligner med verdier fra andre kart
        for (Subsekvens x : kart1.values()) {
            int teller = 0;
            for (Subsekvens y : kart2.values()) {
                if (x.hentSubsekvens().equals(y.hentSubsekvens())) {
                    teller = x.hentAntall() + y.hentAntall();
                }
            }
            Subsekvens ny_subsekvens = new Subsekvens(x.hentSubsekvens());
            if (teller > 0) ny_subsekvens.endreAntall(teller);
            retur_kart.put(x.hentSubsekvens(), ny_subsekvens);
        }

        return retur_kart;
    }
}
