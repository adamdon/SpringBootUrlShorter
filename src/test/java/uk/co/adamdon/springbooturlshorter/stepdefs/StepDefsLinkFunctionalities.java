package uk.co.adamdon.springbooturlshorter.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class StepDefsLinkFunctionalities
{
    private final Logger log;
    private ResponseEntity<String> createLinkResponseEntity;
    private ResponseEntity<String> getLinkByCodeResponseEntity;
    private ResponseEntity<String> getAllLinksResponseEntity;



    public StepDefsLinkFunctionalities()
    {
        log = LoggerFactory.getLogger(StepDefsLinkFunctionalities.class);
    }







    //
    //Scenario: client makes call to POST a new link to createLink
    //
    @When("the client calls createLink")
    public void theClientCallsCreateLink()
    {
        RestTemplate restTemplate;
        String urlString;
        Map<String, String> jsonHashMap;


        log.info("The client calls /api/createLink");
        try
        {
            restTemplate = new RestTemplate();
            urlString = "http://localhost:8080/api/createLink";

            jsonHashMap = new HashMap<>();
            jsonHashMap.put("url", "https://www.google.co.uk/");

            createLinkResponseEntity = restTemplate.postForEntity(urlString, jsonHashMap, String.class);
            Assertions.assertNotNull(createLinkResponseEntity);
        }
        catch (RestClientException restClientException)
        {
            Assertions.fail("restClientException: + " + restClientException.getMessage());
        }
    }

    @Then("the client receives status code of {int} for createLink")
    public void theClientReceivesStatusCodeOfForCreateLink(int arg0)
    {
        log.info("the client receives status code of 200 for createLink");
        Assertions.assertEquals(createLinkResponseEntity.getStatusCode(), HttpStatus.OK);
    }

    @And("the client receives a Code for createLink")
    public void theClientReceivesACodeForCreateLink()
    {
        JSONObject jsonObject;
        String codeString;
        String expectedCodeString;

        log.info("the client receives a Code for createLink");
        expectedCodeString = "nvYTDPKKzdZBMxo1D41TZA==";

        try
        {
            jsonObject = new JSONObject(createLinkResponseEntity.getBody());
            codeString = jsonObject.getString("code");

            Assertions.assertEquals(expectedCodeString, codeString);
        }
        catch (JSONException jsonException)
        {
            Assertions.fail("jsonException: + " + jsonException.getMessage());
        }

    }










    //
    //Scenario makes call to GET a link url to getLinkByCode
    //
    @When("the client calls getLinkByCode with code in url")
    public void theClientCallsGetLinkByCodeWithCodeInUrl()
    {
        RestTemplate restTemplate;

        JSONObject jsonObject;
        String codeString;

        String urlString;


        log.info("The client calls /api/getLinkByCode");
        try
        {
            restTemplate = new RestTemplate();

            codeString = "nvYTDPKKzdZBMxo1D41TZA==";
            urlString = ("http://localhost:8080/api/getLinkByCode/" + codeString);

            getLinkByCodeResponseEntity = restTemplate.getForEntity(urlString, String.class);
            Assertions.assertNotNull(getLinkByCodeResponseEntity);
        }
        catch (RestClientException restClientException)
        {
            Assertions.fail("restClientException: + " + restClientException.getMessage());
        }

    }

    @Then("the client receives status code of {int} for getLinkByCode")
    public void theClientReceivesStatusCodeOfForGetLinkByCode(int arg0)
    {
        log.info("the client receives status code of 200 for getLinkByCode");
        Assertions.assertEquals(getLinkByCodeResponseEntity.getStatusCode(), HttpStatus.OK);
    }

    @And("the client receives a URL for getLinkByCode")
    public void theClientReceivesAURLForGetLinkByCode()
    {
        JSONObject jsonObject;
        String expectedUrlString;
        String linkUrlString;

        log.info("the client receives a Code for createLink");
        expectedUrlString = "https://www.google.co.uk/";

        try
        {
            jsonObject = new JSONObject(getLinkByCodeResponseEntity.getBody());
            linkUrlString = jsonObject.getString("url");

            Assertions.assertEquals(expectedUrlString, linkUrlString);
        }
        catch (JSONException jsonException)
        {
            Assertions.fail("jsonException: + " + jsonException.getMessage());
        }


    }












    //
    // Scenario: client makes call to GET /getAllLinks
    //
    @When("the client calls getAllLinks")
    public void theClientCallsApiGetAllLinks()
    {
        RestTemplate restTemplate;

        log.info("The client calls /api/getAllLinks");
        try
        {
            restTemplate = new RestTemplate();
            getAllLinksResponseEntity = restTemplate.getForEntity("http://localhost:8080/api/getAllLinks", String.class);
            Assertions.assertNotNull(getAllLinksResponseEntity);
        }
        catch (RestClientException restClientException)
        {
            Assertions.fail("restClientException: + " + restClientException.getMessage());
        }
    }

    @Then("the client receives status code of {int} for getAllLinks")
    public void theClientReceivesStatusCodeOf(int arg0)
    {
        log.info("the client receives status code of {int} for getAllLinks");
        Assertions.assertEquals(getAllLinksResponseEntity.getStatusCode(), HttpStatus.OK);
    }

    @And("the client receives an array with Link for getAllLinks")
    public void theClientReceivesAnArrayWithLink()
    {
        JSONArray jsonArray;
        JSONObject jsonObject;
        String codeString;
        String expectedCodeString;

        log.info("the client receives an array with Link for getAllLinks");
        expectedCodeString = "nvYTDPKKzdZBMxo1D41TZA==";

        try
        {
            jsonArray = new JSONArray(getAllLinksResponseEntity.getBody());

            jsonObject = new JSONObject(jsonArray.get(0).toString());
            codeString = jsonObject.getString("code");

            Assertions.assertEquals(expectedCodeString, codeString);
        }
        catch (JSONException jsonException)
        {
            Assertions.fail("jsonException: + " + jsonException.getMessage());
        }


        Assertions.assertEquals(getAllLinksResponseEntity.getStatusCode(), HttpStatus.OK);
    }
}
