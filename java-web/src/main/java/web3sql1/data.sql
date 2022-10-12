INSERT INTO users (id, name, group_id) VALUES (1, 'Jim', 6);
INSERT INTO users (id, name, group_id) VALUES (2, 'Jackson', 7);
INSERT INTO users (id, name, group_id) VALUES (3, 'Nate', 8);
INSERT INTO users (id, name, group_id) VALUES (4, 'Maria', 12);
INSERT INTO users (id, name, group_id) VALUES (5, 'Sergio', 13);

SELECT setval('users_id_seq', 5);

INSERT INTO groupp (id, name) VALUES (2, 'FS2');
INSERT INTO groupp (id, name) VALUES (3, 'FS3');
INSERT INTO groupp (id, name) VALUES (4, 'FS4');
INSERT INTO groupp (id, name) VALUES (5, 'FS5');
INSERT INTO groupp (id, name) VALUES (6, 'FS6');
INSERT INTO groupp (id, name) VALUES (7, 'FS7');
INSERT INTO groupp (id, name) VALUES (8, 'FS8');

SELECT setval('groupp_id_seq', (select max(id) from groupp));

