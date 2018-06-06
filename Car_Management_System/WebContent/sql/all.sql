DROP  schema if exists cms;
#캐릭터 셋을 설정하지 않아서, 애져 DB서버의 캐릭터 셋을 utf-8로 지정한 뒤 쿼리실행
CREATE SCHEMA `cms` 
#DEFAULT CHARACTER SET utf8;

CREATE TABLE if not exists `cms`.`dept` (
  `dept_no` INT NOT NULL AUTO_INCREMENT,
  `dept_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`dept_no`));  #부서 테이블 생성
  
  
CREATE TABLE if not exists `cms`.`mem` (
  `mem_id` VARCHAR(50) NOT NULL,
  `mem_pw` VARCHAR(50) NOT NULL,
  `mem_name` VARCHAR(30) NOT NULL,
  `mem_jumin` VARCHAR(30) NOT NULL,
  `mem_p_no` VARCHAR(10) NULL,
  `mem_addr` VARCHAR(255) NULL,
  `mem_addr_dtl` VARCHAR(50) NULL,
  `mem_hp` VARCHAR(11) NOT NULL,
  `mem_posi` VARCHAR(30) NULL,
  `mem_auth` CHAR(1) NOT NULL default 0,
  `dept_no` INT NOT NULL,
  PRIMARY KEY (`mem_id`),
CONSTRAINT FK_cms_dept FOREIGN KEY(dept_no) REFERENCES dept(dept_no));
#사원 테이블 생성

CREATE TABLE if not exists `cms`.`cent` (
  `cent_no` INT NOT NULL AUTO_INCREMENT,
  `cent_name` VARCHAR(30) NOT NULL,
  `cent_p_no` INT NULL,
  `cent_addr` VARCHAR(255) NULL,
  `cent_addr_dtl` VARCHAR(50) NULL,
  `cent_tell` VARCHAR(15) NOT NULL,
  `cent_fax` VARCHAR(45) NULL,
  `ceo_name` VARCHAR(30) NULL,
  `cent_hp` VARCHAR(11) NULL,
  PRIMARY KEY (`cent_no`));
#정비소 테이블 생성

CREATE TABLE if not exists `cms`.`car` (
  `car_reg_no` VARCHAR(30) NOT NULL,
  `car_divi` VARCHAR(30) NOT NULL,
  `car_model` VARCHAR(30) NOT NULL,
  `ct_date` DATE NULL,
  `ep_date` DATE NULL,
  `co_name` VARCHAR(30) NULL,
  `co_tel` VARCHAR(11) NULL,
  `co_fax` VARCHAR(30) NULL,
  `bo_name` VARCHAR(30) NULL,
  `bo_divi` VARCHAR(30) NULL,
  `bo_age` INT NULL,
  `bo_s_date` DATE NULL,
  `bo_e_date` DATE NULL,
  `total_dist` INT NOT NULL,
  PRIMARY KEY (`car_reg_no`));
#법인 차 테이블 생성

CREATE TABLE if not exists `cms`.`repa` (
  `repa_no` INT NOT NULL AUTO_INCREMENT,
  `cent_no` INT NOT NULL,
  `car_reg_no` VARCHAR(30) NOT NULL,
  `mechanic_name` VARCHAR(30) NULL,
  `repa_s_date` DATE NOT NULL,
  `repa_e_date` DATE NOT NULL,
  `repa_cont` VARCHAR(500) NULL,
  `repa_fee` INT NULL,
  `repa_divi` CHAR(1) NOT NULL default 0
  PRIMARY KEY (`repa_no`),
CONSTRAINT FK_cms_cent FOREIGN KEY(cent_no) REFERENCES cent(cent_no),
CONSTRAINT FK_cms_car FOREIGN KEY(car_reg_no) REFERENCES car(car_reg_no));
#차량 정비내역 테이블 생성

CREATE TABLE if not exists `cms`.`place` (
  `place_no` INT NOT NULL AUTO_INCREMENT,
  `place_name` VARCHAR(50) NOT NULL,
  `place_p_no` INT NULL,
  `place_addr` VARCHAR(255) NULL,
  PRIMARY KEY (`place_no`));
#장소 테이블 생성

CREATE TABLE if not exists `cms`.`cour` (
  `cour_no` INT NOT NULL AUTO_INCREMENT,
  `s_place` INT NOT NULL,
  `e_place` INT NOT NULL,
  `distance` INT NOT NULL,
  `cour_purpo` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cour_no`),
CONSTRAINT FK_cms_s_place FOREIGN KEY(s_place) REFERENCES place(place_no),
CONSTRAINT FK_cms_e_place FOREIGN KEY(e_place) REFERENCES place(place_no)
); #경로 테이블 생성

CREATE TABLE if not exists `cms`.`driv` (
  `driv_no` INT NOT NULL AUTO_INCREMENT,
  `mem_id` VARCHAR(50) NOT NULL,
  `car_reg_no` VARCHAR(30) NOT NULL,
  `cour_no` INT NULL,
  `driv_s_date` DATETIME NOT NULL,
  `driv_e_date` DATETIME NOT NULL,
  `driv_purpo` VARCHAR(50) NULL,
  `card_divi` VARCHAR(50) NULL,
  `oil_fee` INT NULL,
  `trans_fee` INT NULL,
  `etc_text` VARCHAR(100) NULL,
  `etc_fee` INT NULL,
  `befo_dist` INT NULL,
  PRIMARY KEY (`driv_no`),
CONSTRAINT FK_cms_mem_id FOREIGN KEY(mem_id) REFERENCES mem(mem_id),
CONSTRAINT FK_cms_car_reg_no FOREIGN KEY(car_reg_no) REFERENCES car(car_reg_no),
CONSTRAINT FK_cms_cour_no FOREIGN KEY(cour_no) REFERENCES cour(cour_no)
); #운행일지 테이블 생성


commit;