
    drop table Flights cascade constraints

    drop table airports cascade constraints

    drop table flight_tickets cascade constraints

    drop sequence hibernate_sequence

    create table Flights (
        id number(19,0) not null,
        airline varchar2(50 char) not null,
        flight_code varchar2(20 char) not null,
        flight_date timestamp not null,
        flight_time varchar2(20 char) not null,
        landing_time timestamp not null,
        refrence_price double precision not null,
        stop_airport varchar2(50 char),
        take_time timestamp not null,
        type varchar2(20 char) not null,
        landing_airport_id number(10),
        take_airport_id number(10),
        primary key (id)
    )

    create table airports (
        id number(19,0) not null,
        city_name varchar2(50 char) not null,
        airport_name varchar2(50 char) not null,
        primary key (id)
    )

    create table flight_tickets (
        id number(19,0) not null,
        flight_date date not null,
        sell_company varchar2(50 char),
        ticket_price number(10,2),
        flight_id number(10),
        primary key (id)
    )

    alter table Flights 
        add constraint FK_ca5yrtirsenhr3ff5hpvyntk3 
        foreign key (landing_airport_id) 
        references airports

    alter table Flights 
        add constraint FK_ryoensx6heu5a4t7683jkgmif 
        foreign key (take_airport_id) 
        references airports

    alter table flight_tickets 
        add constraint FK_88jycdnirbr1gdjmqaakljf9h 
        foreign key (flight_id) 
        references Flights

    create sequence hibernate_sequence
