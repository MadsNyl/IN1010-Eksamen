public class Koe<T> extends Lenkeliste<T> {
    
    // fjerner forste element i listen
    @Override
    public void fjern() {
        // storrelse paa listen er 1
        if (storrelse() == 1) {
            start = null;
            slutt = null;
        } else {
            start.neste.forrige = null;
            start = start.neste;
        }
    }

    // legger til element i slutten av liste
    @Override
    public void leggTil(T data) {
        Node ny = new Node(data);

        // hvis listen er tom
        if (start == null) {
            start = ny;
            slutt = ny;
        } else {
            slutt.neste = ny;
            ny.forrige = slutt;
            slutt = ny;
        }
    }
}
