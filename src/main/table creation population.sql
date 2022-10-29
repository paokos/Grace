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