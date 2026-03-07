
CREATE TABLE Branch (
    BranchID CHAR(36) PRIMARY KEY DEFAULT gen_random_uuid(),
    Name VARCHAR(255) NOT NULL,
    Address TEXT,
    Phone VARCHAR(50),
    OpenTime TIMESTAMPTZ,
    CloseTime TIMESTAMPTZ
);
