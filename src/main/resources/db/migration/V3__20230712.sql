ALTER TABLE notification ADD CONSTRAINT fk_notification_recipient_id
FOREIGN KEY (recipient_uid) REFERENCES recipient(id);
