DROP DATABASE test;
CREATE DATABASE  IF NOT EXISTS `test`;
USE `test`;

DROP TABLE IF EXISTS `store`;

CREATE TABLE `store` (
    `store_id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) DEFAULT NULL,
    `title` VARCHAR(40) DEFAULT NULL,
    `header` VARCHAR(500) DEFAULT NULL,
    `footer` VARCHAR(500) DEFAULT NULL,
    `copyright` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`store_id`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;

insert into store (STORE_ID,NAME,TITLE,HEADER,FOOTER,COPYRIGHT) values (1, "Test Store Name", "Test Store Title", "Store Header", "Store Footer", "2017");


DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
    `account_id` INT(11) NOT NULL AUTO_INCREMENT,
    `email_address` VARCHAR(50) DEFAULT NULL,
    `role_id` INT(11) DEFAULT 1,
    `user_id` INT(11) DEFAULT NULL,
    `password` varchar(50) DEFAULT NULL,
    `active` boolean default false,
    PRIMARY KEY (`account_id`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;

insert into account (ACCOUNT_ID, EMAIL_ADDRESS, ROLE_ID, USER_ID, PASSWORD, ACTIVE) values (1, 'hepaestus@gmail.com', 1, 1,'password', false);


DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
    `account_id` INT(11) NOT NULL AUTO_INCREMENT,
    `salutation` VARCHAR(10) DEFAULT NULL,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `middle_name` VARCHAR(40) DEFAULT NULL,
    `last_name` VARCHAR(40) DEFAULT NULL,
    `suffix` VARCHAR(10) DEFAULT NULL,
    PRIMARY KEY (`account_id`),
    INDEX `FK_ACCOUNT` (`account_id`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;

insert into user (ACCOUNT_ID, SALUTATION, FIRST_NAME, MIDDLE_NAME, LAST_NAME, SUFFIX) values (1,'Mr.', 'Peter', 'Edward', 'Olsen', 'III');
 

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
    `role_id` INT(11) NOT NULL AUTO_INCREMENT,
    `role_name` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`role_id`)
)  ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=LATIN1;

insert into role (ROLE_ID, ROLE_NAME) values (1, 'USER');
insert into role (ROLE_ID, ROLE_NAME) values (2, 'ADMIN');
insert into role (ROLE_ID, ROLE_NAME) values (3, 'EDITOR');
insert into role (ROLE_ID, ROLE_NAME) values (4, 'ARTIST');


DROP TABLE IF EXISTS `store_copy`;

CREATE TABLE `store_copy`(
  `store_copy_id` int(11) NOT NULL AUTO_INCREMENT,
  `copy_name` varchar(40) NOT NULL,
  `copy_body` varchar(2000) DEFAULT NULL,
  `start_date` datetime,
  `end_date` datetime,
  `store_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`store_copy_id`),
  INDEX `FK_STR` (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, START_DATE, END_DATE, STORE_ID) values (1,'Test Copy One','<p>This is the copy body for copy test one.</p>','2017-01-01 00:00:01','2020-01-01 00:00:01',1);
insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, START_DATE, END_DATE, STORE_ID) values (2,'Test Copy Two','<p>This is the copy body for copy test two.</p>','2017-01-01 00:00:01','2020-01-01 00:00:01',1);
insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, START_DATE, END_DATE, STORE_ID) values (3,'Test Copy Three','<p>This is the copy body for copy test three.</p>','2017-01-01 00:00:01','2020-01-01 00:00:01',1);

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `store_id` int(11) default null,
  `prod_type_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`product_id`),
  INDEX `FK_STORE` (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

    

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `street_address_1` varchar(50) DEFAULT NULL,
  `street_address_2` varchar(50) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `postal_code` varchar(10) DEFAULT NULL,
  `county` varchar(40) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  
  PRIMARY KEY (`address_id`),
  INDEX `FK_USR` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


ALTER TABLE user
    add constraint `FK_ACCOUNT` 
    FOREIGN KEY (`account_id`) 
    references `account` (`account_id`);
    
ALTER TABLE account
    add constraint `FK_USER` 
    FOREIGN KEY (`user_id`) 
    references `user` (`account_id`); 

ALTER TABLE product
    add constraint `FK_STORE`
    foreign key (`store_id`)
    references `store` (`store_id`);

ALTER TABLE store_copy
    add constraint `FK_STR`
    FOREIGN KEY (`store_id`)
    references `store` (`store_id`);

ALTER TABLE address
    add constraint `FK_USR` 
    FOREIGN KEY (`user_id`) 
    references `user` (`account_id`);