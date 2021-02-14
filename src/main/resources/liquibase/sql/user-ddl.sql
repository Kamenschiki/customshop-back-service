CREATE TABLE ROLES
(
    ROLE_ID VARCHAR(36) UNIQUE,
    NAME VARCHAR(36),
    PRIMARY KEY (ROLE_ID)
);

CREATE TABLE USERS
(
    USER_ID VARCHAR(36) UNIQUE,
    NAME VARCHAR(36),
    PASSWORD VARCHAR(168),
    EMAIL VARCHAR(36),
    AUDITABLE_STATUS VARCHAR(8),
    AUD_STATUS_UPDATE_REASON VARCHAR(36),
    CREATE_JWT_TOKEN VARCHAR(256),
    UPDATE_JWT_TOKEN VARCHAR(256),
    CREATE_DATE_TIME_UTC TIMESTAMP,
    UPDATE_DATE_TIME_UTC TIMESTAMP,
    PRIMARY KEY (USER_ID)
);

CREATE TABLE USER_DETAILS
(
    USER_DETAIL_ID VARCHAR(36) UNIQUE,
    USER_ID VARCHAR(36),
    DETAIL_TYPE VARCHAR(256),
    DETAIL_TEXT VARCHAR(8192),
    AUDITABLE_STATUS VARCHAR(8),
    AUD_STATUS_UPDATE_REASON VARCHAR(36),
    CREATE_JWT_TOKEN VARCHAR(256),
    UPDATE_JWT_TOKEN VARCHAR(256),
    CREATE_DATE_TIME_UTC TIMESTAMP,
    UPDATE_DATE_TIME_UTC TIMESTAMP,

    CONSTRAINT `FK_DESCRIBED_USER`
        FOREIGN KEY (USER_ID) REFERENCES USERS (USER_ID)
            ON DELETE CASCADE
            ON UPDATE RESTRICT,
    PRIMARY KEY (USER_DETAIL_ID)
);

CREATE TABLE USER_ROLES
(
    ROLE_ID VARCHAR(36) NULL,
    USER_ID VARCHAR(36) NULL
);