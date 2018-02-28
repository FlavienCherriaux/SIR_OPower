# SIR_Opower - Design

## Technologies utilisées

* Servlet
* JPA
* Jersey / REST
* JAX-RS

## Architecture

* Les ressources statiques du projet se trouvent dans le dossier ```src/main/webapp```.

## JPA

Cela fait un lien avec la base de données MySQL.

## Problèmes rencontrés et solutions

* Ne pas avoir la base qui se vide et recrée à chaque fois
*	* Ouvrir le fichier persistence.xml
*	* Mettre la valeur hibernate.hbm2ddl.auto à ```update```

## Jersey / REST

L'api REST permet de créer un backend sous forme de routes tout en gérant les différents verbes HTTP (GET, POST, UPDATE, DELETE).

L'annotation @Produces(```type```) permet de définir le type de flux renvoyé par la page atteinte dans l'architecture.

## Servlet

Les Servlet sont des classes JAVA permettant de générer des pages web grâce à du code HTML (ressources statiques) et du code JAVA.

Les Servlet ont plusieurs annotations comme @WebServlet(name="nom", urlPatterns={"/url"}) permettant de spécifier par exemple la route jusqu'à la page.

De plus, les Servlet ont des méthodes permettant de gérer les verbes HTTP.

* GET
*	* doGet(...)
* POST
*	* doPost(...)

## JAX-RS

JAX-RS est une API permettant de faire des annotations pour injecte rou récupérer des données.

Cette API utilise des annotations comme : 
* @Produces(```type```)
*	* type étant par exemple MediaType.APPLICATION_JSON
* @Path("/route")
*	* route signifie la route qu'il y aura lorsqu'on voudra taper sur l'API
* @FormParam("x")
*	* x est le "name" du champ du formulaire envoyé à l'API par un verbe HTTP
* Verbes HTTP
*	* Get
*	*	* Utilisation de @Get
*	* Post
*	*	* Utilisation de @Post
*	* Update
*	*	* Utilisation de @Update
*	* Delete
*	*	* Utilisation de @Delete

Pour ce projet, nous avons décidé d'utiliser JAX-RS.