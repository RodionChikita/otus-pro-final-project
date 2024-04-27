CREATE TYPE category_enum AS ENUM ('REAL_ESTATE', 'SHOES');
CREATE TYPE real_estate_type AS ENUM ('FLAT', 'HOSE');

CREATE TABLE clients (
    id bigserial PRIMARY KEY,
    full_name VARCHAR(255),
    date_of_account_create TIMESTAMP
);

CREATE TABLE ads (
    id UUID PRIMARY KEY,
    title VARCHAR(255),
    posting_date TIMESTAMP,
    description VARCHAR(255),
    price bigint,
    actuality boolean,
    city VARCHAR(255),
    full_address VARCHAR(255),
    category_enum VARCHAR(255),
    client_id bigint,
    FOREIGN KEY (client_id) REFERENCES clients (id)
);

CREATE TABLE client_featured_ads(
    id bigserial PRIMARY KEY,
    client_id bigint NOT NULL,
    ad_id UUID NOT NULL,
    UNIQUE(client_id, ad_id),
    FOREIGN KEY (client_id) REFERENCES clients (id),
    FOREIGN KEY (ad_id) REFERENCES ads (id)
);

CREATE TABLE real_estates (
    id UUID PRIMARY KEY,
    real_estate_type VARCHAR(255),
    number_of_rooms SMALLINT,
    floor SMALLINT,
    square INT,
    foreign key (id) REFERENCES ads (id)
);

CREATE TABLE reviews(
    id bigserial PRIMARY KEY,
    client_id bigint,
    review_text VARCHAR(255),
    grade SMALLINT,
    created_at TIMESTAMP,
    client_reviewed_id bigint,
    FOREIGN KEY (client_reviewed_id) REFERENCES clients (id)
);

CREATE TABLE chats(
    id bigserial PRIMARY KEY,
    client_customer_id bigint,
    client_seller_id bigint,
    ad_id UUID,
    created_at TIMESTAMP,
    FOREIGN KEY (client_customer_id) REFERENCES clients (id)
);

CREATE TABLE messages(
    id bigserial PRIMARY KEY,
    client_id bigint,
    chat_id bigint,
    message_text VARCHAR(255),
    created_at TIMESTAMP,
    FOREIGN KEY (chat_id) REFERENCES chats (id)
);

CREATE TABLE shoes (
    id UUID PRIMARY KEY,
    size SMALLINT,
    brand VARCHAR(255),
    FOREIGN KEY (id) REFERENCES ads (id)
);