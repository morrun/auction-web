--------------------------------------------------------
--  File created - Thu-Sep-25-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ECB_USER
--------------------------------------------------------

  CREATE TABLE "ECB_USER" 
   (	"USEREMAIL" VARCHAR2(320 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
    "USERPHONENUMBER" VARCHAR2(100 BYTE),
    "IMAGE" BLOB,
    "ACTIVATED" NUMBER(1,0),
    "CREDITS" NUMBER,
    "BIRTHDAY" DATE,
    "REGISTEREDDATE" DATE,
	"ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Sequence ECB_USER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ECB_USER_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into ECB_USER
SET DEFINE OFF;
Insert into ECB_USER (USEREMAIL,PASSWORD,USERPHONENUMBER,IMAGE,ACTIVATED,CREDITS,BIRTHDAY,REGISTEREDDATE,ID) 
values ('luckzh94@gmail.com','$2a$11$q1sf5mUd1XwOmn6JQu6Zme0vs.ovSe2wU8TqlCFkcpOs89RUgObXG','2023554567',''
,1,4,TO_DATE('1994/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2018/10/25 10:31:22', 'yyyy/mm/dd hh24:mi:ss'),1);
Insert into ECB_USER (USEREMAIL,PASSWORD,USERPHONENUMBER,IMAGE,ACTIVATED,CREDITS,BIRTHDAY,REGISTEREDDATE,ID) 
values ('liuzihao0121@gmail.com','$2a$11$MUm8qXqbWK0F3NqPoZzGme7lsCzuj7gROE5PWpqjwQ/1p7czRx3Ae','2023554567',''
,1,4,TO_DATE('1994/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),TO_DATE('2018/10/25 10:31:22', 'yyyy/mm/dd hh24:mi:ss'),2);
Insert into ECB_USER (USEREMAIL,PASSWORD,USERPHONENUMBER,IMAGE,ACTIVATED,CREDITS,BIRTHDAY,REGISTEREDDATE,ID) 
values ('zihao1@yahoo.com','$2a$11$GFOqKK8jG3xG0aM4pOHjr.V3pa504tSDUAu6sm6sfFH3vegtEqfcS','2023554567',''
,1,4,TO_DATE('1994/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),'',3);
--Insert into ECB_USER (USEREMAIL,PASSWORD,USERPHONENUMBER,IMAGE,ACTIVATED,CREDITS,BIRTHDAY,REGISTEREDDATE,ID) values ('user','$2a$11$GFOqKK8jG3xG0aM4pOHjr.V3pa504tSDUAu6sm6sfFH3vegtEqfcS',3);
--------------------------------------------------------
--  DDL for Index ECB_USER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ECB_USER_PK" ON "ECB_USER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index ECB_USER_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ECB_USER_UK1" ON "ECB_USER" ("USEREMAIL") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Trigger ECB_USER_TRG
--------------------------------------------------------
CREATE OR REPLACE TRIGGER "ECB_USER_TRG" 
BEFORE INSERT ON ECB_USER 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.USEREMAIL IS NULL THEN
      SELECT ECB_USER_SEQ.NEXTVAL INTO :NEW.USEREMAIL FROM SYS.DUAL;
    END IF;
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT ECB_USER_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;    
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "ECB_USER_TRG" ENABLE;

-- CREATE OR REPLACE TRIGGER "ECB_USER_TRG1" 
-- AFTER INSERT ON ECB_USER 
-- FOR EACH ROW 
-- BEGIN
--  <<COLUMN_SEQUENCES>>
--  BEGIN
--    IF INSERTING AND :NEW.REGISTEREDDATE IS NULL OR :NEW.REGISTEREDDATE='' THEN
--      :NEW.REGISTEREDDATE := NOW();
--    END IF;    
--  END COLUMN_SEQUENCES;
-- END;
-- /
-- ALTER TRIGGER "ECB_USER_TRG1" ENABLE;
-- DROP TRIGGER ECB_USER_TRG1;
--------------------------------------------------------
--  Constraints for Table MSI_USER
--------------------------------------------------------

  ALTER TABLE "ECB_USER" MODIFY ("USEREMAIL" NOT NULL ENABLE);
  ALTER TABLE "ECB_USER" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "ECB_USER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ECB_USER" ADD CONSTRAINT "ECB_USER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ECB_USER" ADD CONSTRAINT "ECB_USER_UK1" UNIQUE ("USEREMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
 