public class IndeksertEnkeltListe<T> {
    class Node {
        Node neste;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node start = null;
    private int storrelse = 0;

    // legger til paa gitt posisjon
    public void leggTil(int pos, T data) {
        Node node = start;
        Node ny = new Node(data);

        if (storrelse == 0) {
            start = ny;
            storrelse++;
            return;
        }

        if (pos < 0 || pos > storrelse) return;


        if (pos == 0) {
            ny.neste = start;
            start = ny;
            storrelse++;
            return;
        }

        for (int i = 0; i < pos; i++) {
            node = node.neste;
        }

        System.out.println("node " + node.data);
        ny.neste = node;
        node = ny;
        storrelse++;
    }

    // fjerner paa gitt posisjon
    public void fjern(int pos) {
        int teller = 0;
        if (pos == 0){
            start = start.neste;
            storrelse--;
            return;
        }
        Node node = start;
        Node forrige = null;
        while (node != null){
            if (teller == pos){
                forrige.neste = node.neste;
                storrelse--;
                return;
            }
            teller++;
            forrige = node;
            node = node.neste;
            storrelse--;
        }
    }

    public void print(){
        Node node = start;
        for (int i = 0; i < storrelse; i++) {
            System.out.println(node.data);
            node = node.neste;
        }
    }
}
