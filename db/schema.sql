CREATE TABLE post
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE candidate
(
    id   SERIAL PRIMARY KEY,
    name TEXT
);

insert into candidate (id, name) values (1, 'Junior Jd');
insert into candidate (id, name) values (2, 'Junior+ Jd');
insert into candidate (id, name) values (3, 'SuperJunior Jd');