CREATE TABLE IF NOT EXISTS `applier` (
	`id` BIGINT AUTO_INCREMENT,

  	`member_id` BIGINT NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `professional` (
	`id` BIGINT AUTO_INCREMENT,
	`available_for_interview` BOOLEAN NOT NULL DEFAULT FALSE,
 	`linkedin_link` VARCHAR(300),
 	`facebook_link` VARCHAR(300),
 	`twitter_link` VARCHAR(300),
 	`instagram_link` VARCHAR(300),
 	`other_link_1` VARCHAR(300),
 	`other_link_2` VARCHAR(300),
 	`other_link_3` VARCHAR(300),
 	`hobbies` VARCHAR(300),

  	`member_id` BIGINT NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `professional_profile` (
	`id` BIGINT AUTO_INCREMENT,

	`profile_title` VARCHAR(300) NOT NULL,
	`main_profile` BOOLEAN NOT NULL DEFAULT FALSE,

	`passport_link` VARCHAR(400),
	`resume_link` VARCHAR(400),
	`cover_letter` VARCHAR(400),

    `employment_type` VARCHAR(200),
	`salary_range` VARCHAR(50),
	`job_location` VARCHAR(50),
 	`preferred_job_location_type` VARCHAR(150),
 	`job_seniority` VARCHAR(150),
 	`desired_job_title` VARCHAR(150),

   	`industry` VARCHAR(150),
 	`years_of_experience` INT,
  	`other_comment` TEXT,
 	`other_skills` TEXT,
 	`included_keywords` VARCHAR(300),
	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  	`professional_id` BIGINT NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `member` (
	`id` BIGINT AUTO_INCREMENT,
	`first_name` VARCHAR(40) NOT NULL,
 	`last_name` VARCHAR(40) NOT NULL,
	`date_of_birth` DATE,
  	`current_job_title` VARCHAR(200),
  	`phone_number` VARCHAR(15),
  	`email_address` VARCHAR(50) NOT NULL,
  	`username` VARCHAR(50),
  	`password` TEXT NOT NULL,
  	`avatar` VARCHAR(300),
  	`active` BOOLEAN NOT NULL DEFAULT TRUE,
  	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

 	`nationality_id` BIGINT,
 	`country_of_residence_id` BIGINT,
	PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `job_submission` (
	`id` BIGINT AUTO_INCREMENT,
  	`job_title` VARCHAR(300) NOT NULL,
  	`job_link` VARCHAR(300),
  	`job_location` VARCHAR(300),
  	`job_company` VARCHAR(300),
  	`job_location_type` VARCHAR(300),
  	`other_comment` TEXT,
  	`summary` TEXT,
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

CREATE TABLE IF NOT EXISTS `cover_letter_template` (
	`id` BIGINT AUTO_INCREMENT,
  	`title` VARCHAR(300) NOT NULL,
  	`content` LONGTEXT NOT NULL,
  	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `job_title` (
	`id` BIGINT AUTO_INCREMENT,
  	`title` VARCHAR(300) NOT NULL,
  	`created_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`updated_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `job_experience` (
	`id` BIGINT AUTO_INCREMENT,
  	`title` VARCHAR(300) NOT NULL,
  	`company_name` VARCHAR(300) NOT NULL,
  	`start_date` DATE NOT NULL,
	`end_date` DATE NOT NULL,

	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `member_secret_code` (
	`id` BIGINT AUTO_INCREMENT,
  	`sign_up_verification_code` VARCHAR(300),

	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `salary_range` (
	`id` BIGINT AUTO_INCREMENT,
  	`sal_range` VARCHAR(300),

	PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `roles` (
	`id` BIGINT AUTO_INCREMENT,
  	`title` VARCHAR(200) NOT NULL,

	PRIMARY KEY (`id`)
);

--CREATE TABLE IF NOT EXISTS `member_roles` (
--  `member_id` BIGINT NOT NULL,
--  `role_id` BIGINT NOT NULL
--);
--
--
--ALTER TABLE `member`
--    ADD UNIQUE `email_phone_uq` (`email_address`, `phone_number`);
--
--ALTER TABLE `country`
--    ADD UNIQUE `country_uq` (`title`, `abbreviation`);
--
--ALTER TABLE `member_roles`
--    ADD UNIQUE `member_role_uq` (`member_id`, `role_id`);
--
--ALTER TABLE `member`
--    ADD CONSTRAINT `member_nationality_fk`
--        FOREIGN KEY (`nationality_id`)
--            REFERENCES `country` (`id`)
--                ON DELETE RESTRICT
--                ON UPDATE RESTRICT;
--
--ALTER TABLE `member`
--    ADD CONSTRAINT `member_country_of_residence_fk`
--        FOREIGN KEY (`country_of_residence_id`)
--            REFERENCES `country` (`id`)
--                ON DELETE RESTRICT
--                ON UPDATE RESTRICT;
--
--ALTER TABLE `applier`
--    ADD CONSTRAINT `applier_member_fk`
--        FOREIGN KEY (`member_id`)
--            REFERENCES `member` (`id`)
--                ON DELETE CASCADE
--                ON UPDATE CASCADE;
--
--ALTER TABLE `applier`
--    ADD CONSTRAINT `applier_professional_fk`
--        FOREIGN KEY (`professional_id`)
--            REFERENCES `professional` (`id`)
--                ON DELETE SET NULL
--                ON UPDATE CASCADE;
--
--ALTER TABLE `professional`
--    ADD CONSTRAINT `professional_member_fk`
--        FOREIGN KEY (`member_id`)
--            REFERENCES `member` (`id`)
--                ON DELETE CASCADE
--                ON UPDATE CASCADE;
--
--ALTER TABLE `professional_profile`
--    ADD CONSTRAINT `profile_professional_fk`
--        FOREIGN KEY (`professional_id`)
--            REFERENCES `professional` (`id`)
--                ON DELETE CASCADE
--                ON UPDATE CASCADE;
--
--ALTER TABLE `job_submission`
--    ADD CONSTRAINT `submission_professional_fk`
--        FOREIGN KEY (`professional_id`)
--            REFERENCES `professional` (`id`);
--
--ALTER TABLE `job_submission`
--    ADD CONSTRAINT `submission_applier_fk`
--        FOREIGN KEY (`applier_id`)
--            REFERENCES `applier` (`id`);
--
--ALTER TABLE `member_roles`
--    ADD CONSTRAINT `member_role_fk`
--        FOREIGN KEY (`role_id`)
--            REFERENCES `roles` (`id`)
--                ON DELETE CASCADE
--                ON UPDATE CASCADE;
--
--ALTER TABLE `member_roles`
--    ADD CONSTRAINT `member_member_fk`
--        FOREIGN KEY (`member_id`)
--            REFERENCES `member` (`id`)
--                ON DELETE CASCADE
--                ON UPDATE CASCADE;