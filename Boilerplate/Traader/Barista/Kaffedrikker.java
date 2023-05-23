import java.util.concurrent.CountDownLatch;

public class Kaffedrikker implements Runnable {
    private Bord bord;
    private CountDownLatch barriere;
    private int id;
    private static int teller = 1;

    public Kaffedrikker(Bord bord, CountDownLatch barriere) {
        this.bord = bord;
        this.barriere = barriere;
        id = teller;
        teller++;
    }

    @Override
    public void run() {
        int antallKaffer = 0;
        try {
            while (bord.hentKaffe() != null) {
                String kaffe = bord.hentKaffe();
                System.out.println("Kaffedrikker med id: " + id + ", drakk en " + kaffe + ".");
                antallKaffer++;
            } 
            System.out.println("Kaffedrikker med id: " + id + ", har drukket " + antallKaffer + ".");
            
            barriere.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}