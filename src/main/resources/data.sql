INSERT INTO School (name, hour_price) VALUES ('Szkoła Podstawowa nr 1', 15.50);
INSERT INTO School (name, hour_price) VALUES ('Przedszkole Bajka', 20.00);

INSERT INTO Parent (firstname, lastname) VALUES ('Anna', 'Kowalska');
INSERT INTO Parent (firstname, lastname) VALUES ('Piotr', 'Nowak');
INSERT INTO Parent (firstname, lastname) VALUES ('Maria', 'Krzynówek');

INSERT INTO Child (firstname, lastname, parent_id, school_id) VALUES ('Jan', 'Kowalski', 1, 1);
INSERT INTO Child (firstname, lastname, parent_id, school_id) VALUES ('Ewa', 'Nowak', 2, 2);
INSERT INTO Child (firstname, lastname, parent_id, school_id) VALUES ('Jan', 'Nowak', 2, 1);
INSERT INTO Child (firstname, lastname, parent_id, school_id) VALUES ('Maciej', 'Krzynówek', 3, 2);

INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (1, '2024-02-15 08:00:00', '2024-02-15 12:00:00');
INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (2, '2024-02-15 07:00:00', '2024-02-15 12:00:00');
INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (2, '2024-02-14 06:59:00', '2024-02-14 12:01:00');
INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (2, '2024-02-13 07:30:00', '2024-02-13 12:30:00');

INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (3, '2024-02-15 07:00:00', '2024-02-15 12:00:00');
INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (3, '2024-02-14 07:00:00', '2024-02-14 15:00:00');
INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (3, '2024-02-13 07:00:00', '2024-02-13 13:30:00');

INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (4, '2024-02-15 07:00:00', '2024-02-15 12:00:00');
INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (4, '2024-02-14 07:00:00', '2024-02-14 15:00:00');
INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (4, '2024-02-13 07:00:00', '2024-02-13 13:30:00');

