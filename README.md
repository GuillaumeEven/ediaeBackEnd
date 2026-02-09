# Ediae Backend

## Configuration du Logging

### Option A — Fichier via configuration (`logging.properties`)
**Avantages :**
- Sépare le code et la config (meilleure pratique).
- Facile à changer sans recompiler.
- Centralise le logging pour tout le projet.

**Inconvénients :**
- Nécessite un fichier externe et un paramètre JVM.
- Moins évident en début de projet/formation.

### Option B — Fichier en code (`FileHandler` dans `Main`)
**Avantages :**
- Simple à mettre en place rapidement.
- Visible directement dans le code (pédagogique).

**Inconvénients :**
- Mélange logique métier et config.
- Plus dur à modifier sans recompiler.
- Risque d'oublier d'activer/désactiver en prod.