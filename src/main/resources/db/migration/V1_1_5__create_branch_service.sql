CREATE TABLE BranchService (
    BranchID UUID NOT NULL,
    ServiceID UUID NOT NULL,
    IsAvailable BOOLEAN DEFAULT TRUE,
    EffectiveDate TIMESTAMPTZ DEFAULT CURRENT_TIMESTAMP,

    PRIMARY KEY (BranchID, ServiceID),

    CONSTRAINT fk_branchservice_branch 
        FOREIGN KEY (BranchID) 
        REFERENCES Branch(BranchID) 
        ON DELETE CASCADE,

    CONSTRAINT fk_branchservice_service 
        FOREIGN KEY (ServiceID) 
        REFERENCES Service(ServiceID) 
        ON DELETE CASCADE
);
