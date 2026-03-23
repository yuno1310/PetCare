CREATE TABLE ServiceRecord (
    OrderID UUID PRIMARY KEY,
    CreateDate TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_servicerecord_order 
        FOREIGN KEY (OrderID) 
        REFERENCES ServiceOrder(OrderID) 
        ON DELETE CASCADE
);
