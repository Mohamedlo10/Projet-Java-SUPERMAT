public class SupermatUtils {

    private SupermatUtils() {
        throw new UnsupportedOperationException("Classe utilitaire - ne pas instancier");
    }

    public static Supermat allouerSupermat(int nbLignes, int nbColonnes) {
        if (nbLignes <= 0 || nbColonnes <= 0) return null;
        return new Supermat(nbLignes, nbColonnes);
    }

    public static Supermat produitSupermat(Supermat matriceA, Supermat matriceB) {
        if (matriceA == null || matriceB == null || matriceA.nc != matriceB.nl) return null;
        Supermat resultat = new Supermat(matriceA.nl, matriceB.nc);
        for (int ligne = 0; ligne < matriceA.nl; ligne++) {
            for (int colonne = 0; colonne < matriceB.nc; colonne++) {
                resultat.lignes[ligne][colonne] = 0.0;
                for (int k = 0; k < matriceA.nc; k++) {
                    resultat.lignes[ligne][colonne] += matriceA.lignes[ligne][k] * matriceB.lignes[k][colonne];
                }
            }
        }
        return resultat;
    }

  
    public static void permuterLignes(Supermat matrice, int indiceLigne1, int indiceLigne2) {
        if (matrice == null || indiceLigne1 < 0 || indiceLigne2 < 0 || indiceLigne1 >= matrice.nl || indiceLigne2 >= matrice.nl || indiceLigne1 == indiceLigne2) return;
        double[] temp = matrice.lignes[indiceLigne1];
        matrice.lignes[indiceLigne1] = matrice.lignes[indiceLigne2];
        matrice.lignes[indiceLigne2] = temp;
    }


    public static Supermat sousMatrice(Supermat matriceSource, int premiereLigneIncluse, int derniereLigneIncluse, int premiereColonneIncluse, int derniereColonneIncluse) {
        if (matriceSource == null || premiereLigneIncluse < 0 || derniereLigneIncluse >= matriceSource.nl || premiereLigneIncluse > derniereLigneIncluse || premiereColonneIncluse < 0 || derniereColonneIncluse >= matriceSource.nc || premiereColonneIncluse > derniereColonneIncluse) return null;
        Supermat sousMatrice = new Supermat(derniereLigneIncluse - premiereLigneIncluse + 1, derniereColonneIncluse - premiereColonneIncluse + 1);
        for (int ligne = 0; ligne < sousMatrice.nl; ligne++) {
            for (int colonne = 0; colonne < sousMatrice.nc; colonne++) {
                sousMatrice.lignes[ligne][colonne] = matriceSource.lignes[premiereLigneIncluse + ligne][premiereColonneIncluse + colonne];
            }
        }
        return sousMatrice;
    }


    public static Supermat matSupermat(double[] tableauSource, int nbLignesSource, int nbColonnesSource, int nbLignesSupermat, int nbColonnesSupermat) {
        if (tableauSource == null || nbLignesSource <= 0 || nbColonnesSource <= 0 || nbLignesSupermat <= 0 || nbColonnesSupermat <= 0 || nbLignesSupermat > nbLignesSource || nbColonnesSupermat > nbColonnesSource) return null;
        Supermat supermatrice = new Supermat(nbLignesSupermat, nbColonnesSupermat);
        for (int ligne = 0; ligne < nbLignesSupermat; ligne++) {
            for (int colonne = 0; colonne < nbColonnesSupermat; colonne++) {
                supermatrice.lignes[ligne][colonne] = tableauSource[ligne * nbColonnesSource + colonne];
            }
        }
        return supermatrice;
    }


    public static int supermatMat(Supermat supermatrice, double[] tableauDestination, int nbLignesDestination, int nbColonnesDestination) {
        if (supermatrice == null || tableauDestination == null || nbLignesDestination <= 0 || nbColonnesDestination <= 0 || supermatrice.nl > nbLignesDestination || supermatrice.nc > nbColonnesDestination) return -1;
        for (int ligne = 0; ligne < supermatrice.nl; ligne++) {
            for (int colonne = 0; colonne < supermatrice.nc; colonne++) {
                tableauDestination[ligne * nbColonnesDestination + colonne] = supermatrice.lignes[ligne][colonne];
            }
        }
        return 0;
    }

    public static int analyserContiguite(Supermat matrice) {
        if (matrice == null || matrice.nl <= 1) return 2;
        return 0;
    }

    public static void rendreSupermat(Supermat supermatrice) {
        if (supermatrice != null) {
            supermatrice.lignes = null;
        }
    }
}
