DROP TABLE IF EXISTS tb_article;
create table tb_article(
id serial primary key,
c_id int,
title varchar(25),
auther varchar(25),
description varchar(500),
thumbnail varchar(100),
foreign key(c_id) references tb_category(id) on delete cascade on update cascade
);