create DATABASE jpa_demo;
USE jpa_demo;

create table product (
    id VARCHAR(20),
    product_id VARCHAR(20),
    product_name VARCHAR(50),
    product_desc VARCHAR(200),
    product_price DOUBLE(8,2),
    product_stock INT
);