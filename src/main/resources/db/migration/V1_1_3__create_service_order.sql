CREATE TABLE ServiceOrder (
    OrderID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    VisitID UUID NOT NULL,
    PetID UUID NOT NULL,
    ServiceID UUID NOT NULL,
    Note TEXT,
    State VARCHAR(50) NOT NULL, 

    CONSTRAINT fk_serviceorder_visit 
        FOREIGN KEY (VisitID) 
        REFERENCES Visit(VisitID) 
        ON DELETE CASCADE,
    CONSTRAINT fk_serviceorder_pet 
        FOREIGN KEY (PetID) 
        REFERENCES Pet(PetID) 
        ON DELETE CASCADE,
    CONSTRAINT fk_serviceorder_service 
        FOREIGN KEY (ServiceID) 
        REFERENCES Service(ServiceID) 
        ON DELETE CASCADE
);
