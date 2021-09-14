# Mandelbrot

## Description du projet 

On va travailler sur ce TP sur l'affichage de l'[ensemble de Mandelbrot](https://en.wikipedia.org/wiki/Mandelbrot_set). Pour cela, on va utiliser un programme pré-existant. 
Le but du TP sera de corriger la classe `Complex` en s'aidant de tests unitaires.

## Configuration du projet

Le projet utilise JUnit et JavaFX. Si vous êtes sur votre ordinateur personnel, il vous faut commencer par installer JavaFX (si vous ne l'avez pas déjà). Pour cela, suivre la documentation disponible sur Ametice.

Vérifiez que le répertoire src apparaît en bleu dans l'onglet Project d'IntelliJ, et le répertoire test en vert. Si ce n'est pas le cas, clic droit sur le répertoire, `mark directory as`, puis choisir `Sources Root` et `Test Sources Root` respectivement.

Dans le fichier "test/mandelbrot/ComplexTest.java", choisissez dans un menu de correction d'une des erreurs d'import l'option `Add JUnit 5.4 to classpath`. Cela devrait corriger toutes les erreurs du fichier.

Dans l'onglet Project, clic droit sur le fichier "test/mandelbrot/ComplexTest.java", choisissez l'option `Create ComplexTest...`. Fermez la boite de configuration du test (il est déjà correctement configuré).

Dans l'onglet Project, clic droit sur le fichier "src/viewer/Main.java", choisissez l'option "Create Main.main()". Cela ouvre la fenêtre de configuration pour l'exécution du programme. Dans la case VM options, permettant de paramétrer l'exécution de la machine virtuelle Java faisant tourner votre programme, ajoutez les informations suivantes :

`--module-path ***CHEMIN VERS OPENJFX*** --add-modules javafx.controls,javafx.fxml`

en remplaçant `***...***` par le chemin du répertoire d'installation de javaFX, le répertoire contenant les fichiers d'extensions `.jar`. Sur les ordinateurs de l'université, il devrait être dans `/usr/lib/openJFX` ou `/usr/share/openJFX` ou un autre (mais dans `/usr/` certainement).

Vous avez maintenant les deux configurations pour lancer le programme, soit les tests, soit le main, dans la barre de lancement en haut à droite de l'IDE. Vous pouvez commencer le TP.



## Membres du projet

- NOM, prénom, numéro de groupe, du premier participant
- NOM, prénom, numéro de groupe, du deuxième participant
