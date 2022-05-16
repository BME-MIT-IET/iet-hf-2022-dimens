Feature: Building

  Scenario: Robot
    Given settler with material to build robot
    Then settler can build robot

  Scenario: Portal
    Given settler with material to build portals
    Then settler can build portal

  Scenario: Fail
    Given settler without resources
    Then settler can't build