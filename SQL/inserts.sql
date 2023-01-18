--RODZPARAM
INSERT INTO RodzajParametru VALUES (1,'Silnik', 'tak');
INSERT INTO RodzajParametru VALUES (2,'Skrzynia Biegów', 'tak');
INSERT INTO RodzajParametru VALUES (3,'Hamulce', 'tak');
INSERT INTO RodzajParametru VALUES (4,'Podwozie', 'tak');
INSERT INTO RodzajParametru VALUES (5,'Nadwozie', 'tak');
INSERT INTO RodzajParametru VALUES (6,'Pompa Wodna', 'tak');
INSERT INTO RodzajParametru VALUES (7,'Pompa Pianowa', 'nie');
INSERT INTO RodzajParametru VALUES (8,'Wysięgnik', 'nie');
INSERT INTO RodzajParametru VALUES (9,'Klimatyzacja', 'nie');
INSERT INTO RodzajParametru VALUES (10,'GPS', 'nie');
INSERT INTO RodzajParametru VALUES (11,'Zawieszenie', 'tak');

--PARAM
INSERT INTO Parametr VALUES (1,1,'Silnik Diesel 2.0', 'opis Mercedes Silnik Diesel 2.0', 5000, 'Mercedes', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (2,1,'Silnik Diesel 2.0', 'opis VOLVO Silnik Diesel 2.0', 4000,'VOLVO', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (3,1,'Silnik Diesel 2.0', 'opis M.A.N. Silnik Diesel 2.0', 6000,'M.A.N.', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (4,1,'Silnik Diesel 3.0', 'opis Mercedes Silnik Diesel 3.0', 7000, 'Mercedes', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (5,1,'Silnik Diesel 3.0', 'opis VOLVO Silnik Diesel 3.0', 6000,'VOLVO', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (6,1,'Silnik Diesel 3.0', 'opis M.A.N. Silnik Diesel 3.0', 8000,'M.A.N.', 'https://pin.it/kE3ks2d');

INSERT INTO Parametr VALUES (7,2,'Manualna Skrzynia Biegów', 'opis 7-dmio biegowa manualna skrzynia biegów', 5000, 'Mercedes', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (8,2,'Manualna Skrzynia Biegów', 'opis 7-dmio biegowa manualna skrzynia biegów', 5000, 'VOLVO', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (9,2,'Manualna Skrzynia Biegów', 'opis 7-dmio biegowa manualna skrzynia biegów', 5000, 'Eaton', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (10,2,'Automatyczna Skrzynia Biegów', 'opis skrzynia biegów samoczynnie zmieniająca
biegi w zależności od obciążenia silnika pojazdu, zwalniając użytkownika z konieczności ręcznej zmiany biegów. ', 8000,'VOLVO', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (11,2,'Automatyczna Skrzynia Biegów', 'opis skrzynia biegów samoczynnie zmieniająca
biegi w zależności od obciążenia silnika pojazdu, zwalniając użytkownika z konieczności ręcznej zmiany biegów. ', 7000,'Voith', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (12,2,'Automatyczna Skrzynia Biegów', 'opis skrzynia biegów samoczynnie zmieniająca
biegi w zależności od obciążenia silnika pojazdu, zwalniając użytkownika z konieczności ręcznej zmiany biegów. ', 9000,'ZF', 'https://pin.it/kE3ks2d');

INSERT INTO Parametr VALUES (13,3,'Hamulce hydrauliczne tarczowe ', 'opis hamulce hyfrauliczne o budowie tarczowej', 3000, 'TRW', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (14,3,'Hamulce hydrauliczne bębnowe', 'opis hamulce hyfrauliczne o budowie bębnowe', 4000, 'EATE', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (15,3,'Hamulce pneumatyczne tarczowe ', 'opis hamulce pneumatyczne o budowie tarczowej', 3500, 'Brembo', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (16,3,'Hamulce pneumatyczne bębnowe', 'opis hamulce pneumatyczne o budowie bębnowe', 4500, 'Textar', 'https://pin.it/kE3ks2d');

INSERT INTO Parametr VALUES (17,4,'Rama podluznicowa 4x2', 'opis podwozie pojazdu oparte na budowie podluznicowej w ukladzie 4x2', 4500, 'Mercedes', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (18,4,'Rama krzyżowa 6x4', 'opis podwozie pojazdu oparte na budowie krzyzowej w ukladzie 6x4', 4500, 'VOLVO', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (19,4,'Rama kratownicowa 4x4', 'opis podwozie pojazdu oparte na budowie kratownicowej w ukladzie 4x4', 4500, 'M.A.N.', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (20,4,'Rama centralna 6x6', 'opis podwozie pojazdu oparte na budowie centralnej w ukladzie 6x6', 4500, 'M.A.N.', 'https://pin.it/kE3ks2d');
INSERT INTO Parametr VALUES (21,4,'Rama plytowa 4x4', 'opis podwozie pojazdu oparte na budowie plytowej w ukladzie 4x4', 4500, 'VOLVO', 'https://pin.it/kE3ks2d');

--TypKonta
    INSERT INTO TypKonta Values  (1, 'Admin');
    INSERT INTO TypKonta Values  (2, 'Kierownik');
    INSERT INTO TypKonta Values  (3, 'Pracownik fizyczny');
    INSERT INTO TypKonta Values  (4, 'Dział handlowy');
    INSERT INTO TypKonta Values  (5, 'Serwisant');
    INSERT INTO TypKonta Values  (6, 'Kontrahent');
    INSERT INTO TypKonta Values  (7, 'Użytkownik');
--RodzajPojazdu
INSERT INTO rodzajPojazdu Values (1, 'lekki miejski wóz strażacki', 'Pojazd strażacki o wadze do 7.5 tony przeznaczony do poruszania się po drogach o utwardzonej nawierzchni');
INSERT INTO rodzajPojazdu Values (2, 'lekki uterenowiony wóz strażacki', 'Pojazd strażacki o wadze do 7.5 tony który może jeździć po drogach o twardej nawierzchni, ale też w ograniczonym zakresie poza nimi');
INSERT INTO rodzajPojazdu Values (3, 'lekki terenowy samochód pożarniczy', 'Pojazd strażacki o wadze do 7.5 tony zdolny do poruszania się po każdej drodze i bezdrożach');
INSERT INTO rodzajPojazdu Values (4, 'średni miejski wóz strażacki', 'Pojazd strażacki o wadze od 7.5 do 14 ton  przeznaczony do poruszania się po drogach o utwardzonej nawierzchni');
INSERT INTO rodzajPojazdu Values (5, 'średni uterenowiony wóz strażacki', 'Pojazd strażacki o wadze od 7.5 do 14 ton tony który może jeździć po drogach o twardej nawierzchni, ale też w ograniczonym zakresie poza nimi');
INSERT INTO rodzajPojazdu Values (6, 'średni terenowy samochód pożarniczy', 'Pojazd strażacki o wadze od 7.5 do 14 ton zdolny do poruszania się po każdej drodze i bezdrożach');
INSERT INTO rodzajPojazdu Values (7, 'ciężki miejski wóz strażacki', 'Pojazd strażacki o wadze powyżej 14 ton przeznaczony do poruszania się po drogach o utwardzonej nawierzchni');
INSERT INTO rodzajPojazdu Values (8, 'ciężki uterenowiony wóz strażacki', 'Pojazd strażacki o wadze powyżej 14 ton tony który może jeździć po drogach o twardej nawierzchni, ale też w ograniczonym zakresie poza nimi');
INSERT INTO rodzajPojazdu Values (9, 'ciężki terenowy samochód pożarniczy', 'Pojazd strażacki o wadze powyżej 14 ton zdolny do poruszania się po każdej drodze i bezdrożach');

Drop sequence RodzajAwariiID;
Create sequence RodzajAwariiID
minvalue 0
start with 1
increment by 1;

--RodzajAwari
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Pęknięta opona', 1);
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Usterka sprzęgła', 1);
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Awaria silnika', 1);
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Awaria hamulców', 1);
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Zapchany filtr DPF', 2);
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Hałasujacy pasek', 2);
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Stuki z zawieszenia', 2);
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Pęknięta szyba przednia', 1);
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Pęknięta szyba boczna', 3);
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Dziurawy waż', 1);
    INSERT INTO RodzajAwarii Values (RodzajAwariiID.nextVal, 'Spalona żarówka', 3);
--Uzytkownik
Drop sequence uzytkownicyID;
Create sequence uzytkownicyID
minvalue 0
start with 1
increment by 1;

INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie1','nazwisko1','6','login1','haslo1');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie2','nazwisko2','4','login2','haslo2');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie3','nazwisko3','3','login3','haslo3');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie4','nazwisko4','6','login4','haslo4');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie5','nazwisko5','4','login5','haslo5');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie6','nazwisko6','7','login6','haslo6');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie7','nazwisko7','7','login7','haslo7');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie8','nazwisko8','4','login8','haslo8');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie9','nazwisko9','5','login9','haslo9');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie10','nazwisko10','4','login10','haslo10');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie11','nazwisko11','4','login11','haslo11');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie12','nazwisko12','5','login12','haslo12');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie13','nazwisko13','1','login13','haslo13');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie14','nazwisko14','7','login14','haslo14');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie15','nazwisko15','4','login15','haslo15');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie16','nazwisko16','4','login16','haslo16');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie17','nazwisko17','7','login17','haslo17');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie18','nazwisko18','2','login18','haslo18');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie19','nazwisko19','3','login19','haslo19');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie20','nazwisko20','3','login20','haslo20');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie21','nazwisko21','1','login21','haslo21');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie22','nazwisko22','3','login22','haslo22');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie23','nazwisko23','6','login23','haslo23');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie24','nazwisko24','6','login24','haslo24');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie25','nazwisko25','3','login25','haslo25');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie26','nazwisko26','4','login26','haslo26');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie27','nazwisko27','5','login27','haslo27');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie28','nazwisko28','6','login28','haslo28');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie29','nazwisko29','5','login29','haslo29');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie30','nazwisko30','3','login30','haslo30');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie31','nazwisko31','4','login31','haslo31');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie32','nazwisko32','6','login32','haslo32');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie33','nazwisko33','1','login33','haslo33');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie34','nazwisko34','1','login34','haslo34');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie35','nazwisko35','3','login35','haslo35');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie36','nazwisko36','2','login36','haslo36');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie37','nazwisko37','7','login37','haslo37');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie38','nazwisko38','7','login38','haslo38');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie39','nazwisko39','2','login39','haslo39');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie40','nazwisko40','1','login40','haslo40');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie41','nazwisko41','6','login41','haslo41');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie42','nazwisko42','1','login42','haslo42');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie43','nazwisko43','4','login43','haslo43');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie44','nazwisko44','2','login44','haslo44');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie45','nazwisko45','7','login45','haslo45');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie46','nazwisko46','5','login46','haslo46');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie47','nazwisko47','4','login47','haslo47');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie48','nazwisko48','2','login48','haslo48');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie49','nazwisko49','1','login49','haslo49');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie50','nazwisko50','3','login50','haslo50');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie51','nazwisko51','5','login51','haslo51');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie52','nazwisko52','1','login52','haslo52');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie53','nazwisko53','6','login53','haslo53');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie54','nazwisko54','4','login54','haslo54');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie55','nazwisko55','7','login55','haslo55');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie56','nazwisko56','2','login56','haslo56');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie57','nazwisko57','3','login57','haslo57');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie58','nazwisko58','6','login58','haslo58');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie59','nazwisko59','3','login59','haslo59');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie60','nazwisko60','7','login60','haslo60');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie61','nazwisko61','3','login61','haslo61');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie62','nazwisko62','7','login62','haslo62');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie63','nazwisko63','2','login63','haslo63');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie64','nazwisko64','6','login64','haslo64');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie65','nazwisko65','3','login65','haslo65');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie66','nazwisko66','6','login66','haslo66');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie67','nazwisko67','6','login67','haslo67');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie68','nazwisko68','7','login68','haslo68');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie69','nazwisko69','7','login69','haslo69');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie70','nazwisko70','4','login70','haslo70');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie71','nazwisko71','5','login71','haslo71');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie72','nazwisko72','5','login72','haslo72');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie73','nazwisko73','4','login73','haslo73');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie74','nazwisko74','3','login74','haslo74');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie75','nazwisko75','2','login75','haslo75');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie76','nazwisko76','3','login76','haslo76');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie77','nazwisko77','2','login77','haslo77');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie78','nazwisko78','4','login78','haslo78');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie79','nazwisko79','3','login79','haslo79');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie80','nazwisko80','5','login80','haslo80');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie81','nazwisko81','6','login81','haslo81');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie82','nazwisko82','2','login82','haslo82');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie83','nazwisko83','1','login83','haslo83');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie84','nazwisko84','5','login84','haslo84');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie85','nazwisko85','1','login85','haslo85');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie86','nazwisko86','3','login86','haslo86');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie87','nazwisko87','4','login87','haslo87');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie88','nazwisko88','5','login88','haslo88');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie89','nazwisko89','7','login89','haslo89');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie90','nazwisko90','1','login90','haslo90');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie91','nazwisko91','7','login91','haslo91');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie92','nazwisko92','2','login92','haslo92');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie93','nazwisko93','7','login93','haslo93');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie94','nazwisko94','1','login94','haslo94');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie95','nazwisko95','1','login95','haslo95');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie96','nazwisko96','7','login96','haslo96');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie97','nazwisko97','2','login97','haslo97');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie98','nazwisko98','1','login98','haslo98');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie99','nazwisko99','2','login99','haslo99');
INSERT INTO Uzytkownik Values (uzytkownicyID.nextVal,'imie100','nazwisko100','6','login100','haslo100');


