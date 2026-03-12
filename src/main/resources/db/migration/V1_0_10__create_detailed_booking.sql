CREATE TABLE DetailedBooking (
    BookingID UUID,
    PetID UUID,
    ServiceID UUID,
    Note TEXT,
    Status VARCHAR(50),

    CONSTRAINT pk_detailed_booking 
        PRIMARY KEY (BookingID, ServiceID, PetID),

    CONSTRAINT fk_detailed_booking_booking
        FOREIGN KEY (BookingID)
        REFERENCES Booking(BookingID)
        ON DELETE SET NULL,

    CONSTRAINT fk_detailed_booking_pet
        FOREIGN KEY (PetID)
        REFERENCES Pet(PetID)
        ON DELETE SET NULL,

    CONSTRAINT fk_detailed_booking_service
        FOREIGN KEY (ServiceID)
        REFERENCES Service(ServiceID)
        ON DELETE SET NULL
);
