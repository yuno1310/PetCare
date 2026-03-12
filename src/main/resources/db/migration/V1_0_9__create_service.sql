CREATE TABLE Service (
    ServiceID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    TypeID UUID NOT NULL,
    Name VARCHAR(255),
    Price DOUBLE PRECISION,

    CONSTRAINT fk_service_type
        FOREIGN KEY (TypeID) 
        REFERENCES ServiceType(TypeID) 
        ON DELETE SET NULL 
);
