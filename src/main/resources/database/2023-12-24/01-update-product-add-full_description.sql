-- liquibase formatted sql
-- changeset Karol Malicki:4
alter table product add full_description varchar(2047) after description;