drop database if exists `product_demo`;
create database `product_demo`;
use product_demo;
CREATE TABLE product (
    id INT NOT NULL UNIQUE AUTO_INCREMENT,
    product_code VARCHAR(45),
    product_name VARCHAR(45),
    product_price VARCHAR(45),
    product_amount VARCHAR(45),
    product_description VARCHAR(45),
    product_status VARCHAR(45)
);
--  Bước 3:
-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
-- So sánh câu truy vấn trước và sau khi tạo index
create unique index p_code on product(product_code);
create  index `name` on product(product_name,product_price);
insert into product values (1,'abc','hoang','zzz',111,'sss','s');
insert into product values (2,'xzy','hoang','zzz',111,'sss','s');
explain select * from product where product_name='abc';
-- Bước 4:
-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
-- Tiến hành sửa đổi view
-- Tiến hành xoá view
CREATE VIEW product_view AS
    SELECT 
        product_code, product_name, product_price, product_status
    FROM
        product;
SELECT 
    *
FROM
    product_view;
CREATE OR REPLACE VIEW product_view AS
    SELECT 
        product_code, product_name
    FROM
        product
    WHERE
        product_code = 'xzy';
drop view product_view;
-- Bước 5:
-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
-- Tạo store procedure thêm một sản phẩm mới
-- Tạo store procedure sửa thông tin sản phẩm theo id
-- Tạo store procedure xoá sản phẩm theo id
Delimiter //
create procedure p_look ()
begin 
	select * from product;
end ;
//
create procedure add_p( in `code` varchar(45) , in `name` varchar(45))
begin 
	insert into product (product_code,product_name)
    value(`code`,`name`);
end;
//
create procedure edit_p(in `id` int,in `code` varchar(45) , in `name` varchar(45))
begin 
	update product p set p.product_code= `code`, p.product_name= `name`
    where p.id=`id`;
end;
//
create procedure del_p(in `id` int)
begin
	delete from product p where p.id= `id`;
end;
//
delimiter ;
call add_p('123','ssss');
call edit_p (1,'aaa','bb');
call del_p (2);
call p_look;
