CREATE TABLE IF NOT EXISTS todos (
    id serial,
    task text not null,
    status text not null,
	PRIMARY KEY( id )
);

insert into todos (task, status) values ('JJUG CCCのスライドを作る', 'Doing');
insert into todos (task, status) values ('動画を作る', 'Waiting');
