CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(20) NOT NULL,
    full_name VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    phone VARCHAR(50) NOT NULL,
    password_hash VARCHAR(50) NOT NULL,
    user_type VARCHAR(20) NOT NULL CHECK(user_type IN ('CLIENT', 'PROVIDER')) NOT NULL,
    created_at TIMESTAMP DEFAULT now(),
    updates_at TIMESTAMP DEFAULT now()
);
