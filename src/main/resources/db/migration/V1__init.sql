CREATE TYPE category_enum AS ENUM ('REAL_ESTATE');
CREATE TYPE real_estate_type AS ENUM ('FLAT', 'HOSE');

create table clients (
    id bigserial primary key,
    full_name varchar(255),
    date_of_account_create timestamp
);

create table ads (
    id UUID primary key,
    title varchar(255),
    posting_date timestamp,
    description varchar(255),
    price bigint,
    actuality boolean,
    city varchar(255),
    full_address varchar(255),
    category_enum varchar(255),
    client_id bigint,
    foreign key (client_id) references clients (id)
);

create table real_estates (
    id UUID primary key,
    real_estate_type varchar(255),
    number_of_rooms smallint,
    floor smallint,
    square int,
    foreign key (id) references ads (id)
);

create table reviews(
    id bigserial primary key,
    client_id bigint,
    review_text varchar(255),
    grade smallint,
    created_at timestamp,
    client_reviewed_id bigint,
    foreign key (client_reviewed_id) references clients (id)
);

create table chats(
    id bigserial primary key,
    client_customer_id bigint,
    client_seller_id bigint,
    ad_id UUID,
    created_at timestamp,
    foreign key (client_customer_id) references clients (id)
);

create table messages(
    id bigserial primary key,
    client_id bigint,
    chat_id bigint,
    message_text varchar(255),
    created_at timestamp,
    foreign key (chat_id) references chats (id)
);