# Plateforme de test



## Introduction
IBM Test Platform Cloud est un asset IBM Interactive fournissant une plateforme de test portable pour orchestrer et éxecuter des tests avec Selenium dans Kubernetes.

IBM Test Platform Cloud est composé de ces éléments :

-   **[Selenium Grid](https://www.selenium.dev/documentation/en/grid/)** permet d'exécuter des tests sur plusieurs navigateurs conteneurisés à partir d'un point central, avec une vaste combinaison de navigateur.

-   **[Jenkins](https://www.jenkins.io)** est un outil CI/CD avec lequel on peut créer nos pipelines qui seront charger d'exectuer et récupérer nos codes sources.

- **[SquashTM](https://www.squashtest.com/product-squash-tm)** est un outil de test management qui va lancer l'execution des tests sur jenkins.
 

---


## 1) Près-requis a avoir
Tout d'abord il faut consacrer un environment cloud de travail a la plateforme.Le point fort de cette plateforme c'est qu'elle est fonctionnelle sur tous les cloud disponibles.

- Installation de chocolatey sur Windows pour faciliter l'installation de tous les libraries necessaires:
``` 
1) On demarre notre terminal en mode administrateur 
2) On copie la commande suivante 
 > Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
3) On colle cette commande dans le terminal windows 
4) on appuie sur entrer pour demarrer l'installation
```
-  Installation des libraries sur Windows avec chocolatey : 
  - Installation de JDK:
  ```
  1) Se rendre sur le site (https://www.oracle.com/java/technologies/downloads/#java18) pour démarrer l'installation 
  2) Ensuite on doit configurer la variable d'environment, pour cela naviguer vers le site https://phoenixnap.com/kb/install-java-windows
  ```
  - Installation de docker pour manipuler les contneurs:
  ```
  Se rendre sur le site (https://docs.docker.com/desktop/windows/install/) pour démarrer l'installation 
  ```
  - Installation de kubectl pour manipuler kubernetes:
    ```
    1) Ouvrir le terminal windows
    2) coller la commande suivante *>choco install kubernetes-cli*
    3) verifier si kubectl est bien installer avec la commande *>kubectl version --client*
    ```
  - Installation de git : 
    ```
    1) Naviguer vers le site (https://gitforwindows.org/)
    2) Telecharger git sur votre poste
    ```
-  Clonez le repertoire de travail sur git :
  ```
  1) Ouvrir git Bash
  2) se placer dans le dossier ou le clonage aura lieu
  3) coller la commande suivante > git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY
  4) Appuyer sur entrer
  ```   
        
## 2) Etape 2: Configuration de Kubernetes
-   On doit commencer par configurer les services des differents deployments pour les assoicer a notre environment cloud.Ce qui est important c'est de modifer les Ingress de tous les fichiers.On doit rajouter la nouvelle addresse de notre cloud.
-   verification de la memoire alouer au different pods.
## 3) Etape 3: Démarrer Jenkins
-   On va commencez par démarrer jenkins sur le local pour vérifier que le contneur fonctionne bien:
   ```
  1) On doit télécharger jenkins.war du site (https://www.jenkins.io/download/)
  2) Ensuite, dans notre terminal on se place dans le dossier où se trouve jenkins.war
  3) On execute la commande *>java -jar jenkins.war --httpPort=8080*
  4) naviguer vers localhost:8080 sur votre navigateur
   ```
 -   On lance Jenkins dans notre environment cloud:  
  ```
  1) Ouvrir le terminal Windows et se placer dans le dossier cloner avant
  2) lancer la commande *>kubectl apply -f* ./jenkins
  3) executer aussi la commande *>kubectl apply -f ./ingress* pour démarrer les ingress
  ```
## 4) Etape 4: Selenium Grid
Selenium Grid nous permet d'executer nos cas de tests sur plusieurs navigateur en parallele.On peut demarrer Selenium Grid en local ou sur le cloud.
-   sur le local:
   ```
   1)	Executer la commande *docker pull selenium/standalone-chrome* 
   2)	Executer la commande *docker run -d -p 4444:4444 -v ${pwd}:/dev/shm selenium/standalone-chrome*
   3)	lancer localhost:4444 sur le navigateur
   ```
-   sur le cloud:
  
   - Il suffit de lancer les pods a l'interieur de kubernetes avec la commande *>kubectl apply -f ./selenium*
   

## 6) Realisations de test sur le LocalHost

