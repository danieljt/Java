%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
KOMMENTAR TIL OPPGAVEN MED EGENVURDERING
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
Her er andre forsøk, og de kritiske tilbakemeldingene som ble gitt etter første forsøk skal 
være fikset. Har også fikset på noen av de ukritiske tilbakemeldingene. Nå har jeg også
implementert en metode for å skrive forandringer gjort i programmet til dvdarkiv.txt filen 
etter kjøring. Har tatt noen testrunder med programmet og det ser ut til å fungere fint.
Det tok ca 4 timer å rette på alt da jeg måtte skrive om på mye av grunnstrukturen,
men implementeringen gitt en god del lettere denne gangen.

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
OVERSIKT AV OPPBYGGINGEN AV PRORAMMET
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

DVDAdministrasjon:
--------------------------------------------------------------------------------------- 
Dette er hovedprogrammet for administrasjonen. Her gjøres alle administrative oppgaver.
Registrering av personer, administrering av utlån og retur og kjøp av dvder. Administrasjonen
er slik at den ha 0 til flere personer registrert. Administrasjonen har også tilgang til alle
personer og deres dvder. 


Klassen har følgende attributter og metoder:

HashMap<String, Person> navneliste : Liste over alle personene i arkivet

lesarkiv()                         : Leser arkiv metoden og legger inn i systemet
meny()                             : Setter i gang kommandoløkken og deninteraktive menyen
skrivarkiv()                       : Skriver alle forandringer til arkivfilen


Person:
---------------------------------------------------------------------------------------
Dette er klassen for en person. Programmet har informasjon om navnet, hvilke dvder
personen eier og hvilke personer han låner ut dvder til og hvem han låner fra. Her er også
metodene for å låne bort, låne, gi tilbake og motta DVD-er. Klassen er bygget slik at:
1) En person kan eie 0 til flere dvder med ulike titteler
2) En person kan ikke låne en dvd som personen allerede har
3) En person kan ikke eie flere kopier av samme tittel


Klassen har følgende attributter og metoder:

HashMap<String, DVD> arkiv           : Liste over eide DVD-er
HashMap<String, DVD> utlant          : Liste over utlånte DVD-er
HashMap<String, DVD> lant            : Liste over lånte DVD-er

kjop(String tittel)                  : Registrerer en ny DVD og legger til eier listen
laanut(String tittel, Person laaner) : Reistrerer et utlån av en DVD
laan(DVD film, Person Utlaaner)      : Registrerer et lån av en DVD, returnerer Boolean
retur(String tittel)                 : Registrerer en tilbaelevering av en DVD
motta(DVD film)                      : Registrerer et mottakav en DVD
oversikt()                           : Printer en oversikt over eide, lånte og utlånte DVD-er
statistikk()                         : Printer antall eide, utlånte og lånte DVD-er
navn()                               : Gir navnet til Personen i String format
arkiv()                              : Gir DVD arkivet til personen som et HashMap
utlant()                             : Gir utlånt arkivet til personen som et HashMap
lant()                               : Gir lånt arkivet til personen som et HashMap


DVD:
---------------------------------------------------------------------------------------
Dette er klassen for DVD objekter. Klassen lager et nytt objekt av typen DVD
med tittelen, eieren og hvem som evt låner den. En DVD kan kun eies av én person,
og er enten hos eieren eller hos den evt personen som låner den

Klassen har følgende attributter og metoder

String tittel   : Tittelen på DVD-en
Person eier     : Eieren av DVD-en
Person laner    : Personen som evt låner DVD-en, eller null

tittel(String)  : Gir tittelen til filmen
eier(Person)    : Gir eieren til DVD-en
utlaant()       : Gir posisjonen til DVD-en
flytt(Person)   : Flytter DVD-en til en utlaaner(Person) eller tilbake til eieren(null)
				    
				
