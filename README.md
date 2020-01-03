<p align="center">
<img src="https://image.flaticon.com/icons/svg/311/311334.svg" width="150">
</p>

<p align="center">
<img src="http://hits.dwyl.io/pawel956/pawel956/projetKarimAndCo_ConnexionInscription.svg">
<img src="https://img.shields.io/github/contributors/pawel956/projetKarimAndCo_ConnexionInscription">
<img src="https://img.shields.io/github/repo-size/pawel956/projetKarimAndCo_ConnexionInscription">
<img src="https://img.shields.io/badge/project-maven-red">
</p>

###  PPE n°3 Karim & Co : Création et gestion de CV
---

#### INTRODUCTION
Dans le cadre des PPE de la deuxième année de BTS SIO Option SLAM, j'ai conçu un logiciel Java permettant de **créer**/**gérer** un ou plusieurs **CV**. La création du logiciel Karim&Co a été facilitée avec l'aide de mes camarades qui ont réalisés par groupe des **composants**/**modules**. Le **but** de ce PPE était de **réunir** tous les composants, faire des **modifications**, et des **ajouts** afin de répondre à un besoin étant ici, faire un logiciel complet de création et de gestion des CV des étudiants.

#### FONCTIONNALITES
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

#### DEPENDANCE
Pour ce qui concerne les dépendance voir le fichier `pom.xml`

<p align="center">

[![Generic badge](https://img.shields.io/badge/weblaf-v1.2.9-success)](https://github.com/mgarin/weblaf) 

[<img src="https://img.shields.io/badge/commons--net-3.6-success">](http://mirrors.ircam.fr/pub/apache//commons/net/binaries/commons-net-3.6-bin.zip)  

[<img src="https://img.shields.io/badge/mysql--connector--java-5.1.48-success">](https://repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.48/mysql-connector-java-5.1.48.jar)

[<img src="https://img.shields.io/badge/acrobat-1.1-success">](http://central.maven.org/maven2/com/adobe/acrobat/acrobat/1.1/)

[<img src="https://img.shields.io/badge/itextpdf-5.5.13.1-success">](https://mvnrepository.com/artifact/com.itextpdf/itextpdf/5.5.13.1)

</p>

#### DOCUMENTATION
- Le diagramme de classe : [ici](https://docs.google.com/document/d/1oIMxQ898wdkRi-pWkqLaBM4AR4ZLcovMUhIvGPGQCIc/edit?usp=sharing).
- la documentation utilisateur : [ici](https://docs.google.com/document/d/1oIMxQ898wdkRi-pWkqLaBM4AR4ZLcovMUhIvGPGQCIc/edit?usp=sharing).

#### TELECHARGEMENT DU LOGICIEL
- 1ère méthode :  [cliquez-ici](https://github.com/Geleetz/PPE3_KarimAndCo/archive/master.zip)  → aller dans le dossier des téléchargements → extraire le logiciel du fichier .zip
    
- 2ème méthode : ouvrir Netbeans → aller dans l'onglet  `Team`  → puis aller dans  `Git`  → et enfin dans  `Clone`  → mettre ce lien :  [https://github.com/Geleetz/PPE3_KarimAndCo.git]()  dans  `Repository URL`  → et cliquer sur  `Finish`.

#### INFORMATIONS IMPORTANTES
- ⚠ Pour utiliser les pleines capacités du logiciel, il est conseillé d'avoir une base de données **MySQL**.
- ⚠ Si vous utiliser votre base de données, n'oubliez pas d'importer le fichier PPE3_KarimAndCo.sql avec la plateforme **phpMyAdmin** !
- ⚠ N'oubliez pas de télécharger les dépendances pour le bon fonctionnement du logiciel !

#### CREDIT
BTS SIO option SLAM, lycée Jean Lurçat Perpignan
