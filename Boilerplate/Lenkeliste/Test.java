public class Test {
    public static void main(String[] args) {
        IndeksertEnkeltListe<String> liste = new IndeksertEnkeltListe<>();
        String en = "1";
        String to = "2";
        String tre = "3";
        String fire = "4";

        liste.leggTil(0, en);
        liste.leggTil(0, to);
        liste.leggTil(2, tre);

        liste.print();
    }
}
