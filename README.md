Groupe de :
- Mohamed LO
- Alioune Diallo
- Fatoumata Barro
- Amarou Balde
- Ndiaga Gueye
- Youssouf G. Diatta


L’objet de ce problème est l’écriture d’une bibliothèque de fonctions constituant une implantation améliorée des matrices de
nombres flottants, par exemple en double précision. Une matrice codée comme nous le proposons ici est appelée une
supermatrice. Elle est composée de trois éléments :
1° une structure, appelée le descripteur de la supermatrice, faite de trois champs :
- nl, le nombre de lignes de la matrice
- nc, le nombre de colonnes de la matrice
- ligne, l’adresse du tableau décrit ci-dessous
2° un tableau de nl pointeurs, qui sont les adresses des lignes de la matrice. Le premier élément pointe la première ligne, le
second la deuxième, etc.
3° un espace où sont alloués les nl  ́ nc éléments de la matrice (des doubLe), rangés par lignes. Lorsque cela n’entraînera
pas un travail supplémentaire, on fera en sorte que ces lignes occupent un espace contigu, dans lequel elles sont rangées
en accord avec leurs indices, mais cette propriété ne pourra pas être toujours garantie. Bien entendu, les coefficients
d’une même ligne seront rangés de manière contiguë.


Classe utilitaire contenant toutes les méthodes statiques pour manipuler des objets Supermat.
Chaque méthode correspond à une fonction du projet C d'origine.
 
Classe utilitaire contenant des méthodes statiques pour manipuler des matrices Supermat.
Toutes les méthodes sont statiques et ne nécessitent pas d'instanciation de cette classe.
 
