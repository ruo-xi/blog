
CREATE DATABASE blog DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `password` varchar(255) NOT NULL,
    `mail` varchar(255) DEFAULT NULL,
    `phone_number` varchar(255) DEFAULT NULL,
    `name` varchar(255) NOT NULL,
    `address` varchar(255) DEFAULT NULL,
    `sex` enum('男','女','保密') DEFAULT '保密',
    `intro` varchar(255) DEFAULT NULL,
    `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
    `update_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `follow_count` int(11) DEFAULT '0',
    `fan_count` int(11) DEFAULT '0',
    `avatar_url` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_name` (`name`),
    UNIQUE KEY `unique_mail` (`mail`),
    UNIQUE KEY `unique_phone_number` (`phone_number`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
   `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
   `author_id` int(11) unsigned DEFAULT NULL,
   `title` varchar(255) NOT NULL,
   `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
   `update_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `view_counts` int(11) DEFAULT '0',
   `like_counts` int(11) DEFAULT '0',
   `summary` varchar(255) DEFAULT NULL,
   `body_url` varchar(255) NOT NULL,
   `category_id` int(11) unsigned DEFAULT NULL,
   PRIMARY KEY (`id`),
   KEY `author_id` (`author_id`),
   KEY `category_id` (`category_id`),
   CONSTRAINT `article_ibfk_1` FOREIGN KEY (`author_id`) REFERENCES `user` (`id`),
   CONSTRAINT `article_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
    `star_user_id` int(11) unsigned NOT NULL,
    `stared_user_id` int(11) unsigned NOT NULL,
    PRIMARY KEY (`stared_user_id`,`star_user_id`),
    KEY `star_user_id` (`star_user_id`),
    CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`star_user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`stared_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `comment_comment`;
CREATE TABLE `comment_comment` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `comment_id` int(11) unsigned NOT NULL,
    `user_id` int(11) unsigned NOT NULL,
    `reply_user_id` int(11) unsigned NOT NULL,
    `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
    `like_counts` int(11) DEFAULT '0',
    PRIMARY KEY (`id`),
    KEY `comment_id` (`comment_id`),
    KEY `user_id` (`user_id`),
    KEY `reply_user_id` (`reply_user_id`),
    CONSTRAINT `comment_comment_ibfk_1` FOREIGN KEY (`comment_id`) REFERENCES `comment_article` (`id`),
    CONSTRAINT `comment_comment_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `comment_comment_ibfk_3` FOREIGN KEY (`reply_user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `comment_article`;
CREATE TABLE `comment_article` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `user_id` int(11) unsigned NOT NULL,
    `article_id` int(11) unsigned NOT NULL,
    `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
    `like_counts` int(11) DEFAULT '0',
    PRIMARY KEY (`id`),
    KEY `user_id` (`user_id`),
    KEY `article_id` (`article_id`),
    CONSTRAINT `comment_article_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `comment_article_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
    `user_id` int(11) unsigned NOT NULL,
    `article_id` int(11) unsigned NOT NULL,
    `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`user_id`,`article_id`),
    KEY `article_id` (`article_id`),
    CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
    `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
    `cate_name` varchar(255) NOT NULL,
    `cate_desc` varchar(255) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci





