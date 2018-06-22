CREATE DATABASE addressbook;
--DROP TABLE contact;
--DROP TABLE address;
--DROP TABLE phone;
--DROP TABLE email;

CREATE TABLE contact (
        contact_id serial,
        first_name varchar(35) not null,
        last_name varchar(35) not null,
        company varchar(100) null,
        date_added timestamp not null,
        date_last_updated timestamp null,
        
        constraint pk_contact_id primary key (contact_id)
       
);

CREATE TABLE address (
        address_id serial,
        contact_id int not null,
        address_type varchar(35) not null,
        address_other_description varchar(255),
        address_line_1 varchar(100) not null,
        address_line_2 varchar(100),
        city varchar(50),
        province varchar(50),
        postal_code varchar(20) not null,
        country varchar(3) not null,
        
        constraint pk_address_id primary key (address_id),
        constraint fk_address_contact_id foreign key (contact_id) references contact(contact_id),
        constraint chk_add_other_description check ( 
                (address_type = 'Other' AND address_other_description is not null) OR 
                (address_type <> 'Other' AND address_other_description is null)) 
);

ALTER TABLE address ADD constraint chk_address_type check (address_type IN ('Home', 'Work', 'PO Box', 'Shipping', 'Billing', 'Other'));

CREATE TABLE phone (
        phone_id serial,
        contact_id int not null,
        phone_type varchar(35) not null,
        phone_other_description varchar(255),
        phone_number varchar(20) not null,
        is_primary boolean,
        
        constraint pk_phone_id primary key (phone_id),
        constraint fk_phone_contact_id foreign key (contact_id) references contact(contact_id),
        constraint chk_phone_type check (phone_type IN ('Home', 'Work', 'Mobile', 'Other')),
        constraint chk_phone_other_description check ( 
                (phone_type = 'Other' AND phone_other_description is not null) OR 
                (phone_type <> 'Other' AND phone_other_description is null)) 
        
);

CREATE TABLE email (
        email_id serial,
        contact_id int not null,
        email_type varchar(35) not null,
        email_other_description varchar(255),
        email_address varchar(20) not null,
        
        constraint pk_email_id primary key (email_id),
        constraint fk_email_contact_id foreign key (contact_id) references contact(contact_id),
        constraint chk_email_type check (email_type IN ('Home', 'Work', 'Other')),
        constraint chk_email_other_description check ( 
                (email_type = 'Other' AND email_other_description is not null) OR 
                (email_type <> 'Other' AND email_other_description is null)) 
        
);