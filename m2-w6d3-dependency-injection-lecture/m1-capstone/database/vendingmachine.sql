DROP TABLE inventory;
DROP TABLE log;
DROP TABLE sales_report;
DROP TABLE sales_report_items;

CREATE TABLE inventory (
        slot char(2) not null primary key,
        name varchar(128) not null,
        price decimal(6,2) not null,
        type varchar(10) not null
      );
      
CREATE TABLE log (
        id serial not null primary key,
        action varchar(50) not null,
        beginning_balance decimal(7,2),
        ending_balance decimal(7,2),
        entry_date timestamp
      );
      
CREATE TABLE sales_report (
        id serial not null primary key,
        total_amount decimal(7,2)
      );
      
CREATE TABLE sales_report_items (
        sales_report_id int not null,
        item varchar(50) not null,
        number_sold int not null
      );
      
 INSERT INTO inventory VALUES ('A1', 'Postgres Chips', 4.55, 'Chip');
 INSERT INTO inventory VALUES ('A2', 'Db Crisps', 1.75, 'Chip');
 INSERT INTO inventory VALUES ('B1', 'Sun Cake', 2.85, 'Candy');
 INSERT INTO inventory VALUES ('B2', 'Horse Mane', 3.50, 'Candy');
 INSERT INTO inventory VALUES ('B3', 'Tabletales', 1.50, 'Candy');
 INSERT INTO inventory VALUES ('C1', 'Insert Juice', 1.00, 'Drink');
 INSERT INTO inventory VALUES ('C2', 'Update Cola', 1.75, 'Drink');
 INSERT INTO inventory VALUES ('C3', 'Select Water', 3.25, 'Drink');
 INSERT INTO inventory VALUES ('C4', 'Delete Milk', 0.80, 'Drink');
 
 INSERT INTO inventory VALUES ('D1', 'Chewie Postgres', 1.80, 'Gum');
 INSERT INTO inventory VALUES ('D2', 'Yum Yum check', 0.75, 'Gum');
 INSERT INTO inventory VALUES ('D3', 'Tablemine', 0.65, 'Gum');
 INSERT INTO inventory VALUES ('D4', 'Columngreen', 1.10, 'Gum');
 INSERT INTO inventory VALUES ('D5', 'Rowlets', 1.05, 'Gum');
 
 INSERT INTO sales_report VALUES(1, 0.00);

