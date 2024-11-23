create table employee(
    employee_id varchar(50) primary key,
    first_name varchar(50) not null,
    last_name varchar(50),
    email varchar(50) unique not null,
    password varchar(50) not null,
    title varchar(50) not null ,
    department varchar(50) not null
)