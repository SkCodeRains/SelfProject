	drop database if exists taskManager;
	CREATE database if not exists  taskManager;
	use taskManager;
CREATE TABLE `taskmanager`.`users` (
  `idUsers` INT NOT NULL AUTO_INCREMENT,
  `UserName` VARCHAR(255) NOT NULL,
  `firstname` VARCHAR(255) NULL,
  `lastname` VARCHAR(255) NULL,
  `middlename` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `EmailID` VARCHAR(255) NOT NULL,
  `DOB` VARCHAR(255) NOT NULL,  
  PRIMARY KEY (`idUsers`),
  UNIQUE INDEX `UserName_UNIQUE` (`UserName` ASC) VISIBLE,
  UNIQUE INDEX `EmailID_UNIQUE` (`EmailID` ASC) VISIBLE);
  
  
	CREATE TABLE TaskState (
    `id` INT NOT NULL AUTO_INCREMENT,
    `USERID` INT NOT NULL,
    `TodoTask` TEXT NULL,
    `ContinueTask` TEXT NULL, 
    `CompleteTask` TEXT NULL,
    `datesss` DATETIME NULL DEFAULT (NOW()),
    PRIMARY KEY (`ID`),
  CONSTRAINT `USERTASK`
    FOREIGN KEY (`USERID`)
    REFERENCES `taskmanager`.`users` (`idUsers`)
  );
DELIMITER $$
CREATE PROCEDURE `addUsers` (id int,fname varchar(255),lname varchar(255),mname varchar(255),username varchar(255),password varchar(255),email varchar(255),dob varchar(255))
BEGIN
insert into users(idUsers,UserName ,firstname,lastname,middlename,password,EmailID,DOB) values(id,username,fname,lname,mname,password,email,dob);
END$$

	CREATE PROCEDURE getData(whereid varchar(20))
	BEGIN
    select DISTINCT id,TodoTask from TaskState where USERID=whereid and TodoTask is not null  ORDER BY `datesss`  desc ;
    select DISTINCT id,ContinueTask from TaskState where USERID=whereid and ContinueTask is not null  ORDER BY `datesss`  desc ;
    select DISTINCT id,CompleteTask from TaskState where USERID=whereid and CompleteTask is not null  ORDER BY `datesss`  desc ;
	END $$
	CREATE PROCEDURE movedata(idp int,fromto   VARCHAR(20), tofor  VARCHAR(20))
	BEGIN
		SET @sql := CONCAT( 'update TaskState set ', tofor, '=', fromto, ',', fromto, '=null where id=', idp,';');
		PREPARE stmt1 from @sql;	
		EXECUTE stmt1;
		DROP PREPARE stmt1;
		END $$
	CREATE PROCEDURE UpdateTask(idp int,upData text, tofor VARCHAR(20))
	BEGIN
	set @sql =CONCAT('UPDATE TASKSTATE SET ',tofor,'="',upData,'" where id=',idp);
		PREPARE stmt1 from @sql;	
		EXECUTE stmt1;
		DROP PREPARE stmt1;
	END $$
	CREATE PROCEDURE addTask( ids int,UID INT)
	BEGIN
	insert into TaskState(id,USERID,TodoTask) values (ids,UID,'Double Click To Edit');
	END $$
	create procedure deletetask(idp int )
	begin
		DELETE FROM TaskState where id=idp;
	end $$	
    CREATE PROCEDURE `varify` (namess varchar(255),passwords varchar(255))
BEGIN
select idusers from users where username=namess and password=passwords;
END$$
create procedure `username` (id varchar(255))
begin
SELECT IF (EXISTS(select `username` from users where `username`=id)>0, 0, 1);
END$$

    
DELIMITER ;
insert into taskstate(id,userid,todotask)  values(34,2204,"hello");
insert into taskstate(id,userid,CompleteTask)  values(342,2204,"hello");
insert into taskstate(id,userid,CompleteTask)  values(341,2204,"hello");
insert into taskstate(id,userid,ContinueTask)  values(3422,2204,"hello");

select  * from TaskState;
select  * from users;
call username("a");
delete from users where idusers= 2204; 
call getData(1240);