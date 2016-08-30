# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table person (
  id                            integer auto_increment not null,
  name                          varchar(255),
  age                           integer,
  sex                           varchar(255),
  birthday                      datetime(6),
  constraint pk_person primary key (id)
);

create table student (
  id                            integer auto_increment not null,
  salary                        decimal(38),
  name                          varchar(1024),
  birthday                      datetime(6),
  deadline                      datetime(6),
  constraint pk_student primary key (id)
);

create table task (
  id                            integer auto_increment not null,
  name                          varchar(255),
  done                          tinyint(1) default 0,
  due_date                      datetime(6),
  constraint pk_task primary key (id)
);


# --- !Downs

drop table if exists person;

drop table if exists student;

drop table if exists task;

