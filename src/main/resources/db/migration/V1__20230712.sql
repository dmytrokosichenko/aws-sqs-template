
CREATE TABLE IF NOT EXISTS notification(

    id VARCHAR(36) PRIMARY KEY DEFAULT gen_random_uuid(),
    subject VARCHAR(255) NOT NULL,
    text VARCHAR(200),
    recipient_uid  VARCHAR(36)
);