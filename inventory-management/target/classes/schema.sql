CREATE TABLE inventory(
  id bigint DEFAULT nextval('seq_inventory') NOT NULL,
  item_name CHAR(50) NOT NULL
  quantity bigint NOT NULL
);

CREATE SEQUENCE seq_inventory
    START WITH 1
    INCREMENT BY 30
    NO MINVALUE
    NO MAXVALUE
    CACHE 20
    CYCLE;