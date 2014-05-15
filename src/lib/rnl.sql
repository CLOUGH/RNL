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

CREATE TABLE merchants(
    reg_num INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    branch_num INTEGER,
    merchant_name VARCHAR(30) NOT NULL,
    address VARCHAR(100) NOT NULL,
    phone_number VARCHAR(30),
    email VARCHAR(30) NOT NULL
);
INSERT INTO merchants (reg_num,branch_num,merchant_name, address, phone_number, email)
VALUES ('1','1','MegaMart','Portmore','876-456-789','merchant@megamart.com.jm');

CREATE TABLE loyalty_programs(
    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    merchant INTEGER NOT NULL,
    program_name VARCHAR(30) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    program_type VARHCAR(30) NOT NULL,
    description VARCHAR(1000),

    FOREIGN KEY (merchant) REFERENCES merchants(reg_num) ON DELETE CASCADE ON UPDATE CASCADE    
);

INSERT INTO loyalty_programs(id,merchant,program_name, start_date,end_date,program_type,description)
VALUES('1','1','MegaMart Magna','2013-01-01','2016-01-01','magna','Magna program thats offered by MegaMart');

CREATE TABLE card_accounts(
    account_num INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    user_id INTEGER NOT NULL,
    expiry_date DATE NOT NULL,
    issuer INTEGER NOT NULL,
    points_earned INTEGER NOT NULL,
    loyalty_program INTEGER NOT NULL,
    
    FOREIGN KEY (loyalty_program) REFERENCES loyalty_program(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (issuer) REFERENCES users(user_id) ON DELETE CASCADE ON UPDATE CASCADE   
);

INSERT INTO card_accounts(account_num,loyalty_program, user_id,expiry_date,issuer,points_earned)
VALUES('1','1','4', '2016-01-01','2','100');