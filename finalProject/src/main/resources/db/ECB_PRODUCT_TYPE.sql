--------------------------------------------------------
--  File created - Sat-Oct-27-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ECB_PRODUCT_TYPE
--------------------------------------------------------

  CREATE TABLE "ECB_PRODUCT_TYPE" 
   (	"ID" NUMBER, 
	"TYPE" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

--------------------------------------------------------
--  DDL for Sequence ECB_PRODUCT_TYPE_SEQ
--------------------------------------------------------

CREATE SEQUENCE  "ECB_PRODUCT_TYPE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into ECB_PRODUCT_TYPE
SET DEFINE OFF;
Insert into ECB_PRODUCT_TYPE (ID,TYPE) values (1,'PHONE');
Insert into ECB_PRODUCT_TYPE (ID,TYPE) values (2,'FURNITURE');
--------------------------------------------------------
--  DDL for Index ECB_PRODUCT_TYPE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ECB_PRODUCT_TYPE_PK" ON "ECB_PRODUCT_TYPE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index ECB_PRODUCT_TYPE_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "ECB_PRODUCT_TYPE_UK1" ON "ECB_PRODUCT_TYPE" ("TYPE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
--------------------------------------------------------
--  DDL for Trigger ECB_PRODUCT_TYPE_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "ECB_PRODUCT_TYPE_TRG" 
BEFORE INSERT ON ECB_PRODUCT_TYPE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT ECB_PRODUCT_TYPE_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "ECB_PRODUCT_TYPE_TRG" ENABLE;

--------------------------------------------------------
--  Constraints for Table MSI_USER_PROFILE
--------------------------------------------------------

  ALTER TABLE "ECB_PRODUCT_TYPE" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ECB_PRODUCT_TYPE" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "ECB_PRODUCT_TYPE" ADD CONSTRAINT "ECB_PRODUCT_TYPE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ECB_PRODUCT_TYPE" ADD CONSTRAINT "ECB_PRODUCT_TYPE_UK1" UNIQUE ("TYPE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
