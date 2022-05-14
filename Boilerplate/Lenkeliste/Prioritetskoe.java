public class Prioritetskoe<T extends Comparable<T>> extends Koe<T> {
    

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
