CREATE TABLE Visit (
    VisitID UUID PRIMARY KEY DEFAULT gen_random_uuid(), 
    BookingID UUID NOT NULL,
    BranchID UUID NOT NULL,
    CustomerID UUID NOT NULL,
    EmployeeID UUID NOT NULL,
    TimeIn TIMESTAMPTZ NOT NULL,

    CONSTRAINT fk_visit_booking 
        FOREIGN KEY (BookingID) REFERENCES Booking(BookingID) ON DELETE CASCADE,
    CONSTRAINT fk_visit_branch 
        FOREIGN KEY (BranchID) REFERENCES Branch(BranchID) ON DELETE CASCADE,
    CONSTRAINT fk_visit_customer 
        FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE CASCADE,
    CONSTRAINT fk_visit_employee 
        FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID) ON DELETE CASCADE
);
