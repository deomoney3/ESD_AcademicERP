create table employee(
    employee_id varchar(50) primary key,
    first_name varchar(50) not null,
    last_name varchar(50),
    email varchar(50) unique not null,
    password varchar(50) not null,
    title varchar(50) not null ,
    department varchar(50) not null
);

create table course_specialization(
    specialization_id varchar(50) primary key,
    code varchar(50) not null unique,
    name varchar(50) not null unique ,
    description varchar(50) not null,
    year varchar(50) not null,
    credits_required varchar(50) not null
);