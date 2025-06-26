# eduSystem – Application de Gestion des Cours (Java POO + Swing + SQLite)

**eduSystem** est une application de bureau développée en Java avec Swing pour l’interface graphique. Elle permet la gestion des cours, des séries, des élèves, des professeurs et des locaux dans un établissement scolaire. Le projet applique les principes de la programmation orientée objet (POO) et utilise une base de données SQLite pour la persistance des données.

---

## 🧩 Architecture & Conception

### ⚙️ Modèle objet (UML)

Les entités principales sont modélisées en classes Java, respectant les principes **SOLID** et de la **POO** :

- **`Personne`** (classe abstraite)  
  ↳ `Eleve` et `Professeur` en héritent.

- **`Eleve`**
  - `id` (int)
  - `nom` (String)
  - `coordonnees` (String)
  - `serie` (association avec `Serie`)

- **`Professeur`**
  - `id` (int)
  - `nom` (String)

- **`Local`**
  - `bloc` (char)
  - `niveau` (int)
  - `numero` (int)

- **`Serie`**
  - `id` (int)
  - `listeEleves` (`List<Eleve>`)
  - `capaciteMax = 20` élèves

- **`Cours`**
  - `id` (int)
  - `nom` (String)
  - `professeur` (`Professeur`)
  - `local` (`Local`)
  - `series` (`List<Serie>`), max 4 séries

---

## 💻 Technologies utilisées

- **Langage** : Java SE 17+
- **Interface graphique** : Swing
- **Base de données** : SQLite (fichier `.db`)
- **Architecture** : DAO (Data Access Object)
- **Conception UML** : Astah / modèle orienté objet
- **IDE** : NetBeans

---

## ✅ Fonctionnalités implémentées

| Fonctionnalité                                         | Statut      |
|--------------------------------------------------------|-------------|
| Modélisation UML orientée objet                        | ✔️ terminée |
| Interface Swing avec icônes professionnels             | ✔️ terminée |
| Ajout d’un professeur                                  | ✔️ terminé  |
| Ajout d’un local                                       | ✔️ terminé  |
| Création d’une série                                   | ✔️ terminé  |
| Ajout d’un élève dans une série (max 20)              | ✔️ terminé  |
| Création d’un cours avec professeur et local           | ✔️ terminé  |
| Affectation de séries à un cours (max 4)              | ✔️ terminé  |
| Affichage des élèves inscrits à un cours               | ✔️ terminé  |
| DAO pour chaque entité (CRUD)                          | ✔️ terminé  |
| Tests unitaires des DAO (`TestEleveDAO`, etc.)         | ✔️ terminé  |
| Connexion à SQLite centralisée (`DatabaseManager`)     | ✔️ terminé  |
| Gestion des erreurs et validations (GUI)               | ✔️ terminé  |
| Icones d’illustration dans les fenêtres Swing          | ✔️ terminé  |
| Fenêtre principale centralisée avec navigation         | ✔️ terminé  |
| Enregistrement persistant dans `gestion_cours.db`      | ✔️ terminé  |

---

## 🔜 Fonctionnalités prévues (à terminer)

| Fonctionnalité                                         | Statut              |
|--------------------------------------------------------|---------------------|
| ✏️ Modification d’un élève                             | ☐ à faire           |
| 🗑️ Suppression d’un élève                              | ☐ à faire           |
| ✏️ Modification d’un cours                             | ☐ à faire           |
| 🗑️ Suppression d’un cours                              | ☐ à faire           |
| 🔎 Recherche dynamique d’élèves / cours / séries       | ☐ à faire           |
| 📃 Impression ou export PDF de la liste des élèves     | ☐ à faire           |
| 🔐 Authentification utilisateur (optionnelle)          | ☐ à faire           |
| ☁️ Chargement automatique des données depuis SQLite    | ☐ à faire           |
| 🔁 Rafraîchissement dynamique des interfaces            | ☐ à faire           |


---

## 🗂 Structure du projet

```

eduSystem/
├── src/
│   └── eduSystem/
│       ├── DAO/                # Objets d'accès aux données
│       ├── GUI/                # Interfaces Swing
│       ├── Cours.java
│       ├── Eleve.java
│       ├── Serie.java
│       ├── Professeur.java
│       ├── Local.java
│       └── Personne.java
├── database/
│   └── gestion\_cours.db        # Base de données SQLite
├── img/                        # Ressources graphiques (icônes)
├── dist/
│   └── eduSystem.jar           # Application compilée
└── test/
└── TestX.java              # Tests des DAO

````

---

## 🧪 Tests et démonstration

Des classes de test sont disponibles dans le dossier `/test/` pour vérifier individuellement chaque DAO :
- `TestEleveDAO.java`
- `TestProfesseurDAO.java`
- `TestCoursDAO.java`
- `TestSerieDAO.java`
- `TestLocalDAO.java`

---

## 📝 Instructions de déploiement

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/grand840/eduSystem.git
    ````

2. Ouvrir le projet avec **NetBeans** ou tout autre IDE compatible avec Java Swing.

3. Vérifier que le fichier SQLite `database/gestion_cours.db` est bien accessible.

4. Lancer la classe `MainGUI` pour ouvrir l’interface principale :

    ```bash
   java -cp dist/eduSystem.jar eduSystem.GUI.FenetrePrincipale
    ```

---

## 👨‍🏫 Réalisé dans le cadre d’un projet de Programmation Orientée Objet (POO)

* Langage : **Java**
* Interface : **Swing**
* Persistance : **SQLite avec JDBC**
* Structure MVC & DAO respectée
* Projet documenté, modulaire, prêt à l’usage
