CREATE TABLE items (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    creation_date TIMESTAMP NOT NULL,
    quantity INTEGER NOT NULL,
    fulfilled_quantity INTEGER NOT NULL,
    item_id INTEGER REFERENCES items(id),
    user_id INTEGER REFERENCES users(id)
);

CREATE TABLE stocks (
    id SERIAL PRIMARY KEY,
    creation_date TIMESTAMP NOT NULL,
    quantity INTEGER NOT NULL,
    item_id INTEGER REFERENCES items(id)
);

CREATE TABLE order_stock (
    id SERIAL PRIMARY KEY,
    order_id INTEGER REFERENCES orders(id),
    stock_movement_id INTEGER REFERENCES stocks(id),
    quantity_used INTEGER NOT NULL
);
