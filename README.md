# Roadmap

## Models to implement
- [x] Filmografia
- [x] Acceso
- [x] Clasificacion
- [x] Cuenta
- [x] Genero
- [x] Factura
- [x] Film_Genero
- [x] Pais
- [x] Reparto
- [x] Suscripcion

## Core to implement
- [x] Main
- [x] DBManager
- [x] Daos
  - [x] BaseDao
  - [x] FilmografiaDao

## Features to implement
- [x] filmografia table
  - [x] read all the table
  - [x] read one db entry with an id
  - [x] insert a new entry in the table
  - [x] update an entry
  - [x] delete an entry
- [ ] Menus in main

## Structure of files
- Main.java
- [package] daos
  - FilmografiaDao.java
  - ...
- [package] models
  - Filmografia.java
  - ...
- [package] utils
  - DBManager.java
  - Menu.java