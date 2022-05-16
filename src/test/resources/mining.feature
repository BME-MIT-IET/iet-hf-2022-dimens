Feature: Mining

  Scenario: Mine
    Given asteroid has resource and layercount is 0
    Then settler can mine it

  Scenario: Fail
    Given asteroid is empty and layerCount is 0
    Then settler can't mine

  Scenario: Fail2
    Given asteroid layerCount is 2
    Then settler can't mine