--Pracownik
    Drop sequence pracownicyID;
    Create sequence pracownicyID
    minvalue 0
    start with 1
    increment by 1;

INSERT INTO Pracownik Values (pracownicyID.nextVal,'1',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'2',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'3',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'5',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'6',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'8',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'9',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'10',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'11',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'17',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'18',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'19',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'22',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'23',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'25',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'26',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'27',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'30',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'32',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'33',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'35',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'36',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'38',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'40',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'44',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'45',11,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'46',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'47',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'48',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'51',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'53',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'55',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'56',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'60',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'61',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'62',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'63',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'64',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'66',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'67',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'69',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'70',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'72',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'73',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'74',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'75',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'76',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'78',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'79',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'80',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'81',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'84',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'85',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'86',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'87',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'89',null,'Wolny');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'91',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'92',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'94',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'96',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'97',null,'Zajety');
INSERT INTO Pracownik Values (pracownicyID.nextVal,'98',null,'Wolny');
---
Drop sequence ZlecenieID;
Create sequence ZlecenieID
minvalue 0
start with 1
increment by 1;

INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'1','2022-9-10','ul. Krakowska 12, 31-150 Kraków','zakonczony','25225','6');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'4','2022-9-13','ul. Wrocławska 22, 50-001 Wrocław','w trakcie rozparzenia','19133','4');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'23','2022-9-16','ul. Gdańska 32, 80-001 Gdańsk','odrzucony','19983','4');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'24','2022-9-17','ul. Szczecińska 52, 70-001 Szczecin','w trakcie rozparzenia','22720','2');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'28','2022-9-13','ul. Krakowska 12, 31-150 Kraków','w trakcie rozparzenia','11020','5');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'32','2022-9-17','ul. Gdańska 32, 80-001 Gdańsk','w trakcie rozparzenia','21233','2');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'41','2022-9-10','ul. Gdańska 32, 80-001 Gdańsk','zakonczony','18566','3');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'53','2022-9-14','ul. Bydgoska 62, 85-001 Bydgoszcz','zakonczony','24354','6');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'58','2022-9-11','ul. Wrocławska 22, 50-001 Wrocław','zaakceptowany','18710','5');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'64','2022-9-17','ul. Krakowska 12, 31-150 Kraków','w trakcie rozparzenia','27782','5');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'66','2022-9-11','ul. Poznańska 15, 60-001 Poznań','zaakceptowany','28769','7');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'67','2022-9-12','ul. Wrocławska 22, 50-001 Wrocław','odrzucony','13455','1');
INSERT INTO Zlecenie Values (ZlecenieID.nextVal,'81','2022-9-10','ul. Lubelska 72, 20-001 Lublin','zakonczony','20434','4');

---
Drop sequence kontrahenciID;
Create sequence kontrahenciID
minvalue 0
start with 1
increment by 1;

INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'1','Państwowa Straż Pożarna');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'4','Miasto Kielce');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'23','Gmina Daleszyce');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'24','Gmina Górno');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'28','Narodowa Straż Leśna');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'32','Koleje Państwowe');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'41','Miasto Kraków');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'53','Przedsiębiorstwo Energetyczne');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'58','Państwowa Straż Pożarna');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'64','Miasto Kielce');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'66','Gmina Daleszyce');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'67','Gmina Górno');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'81','Narodowa Straż Leśna');
INSERT INTO Kontrahent Values (kontrahenciID.nextVal,'100','Koleje Państwowe');


