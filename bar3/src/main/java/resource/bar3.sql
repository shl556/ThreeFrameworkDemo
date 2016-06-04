
    alter table POSTS 
        drop 
        foreign key FK_5a9cka17cstbtp51qwnje3qxh;

    alter table POSTS 
        drop 
        foreign key FK_9yb8rxhdydiy4mbv1jpn3rvk7;

    alter table REPLYS 
        drop 
        foreign key FK_4nb7l6bx0mgq464o6l8aecccm;

    alter table REPLYS 
        drop 
        foreign key FK_hn0o4t21kx7qsvflqcdwpo4b;

    drop table if exists KINDS;

    drop table if exists POSTS;

    drop table if exists REPLYS;

    drop table if exists USERS;

    create table KINDS (
        ID bigint not null auto_increment,
        VERSION integer not null,
        KINDNAME varchar(30) not null,
        PARENTKINDID bigint not null,
        primary key (ID)
    );

    create table POSTS (
        ID bigint not null auto_increment,
        VERSION integer not null,
        TITLE varchar(100) not null,
        POSTCONTENT text,
        CTEATETIME timestamp,
        MODIFYTIME timestamp,
        KINDID bigint not null,
        USERID bigint not null,
        primary key (ID)
    );

    create table REPLYS (
        ID bigint not null auto_increment,
        VERSION integer not null,
        REPLYCONTENT text,
        CTEATETIME timestamp,
        MODIFYTIME timestamp,
        USERID bigint not null,
        POSTID bigint not null,
        primary key (ID)
    );

    create table USERS (
        ID bigint not null auto_increment,
        VERSION integer not null,
        LGNAME varchar(15) not null,
        LGPASS varchar(20) not null,
        SEX integer not null,
        NICKNAME varchar(15) not null,
        HEADNAME varchar(20) not null,
        REGISTERTIME timestamp,
        primary key (ID)
    );

    alter table KINDS 
        add constraint UK_45ayifc1paytf5yg1mgl8da8n  unique (KINDNAME);

    alter table USERS 
        add constraint UK_cqv45q7tgwrc8jvgs69ni7yqq  unique (LGNAME);

    alter table POSTS 
        add constraint FK_5a9cka17cstbtp51qwnje3qxh 
        foreign key (KINDID) 
        references KINDS (ID);

    alter table POSTS 
        add constraint FK_9yb8rxhdydiy4mbv1jpn3rvk7 
        foreign key (USERID) 
        references USERS (ID);

    alter table REPLYS 
        add constraint FK_4nb7l6bx0mgq464o6l8aecccm 
        foreign key (USERID) 
        references USERS (ID);

    alter table REPLYS 
        add constraint FK_hn0o4t21kx7qsvflqcdwpo4b 
        foreign key (POSTID) 
        references POSTS (ID);
