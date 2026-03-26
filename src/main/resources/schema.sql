DROP TABLE IF EXISTS course_link CASCADE;
DROP TABLE IF EXISTS node_course CASCADE;
DROP TABLE IF EXISTS node CASCADE;
DROP TABLE IF EXISTS link CASCADE;
DROP TABLE IF EXISTS course CASCADE;
DROP TABLE IF EXISTS route CASCADE;
DROP TABLE IF EXISTS node_type CASCADE;

CREATE TABLE node_type
(
    id_node_type SERIAL PRIMARY KEY,
    name         VARCHAR(50) NOT NULL
);

CREATE TABLE route
(
    id_route    SERIAL PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    description TEXT,
    date_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE course
(
    id_course   SERIAL PRIMARY KEY,
    title       VARCHAR(100) NOT NULL,
    description TEXT,
    date_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE link
(
    id_link     SERIAL PRIMARY KEY,
    title       VARCHAR(200),
    url         TEXT NOT NULL,
    date_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE node
(
    id_node      SERIAL PRIMARY KEY,
    id_route     INT          NOT NULL,
    id_node_type INT,
    title        VARCHAR(100) NOT NULL,
    description  TEXT,
    date_create  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_node_idroute
        FOREIGN KEY (id_route)
            REFERENCES route (id_route)
            ON DELETE CASCADE,

    CONSTRAINT fk_node_idtype
        FOREIGN KEY (id_node_type)
            REFERENCES node_type (id_node_type)
            ON DELETE CASCADE
);

CREATE TABLE node_course
(
    id_node   INT,
    id_course INT,

    PRIMARY KEY (id_node, id_course),

    CONSTRAINT fk_node_course_idnode
        FOREIGN KEY (id_node)
            REFERENCES node (id_node)
            ON DELETE CASCADE,

    CONSTRAINT fk_node_course_idcourse
        FOREIGN KEY (id_course)
            REFERENCES course (id_course)
            ON DELETE CASCADE
);

CREATE TABLE course_link
(
    id_course INT,
    id_link   INT,

    PRIMARY KEY (id_course, id_link),

    CONSTRAINT fk_course_link_idcourse
        FOREIGN KEY (id_course)
            REFERENCES course (id_course)
            ON DELETE CASCADE,

    CONSTRAINT fk_course_link_idlink
        FOREIGN KEY (id_link)
            REFERENCES link (id_link)
            ON DELETE CASCADE
);

INSERT INTO node_type (name)
VALUES ('Tema'),
       ('Subtema'),
       ('Proyecto Final'),
       ('Recursos');