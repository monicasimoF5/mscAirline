/* Erased data from tables and restart id identities: */
TRUNCATE TABLE roles RESTART IDENTITY CASCADE;
TRUNCATE TABLE users RESTART IDENTITY CASCADE;
TRUNCATE TABLE profiles RESTART IDENTITY CASCADE;
TRUNCATE TABLE roles_users RESTART IDENTITY CASCADE;
TRUNCATE TABLE airports RESTART IDENTITY CASCADE;
TRUNCATE TABLE flights RESTART IDENTITY CASCADE;

/* Restarts sequences */
ALTER SEQUENCE roles_id_role_seq RESTART WITH 1;
ALTER SEQUENCE users_id_user_seq RESTART WITH 1;
ALTER SEQUENCE profiles_id_profile_seq RESTART WITH 1;
ALTER SEQUENCE airports_id_airport_seq RESTART WITH 1;
ALTER SEQUENCE flights_id_flight_seq RESTART WITH 1;

DROP SEQUENCE IF EXISTS airports_id_airport_seq_1;

/* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

/* Users */
INSERT INTO users (username, password)
VALUES ('user1', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');
INSERT INTO users (username, password)
VALUES ('admin', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');

/* Profiles */
INSERT INTO profiles (id_user, email, name, phone, picture)
VALUES (1, 'email1@msc.com', 'profile1', 'phone1', 'picture1');
INSERT INTO profiles (id_user, email, name, phone, picture)
VALUES (2, 'email2@msc.com', 'profile2', 'phone2', 'picture2');

/* Roles Users */
INSERT INTO roles_users (role_id, user_id, id_user, id_role) VALUES (1, 1, 1, 1);
INSERT INTO roles_users (role_id, user_id, id_user, id_role) VALUES (2, 2, 2, 2);

/* Airports */
INSERT INTO airports (city, country, name) VALUES ('City1', 'Country1', 'Airport1');
INSERT INTO airports (city, country, name) VALUES ('City2', 'Country2', 'Airport2');
INSERT INTO airports (city, country, name) VALUES ('City3', 'Country3', 'Airport3');

/* Flights */
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('Flight1', 50, '2025-01-30T17:00:00', '2025-01-30T23:30:00', 1,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('Flight2', 50, '2025-01-30T12:00:00', '2025-01-30T19:30:00', 1,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('Flight3', 50, '2025-01-30T09:00:00', '2025-01-30T12:30:00', 2,  3, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('Flight4', 50, '2025-01-30T12:00:00', '2025-01-30T19:30:00', 1,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('Flight5', 50, '2025-01-27T17:00:00', '2025-01-27T23:30:00', 3,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('Flight6', 50, '2025-01-26T12:00:00', '2025-01-26T19:30:00', 3,  1, true);
