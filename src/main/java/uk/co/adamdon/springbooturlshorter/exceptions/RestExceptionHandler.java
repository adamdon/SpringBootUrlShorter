package uk.co.adamdon.springbooturlshorter.exceptions;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uk.co.adamdon.springbooturlshorter.controllers.LinkController;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler
{
    private final Logger logger;


    public RestExceptionHandler()
    {
        this.logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    }

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> constraintViolationException(Exception exception)
    {
        ResponseEntity<String> responseEntity;
        JSONObject jsonObject;
        HttpHeaders httpHeaders;


        jsonObject = new JSONObject();
        jsonObject.put("status", HttpStatus.BAD_REQUEST);
        jsonObject.put("message", "Invalid data send");
        jsonObject.put("error", exception.getMessage());

        httpHeaders = new HttpHeaders();
        httpHeaders.set("Content-Type", "application/json");

        responseEntity = new ResponseEntity<>(jsonObject.toString(), httpHeaders, HttpStatus.BAD_REQUEST);

        logger.info("constraintViolationException: " + jsonObject.toString());

        return responseEntity;
    }
}
