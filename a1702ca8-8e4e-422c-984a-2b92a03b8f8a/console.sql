create database db_sesstion10;
use db_sesstion10;
CREATE TABLE documents
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    file_name   VARCHAR(255) NOT NULL
);
delimiter \\
create procedure add_new_document(
    in p_title VARCHAR(255),
    in p_description TEXT,
    in p_file_name VARCHAR(255)
)
begin
    insert into documents (title, description, file_name)
    values (p_title, p_description, p_file_name);
end \\
delimiter \\;

CREATE TABLE upload_file
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    file_name   VARCHAR(255) NOT NULL,
    description TEXT
);
delimiter \\
create procedure add_new_file(
    in p_file_name VARCHAR(255),
    in p_description TEXT
)
begin
    insert into upload_file (file_name, description)
    values (p_file_name, p_description);
end \\
delimiter \\;


-- dùng tên bảng thống nhất là `documents`
create table project
(
    id          int auto_increment primary key,
    name        varchar(255) not null,
    description text
);

create table document2
(
    id          int auto_increment primary key,
    title       varchar(255),
    description text,
    file_path   varchar(500),
    project_id  int,
    constraint fk_document_project
        foreign key (project_id)
            references project (id)
            on delete cascade
);

delimiter //

create procedure add_new_project(
    in p_name varchar(255),
    in p_description text
)
begin
    insert into project(name, description)
    values (p_name, p_description);
end //

create procedure add_new_documents(
    in p_title varchar(255),
    in p_description text,
    in p_file_name varchar(255),
    in p_project_id int
)
begin
    insert into document2(title, description, file_path, project_id)
    values (p_title, p_description, p_file_name, p_project_id);
end //

create procedure get_id_project(
    in name_in varchar(255)
)
begin
    select id from project where name = name_in;
end //

delimiter ;

drop table project;
drop table document2;
drop procedure get_id_project;
drop procedure add_new_documents;
drop procedure add_new_project;

CREATE TABLE tickets
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    movie_title  VARCHAR(255),
    show_time    DATETIME,
    seats        TEXT,
    total_amount DOUBLE
);
DELIMITER //
CREATE PROCEDURE sp_insert_ticket (
    IN p_movie_title VARCHAR(255),
    IN p_show_time DATETIME,
    IN p_seats TEXT,
    IN p_total_amount DOUBLE
)
BEGIN
    INSERT INTO tickets (movie_title, show_time, seats, total_amount)
    VALUES (p_movie_title, p_show_time, p_seats, p_total_amount);
END //
DELIMITER ;

