import java.util.Iterator;

abstract class Lenkeliste<T> implements Iterable<T> {

    // klasse for node. Lenkeliste bestaar av noder
    class Node {
        public Node forrige = null;
        public Node neste = null;
        protected T data;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() { return data.toString(); }
    }

    // klasse for iterator slik at man kan bruke for-each lokke
    class LenkelisteIterator implements Iterator<T> {
        private int  pos = 0;

        @Override
        public T next() {
            pos++;
            return hent(pos - 1);
        }

        @Override
        public boolean hasNext() { return pos < storrelse(); }
    }

    // setter opp data for lenkeliste
    protected Node start = null;
    protected Node slutt = null;

    // overkjører iterator metode for å returnere et objekt av
    // LenkelisteIterator
    @Override
    public Iterator<T> iterator() {
        return new LenkelisteIterator();
    }

    // returnerer storrelse
    public int storrelse() {
        Node node = start;
        int teller = 0;
        // hvis storrelse er null
        if (node == null) return teller;
        if (node.neste == null) return 1;

        teller++;
        while (node.neste != null) {
            teller++;
            node = node.neste;
        }

        return teller;
    }

    // henter node i gitt posisjon
    public T hent(int pos) throws UgyldigListeIndeks {
        Node node = start;

        // sjekker om indeks er i liste
        if (pos < 0 || pos > storrelse() - 1) throw new UgyldigListeIndeks(pos);

        // hvis pos er forst i liste
        if (pos == 0) return node.data;

        // itererer gjennom liste for aa finne riktig posisjon
        for (int i = 0; i < pos; i++) node = node.neste;

        return node.data;
    }

    // fjerner node i gitt posisjon
    public void fjern(int pos) {
        Node node = start;

        // sjekker om indeks er i liste
        if (pos < 0 || pos > storrelse() - 1) throw new UgyldigListeIndeks(pos);

        // hvis storrelse er 1
        if (storrelse() == 1) {
            start = null;
            slutt = null;
        } else if (pos == 0) {
            // hvis pos er i starten av listen
            start.neste.forrige = null;
            start = start.neste;
        }
        else if (pos == storrelse() - 1) {
            // hvis pos er i slutten av listen
            slutt.forrige.neste = null;
            slutt = null;
        } else {
            for (int i = 0; i < pos; i++) {
                node = node.neste;
            }
            node.forrige.neste = node.neste;
            node.neste.forrige = node.forrige;
            node = null;
        }
    }

    // setter inn node i gitt posisjon
    public void sett(int pos, T data) {
        Node ny = new Node(data);
        Node node = start;

        // hvis liste er tom
        if (storrelse() == 0) {
            leggTil(data);
            return;
        }

        // sjekker om indeks er i liste
        if (pos < 0 || pos > storrelse() - 1) throw new UgyldigListeIndeks(pos);

        // hvis pos er 0
        if (pos == 0) {
            start.forrige = ny;
            ny.neste = start;
            start = ny;
        } else {
            for (int i = 0; i < pos; i++) {
                node = node.neste;
            }
            node.forrige.neste = ny;
            ny.forrige = node.forrige;
            node.forrige = ny;
            ny.neste = node;
            node = ny;
        }
    }

    // bytter node i gitt posisjon
    public void bytt(int pos, T data) {
        Node node = start;
        Node ny = new Node(data);

        // hvis listen er tom
        if (storrelse() == 0) { 
            leggTil(data);
            return;
        }

        // sjekker om indeks er i liste
        if (pos < 0 || pos > storrelse() - 1) throw new UgyldigListeIndeks(pos);

        // hvis pos er i starten av liste
        if (pos == 0) {
            start.neste.forrige = ny;
            ny.neste = start.neste;
            start = ny;
        } 
        else if (pos == storrelse() - 1) {
            // hvis pos er i slutten av liste
            slutt.forrige.neste = ny;
            ny.forrige = slutt.forrige;
            slutt = ny;
        } else {
            for (int i = 0; i < pos; i++) {
                node = node.neste;
            }
            node.forrige.neste = ny;
            node.neste.forrige = ny;
            ny.neste = node.neste;
            ny.forrige = node.forrige;
            node = ny;
        }

    }

    // legger til node
    abstract void leggTil(T data);

    // fjerner node
    abstract void fjern();
}