# Breizh vidéo - Backend

## Mise en place

### Création du projet sur Spring boot Initializer  
Dépendances utilisées:

* Web
* Jpa
* H2 & MySQL
* Lombok

### Mise en place de la table/requêtes

* Plutôt que d'importer toute la BDD du brief, 
j'ai préferé commencer avec la seule table "Village"
histoire de mettre en place l'entité, le lien avec la BDD, 
les requêtes CRUD basiques, les premiers liens avec le front etc.  
  

* Ensuite, mise en place de "Show", avec la relation OtM/MtO.  


* Dans un soucis de praticité, j'utilise d'abord H2 comme GBDD et passerai peut-être plus tard sur MySQL (et vu les problêmes rencontrés par les collègues je vais la jouer safe pour l'instant).


### Ce qui ne sera surement pas fait par manque de temps 

* Implémentation de la couche metier avec les services
* Mise en place de toute la BDD avec toutes les relations,
      toutes les requêtes CRUD etc.   

### Ce qui ne sera surement pas fait par manque de formation

* Sécurité
* Tests

### Requêtes de test CRUD Postman:

GET:
```
* localhost:8080/Village //(liste villages)
* localhost:8080/Village/{id} //(un village)
* localhost:8080/Show/
* localhost:8080/Show/{id}
```  
  
POST (PUT idem avec l'Id en plus dans le JSON):
* localhost:8080/Village

```
{  
"name": "Bled",  
"postCode": 65897  
}
```  
* localhost:8080/Show

```  
{
    "releaseDate": "test"
}
```
* localhost:8080/Show/{id} (avec l'Id d'un village, ajoute la FK de l'Id village associé)
```
{
    "releaseDate": "8 aout 2020"
}
```

DELETE:  
```
localhost:8080/Village/{id}
localhost:8080/Show/{id}
```

