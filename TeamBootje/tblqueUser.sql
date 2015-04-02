CREATE TABLE IF NOT EXISTS `Users`
(
	 `UID`	 	INT(11)			PRIMARY KEY
	,`Username`	VARCHAR(100)		NOT NULL
	,`Password`	VARCHAR(100)		NOT NULL
	,`Name`		VARCHAR(45)
);


INSERT INTO `teambootje`.`users` (`UID`, `Username`, `Password`, `Name`) VALUES (NULL, 'User', 'User', 'User');