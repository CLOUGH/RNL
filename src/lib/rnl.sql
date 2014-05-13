CREATE TABLE users (
    user_id INTEGER PRIMARY KEY AUTOINCREMENT,
    email VARCHAR(30) NOT NULL UNIQUE,
    fname VARCHAR(30) NOT NULL,
    lname VARCHAR(30) NOT NULL,
    password VARCHAR(30)NOT NULL,
    user_type VARCHAR(30) NOT NULL
);

INSERT INTO users (email,password,fname,lname,user_type)
VALUES ('clough.warren@gmail.com','rnlgtx6075','Warren','Clough','csa');

INSERT INTO users (email,password,fname,lname,user_type)
VALUES ('admin@rnl.com','pass1234','Warren','Clough','admin');