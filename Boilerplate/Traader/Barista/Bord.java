import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bord {
    private ArrayList<String> kaffer = new ArrayList<>();
    private boolean erTomt = false;
    private Lock laas = new ReentrantLock(true);
    private Condition ikkeKaffeKlar = laas.newCondition();


    public void singaliserTomt() { erTomt = true; }

    public void serverKaffe(String kaffe) {
        laas.lock();
        try {
            kaffer.add(kaffe);
            if (kaffer.size() > 0) ikkeKaffeKlar.signal();
        } finally {
            laas.unlock();
        }
    }

    public String hentKaffe() throws InterruptedException {
        laas.lock();
        try {
            if (erTomt) return null;
            while (kaffer.size() < 1) ikkeKaffeKlar.await();
            String kaffe = kaffer.get(0);
            kaffer.remove(0);
            return kaffe;
        } finally {
            laas.unlock();
        }
    }
}
