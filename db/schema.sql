CREATE TABLE post
(
    id   SERIAL PRIMARY KEY,
    name TEXT,
    created TIMESTAMP
);

insert into post (id, name, created) values (1, 'Junior Java Job', localtimestamp(1));
insert into post (id, name, created) values (2, 'Middle Java Job', localtimestamp(1));
insert into post (id, name, created) values (3, 'Senior Java Job', localtimestamp(1));

CREATE TABLE candidate
(
    id   SERIAL PRIMARY KEY,
    name TEXT,
    city_id int references cities(id),
    created TIMESTAMP
);

insert into candidate (id, name, city_id, created) values (1, 'Junior Java Developer', 1, localtimestamp(1));
insert into candidate (id, name, city_id, created) values (2, 'Middle Java Developer', 2, localtimestamp(1));
insert into candidate (id, name, city_id, created) values (3, 'Senior Java Developer', 3, localtimestamp(1));

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
