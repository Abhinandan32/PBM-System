create sequence hibernate_sequence
;

create table usr
(
	id bigserial not null
		constraint usr_pkey
			primary key,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	password varchar(100) not null,
	email varchar(255) not null,
	role varchar(255)
)
;

create unique index usr_email_uindex
	on usr (email)
;

create table project
(
	id bigserial not null
		constraint project_pkey
			primary key,
	beginning_date date not null,
	name varchar(255) not null
)
;

create table control_cabinet
(
	id bigserial not null
		constraint control_cabinet_pkey
			primary key,
	real_time bigint not null,
	esitmated_time bigint,
	valuation_cost bigint,
	adjusted_cost bigint not null,
	current bigint not null,
	plc_input bigint not null,
	plc_output bigint not null,
	drive_amount bigint not null,
	protection_amount bigint not null,
	contactors_amount bigint not null,
	is_archive boolean not null,
	not_used_in_model boolean not null,
	to_valuation boolean not null,
	offerer_id bigint
		constraint control_cabinet_offerer_id_fkey
			references usr,
	project_id bigint not null
		constraint control_cabinet_project_id_fkey
			references project,
	safety bigint not null,
	name varchar(25) not null
)
;

create unique index control_cabinet_name_uindex
	on control_cabinet (name)
;

