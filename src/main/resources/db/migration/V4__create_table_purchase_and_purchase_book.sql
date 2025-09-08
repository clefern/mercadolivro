CREATE TABLE purchases (
    id int PRIMARY KEY AUTO_INCREMENT,
    customer_id int NOT NULL,
    nfe varchar(255),
    price decimal(15,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

CREATE TABLE purchase_book (
    purchase_id int NOT NULL,
    book_id int NOT NULL,
    FOREIGN KEY (purchase_id) REFERENCES purchases(id),
    FOREIGN KEY (book_id) REFERENCES books(id),
    PRIMARY key (purchase_id, book_id)
);