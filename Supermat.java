public class Supermat {
    public int nl;
    public int nc;
    public double[][] lignes;

    public Supermat(){}

    public Supermat(int nl, int nc) {
        this.nl = nl;
        this.nc = nc;
        this.lignes = new double[nl][nc];
    }
}
