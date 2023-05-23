import java.util.Iterator;

// lenkeliste klasse
abstract class SamletLenkeliste<T> implements Lenke<T>, Iterable<T> {
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

    // setter opp data for lenkeliste
    protected Node start = null;
    protected Node slutt = null;

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

    // alternativ klasse for iterator
    class AlternativIterator implements Iterator<T> {
        Node denne = start;

        @Override
        public boolean hasNext() {
            return denne != start;
        }

        @Override 
        public T next() {
            Node tmp = denne;
            denne = denne.neste;
            return tmp.data;
        }
    }

    // LenkelisteIterator
    @Override
    public Iterator<T> iterator() {
        return new LenkelisteIterator();
    }

    // returnerer storrelse
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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

// koe klasse
class Koe<T> extends SamletLenkeliste<T> {

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

class Stabel<T> extends SamletLenkeliste<T> {

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

class Prioritetskoe<T extends Comparable<T>> extends Koe<T> {
    // oversskrider leggTil metode for aa sortere liste
    @Override
    public void leggTil(T data) {
        // hvis listen er tom, så legges det til paa en vanlig maate
        if (storrelse() == 0) {
            super.leggTil(data);
            return;
        }

        Node node = start;
        // itererer gjennom alle noder og ser om den nye noden har lavere verdi
        // enn resten av nodene i listen. Hvis den har lavere verdi settes den
        // inn i en sortert rekkefolge
        for (int i = 0; i < storrelse(); i++) {
            if (i != 0) node = node.neste;

            if (node.data.compareTo(data) > 0) {
                super.sett(i, data);
                return;
            }
        }

        // hvis ingen av disse kriteriene er oppfylt, saa legges den til
        // normalt. 
        super.leggTil(data);
    }
}