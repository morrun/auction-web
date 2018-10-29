--------------------------------------------------------
--  DDL for Table ECB_VISIT_HISTORY
--------------------------------------------------------

  CREATE TABLE "ECB_VISIT_HISTORY" 
   (	
   "ID" NUMBER, 
	"VISITATION_ID" NUMBER, 
	"PRODUCT_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
  
--------------------------------------------------------
--  DDL for Sequence ECB_VISIT_HISTORY_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "ECB_VISIT_HISTORY_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE NOORDER  NOCYCLE ;
   Insert into ECB_VISIT_HISTORY (ID,VISITATION_ID,PRODUCT_ID) values (1,1,1);

--------------------------------------------------------
--  DDL for Index ECB_VISIT_HISTORY_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "ECB_VISIT_HISTORY_PK" ON "ECB_VISIT_HISTORY" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;

--------------------------------------------------------
--  DDL for Trigger ECB_VISIT_HISTORY_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "ECB_VISIT_HISTORY_TRG" 
BEFORE INSERT ON ECB_VISIT_HISTORY 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT ECB_VISIT_HISTORY_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;


/
ALTER TRIGGER "ECB_VISIT_HISTORY_TRG" ENABLE;

--------------------------------------------------------
--  Constraints for Table ECB_VISIT_HISTORY
--------------------------------------------------------

  ALTER TABLE "ECB_VISIT_HISTORY" ADD CONSTRAINT "ECB_VISIT_HISTORY_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "ECB_VISIT_HISTORY" MODIFY ("ID" NOT NULL ENABLE);