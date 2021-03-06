--------------------------------------------------------
--  File created - Sat-Oct-27-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ECB_OPERATIONS
--------------------------------------------------------

  CREATE TABLE "ECB_OPERATIONS" 
   (	"ID" NUMBER, 
	"TYPE" VARCHAR2(30),
    "USER_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
--------------------------------------------------------
--  DDL for Sequence ECB_OPERATIONS_SEQ
--------------------------------------------------------

CREATE SEQUENCE  "ECB_OPERATIONS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER  NOCYCLE ;
Insert into ECB_OPERATIONS (ID,TYPE,USER_ID) values (1,'AUCTION',1);
Insert into ECB_OPERATIONS (ID,TYPE,USER_ID) values (2,'SELL',1);

--------------------------------------------------------
--  DDL for Index ECB_OPERATIONS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ECB_OPERATIONS_PK" ON "ECB_OPERATIONS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

--------------------------------------------------------
--  DDL for Trigger ECB_OPERATIONS_TRG
--------------------------------------------------------

CREATE OR REPLACE TRIGGER "ECB_OPERATIONS_TRG" 
BEFORE INSERT ON ECB_OPERATIONS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT ECB_OPERATIONS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "ECB_OPERATIONS_TRG" ENABLE;

--------------------------------------------------------
--  Constraints for Table ECB_OPERATIONS
--------------------------------------------------------

  ALTER TABLE "ECB_OPERATIONS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ECB_OPERATIONS" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "ECB_OPERATIONS" ADD CONSTRAINT "ECB_OPERATIONS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;