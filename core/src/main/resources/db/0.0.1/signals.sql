CREATE TABLE if not exists signals
(
    id          BIGINT NOT NULL ,
    type        VARCHAR(255),
    description VARCHAR(255),
    CONSTRAINT pk_signals PRIMARY KEY (id)
);
