create table events(
    event_id integer GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
    name varchar(35),
    description varchar(105),
    start_date date,
    end_date date,
    type varchar(15)
);

create table locations(
        id integer primary key,
        name varchar(25) not null,
        city varchar(25),
        country varchar(25)
 );

alter table events
add column location_id integer;

insert into locations values 
(1,'Sala Palatului','Bucuresti','Romania'),
(2,'Arena Nationala','Bucuresti','Romania'),
(3,'BT Arena','Cluj','Romania'),
(4,'Piata Constitutiei','Bucuresti','Romania'),
(5,'Sala Polivalenta','Cluj','Romania'),
(6,'Cinema City', 'Bucuresti', 'Romania');

insert into events(name,description,start_date,end_date,type,location_id)
values 
        ('Ed Sheeran concert','Ed Sheeran concerteaza in Romania',cast('2019-07-03' as date),
cast('2019-07-03' as date),'concert',2),
        ('Enrique Iglesias Concert','Enrique Iglesias  concerteaza in Cluj Napoca',
cast('2020-10-29' as date), cast('2020-10-29' as date),'concert',3),
        ('The Cure Concert', 'The Cure si Editors God is an astronaut Tour 2019',
cast('2019-07-03' as date), cast('2019-07-03' as date),'concert',4),
        ('Bon Jovi concert','Bon Jovi in concert la Sala Palatului This House is not For Sale Tour 2019',
cast('2019-01-19' as date), cast('2019-01-22' as date),'concert',1),
        ('Lara Fabian in concert','Mult indragita artista Lara Fabian revine cu un nou turneu mondial “50 World Tour”.',
cast('2020-11-18' as date), cast('2020-11-18' as date),'concert',1),
        ('Bohemiam Rhapsody','Rami Malek playes Freddie Mercury',
cast('2019-07-15' as date),cast('2019-07-15' as date),'movie',6),
        ('The Hustle', 'Ticăloasele (The Hustle) le are în prim plan pe Anne Hathaway și Rebel Wilson.',
cast('2019-07-13' as date),cast('2019-07-15' as date),'movie',6),
        ('Avengers: Endgame','Răzbunătorii care au supraviețuit decimării adică Thor, Black Widow, Captain America și Bruce Banner
',cast('2019-5-10' as date),cast('2019-5-12' as date),'movie',6),
        ('Hellboy', 'Hellboy ajunge în Marea Britanie, unde trebuie să le înfrângă pe consoarta lui Merlin și Regina Nimue',
cast('2019-05-11' as date),cast('2019-05-11' as date),'movie',7),
        ('Little','Regina Hall pe care o știm din Girls Trip și Marsai Martin din serialul
 Black-ish.',cast('2019-08-23' as date),cast('2019-08-23' as date),'movie',6),
        ('Hotel Mumbai','Un grup de pakistanezi foarte bine înarmați ia cu asalt hotelul Taj Mahal din Mumbai India.'
,cast('2019-07-15' as date),cast('2019-07-17' as date),'movie',6),
        ('Noii infractori','Umorul si intelepciunea unei familii oneste din zilele noastre te vor face sa razi cu lacrimi.'
,cast('2019-05-31' as date),cast('2019-05-31' as date),'theatre', 8),
        ('O femeie singura','Joaca castigatoarea premiului Cea mai buna interpretare feminina la
 Festivalul National de Teatru Galati',cast('2019-05-31' as date),cast('2019-05-31' as date),'theatre',9);

insert into locations 
values
(7,'Happy Cinema','Buzau','Romania'),
(8,'Teatrul National','Bucuresti','Romania'),
(9,'Teatrul de Arta','Iasi','Romania');

insert into locations
values (10,'Mojo Club','Valencia','Spania');

alter table events
add constraint fk_location foreign key (location_id) references locations(id);

create table consumers(
    consumer_id Integer GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
    first_name varchar(25),
    last_name varchar(25),
    birth_date date,
    location_id integer,
    email varchar(35)
);

alter table consumers
add constraint fk_loc_cons foreign key (location_id) references locations(id);

create table tickets(
    id Integer GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) primary key,
    vip Boolean ,
    price Double not null,
    vip_price Double not null,
    seat varchar(5),
    event_id Integer not null
);

insert into tickets(price,vip_price,seat,event_id)
values(30,80,'1A',9),
(30,80,'1A',8),
(40,80,'11A',14),
(40,80,'2A',14),
(40,80,'3A',14),
(40,80,'4A',14),
(40,80,'1A',6),
(40,80,'2A',6),
(40,80,'3A',6),
(40,80,'4A',6);

update tickets
set seat = '1A'
where id =3;

alter table tickets
add constraint fk_event foreign key (event_id) references events(event_id);

update tickets
set event_id = 12
where id = 3;

insert into tickets(price,vip_price,seat,event_id)
values (40,70,'1A',11),(40,70,'2A',11),(40,70,'2A',11),
(40,70,'1A',7),(200,300,'1A',4),(200,300,'2A',4),
(200,300,'3A',4),(200,300,'1A',4),(50,50,'1A',9);

select *
from tickets t join events e on (t.EVENT_ID = e.EVENT_ID);

insert into tickets(price,vip_price,seat,event_id)
values (110.5,170,'1A',1),
(110.5,170,'2A',1),
(110.5,170,'3A',1),(110.5,170,'4A',1),
(110.5,170,'1B',1),(110.5,170,'1B',1),
(110.5,170,'2B',1),(110.5,170,'3B',1),
(110.5,170,'4B',1),(110.5,170,'5B',1),
(150,170,'1A',5),(150,170,'2A',5),(150,170,'3A',5),(150,170,'4A',5),
(150,170,'5A',5),(150,170,'1B',5),(150,170,'2B',5),(150,170,'3B',5),
(150,170,'4B',5),
(110.5,170,'1A',2),(110.5,170,'2A',2),(110.5,170,'3A',1),(110.5,170,'4A',1),
(110.5,170,'1B',1),(110.5,170,'1B',1),(110.5,170,'2B',1),(110.5,170,'3B',1),
(110.5,170,'4B',1),(110.5,170,'5B',1),(150,170,'1A',5),
(150,170,'2A',5),(150,170,'3A',5),(150,170,'4A',5),
(150,170,'5A',5),(150,170,'1B',5),(150,170,'2B',5),
(150,170,'3B',5),(150,170,'4B',5);

alter table consumers
add column consumer_id Integer;

alter table consumers
drop column consumer_id;


alter table consumers
add column consumer_id Integer not null default 0;

alter table consumers
add constraint pk_cons primary key(consumer_id);

alter table tickets
add constraint fk_consumer foreign key (consumer_id) references consumers(consumer_id);


select distinct e.event_id,name
from tickets t join events e on (t.EVENT_ID = e.EVENT_ID);
select * from events e join locations l on (e.location_id = l.id);




