-- liquibase formatted sql
-- changeset Karol Malicki:7
insert into category (id, name, description, slug) values (1, 'Other', '', 'other');
update product set category_id=1;
alter table product MODIFY category_id bigint not null;