CREATE TABLE post
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE candidate
(
    id   SERIAL PRIMARY KEY,
    name TEXT,
    city_id int references cities(id)
);

insert into candidate (id, name, city_id) values (1, 'Junior Java Developer', 1);
insert into candidate (id, name, city_id) values (2, 'Junior+ Java Developer', 2);
insert into candidate (id, name, city_id) values (3, 'Middle Java Developer', 3);

CREATE TABLE users
(
    id SERIAL PRIMARY KEY,
    name TEXT,
    email TEXT,
    password TEXT
);

CREATE TABLE cities
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

insert into cities (id, name) values (1, 'SPB');
insert into cities (id, name) values (2, 'Minsk');
insert into cities (id, name) values (3, 'London');
