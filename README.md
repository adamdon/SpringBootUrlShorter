# SpringBootUrlShorter

A hash #⃣️ derived, non-collision 🚗 URL shortener. Built with a React ⚛️ frontend, a Java ☕️ Spring Boot backend, and a h2 database. Tested with Cucumber 🥒

## Installation

The run configuration is available within the "/.run/" directory. Or the application can be ran from the following entry point.
```bash
SpringBootUrlShorterApplication.class
```

## Testing
The following Gherkin file can be ran with CucumberIntegrationTest

```ruby

Feature: Link functionalities

  Scenario: client makes call to POST a new link to createLink
    When the client calls createLink
    Then the client receives status code of 200 for createLink
    And the client receives a code for createLink

  Scenario: client makes call to GET a link url to getLinkByCode
    When the client calls getLinkByCode with code in url
    Then the client receives status code of 200 for getLinkByCode
    And the client receives a URL for getLinkByCode

  Scenario: client makes call to GET getAllLinks
    When the client calls getAllLinks
    Then the client receives status code of 200 for getAllLinks
    And the client receives an array with Link for getAllLinks
```



## License
[MIT](https://choosealicense.com/licenses/mit/)
