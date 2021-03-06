CREATE TABLE `html_page` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `organization_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `document_no` int(11) DEFAULT NULL,
  `page_no` int(11) DEFAULT NULL,
  `order` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `html` text DEFAULT NULL,
  `html_no_tag` text DEFAULT NULL,
  `stake_holder_id` int(11) DEFAULT NULL,
  `yesr` int(11) DEFAULT NULL,
  `active` tinyint(3) unsigned NOT NULL DEFAULT 1,
  `create_time` datetime DEFAULT current_timestamp(),
  `create_by` varchar(255) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `delete_time` datetime DEFAULT NULL,
  `delete_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;