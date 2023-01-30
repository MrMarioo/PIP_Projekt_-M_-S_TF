Drop table Awaria;
Drop table zadanie;
Drop table Pojazd;
Drop table Specyfikacja;
Drop table Zlecenie;
Drop table Parametr;
Drop table Ustawienia;
Drop table Kontrahent;
Drop table Pracownik;
Drop table Uzytkownik;
Drop table RodzajAwarii;
Drop table TypKonta;
Drop table RodzajParametru;
Drop table RodzajPojazdu;
Drop sequence RodzajAwariiID;
Create sequence RodzajAwariiID
minvalue 0
start with 1
increment by 1;
Drop sequence uzytkownicyID;
Create sequence uzytkownicyID
minvalue 0
start with 1
increment by 1;
Drop sequence pracownicyID;
Create sequence pracownicyID
minvalue 0
start with 1
increment by 1;
Drop sequence ZlecenieID;
Create sequence ZlecenieID
minvalue 0
start with 1
increment by 1;
Drop sequence kontrahenciID;
Create sequence kontrahenciID
minvalue 0
start with 1
increment by 1;
Drop sequence zadaniaID;
Create sequence zadaniaID
minvalue 0
start with 1
increment by 1;
Drop sequence pojazdyID;
Create sequence pojazdyID
minvalue 0
start with 1
increment by 1;
CREATE TABLE RodzajPojazdu (
    IDRodzajPojazdu NUMERIC PRIMARY KEY,
    Nazwa NVARCHAR2(50),
    Opis NVARCHAR2(250)
);

CREATE TABLE RodzajParametru (
    IDRodzajuParametru NUMERIC PRIMARY KEY,
    Nazwa NVARCHAR2(50) NOT NULL,
    Wymagane NVARCHAR2(3) 
    --IN ('Tak' ,'Nie')
);

CREATE TABLE TypKonta (
    IDTypKonta NUMERIC PRIMARY KEY,
    Nazwa NVARCHAR2(50)
);

CREATE TABLE RodzajAwarii (
    IDRodzajuAwarii NUMERIC PRIMARY KEY,
    Nazwa NVARCHAR2(50),
    Priorytet NUMERIC
);

CREATE TABLE Uzytkownik (
    IDUzytkownika NUMERIC PRIMARY KEY,
    Imie NVARCHAR2(50),
    Nazwisko NVARCHAR2(50),
    TypKontaID NUMERIC,
    Login NVARCHAR2(50) UNIQUE,
    Haslo NVARCHAR2(50),
    CONSTRAINT UzytTypKonta_FK FOREIGN KEY (TypKontaID) REFERENCES TypKonta(IDTypKonta)
);

CREATE TABLE Pracownik (
    IDPracownika NUMERIC PRIMARY KEY,
    UzytkownikID NUMERIC,
    KierownikID NUMERIC,
    Status NVARCHAR2(50),
    CONSTRAINT PracUzyt_FK FOREIGN KEY (UzytkownikID) REFERENCES Uzytkownik(IDUzytkownika),
    CONSTRAINT PracKier_FK FOREIGN KEY (KierownikID) REFERENCES Uzytkownik(IDUzytkownika)
);

CREATE TABLE Kontrahent (
    IDKontrahenta NUMERIC PRIMARY KEY,
    UzytkownikID NUMERIC,
    Nazwa NVARCHAR2(50),
    CONSTRAINT KontrUzyt_FK FOREIGN KEY (UzytkownikID) REFERENCES Uzytkownik(IDUzytkownika)
);

CREATE TABLE Ustawienia (
    UzytkownikID NUMERIC,
    Jezyk NVARCHAR2(50),
    TrybCiemny NVARCHAR2(3),
    --IN ('Tak' ,'Nie')
    CONSTRAINT UstawUzyt_FK FOREIGN KEY (UzytkownikID) REFERENCES Uzytkownik(IDUzytkownika)
);

CREATE TABLE Parametr (
    IDParametru NUMERIC PRIMARY KEY,
    RodzajParametruID NUMERIC,
    Nazwa NVARCHAR2(50),
    Opis NVARCHAR2(250),
    Cena NVARCHAR2(50),
    Marka NVARCHAR2(50),
    Zdjecie NVARCHAR2(250),
    CONSTRAINT ParamRodzPar_FK FOREIGN KEY (RodzajParametruID) REFERENCES RodzajParametru(IDRodzajuParametru)
);

CREATE TABLE Zlecenie (
    IDZlecenia NUMERIC PRIMARY KEY,
    KontrahentID NUMERIC,
    Data DATE,
    Adres NVARCHAR2(50),
    Status NVARCHAR2(50),
    Cena FLOAT,
    RodzajPojazduID NUMERIC,
    CONSTRAINT ZlecenieRodzPoj_FK FOREIGN KEY (RodzajPojazduID) REFERENCES RodzajPojazdu(IDRodzajPojazdu),
    CONSTRAINT ZlecenieUzyt_FK FOREIGN KEY (KontrahentID) REFERENCES KONTRAHENT(IDKONTRAHENTA)
);

CREATE TABLE Specyfikacja (
    ParametrID NUMERIC,
    ZlecenieID NUMERIC,
    CONSTRAINT SpecParam FOREIGN KEY (ParametrID) REFERENCES Parametr(IDParametru),
    CONSTRAINT SpecZlec FOREIGN KEY (ZlecenieID) REFERENCES Zlecenie(IDZlecenia)
);

CREATE TABLE Pojazd (
    IDPojazdu NUMERIC PRIMARY KEY,
    RodzajID NUMERIC,
    ZlecenieID NUMERIC,
    Status NVARCHAR2(50),
    CONSTRAINT PojZlec_FK FOREIGN KEY (ZlecenieID) REFERENCES Zlecenie(IDZlecenia)
);

CREATE TABLE Zadanie (
    IDZadania NUMERIC PRIMARY KEY,
    PojazdID NUMERIC,
    PracownikID NUMERIC,
    Data DATE,
    Opis NVARCHAR2(50),
    Status NVARCHAR2(50),
    KierownikID NUMERIC,
    CONSTRAINT ZadPoj_FK FOREIGN KEY (PojazdID) REFERENCES Pojazd(IDPojazdu),
    CONSTRAINT ZadPrac_FK FOREIGN KEY (PracownikID) REFERENCES Pracownik(IDPracownika),
    CONSTRAINT ZadKier_FK FOREIGN KEY (KierownikID) REFERENCES Pracownik(IDPracownika)
);

CREATE TABLE Awaria (
    IDAwarii NUMERIC PRIMARY KEY,
    PojazdID NUMERIC,
    ZadanieID NUMERIC,
    Data DATE,
    RodzajAwariiID NUMERIC,
    Opis NVARCHAR2(50),
    Lokalizacja NVARCHAR2(50),
    Zdjecie NVARCHAR2(50),
    CONSTRAINT AwariaRodz_FK FOREIGN KEY (RodzajAwariiID) REFERENCES RodzajAwarii(IDRodzajuAwarii),
    CONSTRAINT AwariaPoj_FK FOREIGN KEY (PojazdID) REFERENCES Pojazd(IDPojazdu),
    CONSTRAINT AwariaZad_FK FOREIGN KEY (ZadanieID) REFERENCES Zadanie(IDZadania)
);
