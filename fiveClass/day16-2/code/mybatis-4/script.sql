--一对一关系（主键关联映射）
CREATE TABLE mybatis_person
(
    person_id       INT(4) AUTO_INCREMENT PRIMARY KEY,
    person_name     VARCHAR(20) NOT NULL,
    person_password VARCHAR(20) NOT NULL,
    person_salary   FLOAT(6, 2) NOT NULL,
    person_birthday DATE        NOT NULL
);

CREATE TABLE mybatis_id_card
(
    id_card_id     INT(4) PRIMARY KEY AUTO_INCREMENT,
    id_card_number VARCHAR(20) NOT NULL
);

ALTER TABLE mybatis_id_card
    ADD CONSTRAINT fk_id_card_id FOREIGN KEY (id_card_id)
        REFERENCES mybatis_person (person_id);





--多对多关系
CREATE TABLE mybatis_teacher
(
    teacher_id     INT(4) PRIMARY KEY AUTO_INCREMENT,
    teacher_name   VARCHAR(20) NOT NULL,
    teacher_salary FLOAT(6, 2) NOT NULL
);

CREATE TABLE mybatis_student
(
    student_id    INT(4) PRIMARY KEY AUTO_INCREMENT,
    student_name  VARCHAR(20) NOT NULL,
    student_score FLOAT(4, 2) NOT NULL
);

CREATE TABLE mybatis_teacher_student
(
    teacher_id INT(4),
    student_id INT(4)
);

ALTER TABLE mybatis_teacher_student
    ADD CONSTRAINT pk_teacher_id_student_id PRIMARY KEY (teacher_id, student_id);

ALTER TABLE mybatis_teacher_student
    ADD CONSTRAINT fk_teacher_id FOREIGN KEY (teacher_id)
        REFERENCES mybatis_teacher (teacher_id);

ALTER TABLE mybatis_teacher_student
    ADD CONSTRAINT fk_student_id FOREIGN KEY (student_id)
        REFERENCES mybatis_student (student_id);

--无限极分类
CREATE TABLE mybatis_category
(
    category_id   INT(4) PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(20) NOT NULL,
    parent_id     INT(4)
);

ALTER TABLE mybatis_category
    ADD CONSTRAINT fk_parent_id FOREIGN KEY (parent_id)
        REFERENCES mybatis_category (category_id);

--继承映射
CREATE TABLE mybatis_animal
(
    animal_id   INT(4) PRIMARY KEY AUTO_INCREMENT,
    animal_name VARCHAR(20) NOT NULL,
    eye_color   VARCHAR(10),
    fur_color   VARCHAR(10),
    type        CHAR(1)     NOT NULL
);