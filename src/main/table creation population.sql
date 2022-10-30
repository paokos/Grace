drop schema if exists grace;
create schema grace;
use grace;

create table carrello(
    cartID int primary key auto_increment
);

create table utente(
    id int primary key auto_increment,
    nome varchar(20) not null,
    cognome varchar(20) not null,
    indirizzo varchar(50),
    email varchar(40) not null unique,
    password char(40) not null,
    admin boolean default false,
    carrello int,
    foreign key(carrello) references carrello(cartID)
    on update cascade
    on delete set null
);

create table ordine(
    ordineID int primary key,
    indirizzo varchar(50) not null,
    data date not null,
    utente int,
    foreign key (utente) references utente(id)
    on update cascade
    on delete set null
);

create table prodotto(
    codice int primary key auto_increment,
    nome varchar (50) not null,
    prezzo double,
    colore varchar(30),
    taglia char(6),
    descrizione varchar(2048),
    disponibili int default 0,
    imgsrc varchar(2048)
);

create table carpro(
    cart int,
    prod int,
    quantita int,
    primary key(cart, prod),
    foreign key (cart) references carrello(cartID)
        on delete cascade
        on update cascade,
    foreign key (prod) references prodotto(codice)
        on update cascade
        on delete cascade
);

create table ordpro(
    cart int,
    prod int,
    quantita int,
    prezzo float,
    primary key(cart, prod),
    foreign key (cart) references carrello(cartID)
        on delete cascade
        on update cascade,
    foreign key (prod) references prodotto(codice)
        on delete cascade
        on update cascade
);

create table categoria(
    catId int primary key auto_increment,
    nome varchar(30),
    descrizione varchar(2048)
);

create table procat(
    prod int,
    cat int,
    primary key(prod, cat),
    foreign key (prod) references prodotto(codice)
        on delete cascade
        on update cascade,
    foreign key (cat) references categoria(catID)
        on delete cascade
        on update cascade
);

insert into categoria
values(null, "Uomo", "Uomo"),
(null, "Donna", null),
(null, "Bambino", null),
(null, "Cappotto", null),
(null, "Scarpe", null),
(null, "Sportivo", null),
(null, "Felpa", null),
(null, "T-Shirt", null),
(null, "Invernale", null),
(null, "Estivo", null),
(null, "Nuovo", null),
(null, "Pantalone", null),
(null, "Cargo", null),
(null, "Tuta", null),
(null, "Completo", null);

insert into carrello values
(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null),(null);
select * from carrello;

insert into utente values
(null, "Mario", "Rossi", "indirizzo", "mrossi@email.org", SHA1("mrossi"), true, 1);
(null, "", cognome, indirizzo, email, pass, true, 2),
(null, "", cognome, indirizzo, email, pass, false, 3),
(null, "", cognome, indirizzo, email, pass, false, 4),
(null, "", cognome, indirizzo, email, pass, false, 5);
select * from utente;

insert into ordine
values(null, 'indirizzo', str_to_date('ca', 'YYYY-MM-DD'), 1),
(null, 'indirizzo', str_to_date('ca', 'YYYY-MM-DD'), 1),
(null, 'indirizzo', str_to_date('ca', 'YYYY-MM-DD'), 3;
select * from ordine;

insert into prodotto values
(),
();