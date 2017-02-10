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
  `copy_link` varchar(300) DEFAULT NULL,
  `copy_link_text` varchar(300) DEFAULT NULL,
  `copy_image` varchar(100) DEFAULT NULL,
  `copy_image_alt_text` varchar(100) DEFAULT NULL,
  `copy_type` varchar(40) DEFAULT NULL,
  `start_date` datetime,
  `end_date` datetime,

  `store_id` int(11) DEFAULT NULL,
  
  PRIMARY KEY (`store_copy_id`),
  INDEX `FK_STR` (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, COPY_LINK, COPY_LINK_TEXT, COPY_IMAGE, COPY_IMAGE_ALT_TEXT, COPY_TYPE, START_DATE, END_DATE, STORE_ID) values (1,'Carousel Copy One'    ,'<p>This is the carousel copy body for copy test one.</p>','img-one.png','image one alt text','link-one','View details One &raquo;','carousel','2017-01-01 00:00:01','2020-01-01 00:00:01',1);
insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, COPY_LINK, COPY_LINK_TEXT, COPY_IMAGE, COPY_IMAGE_ALT_TEXT, COPY_TYPE, START_DATE, END_DATE, STORE_ID) values (2,'Carousel Copy Two'    ,'<p>This is the carousel copy body for copy test two.</p>','img-two.png','image two alt text','link-two','View details Two &raquo;','carousel','2017-01-01 00:00:01','2020-01-01 00:00:01',1);
insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, COPY_LINK, COPY_LINK_TEXT, COPY_IMAGE, COPY_IMAGE_ALT_TEXT, COPY_TYPE, START_DATE, END_DATE, STORE_ID) values (3,'Carousel Copy Three'  ,'<p>This is the carousel copy body for copy test three.</p>','img-three.png','image three alt text','link-three','View details Three&raquo;','carousel','2017-01-01 00:00:01','2020-01-01 00:00:01',1);
insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, COPY_LINK, COPY_LINK_TEXT, COPY_IMAGE, COPY_IMAGE_ALT_TEXT, COPY_TYPE, START_DATE, END_DATE, STORE_ID) values (4,'Featurette Copy One'  ,'<h2 class="featurette-heading">First featurette heading. <span class="text-muted">It\'ll blow your mind.</span></h2><p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>','img-one.png','image one alt text','link-one','View details One&raquo;','featurette','2017-01-01 00:00:01','2020-01-01 00:00:01',1);
insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, COPY_LINK, COPY_LINK_TEXT, COPY_IMAGE, COPY_IMAGE_ALT_TEXT, COPY_TYPE, START_DATE, END_DATE, STORE_ID) values (5,'Featurette Copy Two'  ,'<p>This is the featurette copy body for copy test two.</p>','img-two.png','image two alt text','link-two','View details Two &raquo;','featurette','2017-01-01 00:00:01','2020-01-01 00:00:01',1);
insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, COPY_LINK, COPY_LINK_TEXT, COPY_IMAGE, COPY_IMAGE_ALT_TEXT, COPY_TYPE, START_DATE, END_DATE, STORE_ID) values (6,'Featurette Copy Three','<p>This is the featurette copy body for copy test three.</p>','img-three.png','image three alt text','link-three','View details Three&raquo;','featurette','2017-01-01 00:00:01','2020-01-01 00:00:01',1);
insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, COPY_LINK, COPY_LINK_TEXT, COPY_IMAGE, COPY_IMAGE_ALT_TEXT, COPY_TYPE, START_DATE, END_DATE, STORE_ID) values (7,'Posting Copy One'     ,'<h2>Posting One</h2><p>This is the posting copy body for copy test one.</p>','img-one.png','link-one','View details One &raquo;','image one alt text','posting','2017-01-01 00:00:01','2020-01-01 00:00:01',1);
insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, COPY_LINK, COPY_LINK_TEXT, COPY_IMAGE, COPY_IMAGE_ALT_TEXT, COPY_TYPE, START_DATE, END_DATE, STORE_ID) values (8,'Posting Copy Two'     ,'<h2>Posting Two</h2><p>This is the posting copy body for copy test two.</p>','img-two.png','link-two','View details Two &raquo;','image two alt text','posting','2017-01-01 00:00:01','2020-01-01 00:00:01',1);
insert into store_copy (STORE_COPY_ID, COPY_NAME, COPY_BODY, COPY_LINK, COPY_LINK_TEXT, COPY_IMAGE, COPY_IMAGE_ALT_TEXT, COPY_TYPE, START_DATE, END_DATE, STORE_ID) values (9,'Posting Copy Three'   ,'<h2>Posting Three</h2><p>This is the posting copy body for copy test three.</p>','img-three.png','link-three','View details Three &raquo;','image three alt text','posting','2017-01-01 00:00:01','2020-01-01 00:00:01',1);




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