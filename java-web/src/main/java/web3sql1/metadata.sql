-- noinspection SqlNoDataSourceInspectionForFile

create table users
(
    id serial constraint users_pk primary key,
    name text not null,
    group_id integer
);

create table groupp
(
    id serial not null constraint groupp_pk primary key,
    name text not null
);

