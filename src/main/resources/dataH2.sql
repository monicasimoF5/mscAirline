/* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

INSERT INTO users (username, password)
VALUES ('Vicente', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');
INSERT INTO users (username, password)
VALUES ('Mónica', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');

/* Profiles */
INSERT INTO profiles (id_user, email, name, phone, picture)
VALUES (1, 'vicente@msc.com', 'Vicente', '601123456', 'https://cdn.pixabay.com/photo/2021/07/02/04/48/user-6380868_640.png');
INSERT INTO profiles (id_user, email, name, phone, picture)
VALUES (2, 'monica@msc.com', 'Monica', '602123456', 'https://cdn.pixabay.com/photo/2021/07/02/04/48/user-6380868_640.png');

/* Roles Users */
INSERT INTO roles_users (id_role, id_user) VALUES (1, 1);
INSERT INTO roles_users (id_role, id_user) VALUES (2, 2);

/* Airports */
INSERT INTO airports (city, country, name) VALUES ('Valencia', 'España', 'Manises');
INSERT INTO airports (city, country, name) VALUES ('Barcelona', 'España', 'El Prat');
INSERT INTO airports (city, country, name) VALUES ('Madrid', 'España', 'Barajas');

/* Flights */
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('BCN456', 50, '2025-01-30T17:00:00', '2025-01-30T23:30:00', 1,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('BCN404', 50, '2025-01-30T12:00:00', '2025-01-30T19:30:00', 1,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('MAD380', 50, '2025-01-30T09:00:00', '2025-01-30T12:30:00', 2,  3, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('BCN568', 50, '2025-01-30T12:00:00', '2025-01-30T19:30:00', 1,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('BCN125', 50, '2025-01-27T17:00:00', '2025-01-27T23:30:00', 3,  2, true);
INSERT INTO flights (name, available_seats, departure_time, arrival_time, id_origin, id_destination, status_flight) VALUES ('VLC297', 50, '2025-01-26T12:00:00', '2025-01-26T19:30:00', 3,  1, true);
