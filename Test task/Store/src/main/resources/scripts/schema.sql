CREATE TABLE CONTACT (
) ;
ID INT NOT NULL АОТО INCREMENT
, FIRST_NAME VARCHAR(6O) NOT NULL
, LAST_NAME VARCHAR(40) NOT NULL
, BIRTH_DATE DATE
, VERSION INT NOT NULL DEFAULT О
, UNIQUE UQ_CONTACT_l (FIRST_NAME, LAST_NAME)
, PRIMARY KEY (ID)
CREATE TABLE HOBBY (
) ;
HOBBY_ID VARCHAR(20) NOT NULL
, PRIMARY KEY (HOBBY_ID)
CREATE TABLE CONTACT TEL DETAIL
ID INT NOT NOLL АОТО INCREMENT
) ;
, CONTACT ID INT NOT NULL
, TEL_ТУРЕ VARCHAR ( 20) NOT NULL
, TEL NUMBER VARCHAR ( 20) NOT NULL
, VERSION INT NOT NULL DEFAULT 0
, UNIQUE UQ_CONTACT_TEL_DETAIL_l (CONTACT_ID, TEL_TYPE)
, PRIMARY KEY (ID)
, CONSTRAINT FK_CONTACT_TEL_DETAIL_l FOREIGN KEY (CONTACT_ID)
REFERENCES CONTACT (ID);
CREATE TABLE CONTACT_HOBBY_DETAIL (
CONTACT ID INT NOT NULL
, HOBBY_ID VARCHAR(20) NOT NULL
, PRIMARY KEY (CONTACT_ID, HOBBY_ID)
, CONSTRAINT FK CONTACT HOBBY DETAIL 1 FOREIGN KEY (CONTACT_ID)
REFERENCES CONTACT (ID) ON DELETE CASCADE
, CONSTRAINT FK CONTACT_HOBBY DETAIL 2 FOREIGN KEY (HOBBY_ID)
RE REFERENCES HOBBY ( HOBBY ID)
) ;