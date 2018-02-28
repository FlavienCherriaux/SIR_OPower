# SIR_OPower

## Avant de commencer
Téléchargez ou clonez le projet, puis importez le dans l'IDE de votre choix en tant que projet Maven. Lancez ensuite la classe src/main/java/main/JpaTest pour peupler la base de données. Créez ensuite une configuration pour pouvoir lancer le serveur. Sous Eclipse :
- clic droit sur le projet -> Run as -> Maven build...
- dans Goals, tapez tomcat7:run
- lancez le projet

Une fois la configuration créée, lancez le projet en sélectionnant Run as -> Maven build

## Utilisation de l'API
L'URL de base pour utiliser l'API est la suivante : ``` http://localhost:8181/opower/api ```

### Méthodes
``` /home ``` (GET) : retourne la liste des maisons au format JSON
``` /home/:id ``` (GET) : retourne la maison possédant l'identifiant :id au format JSON
``` /home ``` (POST) : ajoute une maison. Nécessite 3 paramètres : taille (taille de la maison), nbChambres (nombre de chambres), idPerson (identifiant de la personne possédant la maison)
``` /home/:id ``` (DELETE) : supprime la maison possédant l'identifiant :id
``` /person ``` (GET) : retourne la liste des personnes au format JSON
``` /person/:id ``` (GET) : retourne la personne possédant l'identifiant :id au format JSON
``` /person ``` (POST) : ajoute une maison. Nécessite 3 paramètres : nom (nom de la personne), prenom (prénom de la personne), mail (mail de la personne)
``` /person/:id ``` (DELETE) : supprime la personne possédant l'identifiant :id
``` /device ``` (GET) : retourne la liste des appareils au format JSON
``` /device/:id ``` (GET) : retourne l'appareil possédant l'identifiant :id au format JSON
``` /device/electronic ``` (POST) : ajoute un appareil électronique. Nécessite 2 paramètres : conso (consommation de l'appareil), idHome (identifiant de la maison auquel l'appareil appartient)
``` /device/heater ``` (POST) : ajoute un chauffage. Nécessite 2 paramètres : power (puissance du chauffage), idHome (identifiant de la maison auquel l'appareil appartient)
``` /device/:id ``` (DELETE) : supprime l'appareil possédant l'identifiant :id

## Auteurs
CHERRIAUX Flavien & LE QUAY Caroline, groupe 1A