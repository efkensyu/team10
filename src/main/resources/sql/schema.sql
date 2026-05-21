/*DROP TABLE IF EXISTS BUMON_TBL;
CREATE TABLE BUMON_TBL(
	BUMON_CD CHAR(3),
	BUMON_NM VARCHAR2(20),
	PRIMARY KEY(BUMON_CD)
	);*/
	
/*create table size_tbl (size_id int auto_increment primary key,  size_name varchar(10));*/
CREATE TABLE size_tbl (
    size_id INT NOT NULL AUTO_INCREMENT,
    size_name VARCHAR(10) NOT NULL,
    PRIMARY KEY (size_id)
);

	
/*CREATE TABLE breed_tbl ( breed_id INT NOT NULL AUTO_INCREMENT,-- 犬種ID（主キー、NOT NULL、自動採番）
breed_name VARCHAR(100) NOT NULL, -- 犬種名（NOT NULL）
size_id INT NOT NULL, -- サイズID（NOT NULL、外部キー対象） 
breed_image LONGBLOB, -- 犬種画像（バイナリデータを保存可能） 
feature TEXT, -- 特徴（長文に対応できるテキスト型） 
PRIMARY KEY (breed_id), -- 主キーの設定 
FOREIGN KEY (size_id) REFERENCES size_tbl(size_id); -- 外部キーの設定 ) */

CREATE TABLE breed_tbl (
    breed_id INT NOT NULL AUTO_INCREMENT,
    breed_name VARCHAR(100) NOT NULL,
    size_id INT NOT NULL,
    breed_image LONGBLOB,
    feature TEXT,
    PRIMARY KEY (breed_id),
    FOREIGN KEY (size_id) REFERENCES size_tbl(size_id)
);


/*CREATE TABLE pets_tbl (
    pet_id      INT NOT NULL AUTO_INCREMENT,   -- ★これが必要！主キー用のID（自動採番）
    pet_name    VARCHAR(100) NOT NULL,
    breed_id    INT,
    pet_image   LONGBLOB,
    pet_pass    VARCHAR(255) NOT NULL,
    gender      VARCHAR(10),
    birthday    DATE,
    memo        TEXT,
    PRIMARY KEY (pet_id),
    CONSTRAINT fk_pets_breed FOREIGN KEY (breed_id) REFERENCES breed_tbl(breed_id)
);*/

CREATE TABLE pets_tbl (
    pet_id INT NOT NULL AUTO_INCREMENT,
    pet_name VARCHAR(100) NOT NULL,
    breed_id INT,
    pet_image LONGBLOB,
    pet_pass VARCHAR(255) NOT NULL,
    gender VARCHAR(10),
    birthday DATE,
    memo TEXT,
    PRIMARY KEY (pet_id),
    CONSTRAINT fk_pets_breed FOREIGN KEY (breed_id) REFERENCES breed_tbl(breed_id)
);


