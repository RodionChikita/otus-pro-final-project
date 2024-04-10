create table shoes (
    id UUID primary key,
    size smallint,
    brand varchar(255),
    foreign key (id) references ads (id)
);