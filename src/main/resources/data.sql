DROP TABLE IF EXISTS BUILDING;

CREATE TABLE BUILDING
(
    ID           UUID DEFAULT RANDOM_UUID() NOT NULL PRIMARY KEY,
	CODE	     VARCHAR(100) NOT NULL,
    NAME         VARCHAR(200) NOT NULL,
    IS_ACTIVE    BOOLEAN NOT NULL,
    CREATED_AT   DATETIME DEFAULT CURRENT_TIMESTAMP(),
    UPDATED_AT   DATETIME DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
	UNIQUE KEY BUILDING_CODE_UNIQUE (CODE)
);

DROP TABLE IF EXISTS FLOOR;

CREATE TABLE FLOOR
(
    ID           UUID DEFAULT RANDOM_UUID() NOT NULL PRIMARY KEY,
	CODE		 VARCHAR(100) NOT NULL,
	BUILDING_ID  UUID NOT NULL,
    NAME         VARCHAR(200) NOT NULL,
    IS_ACTIVE    BOOLEAN NOT NULL,
    CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP(),
    UPDATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
	UNIQUE KEY FLOOR_CODE_UNIQUE (CODE),
    FOREIGN KEY (BUILDING_ID) REFERENCES BUILDING (ID)
);

DROP TABLE IF EXISTS ROOM;

CREATE TABLE ROOM
(
    ID                 UUID DEFAULT RANDOM_UUID() NOT NULL PRIMARY KEY,
	CODE			   VARCHAR(100) NOT NULL,
	FLOOR_ID           UUID NOT NULL,
    NAME               VARCHAR(200) NOT NULL,
	MAXIMUM_ALLOCATION INT NOT NULL,
	STATUS             VARCHAR(100) NOT NULL,
	HAS_MULTIMEDIA     BOOLEAN NOT NULL,
	CLEAN_UP_TIME	   INT NOT NULL,
    IS_ACTIVE          BOOLEAN NOT NULL,
    CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP(),
    UPDATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
	UNIQUE KEY ROOM_CODE_UNIQUE (CODE),
    FOREIGN KEY (FLOOR_ID) REFERENCES FLOOR (ID)
);

DROP TABLE IF EXISTS RESERVATION;

CREATE TABLE RESERVATION
(
    ID               UUID DEFAULT RANDOM_UUID() NOT NULL PRIMARY KEY,
	ROOM_ID          UUID NOT NULL,
    START_DATE       DATETIME NOT NULL,
	TIME_SPAN        DECIMAL(6,3) NOT NULL,
	ATTENDEES_NUMBER INT NOT NULL,
    IS_ACTIVE        BOOLEAN NOT NULL,
    CREATED_AT       DATETIME DEFAULT CURRENT_TIMESTAMP(),
    UPDATED_AT       DATETIME DEFAULT CURRENT_TIMESTAMP() ON UPDATE CURRENT_TIMESTAMP(),
    PRIMARY KEY (ID),
    FOREIGN KEY (ROOM_ID) REFERENCES ROOM (ID)
);


INSERT INTO BUILDING(CODE, NAME, IS_ACTIVE, CREATED_AT) VALUES ('B001', 'LOS OLIVOS', true, CURRENT_TIMESTAMP());
INSERT INTO BUILDING(CODE, NAME, IS_ACTIVE, CREATED_AT) VALUES ('B002', 'ALISOS', true, CURRENT_TIMESTAMP());
INSERT INTO FLOOR(BUILDING_ID, CODE, NAME, IS_ACTIVE, CREATED_AT) SELECT ID, 'F001', 'FLOOR 1', true, CURRENT_TIMESTAMP() FROM BUILDING WHERE CODE = 'B001';
INSERT INTO FLOOR(BUILDING_ID, CODE, NAME, IS_ACTIVE, CREATED_AT) SELECT ID, 'F002', 'FLOOR 2', true, CURRENT_TIMESTAMP() FROM BUILDING WHERE CODE = 'B001';
INSERT INTO FLOOR(BUILDING_ID, CODE, NAME, IS_ACTIVE, CREATED_AT) SELECT ID, 'F003', 'FLOOR 3', true, CURRENT_TIMESTAMP() FROM BUILDING WHERE CODE = 'B002';
INSERT INTO ROOM(CODE, FLOOR_ID, NAME, MAXIMUM_ALLOCATION, STATUS, HAS_MULTIMEDIA, CLEAN_UP_TIME, IS_ACTIVE, CREATED_AT) 
 SELECT 'R001',ID, 'ROOM 1', 200, 'AVAILABLE', true, 5 + 200, true, CURRENT_TIMESTAMP() FROM FLOOR WHERE CODE = 'F001';
INSERT INTO ROOM(CODE, FLOOR_ID, NAME, MAXIMUM_ALLOCATION, STATUS, HAS_MULTIMEDIA, CLEAN_UP_TIME, IS_ACTIVE, CREATED_AT) 
 SELECT 'R002',ID, 'ROOM 2', 300, 'AVAILABLE', true, 5 + 300, true, CURRENT_TIMESTAMP() FROM FLOOR WHERE CODE = 'F001';
INSERT INTO ROOM(CODE, FLOOR_ID, NAME, MAXIMUM_ALLOCATION, STATUS, HAS_MULTIMEDIA, CLEAN_UP_TIME, IS_ACTIVE, CREATED_AT) 
 SELECT 'R003',ID, 'ROOM 3', 400, 'AVAILABLE', true, 5 + 400, true, CURRENT_TIMESTAMP() FROM FLOOR WHERE CODE = 'F002';
INSERT INTO ROOM(CODE, FLOOR_ID, NAME, MAXIMUM_ALLOCATION, STATUS, HAS_MULTIMEDIA, CLEAN_UP_TIME, IS_ACTIVE, CREATED_AT) 
 SELECT 'R004',ID, 'ROOM 4', 500, 'AVAILABLE', false, 5 + 500, true, CURRENT_TIMESTAMP() FROM FLOOR WHERE CODE = 'F002';
INSERT INTO ROOM(CODE, FLOOR_ID, NAME, MAXIMUM_ALLOCATION, STATUS, HAS_MULTIMEDIA, CLEAN_UP_TIME, IS_ACTIVE, CREATED_AT) 
 SELECT 'R005',ID, 'ROOM 5', 600, 'AVAILABLE', true, 5 + 600, true, CURRENT_TIMESTAMP() FROM FLOOR WHERE CODE = 'F003';


