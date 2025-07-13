public class Main {
    private Main() {
        throw new UnsupportedOperationException("Classe d'exemple - ne pas instancier");
    }

    public static void main(String[] args) {
        // Création d'une matrice 3x3
        Supermat matA = SupermatUtils.allouerSupermat(3, 3);
        double val = 1.0;
        for (int i = 0; i < matA.nl; i++) {
            for (int j = 0; j < matA.nc; j++) {
                matA.lignes[i][j] = val++;
            }
        }

        // Création d'une autre matrice 3x2
        Supermat matB = SupermatUtils.allouerSupermat(3, 2);
        val = 1.0;
        for (int i = 0; i < matB.nl; i++) {
            for (int j = 0; j < matB.nc; j++) {
                matB.lignes[i][j] = val++;
            }
        }

        // Affichage des matrices
        System.out.println("Matrice A :");
        printSupermat(matA);
        System.out.println("Matrice B :");
        printSupermat(matB);

        // Produit matriciel
        Supermat produit = SupermatUtils.produitSupermat(matA, matB);
        System.out.println("Produit A x B :");
        printSupermat(produit);

        // Permutation de deux lignes
        SupermatUtils.permuterLignes(matA, 0, 2);
        System.out.println("A après permutation des lignes 0 et 2 :");
        printSupermat(matA);

        // Extraction d'une sous-matrice
        Supermat sous = SupermatUtils.sousMatrice(matA, 0, 1, 0, 1);
        System.out.println("Sous-matrice de A (lignes 0-1, colonnes 0-1) :");
        printSupermat(sous);

        // Conversion Supermat -> tableau 1D
        double[] tableau = new double[matA.nl * matA.nc];
        int res = SupermatUtils.supermatMat(matA, tableau, matA.nl, matA.nc);
        System.out.println("Tableau 1D obtenu à partir de A :");
        for (double d : tableau) System.out.print(d + " ");
        System.out.println();
        System.out.println("Résultat de supermatMat : " + res);

        // Création d'une Supermat à partir d'un tableau 1D
        Supermat fromTab = SupermatUtils.matSupermat(tableau, matA.nl, matA.nc, matA.nl, matA.nc);
        System.out.println("Supermat créée à partir du tableau 1D :");
        printSupermat(fromTab);

        // Analyse de la contiguïté (toujours 0 en Java)
        System.out.println("Analyse contiguïté de matA : " + SupermatUtils.analyserContiguite(matA));

        // Libération (mise à null)
        SupermatUtils.rendreSupermat(matA);
        SupermatUtils.rendreSupermat(matB);
        SupermatUtils.rendreSupermat(produit);
        SupermatUtils.rendreSupermat(sous);
        SupermatUtils.rendreSupermat(fromTab);
    }

    public static void printSupermat(Supermat m) {
        if (m == null) {
            System.out.println("(null)");
            return;
        }
        for (int i = 0; i < m.nl; i++) {
            for (int j = 0; j < m.nc; j++) {
                System.out.print(m.lignes[i][j] + " ");
            }
            System.out.println();
        }
    }
}
