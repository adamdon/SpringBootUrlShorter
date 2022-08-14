Feature: Link functionalities

  Scenario: client makes call to POST a new link to createLink
    When the client calls createLink
    Then the client receives status code of 200 for createLink
    And the client receives a Code for createLink

  Scenario: client makes call to GET a link url to getLinkByCode
    When the client calls getLinkByCode with code in url
    Then the client receives status code of 200 for getLinkByCode
    And the client receives a URL for getLinkByCode

  Scenario: client makes call to GET /getAllLinks
    When the client calls getAllLinks
    Then the client receives status code of 200 for getAllLinks
    And the client receives an array with Link for getAllLinks