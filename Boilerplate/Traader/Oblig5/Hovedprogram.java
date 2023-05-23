import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hovedprogram {
    private static SubsekvensRegister register = new SubsekvensRegister();

    public static void main(String[] args) {
        String mappe_liten = "Data/TestDataLitenLike/";
        String mappe = "Data/TestDataLike/";

        lesInn(mappe_liten);

        flettSammen();
        System.out.println(register.storrelse());
        register.SkrivUtKart();
    }

    private static void lesInn(String mappe) {
        try {
            Scanner sc = new Scanner(new File(mappe + "metadata.csv"));
            while (sc.hasNextLine()) {
                String linje = sc.nextLine();
                HashMap<String, Subsekvens> kart = SubsekvensRegister.lesFil(mappe + linje); 
                register.leggTil(kart);         
            }
        } catch (FileNotFoundException e) { e.printStackTrace(); }
    }

    private static void flettSammen() {
        HashMap<String, Subsekvens> nytt_kart; 
        while (register.storrelse() > 1) {
            nytt_kart = SubsekvensRegister.flett(register.hentUt(0), register.hentUt(1));
            register.fjern(0);
            register.fjern(1);
            register.leggTil(nytt_kart);
        }
    }
}
