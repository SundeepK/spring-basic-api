Feature:
  AS a consumer of spring basic api
  I want to get my custom path variable and param variable
  SO that I can make requests using custom path and param variables

  Scenario: Api returns 200 for unknown address
    When I get test/mytestpath?bar=mytestparam
    Then response is a "200"
    And the JSON should be:
      """
      {
        "message": "mytestpath mytestparam"
      }
      """
