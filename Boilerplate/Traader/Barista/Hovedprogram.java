import java.util.concurrent.CountDownLatch;

public class Hovedprogram {
    public static void main(String[] args) {
        final int BARISTAER = 2;
        final int KAFFEDRIKKERE = 10;
        CountDownLatch baristaBarriere = new CountDownLatch(BARISTAER);
        CountDownLatch kaffedrikkerBarriere = new CountDownLatch(KAFFEDRIKKERE);
        Bord bord = new Bord();

        for (int i = 0; i < BARISTAER; i++) {
            Runnable baristaTraad = new Barista(bord, baristaBarriere);
            Thread traad = new Thread(baristaTraad);
            traad.start();
        }

        for (int i = 0; i < KAFFEDRIKKERE; i++) {
            Runnable kaffedrikkerTraad = new Kaffedrikker(bord, kaffedrikkerBarriere);
            Thread traad = new Thread(kaffedrikkerTraad);
            traad.start();
        }

        try {
            baristaBarriere.await();
            kaffedrikkerBarriere.await();
        } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
