update events
set start_date = CAST('2019-07-3' AS DATE)
where event_id = 3;

select * from TEODORA.EVENTS;
insert into events(event_id,name,description)
values(2,'Enrique Iglesias Concert','Enrique Iglesias  concerteaza in Cluj Napoca'),
(3,'The Cure Concert', 'The Cure si Editors concerteaza in Romania in cadrul God is an astronaut Tour 2019');

create table locations(
        id integer primary key,
        name varchar(25) not null,
        city varchar(25)
 );

alter table locations
add (country varchar(25));

alter table locations
add country varchar(25);

alter table locations
add myid integer);
select * 
from events e right join locations l on  (e.LOCATION_ID = l.id);
update events
set start_date = CAST('2019-07-3' AS DATE)
where event_id = 3;
update events
set end_date = CAST('2019-07-5' AS DATE)
where event_id = 3;
update events
set name = "Ed Sheeran Concert"
where event_id = 1;

alter table locations
drop column myid;

insert into events 
values (9,'Răzbunătorii care au supraviețuit decimării provocate de Thanos cu un simplu pocnet din degete: adică Thor, Black Widow, Captain America și Bruce Banner încearcă să găsească o 
cale de a-și salva prietenii si aliații',cast('2019-5-10' as date),cast('2019-5-12' as date),'Avengers: Endgame',6);