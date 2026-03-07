CREATE TABLE Booking (
    BookingID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    CustomerID UUID,
    EmployeeID UUID,
    PetID UUID,
    BranchID UUID,
    BookingTime TIMESTAMP,
    Status VARCHAR(50),
    CreatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    Note TEXT,
    CONSTRAINT fk_booking_customer 
        FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE SET NULL,
    CONSTRAINT fk_booking_employee 
        FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID) ON DELETE SET NULL,
    CONSTRAINT fk_booking_pet 
        FOREIGN KEY (PetID) REFERENCES Pet(PetID) ON DELETE SET NULL,
    CONSTRAINT fk_booking_branch 
        FOREIGN KEY (BranchID) REFERENCES Branch(BranchID) ON DELETE SET NULL
);
