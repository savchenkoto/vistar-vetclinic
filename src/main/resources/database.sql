create table roles
(
  id   serial      not null
    constraint roles_pkey
    primary key,
  type varchar(45) not null
);

create table users
(
  id         serial                 not null
    constraint users_pkey
    primary key,
  email      varchar(45)            not null,
  password   varchar(255)           not null,
  photo      varchar(45),
  role_id    integer                not null
    constraint users_roles_id_fk
    references roles
    on update cascade,
  first_name varchar(45) default 12 not null,
  last_name  varchar(45) default 45 not null
);

create unique index users_email_uindex
  on users (password);

create unique index roles_role_uindex
  on roles (type);

create table messages
(
  id           serial    not null
    constraint messages_pkey
    primary key,
  sender_id    integer   not null
    constraint messages_users_id_fk
    references users,
  receiver_id  integer   not null
    constraint messages_users_id_fk_2
    references users,
  message      text      not null,
  delivered_at timestamp not null
);

create table animals
(
  id   serial      not null
    constraint animals_pkey
    primary key,
  type varchar(45) not null
);

create table pets
(
  id       serial      not null
    constraint pets_pkey
    primary key,
  type_id  integer     not null
    constraint pets_animals_id_fk
    references animals,
  owner_id integer     not null
    constraint pets_users_id_fk
    references users,
  name     varchar(45) not null,
  birthday date,
  photo    varchar(45)
);

create unique index animals_animal_uindex
  on animals (type);

create table card_statuses
(
  id   serial      not null
    constraint card_statuses_pkey
    primary key,
  type varchar(45) not null
);

create table medical_cards
(
  id               serial  not null
    constraint medical_card_pkey
    primary key,
  pet_id           integer not null
    constraint medical_card_pets_id_fk
    references pets,
  application_date date    not null,
  closing_date     integer,
  status_id        integer not null
    constraint medical_card_card_statuses_id_fk
    references card_statuses,
  doctor_id        integer not null
    constraint medical_cards_doctor_id_fk
    references users
);

create table visits
(
  id              serial    not null
    constraint visits_pkey
    primary key,
  medical_card_id integer   not null
    constraint visits_medical_card_id_fk
    references medical_cards,
  date            date      not null,
  description     text      not null,
  treatment       text      not null,
  updated_at      timestamp not null
);