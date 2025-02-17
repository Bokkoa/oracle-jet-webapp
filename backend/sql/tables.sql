CREATE TABLE `services`.`jet_users` (
  `user_name` VARCHAR(45) NOT NULL,
  `user_password` VARCHAR(45) NULL,
  `user_display_name` VARCHAR(100) NULL,
  `user_active` VARCHAR(45) NULL,
  `user_type` VARCHAR(45) NULL,
  PRIMARY KEY (`user_name`));


CREATE TABLE `services`.`jet_customers` (
  `customer_id` VARCHAR(45) NOT NULL,
  `customer_name` VARCHAR(60) NULL,
  `customer_address` VARCHAR(200) NULL,
  `customer_email` VARCHAR(145) NULL,
  `customer_website` VARCHAR(145) NULL,
  `customer_phone` VARCHAR(45) NULL,
  `customer_description` VARCHAR(500) NULL,
  PRIMARY KEY (`customer_id`));


CREATE TABLE `services`.`jet_services` (
  `service_name` VARCHAR(60) NOT NULL,
  `service_description` VARCHAR(145) NULL,
  PRIMARY KEY (`service_name`));


CREATE TABLE `services`.`jet_services_schedule` (
  `schedule_id` INT NOT NULL AUTO_INCREMENT,
  `schedule_customer_fk` VARCHAR(45) NULL,
  `schedule_service_fk` VARCHAR(45) NULL,
  `schedule_status` VARCHAR(45) NULL,
  `schedule_description` VARCHAR(145) NULL,
  `schedule_date` DATETIME NULL,
  `schedule_added_by` VARCHAR(45) NULL,
  `schedule_added_date` DATETIME NULL,
  PRIMARY KEY (`schedule_id`));


CREATE TABLE `services`.`jet_schedule_notes` (
  `schedule_note_pk` INT NOT NULL AUTO_INCREMENT,
  `schedule_fk` INT NULL,
  `schedule_note_description` VARCHAR(300) NULL,
  `schedule_note_added_by` VARCHAR(45) NULL,
  `schedule_note_added_date` DATETIME NULL,
  PRIMARY KEY (`schedule_note_pk`));

