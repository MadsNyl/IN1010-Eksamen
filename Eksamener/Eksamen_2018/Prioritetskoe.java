public class Prioritetskoe<T> {
    class Node{
        public Node neste = null;
        T data;
        int prio;
        public Node(T data, int prio) {
            this.data = data;
            this.prio = prio;
        }
    }

    private Node start = null;
    private int storrelse = 0;

    public void settInn(T inn, int prio) {
        Node ny = new Node(inn);

        if (antall() == 0) {
            start = ny;
            storrelse++;
            return;
        }

        Node node = start;
        for (int i = 0; i < antall(); i++) {
            if (node.prio > prio) {
                ny.neste = node;
                node = ny;
                storrelse++;
                return;
            }
            node = node.neste;
        }

        node.neste = ny;
        storrelse++;
    }

    public T taUt() {
        Node node = start;
        if (antall() == 1) {
            start = null;
            return start;
        }
        start = start.neste;
        return node;
    }

    public int antall() {
        return storrelse;
    }
}
