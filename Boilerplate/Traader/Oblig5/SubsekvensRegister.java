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
                        streng += del1;
                        streng += del2;
                        streng += del3;
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
}
