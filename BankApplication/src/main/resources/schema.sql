CREATE TABLE cg_bank_account
(
	custId BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	accountNumber INTEGER NOT NULL, 
	ifscCode INTEGER NOT NULL, 
	customerName VARCHAR(255), 
	phoneNumber INTEGER, 
	city VARCHAR(255)
);
