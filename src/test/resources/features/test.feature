@runnable
Feature: Booking flight
  As an User
  I want to be able to booking flight with wrong card number
  To be able get information about problem with payment

  Scenario: Book a flight
    Given Ryanair page open
    When User book a flight with incorrect card number
    Then He will be able to see correct error message

