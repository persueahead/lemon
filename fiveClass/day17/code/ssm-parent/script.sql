CREATE TABLE ssm_department
(
    department_id       INT(4) AUTO_INCREMENT
        PRIMARY KEY,
    department_name     VARCHAR(20) NOT NULL,
    department_location VARCHAR(20) NOT NULL
)
    COLLATE = utf8mb4_bin;

CREATE TABLE ssm_user
(
    user_id       INT(4) AUTO_INCREMENT
        PRIMARY KEY,
    user_name     VARCHAR(10) NOT NULL,
    user_password VARCHAR(10) NOT NULL,
    user_salary   FLOAT(6, 2) NOT NULL,
    user_birthday DATE        NOT NULL,
    department_id INT(4)      NULL,
    CONSTRAINT fk_department_id
        FOREIGN KEY (department_id) REFERENCES ssm_department (department_id)
)
    COLLATE = utf8_bin;


