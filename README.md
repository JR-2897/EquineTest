# EquineTest
Projet final cours metho test et tests unitaires

Pierre VILLIERS et Jean RAGUENEAU

## Description du Projet
Application de gestion d'un hippodrome en console.

Possibilités :
  - Voir toutes les courses et tous les chevaux
  - Voir les chevaux dans une course
  - Ajouter des courses et des chevaux
  - Ajouter des chevaux à une course
  - Voir les informations d'une course et d'un cheval
  - Lancer une course et connaître le vainqueur
  - Afficher le résultat des 10 derniéres courses

## Stratégie de Tests

Nous avons commencer par écrire les signatures de nos méthodes et mettre dedans notre type de retour true ou false.
Par la suite nous avons voulu définir les tests pour ces différentes méthodes. 
Ensuite après s'être assurée que les tests échouées nous avons commencé le développement des méthodes.
Pour cela nous sommes parti des DAO vers les controllers.

## Régles définies

1) Une course ne pas être lancé tant qu'elle ne posséde pas 6 chevaux
2) Une course ne pas acceuillir plus de 6 chevaux
3) Une course ne pas supprimé si elle a été lancé
4) Une course peut être supprimé même si elle posséde un ou plusieurs chevaux
5) Deux courses ne peuvent pas avoir le même nom
6) Une course ne peut pas être créer sans nom (null ou vide)
7) Une course ne pas être lancé si elle n'existe pas
8) Une course ne peux pas être relancé
9) Il est impossible d'afficher les informations d'une course inexistante
10) Un cheval ne peut pas être ajouté à une course s'il n'existe pas
11) Un cheval ne pas être supprimé d'une course si elle a été lancé
12) Un cheval ne pas être supprimé s'il participe à une course
13) Deux chevaux ne peuvent pas avoir le même nom
14) Un cheval ne peut pas être créer sans nom (null ou vide)
15) Un cheval ne peut pas être créer sans âge (négatif ou égale à 0)
16) Il est impossible d'afficher les informations d'un cheval inexistant
