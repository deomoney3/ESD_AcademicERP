create table employee(
    employee_id varchar(50) primary key,
    first_name varchar(50) not null,
    last_name varchar(50),
    email varchar(50) unique not null,
    password varchar(50) not null,
    title varchar(50) not null ,
    department varchar(50) not null
);

create table specialization(
    specialization_id varchar(50) primary key,
    code varchar(500) not null unique,
    name varchar(500) not null unique ,
    description varchar(500) not null,
    year varchar(50) not null,
    credits_required varchar(50) not null
);

create table courses(
    course_id varchar(50) primary key,
    course_code varchar(50) not null unique,
    name varchar(500) not null,
    description varchar(500) not null,
    year varchar(50) not null,
    term varchar(50) not null,
    faculty varchar(50) not null,
    credits varchar(50) not null,
    capacity varchar(50) not null
);

create table specialization_course(
    id bigint auto_increment primary key,
    specialization_id varchar (50) not null,
    course_id varchar(50) not null
);