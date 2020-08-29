CREATE TABLE IF NOT EXISTS department (
department_id bigint,
department_name varchar(255),
PRIMARY KEY(department_id)
);

CREATE TABLE IF NOT EXISTS employees (
employee_id bigint AUTO_INCREMENT,
employee_name varchar(255),
manager_id bigint,
department_id bigint,
PRIMARY KEY(employee_id),
FOREIGN KEY(department_id) REFERENCES department(department_id)
);