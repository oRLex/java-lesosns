create table groupp (
    id serial not null constraint groupp_pk primary key,
    name text not null
);

create table users (
    id serial not null constraint users_pk primary key,
    name text not null,
    group_id integer
);
