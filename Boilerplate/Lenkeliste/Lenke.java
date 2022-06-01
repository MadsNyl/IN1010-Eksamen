interface Lenke<T> {
    public int storrelse();
    public T hent(int pos);
    public void fjern(int pos);
    public void sett(int pos, T data);
    public void bytt(int pos, T data);
}
