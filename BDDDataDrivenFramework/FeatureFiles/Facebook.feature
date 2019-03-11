Feature: Facebook Testing
  I want to use this template for my feature file

  @shiva @tag1
  Scenario Outline: Facebook login testing 
    And set test id "<TestID>"
    Given user read test data from Excel "E:\\vikky selenium\\prgrms\\BDDDataDrivenFramework\\ExcelSheets\\TestData.xlsx"
    And user read objects from property file "E:\\vikky selenium\\prgrms\\BDDDataDrivenFramework\\PropertyFiles\\PF1.properties"
    And user open browser "Chrome"
    And user open Application using URL "#URL"
    And user enter text "#homepageUsernameTextBox" into textBox "#Gmail"
    And user enter text "#homepagePasswordTextBox" into textBox "#Password"
    And user click on "#homepageLoginButton"
    And user close browser

    Examples: 
      | TestID |
      | Test2  |
      | Test3  |
