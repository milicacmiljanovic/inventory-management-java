# Space Agency Database Application

A Java desktop application for managing a fictional space agency's database — people, missions, flights, habitable objects, and real estate transactions. Built with a full MVC architecture on top of JDBC.

**Course:** Databases · School of Computing, University of Belgrade  
**Team:** Milica Cmiljanović, Tijana Ignjatov  
**Language:** Java · JDBC · Swing

---

## What This Does

Provides a GUI for browsing, filtering, and interacting with a relational database covering the operations of a space agency. Users can log in, view missions and flights, manage habitable objects (space stations, planets), and record purchase transactions.

### Features
- Login / registration with server-side authentication
- Tabular views for: People, Missions, Flights, Objects, Buildings
- Filtering and search across all entity types
- Record purchases (real estate and taxi rides for space agency personnel)
- View personal purchase history per user
- MVC separation — model handles all DB calls, controllers handle logic, views are pure Swing

---

## Architecture

```
src/main/java/person/
 ├── model/
 │    ├── base/         # Server.java, DataBase.java — connection management
 │    ├── utility/      # JDBCUtils — query helpers
 │    └── *.java        # Entity classes (Misija, Putovanje, Kupovina, ...)
 ├── view/              # Swing panels and tables for each entity
 │    ├── MainView.java
 │    ├── MissionsTable.java
 │    ├── FlighTable.java
 │    └── ...
 └── controller/        # Event handlers and business logic
      ├── LogInControl.java
      ├── BuyTicketControl.java
      ├── FilterControl.java
      └── ...
```

---

## Tech Stack

- **Java** with **Swing** for the desktop GUI
- **JDBC** for all database communication
- **Maven** for dependency management and build
- Relational database with entities: Persons, Missions, Flights, Planets, Habitable Objects, Vehicles, Purchases

---

## How to Run

Configure the database connection in `Server.java`, then build and run via Maven:

```bash
mvn clean package
java -jar target/<artifact>.jar
```

Requires a running database instance with the schema loaded.
