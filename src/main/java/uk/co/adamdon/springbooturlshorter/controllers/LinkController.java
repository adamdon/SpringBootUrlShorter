package uk.co.adamdon.springbooturlshorter.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import uk.co.adamdon.springbooturlshorter.models.Link;
import uk.co.adamdon.springbooturlshorter.services.LinkService;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@Validated
public class LinkController
{
    private final LinkService linkService;
    private final Logger logger;


    public LinkController(LinkService linkService)
    {
        this.linkService = linkService;
        this.logger = LoggerFactory.getLogger(LinkController.class);
    }



    @GetMapping("/api/getAllLinks")
    public ResponseEntity<List<Link>> getAllLinks()
    {
        ResponseEntity<List<Link>> returnResponseEntity;
        List<Link> allLinkList;

        allLinkList = linkService.getAllLinks();
        returnResponseEntity = ResponseEntity.ok().body(allLinkList);
        logger.info("getAllLinks - Return List Size: " + allLinkList.size());

        return returnResponseEntity;
    }

    @GetMapping("/api/getLinkById/{id}")
    public ResponseEntity<Link> getLinkById(@PathVariable Long id)
    {
        ResponseEntity<Link> returnResponseEntity;
        Link foundLink;

        try
        {
            foundLink = linkService.getLinkById(id);
            returnResponseEntity = ResponseEntity.ok().body(foundLink);
            logger.info("getLinkById - Found Link: " + foundLink.toString());
        }
        catch (Exception exception)
        {
            returnResponseEntity = ResponseEntity.badRequest().body(new Link());
            logger.info("getLinkById - Not Found: " + exception.getMessage());
        }

        return returnResponseEntity;
    }


//    @PostMapping("/api/createLink")
    @RequestMapping(value = "/api/createLink", method = RequestMethod.POST)
    public ResponseEntity<Link> createLink(@Valid @RequestBody Link link, BindingResult bindingResult)
    {
        ResponseEntity<Link> returnResponseEntity;
        Link newLink;

        try
        {
            newLink = this.linkService.createLink(link);
            returnResponseEntity = ResponseEntity.ok().body(newLink);
            logger.info("createLink - Created Link: " + newLink.toString());
        }
        catch (Exception exception)
        {
            logger.info("createLink - Failed: " + link.toString());
            returnResponseEntity = ResponseEntity.badRequest().body(new Link());
        }

        return returnResponseEntity;
    }








}
