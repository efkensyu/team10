DROP TABLE IF EXISTS team10_pets_tbl;
DROP TABLE IF EXISTS team10_breed_tbl;
DROP TABLE IF EXISTS team10_size_tbl;

-- 1. サイズテーブル
CREATE TABLE team10_size_tbl (
    size_id INT NOT NULL AUTO_INCREMENT,
    size_name VARCHAR(10) NOT NULL,
    PRIMARY KEY (size_id)
);

-- 2. 犬種テーブル
CREATE TABLE team10_breed_tbl (
    breed_id INT NOT NULL AUTO_INCREMENT,
    breed_name VARCHAR(100) NOT NULL,
    size_id INT NOT NULL,
    breed_image VARCHAR(255),
    feature TEXT,
    PRIMARY KEY (breed_id),
    FOREIGN KEY (size_id) REFERENCES team10_size_tbl(size_id)
);

-- 3. ペットテーブル
CREATE TABLE team10_pets_tbl (
    pet_id INT NOT NULL AUTO_INCREMENT,
    pet_name VARCHAR(100) NOT NULL,
    breed_id INT,
    pet_image VARCHAR(255), 
    pet_pass VARCHAR(255) NOT NULL,
    gender VARCHAR(10),
    birthday DATE,
    memo TEXT,
    PRIMARY KEY (pet_id),
    CONSTRAINT fk_pets_breed FOREIGN KEY (breed_id) REFERENCES team10_breed_tbl(breed_id)
);

