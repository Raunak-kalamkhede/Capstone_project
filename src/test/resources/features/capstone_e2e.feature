Feature: Capstone Omni-Channel Validation Engine

  @Capstone
  Scenario: Enterprise E2E validation combining UI, API, Data, and Performance
    Given the backend API is validated and active via Rest-Assured
    And I read user credentials dynamically from the Excel sheet
    When I execute a UI login on SauceDemo via Selenium Grid
    Then I stress test the backend infrastructure using JMeter