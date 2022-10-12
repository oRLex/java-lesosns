select * from users order by id;
select * from groupp order by id;

select u.id, u.name, g.name from users u
inner join groupp g on (u.group_id = g.id);

select u.id, u.name, g.name from users u
left outer join groupp g on (u.group_id = g.id);

select u.id, u.name, g.name from users u
right outer join groupp g on (u.group_id = g.id);

select u.id uid, u.name uname, g.name gname from users u
full outer join groupp g on (u.group_id = g.id);

select x.uid, x.uname, x.gname
from (select u.id uid, u.name uname, g.name gname from users u
full outer join groupp g on (u.group_id = g.id)) x;

select count(*) from users;

select count(*) from users where group_id is null;

---------------------------------------------
select x.group_id, g.name, x.g_count
from
    (select group_id, count(group_id) g_count
     from users
     where group_id is not null
     group by group_id) x
     join groupp g on g.id = group_id;
---------------------------------------------
select x.group_id, g.name, x.group_count
from group_count x
     join groupp g on g.id = group_id;
---------------------------------------------
create view group_count as
select group_id, count(group_id) group_count
from users
where group_id is not null
group by group_id
---------------------------------------------

