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
    ```
  - Installation de kubectl pour manipuler kubernetes:
    1) Ouvrir le terminal windows
    2) coller la commande suivante > choco install kubernetes-cli
    3) verifier si kubectl est bien installer avec la commande kubectl version --client
    ```
  - Installation de git : 
    ```
    1) Naviguer vers le site https://gitforwindows.org/
    2) Telecharger git sur votre poste
    ```
-  Clonez le repertoire de travail sur git :
  ```
  1) Ouvrir git Bash
  2) se placer dans le dossier ou le clonage aura lieu
  3) coller la commande suivante > git clone https://github.com/YOUR-USERNAME/YOUR-REPOSITORY
  4) Appuyer sur entrer
  ```   
        
## 2) Cloner le repertoire git pour avoir tous les fichier de configurations kubernetes des images docker 
## 3) Lancer SquashTM ou Jira Xray
## 4) Lancement de Jenkins
## 5) Selenium Grid
## 6) Realisations de test sur le LocalHost

