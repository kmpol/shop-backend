-- liquibase formatted sql
-- changeset Karol Malicki:2
alter table product add image varchar(128) after currency;