--------------------------------------------------------
--  File created - Sat-Oct-27-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ECB_ORDER
--------------------------------------------------------

  CREATE TABLE "ECB_ORDER" 
   (	"ID" NUMBER, 
	"PURCHASE_DATE" DATE DEFAULT SYSDATE NOT NULL,
    "USER_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Sequence ECB_ORDER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ECB_ORDER_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER  NOCYCLE ;
Insert into ECB_ORDER (ID,PURCHASE_DATE,USER_ID) values (1,to_date('04-NOV-17','DD-MON-RR'),1);

--------------------------------------------------------
--  DDL for Index ECB_ORDER_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ECB_ORDER_PK" ON "ECB_ORDER" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

--------------------------------------------------------
--  DDL for Trigger ECB_ORDER_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "ECB_ORDER_TRG" 
BEFORE INSERT ON ECB_ORDER 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT ECB_ORDER_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "ECB_ORDER_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table ECB_ORDER
--------------------------------------------------------

  ALTER TABLE "ECB_ORDER" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "ECB_ORDER" MODIFY ("PURCHASE_DATE" NOT NULL ENABLE);
  ALTER TABLE "ECB_ORDER" ADD CONSTRAINT "ECB_ORDER_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;