create --Create a new Sequence

CREATE SEQUENCE UIDs
             START WITH 100 CACHE 20000;

create table users ( UID int  , Fullname varchar2(255), passwords varchar2(255), emails varchar2(255) , images blob , roles varchar2(255));
create table admins (AID int )