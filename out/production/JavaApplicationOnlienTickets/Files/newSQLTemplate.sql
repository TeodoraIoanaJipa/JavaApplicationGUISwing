/*create table events(
    event_id integer primary key,
    name varchar(35),
    description varchar(35),
    start_date date,
    end_date date,
    type varchar(15)
);*/


alter table events
add column location_id integer;
/*
create table locations(
        id integer primary key,
        name varchar(25) not null,
        city varchar(25),
        country varchar(25)
 );

insert into locations values 
(1,'Sala Palatului','Bucuresti','Romania'),
(2,'Arena Nationala','Bucuresti','Romania'),
(3,'BT Arena','Cluj','Romania'),
(4,'Piata Constitutiei','Bucuresti','Romania'),
(5,'Sala Polivalenta','Cluj','Romania'),
(6,'Cinema City', 'Bucuresti', 'Romania');

alter table events
add constraint fk_location foreign key (location_id) references locations(id);



create table consumers(
    first_name varchar(25),
    last_name varchar(25),
    birth_date date,
    location_id integer,
    email varchar(35)
);

alter table consumers
add constraint fk_loc_cons foreign key (location_id) references locations(id);
*/