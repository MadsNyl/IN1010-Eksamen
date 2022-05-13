import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Barista implements Runnable {
    private final String[] drikker = {"Americano", "Cafe au lait", "Caffe latte", "Caffe mocca", "Espresso", "Cortado"};
    private Bord bord;
    private CountDownLatch barriere;
    private int id;
    private int teller = 1;

    public Barista(Bord bord, CountDownLatch barriere) {
        this.bord = bord;
        this.barriere = barriere;
        this.id = this.teller;
        this.teller++;
    }

    @Override
    public void run() {
        Random generator = new Random();
        for (int i = 0; i < 10; i++) {
            int nummer = generator.nextInt(drikker.length - 1);
            String kaffe = drikker[nummer];
            System.out.println("Barista med id: " + id + ", har laget en " + kaffe + ".");
            bord.serverKaffe(kaffe);
        }
        // bord.singaliserTomt();
        barriere.countDown();
    }

}
