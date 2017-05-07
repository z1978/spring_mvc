CREATE TABLE user (
  id INTEGER NOT NULL,
  first_name CHARACTER(20) NOT NULL,
  last_name CHARACTER(20) NOT NULL,
  age INTEGER DEFAULT NULL,
  create_time TIMESTAMP NOT NULL,
  update_time TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE people (
  id INTEGER NOT NULL,
  first_name CHARACTER(20) DEFAULT NULL,
  last_name CHARACTER(20) DEFAULT NULL,
  PRIMARY KEY (id)
);