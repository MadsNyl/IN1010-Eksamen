import java.util.Iterator;

abstract class EnkeltlenketLenkeliste<T> implements Iterable<T>{
    
    class Node {
        Node neste;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    class MinIterator implements Iterator<T> {
        Node denne = start;

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            Node tmp = denne;
            denne = denne.neste;
            return tmp.data;
        }
    }

    protected Node start = null;
    protected int storrelse = 0;

    public Iterator<T> iterator() {
        return new MinIterator();
    }

    public int storrelse() {
        return storrelse;
    }

    public T hent(int pos) throws UgyldigListeIndeks {
        Node node = start;
        if (pos < 0 || pos > storrelse() - 1) throw new UgyldigListeIndeks(pos);

        if (pos == 0) {
            return node.data;
        }

        for (int i = 0; i < pos; i++) {
            node = node.neste;
        }

        return node.data;
    }

    // setter inn forst i listen
    public void leggTil(T data) {
        Node ny = new Node(data);
        Node node = start;

        if (storrelse() == 0) {
            start = ny;
            storrelse++;
            return;
        }

        for (int i = 0; i < storrelse(); i++) {
            node = node.neste;
        }

        node.neste = ny;
        storrelse++;
    }

    // fjerner siste i listen
    public void fjern() {
        Node node = start;
        Node forrige = null;
        if (storrelse() == 1) {
            start = null;
            storrelse--;
            return;
        }
        
        int teller = 0;
        while (node != null) {
            if (teller == storrelse() - 1) {
                forrige.neste = node.neste;
                storrelse--;
                return;
            }
            teller++;
            forrige = node;
            node = node.neste;
        }
    }
}

class EnkeltlenketStabel<T> extends EnkeltlenketLenkeliste<T> {
    // setter inn sist i listen
    @Override
    public void leggTil(T data) {
        Node node = start;
        Node ny = new Node(data);

        if (storrelse() == 0) {
            start = ny;
            storrelse++;
            return;
        } 

        while (node.neste != null) {
            node = node.neste;
        }

        node.neste = ny;

        storrelse++;
    }  
}

class EnkeltlenketPrioritetskoe<T extends Comparable<T>> extends EnkeltlenketLenkeliste<T> {
    // legger til i sortert rekkefølge
    @Override
    public void leggTil(T data) {
        Node node = start;
        Node ny = new Node(data);

        if (node == null) {
            start = ny;
            return;
        }

        if (ny.data.compareTo(start.data) < 0) {
            ny.neste = node;
            start = ny;
            return;
        }

        while (node.neste != null) {
            if (ny.data.compareTo(start.data) < 0) {
                ny.neste = node.neste;
                node.neste = ny;
                return;
            }
            node = node.neste;
        }
        node.neste = ny;

    }
} 
