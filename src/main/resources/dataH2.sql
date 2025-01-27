/* Roles */
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_USER');
INSERT INTO roles (id_role, name) VALUES (default, 'ROLE_ADMIN');

/* Users */
INSERT INTO users (id_user, username, password) VALUES (default, 'user1', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');
INSERT INTO users (id_user, username, password) VALUES (default, 'admin', '$2a$12$8LegtLQWe717tIPvZeivjuqKnaAs5.bm0Q05.5GrAmcKzXw2NjoUO');

/* Profiles */
INSERT INTO profiles (id_profile, user_id, name, phone, email, picture) VALUES (default, 1, 'profile1', 'phone1', 'email1@msc.com', 'picture1');
INSERT INTO profiles (id_profile, user_id, name, phone, email, picture) VALUES (default, 2, 'profile2', 'phone2', 'email2@msc.com', 'picture2');

/* Roles Users */
INSERT INTO roles_users (role_id, user_id) VALUES (1, 1);
INSERT INTO roles_users (role_id, user_id) VALUES (2, 2);

/* Airports */
INSERT INTO airport (city, country, name) VALUES ('City1', 'Country1', 'Airport1');
INSERT INTO airport (city, country, name) VALUES ('City2', 'Country2', 'Airport2');
INSERT INTO airport (city, country, name) VALUES ('City3', 'Country3', 'Airport3');

/* Flights */
INSERT INTO flight (flight_id, name, available_seats, departure_time, arrival_time, origin_id, destination_id, status_flight) VALUES (default, 'Flight1', 50, '2025-01-30T17:00:00', '2025-01-30T23:30:00', 1,  2, true);
INSERT INTO flight (flight_id, name, available_seats, departure_time, arrival_time, origin_id, destination_id, status_flight) VALUES (default, 'Flight2', 50, '2025-01-30T12:00:00', '2025-01-30T19:30:00', 1,  2, true);
INSERT INTO flight (flight_id, name, available_seats, departure_time, arrival_time, origin_id, destination_id, status_flight) VALUES (default, 'Flight3', 50, '2025-01-30T09:00:00', '2025-01-30T12:30:00', 2,  3, true);
INSERT INTO flight (flight_id, name, available_seats, departure_time, arrival_time, origin_id, destination_id, status_flight) VALUES (default, 'Flight4', 50, '2025-01-30T12:00:00', '2025-01-30T19:30:00', 1,  2, true);
INSERT INTO flight (flight_id, name, available_seats, departure_time, arrival_time, origin_id, destination_id, status_flight) VALUES (default, 'Flight5', 50, '2025-01-27T17:00:00', '2025-01-27T23:30:00', 3,  2, true);
INSERT INTO flight (flight_id, name, available_seats, departure_time, arrival_time, origin_id, destination_id, status_flight) VALUES (default, 'Flight6', 50, '2025-01-26T12:00:00', '2025-01-26T19:30:00', 3,  1, true);
