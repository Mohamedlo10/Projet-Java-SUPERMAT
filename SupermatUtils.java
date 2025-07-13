/**
 * Classe utilitaire contenant toutes les méthodes statiques pour manipuler des objets Supermat.
 * Chaque méthode correspond à une fonction du projet C d'origine.
 */
/**
 * Classe utilitaire contenant des méthodes statiques pour manipuler des matrices Supermat.
 * Toutes les méthodes sont statiques et ne nécessitent pas d'instanciation de cette classe.
 */
public class SupermatUtils {
    
    /**
     * Constructeur privé pour empêcher l'instanciation de cette classe utilitaire.
     * Toutes les méthodes sont statiques et doivent être appelées directement sur la classe.
     */
    private SupermatUtils() {
        throw new UnsupportedOperationException("Classe utilitaire - ne pas instancier");
    }

    /**
     * Alloue une nouvelle matrice Supermat de dimensions données.
     * @param nl Nombre de lignes
     * @param nc Nombre de colonnes
     * @return Un nouvel objet Supermat ou null si dimensions invalides
     */
    public static Supermat allouerSupermat(int nl, int nc) {
        if (nl <= 0 || nc <= 0) return null;
        return new Supermat(nl, nc);
    }

    /**
     * Effectue le produit matriciel de deux matrices Supermat.
     * @param a Première matrice (gauche)
     * @param b Deuxième matrice (droite)
     * @return Nouvelle matrice résultat ou null si dimensions incompatibles
     */
    public static Supermat produitSupermat(Supermat a, Supermat b) {
        if (a == null || b == null || a.nc != b.nl) return null;
        Supermat c = new Supermat(a.nl, b.nc);
        for (int i = 0; i < a.nl; i++) {
            for (int j = 0; j < b.nc; j++) {
                c.lignes[i][j] = 0.0;
                for (int k = 0; k < a.nc; k++) {
                    c.lignes[i][j] += a.lignes[i][k] * b.lignes[k][j];
                }
            }
        }
        return c;
    }

    /**
     * Permute deux lignes d'une matrice Supermat.
     * @param a Matrice cible
     * @param i Indice de la première ligne
     * @param j Indice de la seconde ligne
     */
    public static void permuterLignes(Supermat a, int i, int j) {
        if (a == null || i < 0 || j < 0 || i >= a.nl || j >= a.nl || i == j) return;
        double[] temp = a.lignes[i];
        a.lignes[i] = a.lignes[j];
        a.lignes[j] = temp;
    }

    /**
     * Extrait une sous-matrice d'une matrice Supermat.
     * @param a Matrice source
     * @param l1 Première ligne (incluse)
     * @param l2 Dernière ligne (incluse)
     * @param c1 Première colonne (incluse)
     * @param c2 Dernière colonne (incluse)
     * @return Nouvelle Supermat représentant la sous-matrice, ou null si indices invalides
     */
    public static Supermat sousMatrice(Supermat a, int l1, int l2, int c1, int c2) {
        if (a == null || l1 < 0 || l2 >= a.nl || l1 > l2 || c1 < 0 || c2 >= a.nc || c1 > c2) return null;
        Supermat sm = new Supermat(l2 - l1 + 1, c2 - c1 + 1);
        for (int i = 0; i < sm.nl; i++) {
            for (int j = 0; j < sm.nc; j++) {
                sm.lignes[i][j] = a.lignes[l1 + i][c1 + j];
            }
        }
        return sm;
    }

    /**
     * Crée une Supermat à partir d'un tableau 1D de doubles, en extrayant un bloc.
     * @param m Tableau source
     * @param nld Nombre de lignes du tableau source
     * @param ncd Nombre de colonnes du tableau source
     * @param nle Nombre de lignes de la supermatrice
     * @param nce Nombre de colonnes de la supermatrice
     * @return Nouvelle Supermat ou null si paramètres invalides
     */
    public static Supermat matSupermat(double[] m, int nld, int ncd, int nle, int nce) {
        if (m == null || nld <= 0 || ncd <= 0 || nle <= 0 || nce <= 0 || nle > nld || nce > ncd) return null;
        Supermat sm = new Supermat(nle, nce);
        for (int i = 0; i < nle; i++) {
            for (int j = 0; j < nce; j++) {
                sm.lignes[i][j] = m[i * ncd + j];
            }
        }
        return sm;
    }

    /**
     * Copie les données d'une Supermat vers un tableau 1D de doubles.
     * @param sm Supermat source
     * @param m Tableau destination
     * @param nld Nombre de lignes du tableau destination
     * @param ncd Nombre de colonnes du tableau destination
     * @return 0 si succès, -1 sinon
     */
    public static int supermatMat(Supermat sm, double[] m, int nld, int ncd) {
        if (sm == null || m == null || nld <= 0 || ncd <= 0 || sm.nl > nld || sm.nc > ncd) return -1;
        for (int i = 0; i < sm.nl; i++) {
            for (int j = 0; j < sm.nc; j++) {
                m[i * ncd + j] = sm.lignes[i][j];
            }
        }
        return 0;
    }

    /**
     * Analyse la contiguïté mémoire des lignes de la Supermat (utile surtout en C, simulé ici).
     * @param a Supermat à analyser
     * @return 2 si contiguë, 1 si réordonnable, 0 sinon
     */
    public static int analyserContiguite(Supermat a) {
        // En Java, les tableaux sont toujours des objets distincts, donc contiguïté non garantie.
        // On simule le comportement :
        if (a == null || a.nl <= 1) return 2;
        // Si toutes les références de lignes pointent vers des tranches successives du même tableau, on pourrait détecter la contiguïté.
        // Ici, on retourne toujours 0, car Java ne garantit pas la contiguïté mémoire.
        return 0;
    }

    /**
     * "Libère" la Supermat (en Java, on met à null pour aider le GC).
     * @param sm Supermat à rendre
     */
    public static void rendreSupermat(Supermat sm) {
        // En Java, le ramasse-miettes gère la mémoire.
        // On peut mettre les références à null pour aider le GC.
        if (sm != null) {
            sm.lignes = null;
        }
    }
}
