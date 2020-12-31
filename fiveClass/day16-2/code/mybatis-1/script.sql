CREATE TABLE mybatis_user
(
    user_id       INT(4) PRIMARY KEY AUTO_INCREMENT,
    user_name     VARCHAR(20) NOT NULL,
    user_password VARCHAR(20) NOT NULL,
    user_salary   FLOAT(6, 2) NOT NULL,
    user_birthday DATE        NOT NULL
);