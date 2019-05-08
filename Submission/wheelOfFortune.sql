DROP TABLE Animals;
DROP TABLE Brands;
DROP TABLE Countries;
DROP TABLE Movies;

CREATE TABLE Animals
	(words varchar (25),
	hints varchar (50));
	
CREATE TABLE Brands
	(words varchar (25),
	hints varchar (50));
	
CREATE TABLE Countries
	(words varchar (25),
	hints varchar (50));
	
CREATE TABLE Movies
	(words varchar (25),
	hints varchar (50));

alter table Animals
add constraint Animals_words_pk primary key(words);

alter table Brands
add constraint Brands_words_pk primary key(words);

alter table Countries
add constraint Countries_words_pk primary key(words);

alter table Movies
add constraint Movies_words_pk primary key(words);