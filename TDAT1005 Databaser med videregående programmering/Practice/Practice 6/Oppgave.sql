/* -- Oppgave 1 -- */

/* Oppg. A 
Lag en SQL-spørring som utfører operasjonene seleksjon og projeksjon på tabellen Bok.
*/
-- Seleksjon
SELECT * FROM bok
WHERE utgitt_aar BETWEEN 1990 AND 1995; 

-- Projeksjon
SELECT tittel, utgitt_aar FROM bok; 

/* Oppg. B
Lag en SQL-spørring som utfører operasjonen produkt på tabellene Forlag og Bok.
Beskriv resultatet med egne ord.
*/
-- Det kartesiske produktet av de to tabelene. Alle mulig kombinasjoner av tuppler.
SELECT * FROM forlag, bok;

/* Oppg. C
Lag SQL-spørringer som utfører operasjonene likhetsforening (equijoin) og naturlig forening (natural join) på tabellene Forlag og Bok.
Hva forteller resultatet?
*/
-- Natural Join
-- Resultatet viser ??
SELECT * FROM forlag NATURAL JOIN bok

-- Equi Join, samme som inner join??
-- Resultatet viser info om forlag bøkene og forlagene tilknyttet de
SELECT *
FROM forlag, bok
WHERE forlag.forlag_id = bok.bok_id;

/* Oppg. D
Finn eksempler på attributter eller kombinasjoner av attributter som er unionkompatible.
*/
-- Disse attributtene er unionkompitable
-- Samme datatype og navn
forlag.forlag_id AND bok.forlag_id
forfatter.fornavn, forfatter.etternavn AND konsulent.fornavn, konsulent.etternavn

-- Eksempel på operajons, gir alle navnene som finnes i de to tabellene.
SELECT fornavn, etternavn FROM forfatter 
UNION 
SELECT fornavn, etternavn FROM konsulent


/* -- Oppgave 2 -- */

/* Oppg. A
Bruk SQL til å finne navnene til alle forlagene. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
*/
-- Projeksjon, alle unike navn fra forlag tabell
SELECT DISTINCT forlag_navn FROM forlag;

/* Oppg. B
Bruk SQL til å finne eventuelle forlag (forlag_id er nok) som ikke har gitt ut bøker. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
*/
-- Seleksjon og projeksjon, join??
SELECT * FROM forlag WHERE forlag.forlag_id NOT IN (SELECT forlag_id FROM bok);


/* Oppg. C
Bruk SQL til å finne forfattere som er født i 1948. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
*/
-- Seleksjon
SELECT * FROM `forfatter` WHERE fode_aar = 1948;

/* Oppg. D
Bruk SQL til å finne navn og adresse til forlaget som har gitt ut boka 'Generation X'. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
*/
-- Join
SELECT forlag_navn, adresse FROM forlag WHERE forlag_id 
IN 
(SELECT bok_id FROM bok WHERE bok.tittel LIKE 'Generation X');

/* Oppg. E
Bruk SQL til å finne titlene på bøkene som Hamsun har skrevet. Hvilken eller hvilke operasjoner fra relasjonsalgebraen brukte du?
*/
-- Join
SELECT tittel FROM bok WHERE bok_id 
IN (SELECT bok_id FROM bok_forfatter WHERE forfatter_id 
	IN (SELECT forfatter_id FROM forfatter WHERE etternavn = 'Hamsun')) 

/* Oppg. F
Bruk SQL til å finne informasjon om bøker og forlagene som har utgitt dem
*/
SELECT 
    bok.tittel AS 'Bok Tittel', 
    bok.utgitt_aar AS 'Utgitt År', 
    forlag.forlag_navn AS 'Forlag Navn',
    forlag.adresse AS 'Forlag Adresse',
    forlag.telefon AS 'Forlag Tlf'
FROM 
	forlag
LEFT OUTER JOIN bok ON 
	bok.forlag_id = forlag.forlag_id
ORDER BY 
	forlag.forlag_navn
