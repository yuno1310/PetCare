CREATE TABLE Employee (
    EmployeeID UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    BranchID UUID,
    Name VARCHAR(255) NOT NULL,
    DateOfBirth TIMESTAMPTZ,
    StartDate TIMESTAMPTZ,
    Gender VARCHAR(20),
    Salary DECIMAL(12, 2),
    Position VARCHAR(100),
    CONSTRAINT fk_branch
        FOREIGN KEY (BranchID) 
        REFERENCES Branch(BranchID)
        ON DELETE SET NULL
);
