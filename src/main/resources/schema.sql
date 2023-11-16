create table person
(
    name varchar(255) NOT NULL
);

create table student
(
    id integer not null,
    name varchar(255) not null,
    passport_number varchar(255) not null,
    primary key(id)
);