CREATE TABLE Avion (
    id SERIAL PRIMARY KEY,
    modele VARCHAR(255) NOT NULL,
    siegeBusiness INT NOT NULL,
    siegeEco INT NOT NULL,
    dateFabrication DATE NOT NULL
);

CREATE TABLE Ville (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    codeAeroport VARCHAR(10) NOT NULL UNIQUE
);

CREATE TABLE Vol (
    id SERIAL PRIMARY KEY,
    avion_id INT REFERENCES Avion(id),
    villeDepart_id INT REFERENCES Ville(id),
    villeArrivee_id INT REFERENCES Ville(id),
    dateDepart TIMESTAMP NOT NULL,
    dateArrivee TIMESTAMP NOT NULL,
    siegesDisponiblesBusiness INT NOT NULL,
    siegesDisponiblesEco INT NOT NULL
);

CREATE TABLE User (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    motDePasse VARCHAR(255) NOT NULL
);

CREATE TYPE TypeSiege AS ENUM ('Business', 'Economique');
CREATE TYPE StatutReservation AS ENUM ('Confirmée', 'Annulée');

CREATE TABLE Reservation (
    id SERIAL PRIMARY KEY,
    vol_id INT REFERENCES Vol(id),
    user_id INT REFERENCES User(id),
    typeSiege TypeSiege NOT NULL,
    dateReservation TIMESTAMP NOT NULL,
    statut StatutReservation NOT NULL
);

CREATE TABLE Promotion (
    id SERIAL PRIMARY KEY,
    vol_id INT REFERENCES Vol(id) UNIQUE,
    pourcentageSiegeBusiness DOUBLE PRECISION NOT NULL,
    pourcentageSiegeEco DOUBLE PRECISION NOT NULL
);

-- Insertion de données de test
INSERT INTO Avion (modele, siegeBusiness, siegeEco, dateFabrication) VALUES
('Boeing 747', 50, 300, '2010-06-15'),
('Airbus A320', 30, 150, '2015-09-22');

INSERT INTO Ville (nom, codeAeroport) VALUES
('Paris', 'CDG'),
('New York', 'JFK'),
('London', 'LHR');

INSERT INTO Vol (avion_id, villeDepart_id, villeArrivee_id, dateDepart, dateArrivee, siegesDisponiblesBusiness, siegesDisponiblesEco) VALUES
(1, 1, 2, '2025-03-10 08:00:00', '2025-03-10 14:00:00', 50, 300),
(2, 2, 3, '2025-03-12 09:30:00', '2025-03-12 11:00:00', 30, 150);

INSERT INTO User (nom, email, motDePasse) VALUES
('Alice Dupont', 'alice@example.com', 'password123'),
('Bob Martin', 'bob@example.com', 'securepass');

INSERT INTO Reservation (vol_id, user_id, typeSiege, dateReservation, statut) VALUES
(1, 1, 'Business', '2025-02-15 10:00:00', 'Confirmée'),
(2, 2, 'Economique', '2025-02-16 11:30:00', 'Annulée');

INSERT INTO Promotion (vol_id, pourcentageSiegeBusiness, pourcentageSiegeEco) VALUES
(1, 20.0, 10.0);
