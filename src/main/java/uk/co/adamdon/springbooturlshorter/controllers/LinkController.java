package uk.co.adamdon.springbooturlshorter.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.adamdon.springbooturlshorter.models.Link;
import uk.co.adamdon.springbooturlshorter.services.LinkService;

import javax.validation.Valid;
import java.util.List;

@RestController
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


    @PostMapping("/api/createLink")
    public ResponseEntity<Link> createLink(@Valid @RequestBody Link link)
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
