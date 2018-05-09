create table publisher(id bigint auto_increment primary key, name nvarchar(50));

create table item(id bigint auto_increment primary key,
  dtype nvarhar(31),
  description nvarchar(3000),
  title nvarchar(100),
  unit_cost double,
  isbn nvarchar(15),
  language nvarchar(255),
  nb_of_pages integer,
  publication_date date,
  publisher_pk bigint,
  genre nvarchar(255),
  music_company nvarchar(255),
  total_duration double);

create table musician(id bigint auto_increment primary key,
  bio nvarchar(5000),
  date_of_birth date,
  first_name nvarchar(50),
  last_name nvarchar(50),
  preferred_instrument nvarchar(255));

create table author(id bigint auto_increment primary key,
  bio nvarchar(5000),
  date_of_birth date,
  first_name nvarchar(50),
  last_name nvarchar(50),
  preferred_language integer);

