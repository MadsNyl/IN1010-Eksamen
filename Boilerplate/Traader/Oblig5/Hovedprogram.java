import java.util.HashMap;

public class Hovedprogram {
    public static void main(String[] args) {
        String filvei = "Data/test1.txt";

        HashMap<String, Subsekvens> kart = SubsekvensRegister.lesFil(filvei);

        for (String e : kart.keySet()) {
            System.out.println(e);
        }
    }
}
