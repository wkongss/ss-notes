Feature: Is it Friday?

  # Scenario: Sunday is not Friday
  #   Given today is "Sunday"
  #   When I ask if it is Friday
  #   Then I should be told "No"

  # Scenario: Friday is Friday
  #   Given today is "Friday"
  #   When I ask if it is Friday
  #   Then I should be told "Yes"

  Scenario Outline: Today is or is not Friday
    Given today is "<day>"
    When I ask if it is Friday
    Then I should be told "<response>"

    Examples:
      | day       | response |
      | Sunday    | No       |
      | Monday    | No       |
      | Tuesday   | No       |
      | Wednesday | No       |
      | Thursday  | No       |
      | Friday    | Yes      |
      | Saturday  | No       |