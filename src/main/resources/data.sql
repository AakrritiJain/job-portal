DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS CANDIDATE;
DROP TABLE IF EXISTS JOB;
DROP TABLE IF EXISTS JOB_REQUEST;

CREATE TABLE USER(
username VARCHAR(250) NOT NULL PRIMARY KEY,
password VARCHAR(250) NOT NULL,
role VARCHAR(250) NOT NULL);

CREATE TABLE CANDIDATE(
id INT PRIMARY KEY,
first_name VARCHAR(250) NOT NULL,
last_name VARCHAR(250) NOT NULL,
experience_in_years INT,
skills VARCHAR(250),
contact VARCHAR(250),
email VARCHAR(250),
headline VARCHAR(250)
);

CREATE TABLE JOB(
id INT PRIMARY KEY,
headline VARCHAR(250),
required_experience VARCHAR(250),
required_skills VARCHAR(250),
location VARCHAR(250),
created_date TIMESTAMP
);

CREATE TABLE JOB_REQUEST(
id INT PRIMARY KEY,
job_id INT,
candidate_id INT,
status VARCHAR(250),
candidate_name VARCHAR(250),
last_modified_time TIMESTAMP,
contact VARCHAR(250),
email VARCHAR(250),
headline VARCHAR(250),
foreign key (job_id) references JOB (id),
foreign key (candidate_id) references CANDIDATE (id)
);

