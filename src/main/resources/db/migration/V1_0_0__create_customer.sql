CREATE TABLE Customer (
  CustomerID UUID PRIMARY KEY,
  Name VARCHAR(100) NOT NULL,
  PhoneNumber VARCHAR(20),
  Email VARCHAR(100),
  CitizenID VARCHAR(20) UNIQUE,
  Gender VARCHAR(10),
  DateOfBirth TIMESTAMPTZ,
  LoyaltyPoints INT DEFAULT(0),
  MembershipTier VARCHAR(50) DEFAULT 'Standard'
);
