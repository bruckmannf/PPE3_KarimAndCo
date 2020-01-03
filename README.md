<p align="center">
<img src="https://image.flaticon.com/icons/svg/1412/1412225.svg" width="150">
</p>

<p align="center">
<img src="http://hits.dwyl.io/pawel956/ppe3.svg">
<img src="https://img.shields.io/github/repo-size/pawel956/ppe3">
<img src="https://img.shields.io/badge/project-maven-red">
</p>

###  PPE n°3 Karim & Co - Création et gestion de CV
---

#### Introduction
Dans le cadre des PPE de la deuxième année de BTS SIO Option SLAM, j'ai conçu un logiciel Java permettant de **créer**/**gérer** un ou plusieurs **CV**. La création du logiciel Karim&Co a été facilitée avec l'aide de mes camarades qui ont réalisés par groupe des **composants**/**modules**. Le **but** de ce PPE était de **réunir** tous les composants, faire des **modifications**, et des **ajouts** afin de répondre à un besoin étant ici, faire un logiciel complet de création et de gestion des CV des étudiants.

#### Fonctionnalités
Avec le logiciel Karim & Co, on peut :
- **S'inscrire** :
    - Vérification du format des informations saisies dans les champs,
    - Vérification des différentes informations ( = date de naissance, pays etc...)
    - Enregistrement d'une photo,
    - Saisie des mots de passe avec un clavier et chiffrement de ceux-ci sur la base de données,
- **Se connecter**
- **Modifier les informations du compte de l'utilisateur après l'inscription**
- **Créer et gérer un ou plusieurs CV** :
	- Saisie du titre et description du CV,
	- Saisie d'une ou plusieurs expérience(s) professionnelle(s),
	- Saisie d'une ou plusieurs formation(s),
	- Saisie d'une ou plusieurs information(s) complémentaire(s),
- **Accéder à l'interface d'administration par un compte administrateur** :
	- Création, modification, et suppression des comptes utilisateurs,
	- Importer et exporter les données des utilisateurs en JSON, XML et CSV,
- **Exporter le CV en PDF**

#### Pour utiliser les pleins capacités du logiciel il est conseillé d'avoir une base de données MySQL.

#### Téléchargement du logiciel
- 1ère méthode :  [cliquez-ici](https://github.com/pawel956/ppe3/archive/master.zip)  → aller dans le dossier des téléchargements → extraire le logiciel du fichier .zip
    
- 2ème méthode : ouvrir Netbeans → aller dans l'onglet  `Team`  → puis aller dans  `Git`  → et enfin dans  `Clone`  → mettre ce lien :  [https://github.com/pawel956/ppe3.git]()  dans  `Repository URL`  → et cliquer sur  `Finish`

#### Configuration du logiciel
Pour que le logiciel fonctionne, il faut **éditer** le fichier **src\main\java\com\pradyna\constants\Constants.java.example**, saisir les informations demandées et renommer le fichier en **Constants.java**.

Pour le **PPE3** voici les informations nécessaires : [cliquez-ici](https://docs.google.com/document/d/15ZVClDCdQMAE44xiKp6cXZA4lnkenyuuymlzlG8Hg_Y/edit?usp=sharing).

Si vous n'avez pas accès au document, il faut mettre les informations de votre base de données et pour les autres informations, il faut aller sur les sites de [Google](https://console.developers.google.com/) et de [Facebook](https://developers.facebook.com/). Si vous préférez, vous pouvez **désactiver** la connexion via Google et/ou Facebook, il suffit de mettre false aux propriétés **SIGN_UP_VIA_*_IS_ENABLED**.

⚠ Si vous utiliser votre base de données, n'oubliez pas d'importer le fichier ppe3.sql avec **phpMyAdmin** !

#### Lancement du logiciel
Il suffit de lancer la classe **com.pradyna.main.ppe3** !
