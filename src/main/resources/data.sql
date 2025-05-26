CREATE TABLE IF NOT EXISTS employees (
                                         id VARCHAR(255) PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    curp VARCHAR(255),
    position VARCHAR(255),
    immediate_boss_id VARCHAR(255),
    street VARCHAR(255),
    exterior_number VARCHAR(255),
    interior_number VARCHAR(255),
    neighborhood VARCHAR(255),
    municipality VARCHAR(255),
    state VARCHAR(255),
    country VARCHAR(255)
    );

INSERT INTO employees (id, first_name, last_name, curp, position, immediate_boss_id, street, exterior_number, interior_number, neighborhood, municipality, state, country)
VALUES
    ('1', 'John', 'Doe', 'CURP123456', 'Manager', NULL, '123 Main St', '1', NULL, 'Downtown', 'City Center', 'State', 'Country'),
    ('2', 'Jane', 'Smith', 'CURP654321', 'Developer', '1', '456 Elm St', '2', NULL, 'Uptown', 'City Center', 'State', 'Country'),
    ('3', 'Alice', 'Johnson', 'CURP789012', 'Developer', '1', '789 Oak St', '3', NULL, 'Uptown', 'City Center', 'State', 'Country');