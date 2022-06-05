package uk.co.adamdon.springbooturlshorter.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.adamdon.springbooturlshorter.models.Link;
import uk.co.adamdon.springbooturlshorter.services.LinkService;

import java.util.List;

@RestController
public class LinkController
{
    private final LinkService linkService;

    public LinkController(LinkService linkService)
    {
        this.linkService = linkService;
    }



    @GetMapping("/api/getAllLinks")
    public ResponseEntity<List<Link>> getAllProduct()
    {
        return ResponseEntity.ok().body(linkService.getAllLinks());
    }

    @GetMapping("/api/getLinkById/{id}")
    public ResponseEntity<Link> getProductById(@PathVariable Long id)
    {
        try
        {
            Link foundLink = linkService.getLinkById(id);
            return ResponseEntity.ok().body(foundLink);
        }
        catch (Exception exception)
        {
            return ResponseEntity.badRequest().body(new Link());
        }
    }


    @PostMapping("/api/createLink")
    public ResponseEntity<Link> createLink(@RequestBody Link link)
    {
        return ResponseEntity.ok().body(this.linkService.createLink(link));
    }



}
