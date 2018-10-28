--------------------------------------------------------
--  DDL for Table ECB_OPERATIONS_HISTORY
--------------------------------------------------------

  CREATE TABLE "ECB_OPERATIONS_HISTORY" 
   (	
   "ID" NUMBER, 
	"OPERATIONS_ID" NUMBER, 
	"PRODUCT_ID" NUMBER,
    "OPERATION_DATE" DATE DEFAULT SYSDATE NOT NULL,
    "PRICE" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
  
--------------------------------------------------------
--  DDL for Sequence ECB_OPERATIONS_HISTORY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ECB_OPERATIONS_HISTORY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER  NOCYCLE ;
   Insert into ECB_OPERATIONS_HISTORY (ID,OPERATIONS_ID,PRODUCT_ID,PRICE) values (1,1,1,900);
   Insert into ECB_OPERATIONS_HISTORY (ID,OPERATIONS_ID,PRODUCT_ID,PRICE) values (2,2,2,1120);
   
--------------------------------------------------------
--  DDL for Index ECB_OPERATIONS_HISTORY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ECB_OPERATIONS_HISTORY_PK" ON "ECB_OPERATIONS_HISTORY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  

--------------------------------------------------------
--  DDL for Trigger ECB_ORDER_PRODUCT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "ECB_OPERATIONS_HISTORY_TRG" 
BEFORE INSERT ON ECB_OPERATIONS_HISTORY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT ECB_OPERATIONS_HISTORYT_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;


/
ALTER TRIGGER "ECB_OPERATIONS_HISTORY_TRG" ENABLE;

--------------------------------------------------------
--  Constraints for Table ECB_OPERATIONS_HISTORY
--------------------------------------------------------

  ALTER TABLE "ECB_OPERATIONS_HISTORY" ADD CONSTRAINT "ECB_OPERATIONS_HISTORY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ECB_OPERATIONS_HISTORY" MODIFY ("ID" NOT NULL ENABLE);