CREATE TABLE IF NOT EXISTS `applier` (
	`id` BIGINT AUTO_INCREMENT,
  	`member_id` BIGINT NOT NULL,
  	`professional_id` BIGINT NULL,

	PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `professional` (
	`id` BIGINT AUTO_INCREMENT,
	`available_for_interview` BOOLEAN NOT NULL DEFAULT FALSE,
 	`linkedin_link` VARCHAR(300) NULL,
 	`other_link_1` VARCHAR(300),
 	`other_link_2` VARCHAR(300) NULL,
 	`other_link_3` VARCHAR(300) NULL,
 	`hobbies` VARCHAR(300) NOT NULL,
  	`member_id` BIGINT NOT NULL,

    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `professional_profile` (
	`id` BIGINT AUTO_INCREMENT,

	`profile_title` VARCHAR(300) NOT NULL,
	`main_profile` BOOLEAN NOT NULL DEFAULT FALSE,

	`passport_link` VARCHAR(400) NOT NULL,
	`resume_link` VARCHAR(400) NOT NULL,
	`cover_letter_link` VARCHAR(400) NOT NULL,

	`salary_range` VARCHAR(30) NOT NULL,
 	`preferred_job_location_type` VARCHAR(150) NOT NULL,
 	`job_seniority` VARCHAR(150) NOT NULL,
 	`desired_job_title` VARCHAR(150) NOT NULL,

   	`industry` VARCHAR(150) NULL,
 	`years_of_experience` INT NULL,
  	`other_comment` TEXT NULL,
 	`other_skills` TEXT NULL,
	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  	`professional_id` BIGINT NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `member` (
	`id` BIGINT AUTO_INCREMENT,
	`first_name` VARCHAR(40) NOT NULL,
 	`last_name` VARCHAR(40) NOT NULL,
	`date_of_birth` DATE NOT NULL,
  	`current_job_title` VARCHAR(200) NOT NULL,
  	`phone_number` VARCHAR(15) NOT NULL,
  	`email_address` VARCHAR(50) NOT NULL,
  	`password` TEXT NOT NULL,
  	`avatar` VARCHAR(300) NOT NULL,
  	`active` BOOLEAN NOT NULL DEFAULT TRUE,
  	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

 	`nationality_id` BIGINT NOT NULL,
 	`country_of_residence_id` BIGINT NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `job_submission` (
	`id` BIGINT AUTO_INCREMENT,
  	`job_title` VARCHAR(300) NOT NULL,
  	`job_link` VARCHAR(300) NOT NULL,
  	`other_comment` TEXT NOT NULL,
  	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  	`professional_id` BIGINT NOT NULL,
  	`applier_id` BIGINT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `country` (
	`id` BIGINT AUTO_INCREMENT,
  	`title` VARCHAR(300) NOT NULL,
  	`abbreviation` VARCHAR(10) NOT NULL,
  	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

	PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `roles` (
	`id` BIGINT AUTO_INCREMENT,
  	`title` VARCHAR(200) NOT NULL,
  	`code` VARCHAR(200) NOT NULL,

	PRIMARY KEY (`id`)
);