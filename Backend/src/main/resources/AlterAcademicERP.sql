ALTER TABLE specialization MODIFY COLUMN name VARCHAR(255);
ALTER TABLE specialization_course ADD CONSTRAINT fk_specialization FOREIGN KEY (specialization_id) REFERENCES specialization(specialization_id) ON DELETE CASCADE;
