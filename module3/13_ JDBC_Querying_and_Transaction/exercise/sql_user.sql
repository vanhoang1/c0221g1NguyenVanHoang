drop  procedure if exists get_all_user;
drop  procedure if exists update_user;
DELIMITER $$
CREATE PROCEDURE get_all_user()
BEGIN
    SELECT *

    FROM users;

    END$$
DELIMITER ;
call get_all_user();
DELIMITER $$
CREATE PROCEDURE update_user(in p_id int,in p_name varchar(120),in p_email varchar(220) , in p_country varchar(120))
BEGIN
    update users set name=p_name ,email= p_email,country=p_country where id=p_id;
END$$
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE delete_user(in p_id int)
BEGIN
    delete from users where id = p_id;
END$$
DELIMITER ;
