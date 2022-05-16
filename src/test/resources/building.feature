Feature: Building

  Scenario: Robot
    Given settler has 1 iron, 1 coal, 1 uran to build robot
    Then settler can build robot

  Scenario: Portal
    Given settler has 2 irons, 1 waterice, 1 uran to build portals
    Then settler can build portal

  Scenario: Fail
    Given settler without resources
    Then settler can't build