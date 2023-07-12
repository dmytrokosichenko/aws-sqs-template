
CREATE TABLE IF NOT EXISTS recipient(

    id VARCHAR(36) PRIMARY KEY DEFAULT gen_random_uuid(),
    channel VARCHAR(255) NOT NULL,
    text VARCHAR(200),
    address  VARCHAR(1024),
    full_name  VARCHAR(1000)
);
