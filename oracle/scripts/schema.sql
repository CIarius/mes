/*
BEGIN
  FOR t IN (SELECT table_name FROM user_tables) LOOP
    EXECUTE IMMEDIATE 'DROP TABLE "' || t.table_name || '" CASCADE CONSTRAINTS';
  END LOOP;
END;
/
*/

CREATE TABLE titles (
	id INT GENERATED ALWAYS AS IDENTITY,
	title VARCHAR2(50),
	PRIMARY KEY(id)
);

INSERT INTO titles (title) VALUES('MR');
INSERT INTO titles (title) VALUES('MRS');
INSERT INTO titles (title) VALUES('MS');

CREATE TABLE genders(
	id INT GENERATED ALWAYS AS IDENTITY,
	gender VARCHAR2(50),
	PRIMARY KEY(id)
);

INSERT INTO genders (gender) VALUES('M');
INSERT INTO genders (gender) VALUES('F');

CREATE TABLE departments(
	id INT GENERATED ALWAYS AS IDENTITY,
	department VARCHAR2(50),
	PRIMARY KEY(id)
);

INSERT INTO departments (department) VALUES('PRODUCTION');
INSERT INTO departments (department) VALUES('ADMINISTRATION');
INSERT INTO departments (department) VALUES('FINANCE');
INSERT INTO departments (department) VALUES('INFORMATION TECHNOLOGY');
INSERT INTO departments (department) VALUES('MARKETING');
INSERT INTO departments (department) VALUES('PUBLIC RELATIONS');
INSERT INTO departments (department) VALUES('QUALITY');
INSERT INTO departments (department) VALUES('ENGINEERING');
INSERT INTO departments (department) VALUES('MAINTENANCE');
INSERT INTO departments (department) VALUES('PROCUREMENT');
INSERT INTO departments (department) VALUES('LOGISTICS');
INSERT INTO departments (department) VALUES('HUMAN RESOURCES');

CREATE TABLE roles(
	id INT GENERATED ALWAYS AS IDENTITY,
	role VARCHAR2(50),
	PRIMARY KEY(id)
);

INSERT INTO roles (role) VALUES('CHAIRMAN');
INSERT INTO roles (role) VALUES('DIRECTOR');
INSERT INTO roles (role) VALUES('MANAGER');
INSERT INTO roles (role) VALUES('PROFESSIONAL');
INSERT INTO roles (role) VALUES('SUPERVISOR');
INSERT INTO roles (role) VALUES('LEAD HAND');
INSERT INTO roles (role) VALUES('TECHNICAN');
INSERT INTO roles (role) VALUES('SKILLED');
INSERT INTO roles (role) VALUES('SEMI-SKILLED');
INSERT INTO roles (role) VALUES('UNSKILLED');
INSERT INTO roles (role) VALUES('INTERN');
INSERT INTO roles (role) VALUES('APPRENTICE');

CREATE TABLE shifts(
	id INT GENERATED ALWAYS AS IDENTITY,
	shift VARCHAR2(50),
	PRIMARY KEY(id)
);

INSERT INTO shifts (shift) VALUES('DAY');
INSERT INTO shifts (shift) VALUES('EVENING');
INSERT INTO shifts (shift) VALUES('NIGHT');
INSERT INTO shifts (shift) VALUES('WEEKEND');

CREATE TABLE employees (
	id INT GENERATED ALWAYS AS IDENTITY,
    	title_id		INT,
    	forename		VARCHAR2(50),
    	surname		VARCHAR2(50),
    	gender_id		INT,
    	date_of_birth	DATE,
    	date_of_hire	DATE,
    	department_id	INT,
    	role_id		INT,
    	shift_id		INT,
    	PRIMARY KEY(id),
	FOREIGN KEY(title_id) REFERENCES titles(id),
	FOREIGN KEY(gender_id) REFERENCES genders(id),
	FOREIGN KEY(department_id) REFERENCES departments(id),
	FOREIGN KEY(role_id) REFERENCES roles(id),
	FOREIGN KEY(shift_id) REFERENCES shifts(id)	
);

COMMIT;

EXIT;