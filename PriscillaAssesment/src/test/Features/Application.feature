
Feature: Search fro product test
  @testing
  Scenario Outline: Testing searching and adding to cart
    Given I open a browser and enter url
    When when I search for "<hair product>"
    Then I should get it and add to cat



    Examples:
      | hair product |
      | hair product |

