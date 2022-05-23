abstract class Avdeling {
    protected PasientAdm register;

    public void settInn(Pasient p) {
        register.settInnPasient(p);
    }

    public Pasient hentUt(Pasient p) {
        return register.hentUt(p);
    }

    public Pasient hentUt(int i) {
        return register.hentUt(i);
    }
}
