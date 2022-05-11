import java.util.HashMap;

public class Hovedprogram {
    public static void main(String[] args) {
        String filvei1 = "Data/test1.txt";
        String filvei2 = "Data/test2.txt";

        HashMap<String, Subsekvens> kart1 = SubsekvensRegister.lesFil(filvei1);
        HashMap<String, Subsekvens> kart2 = SubsekvensRegister.lesFil(filvei2);

        HashMap<String, Subsekvens> flettet_kart = SubsekvensRegister.flett(kart1, kart2);

        for (Subsekvens e : flettet_kart.values()) {
            System.out.println(e);
        }
    }
}
