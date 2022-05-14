CREATE TABLE IF NOT EXISTS todos (
    id serial,
    task text not null,
    status text not null,
	PRIMARY KEY( id )
);
