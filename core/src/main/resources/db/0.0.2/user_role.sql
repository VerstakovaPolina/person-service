create table if not exists role
( id bigint not null primary key,
  role text);

create table if not exists users
( id bigint not null primary key,
  username text,
  password text);

create table if not exists user_role
( id bigint not null primary key,
  user_id bigint references users(id),
  role_id bigint references role(id));