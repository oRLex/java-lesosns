-- noinspection SqlNoDataSourceInspectionForFile

create table "user"
(
    id serial constraint user_pk primary key,
    name text not null,
    group_id int
        constraint user_groupp_id_fk
            references groupp
);


create table groupp
(
    id serial not null constraint groupp_pk primary key,
    name text not null
);

