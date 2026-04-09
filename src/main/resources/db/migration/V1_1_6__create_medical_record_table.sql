CREATE TABLE MedicalRecord (
    MedicalRecordID UUID PRIMARY KEY,
    VetID UUID NOT NULL,
    PetID UUID NOT NULL,
    Symptoms TEXT,
    Diagnosis TEXT, 
    ReExamDate TIMESTAMPTZ,
    Notes TEXT,

    CONSTRAINT fk_medicalrecord_base 
        FOREIGN KEY (MedicalRecordID) 
        REFERENCES Visit(VisitID) 
        ON DELETE CASCADE,

    CONSTRAINT fk_medicalrecord_vet 
        FOREIGN KEY (VetID) 
        REFERENCES Employee(EmployeeID) 
        ON DELETE CASCADE,

    CONSTRAINT fk_medicalrecord_pet 
        FOREIGN KEY (PetID) 
        REFERENCES Pet(PetID) 
        ON DELETE CASCADE
);
