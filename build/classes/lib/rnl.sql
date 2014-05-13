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
VALUES ('csa@rnl.com','1234','Test','User','csa');

INSERT INTO users (email,password,fname,lname,user_type)
VALUES ('admin@rnl.com','pass1234','Warren','Clough','admin');

INSERT INTO users (email,password,fname,lname,user_type)
VALUES ('customer@rnl.com','1234','Test','User','customer');

CREATE TABLE csa (
    user_id INTEGER PRIMARY KEY NOT NULL,
    csa_type VARCHAR(30) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(users_id) ON DELETE CASCADE ON UPDATE CASCADE
); 

INSERT INTO csa(user_id, csa_type)
VALUES ('1','regular');

CREATE TABLE customers(
    user_id INTEGER PRIMARY KEY NOT NULL,
    gender VARCHAR(30) NOT NULL,
    dob DATE NOT NULL,
    trn VARCHAR UNIQUE NOT NULL,
    phone VARCHAR(30),
   
    FOREIGN KEY (user_id) REFERENCES users(users_id) ON DELETE CASCADE ON UPDATE CASCADE   
);

INSERT INTO customers (user_id,gender,dob,trn,phone)
VALUES ('4','Male','1992-02-12','123-456-789','3937739');