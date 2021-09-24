drop table if exists users;
drop table if exists roles;
drop table if exists users_roles;


CREATE TABLE users (
  id int(11) NOT NULL AUTO_INCREMENT,
  login varchar(45) NOT NULL,
  password varchar(64) NOT NULL,
  enabled tinyint(1) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE roles (
  id int(11) NOT NULL AUTO_INCREMENT,
  role_name varchar(45) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE users_roles (
  user_id int(11) NOT NULL,
  role_id int(11) NOT NULL,
  CONSTRAINT role_fk FOREIGN KEY (user_id) REFERENCES roles (id),
  CONSTRAINT user_fk FOREIGN KEY (role_id) REFERENCES users (id)
);

INSERT INTO users (login, password, enabled)
VALUES ('reader', '$2a$10$8yzmROgpvrnUXCssDG1kV.jY51pXvFL49KKlw4yVTUv/Rnx3rZgl6', '1');
INSERT INTO users (login, password, enabled)
VALUES ('editor', '$2a$10$Y4uw8pVXJ19lvYKUHehyuunVjPBdaU7OEOqgxKBKgVGbWSb.rTYrC', '1');
INSERT INTO users (login, password, enabled)
VALUES ('author', '$2a$10$Ol/3irArF3e1Jw2S..appOOdNmRydi8xpBURsTCP2ZF17fXL21fUS', '1');

INSERT INTO roles (role_name) VALUES ('READER');
INSERT INTO roles (role_name) VALUES ('EDITOR');
INSERT INTO roles (role_name) VALUES ('AUTHOR');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 3);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 3);