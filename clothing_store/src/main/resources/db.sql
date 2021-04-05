create table roles(id serial primary key, role_name varchar(250));
create table users(id serial primary key, name varchar(250), surname varchar(250), email varchar(50),username varchar(250), password varchar(250), address varchar(250),role_id int, foreign key(role_id) references roles(id));
create table orders(id serial primary key, total float, shipping_address varchar(250), order_address varchar(250), order_date date,id_user int, foreign key(id_user) references users(id));
create table category(id serial primary key, c_name varchar(250));
create table subcategory(id serial primary key, pc_name varchar(250), id_category int, foreign key(id_category) references category(id));
create table products(id serial primary key, name varchar(250), description text, price float, p_size varchar(250), id_subcategory int, foreign key(id_subcategory) references subcategory(id));
create table order_items(id serial primary key, quantity int, amount int,id_order int, id_product int, foreign key(id_order) references orders(id), foreign key(id_product) references products(id));