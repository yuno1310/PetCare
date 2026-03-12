CREATE TABLE ServiceType (
    TypeID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    Name VARCHAR(255) NOT NULL
);


