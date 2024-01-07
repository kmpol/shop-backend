-- liquibase formatted sql
-- changeset Karol Malicki:9
alter table review add is_moderated boolean not null after content;