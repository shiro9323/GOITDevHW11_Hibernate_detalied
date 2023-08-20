INSERT INTO Client (name)
VALUES
    ('client1'),
    ('client2'),
    ('client3'),
    ('client4'),
    ('client5'),
    ('client6'),
    ('client7'),
    ('client8'),
    ('client9'),
    ('client10');

INSERT INTO Planet (id, name)
VALUES
    ('MARS', 'Mars'),
    ('VEN', 'Venus'),
    ('SAT', 'Saturn'),
    ('EAR', 'Earth'),
    ('JUP', 'Jupiter');

INSERT INTO Ticket (created_at, client_id, from_planet_id, to_planet_id)
SELECT
    CURRENT_TIMESTAMP - INTERVAL '1' DAY * (RAND() * 30 + 1) AS created_at,
    c.id AS client_id,
    p1.id AS from_planet_id,
    p2.id AS to_planet_id
FROM
    Client c
    CROSS JOIN Planet p1
    CROSS JOIN Planet p2
WHERE
    p1.id != p2.id
ORDER BY
    RAND()
    LIMIT
    10;