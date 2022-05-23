public class PasientPrio extends PasientAdm {
    private Pasient[] start = new Pasient[MAXPASPRIO + 1];
    private Pasient[] slutt = new Pasient[MAXPASPRIO + 1];

    @Override
    public void settInnPasient(Pasient p) {
        int i = p.prioritet;

        if (start[i] == null) {
            start[i] = p;
        } else {
            slutt[i].neste = p;
        }

        slutt[i] = p;
        p.neste = null;
    }

    @Override
    public Pasient hentUt(int i) {
        if (start[i] != null && slutt[i] != null) {
            if (start[i].neste == null) {
                start[i] = null;
                slutt[i] = null;
                return start[i];
            } else {
                Pasient peker = start[i];
                while(peker.neste != null) {
                    if (peker.neste.equlas(slutt[i])) {
                        peker.neste == null;
                    }
                    peker = peker.neste;
                }
                slutt[i] = null;
                return slutt[i];
            }
        }

        return null;
    }

    @Override
    public Pasient hentUt(Pasient p) {
        int i = p.prioritet;

        if (start[i] != null && slutt[i] != null) {
            if (start[i].neste == null) {
                start[i] = null;
                slutt[i] = null;
                return start[i];
            } else {
                Pasient peker = start[i];
                while(peker.neste != null) {
                    if (peker.neste.equlas(slutt[i])) {
                        peker.neste == null;
                    }
                    peker = peker.neste;
                }
                slutt[i] = null;
                return slutt[i];
            }
        }

        return null;
    }
}
