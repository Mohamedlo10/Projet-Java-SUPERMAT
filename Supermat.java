/**
 * Représente une matrice générique (Supermat) avec un nombre de lignes et de colonnes.
 * Les données sont stockées dans un tableau 2D de doubles.
 */
public class Supermat {
    /** Nombre de lignes */
    public int nl;
    /** Nombre de colonnes */
    public int nc;
    /** Données de la matrice */
    public double[][] lignes;

    /**
     * Constructeur de la classe Supermat.
     * @param nl Nombre de lignes
     * @param nc Nombre de colonnes
     */
    public Supermat(int nl, int nc) {
        this.nl = nl;
        this.nc = nc;
        this.lignes = new double[nl][nc];
    }
}
