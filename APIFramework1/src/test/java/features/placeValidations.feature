   Feature: Validating place API's
      
      Scenario Outline: Verifying if place is being successfully added using addplace API
      Given Add place payload "<name>" "<language>" "<address>"
      When User calls "AddPlaceAPI" with "POST" http request
      Then the API call got  success with status code 200
      And "status" in response body os "OK"
       And "scope" in response body os "APP"
       And verify place_Id created maps to "<name>" using "getPlaceAPI
     
      Examples: 
      |name   | language| address           |
      |AAhouse| English | world cross center|
      #|BBhouse| Spanish | sea cross center  |
      
      
      
      
