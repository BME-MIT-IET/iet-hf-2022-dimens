Feature: Hiding

  Scenario: Safe
    Given asteroid is empty and layercount is 0
    When asteroid is in sunstorm
    Then settler can hide

  Scenario: Death
    Given asteroid is empty but layerCount is not 0
    When asteroid is in sunstorm
    Then settler dies