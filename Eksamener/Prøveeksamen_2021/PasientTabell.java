public class PasientTabell extends PasientAdm {
    private Pasient[] tabell;
    private int sisteInnlagte;

    public PasientTabell(int lengde) {
        tabell = new Pasient[lengde];
    }

    @Override
    public void settInnPasient(Pasient p) {
        boolean erTom = false;
        for (int i = 0; i < tabell.length; i++) {
            if (tabell[i] == null) erTom = true;
        }

        if (erTom) {
            tabell[0] = p;
            sisteInnlagte = 0;
        } else {
            for (int i = sisteInnlagte; i < tabell.length; i++) {
                if (tabell[i] != null) {
                    sisteInnlagte = i;
                    tabell[i] = p;
                }
            }
        }
    }

    @Override
    public Pasient hentUt(int i) {
        Pasient hentet = tabell[i];

        for (int i = 0; i < tabell.length; i++) {
            if (tabell[i].prioritet.equals(hentet.prioritet)) {
                tabell[i].sengNr = -1;
                hentet = tabell[i];
                tabell[i] = null;
                return hentet;
            }
        }

        return null;
    }

    @Override
    public Pasient hentUt(Pasient p) {
        int sengenummer = p.sengNr;

        if (sengenummer < tabell.length) {
            Pasient hentet = tabell[sengenummer];
            hentet.sengNr = -1;
            tabell[sengenummer] = null;
            return hentet;
        }

        return null;
    }
}
