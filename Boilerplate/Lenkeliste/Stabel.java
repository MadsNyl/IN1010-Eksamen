public class Stabel<T> extends Lenkeliste<T> {
    
    // legger til node paa slutten av liste
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

    // fjerner node fra slutten av liste
    @Override
    public void fjern() {
        if (storrelse() == 1) {
            start = null;
            slutt = null;
        } else {
            slutt.forrige.neste = null;
            slutt = slutt.forrige;
        }
    }
}
