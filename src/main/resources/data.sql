INSERT INTO School (name, hour_price) VALUES ('Szkoła Podstawowa nr 1', 15.50);
INSERT INTO School (name, hour_price) VALUES ('Przedszkole Bajka', 20.00);

INSERT INTO Parent (firstname, lastname) VALUES ('Anna', 'Kowalska');
INSERT INTO Parent (firstname, lastname) VALUES ('Piotr', 'Nowak');

INSERT INTO Child (firstname, lastname, parent_id, school_id) VALUES ('Jan', 'Kowalski', 1, 1);
INSERT INTO Child (firstname, lastname, parent_id, school_id) VALUES ('Ewa', 'Nowak', 2, 2);

INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (1, '2024-02-15 08:00:00', '2024-02-15 12:00:00');
INSERT INTO Attendance (child_id, entry_date, exit_date) VALUES (2, '2024-02-15 07:30:00', '2024-02-15 12:30:00');
