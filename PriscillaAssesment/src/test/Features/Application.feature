@testing
Feature: ILab Assessment

  Scenario Outline: Job Application to ILab


    Given I want to apply from ILab side
    When I click on careers
    And select south Africa link
    And select the the advertised Jobs
    #And click on the apply online link
    #And I should be able to enter "<applicatName>" "<emailAddress>" "<message>"
    And I type in my personal details "<applicatName>" and "<surname>" "<emailAddress>" "<message>"
    Then i should be able to submit the application and quite the browser


    Examples:
      | applicatName |surname| emailAddress							  |message|
      | Priscilla    |Muleya | automationAssessment@iLabQuality.com   | I am respoding to the advitised position|