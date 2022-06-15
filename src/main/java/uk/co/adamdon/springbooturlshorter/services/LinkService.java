package uk.co.adamdon.springbooturlshorter.services;

import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.adamdon.springbooturlshorter.controllers.LinkController;
import uk.co.adamdon.springbooturlshorter.models.Link;
import uk.co.adamdon.springbooturlshorter.repositories.LinkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.co.adamdon.springbooturlshorter.utilities.CodeGenerator;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class LinkService
{
    private final LinkRepository linkRepository;
    private final Logger logger;

    public LinkService(LinkRepository linkRepository)
    {
        this.linkRepository = linkRepository;
        this.logger = LoggerFactory.getLogger(LinkService.class);
    }



    public Link createLink(Link link) throws ConstraintViolationException
    {
        Link returnSavedLink;
        List<Link> foundLinkList;
        UrlValidator urlValidator;
        String linkUrlString;
        String linkCodeString;


        linkUrlString = link.getUrl();
        urlValidator = new UrlValidator();

        if(urlValidator.isValid(linkUrlString))
        {
            foundLinkList = this.linkRepository.findByUrlOrderById(linkUrlString);

            if(foundLinkList.isEmpty())
            {
                linkCodeString = CodeGenerator.getInstance().create(linkUrlString);
                link.setCode(linkCodeString);
                returnSavedLink = linkRepository.save(link);
            }
            else
            {
                returnSavedLink = foundLinkList.get(0);
            }


            return returnSavedLink;
        }
        else
        {
            throw new ConstraintViolationException("Not a real url", new HashSet<>());
        }
    }





    public List<Link> getAllLinks()
    {
        List<Link> allLinkList;

        allLinkList = this.linkRepository.findAll();

        return allLinkList;
    }


    public Link getLinkById(Long LinkId) throws ConstraintViolationException
    {
        Optional<Link> foundLinkOptional;
        Link foundLink;


        foundLinkOptional = this.linkRepository.findById(LinkId);
        if(foundLinkOptional.isPresent())
        {
            foundLink = foundLinkOptional.get();
            return foundLink;
        }
        else
        {
            throw new ConstraintViolationException("Record not found with id: " + LinkId, new HashSet<>());
        }
    }


    public Link getLinkByCode(String code) throws ConstraintViolationException
    {
        List<Link> foundLinkList;
        Link foundLink;

        foundLinkList = this.linkRepository.findByCodeOrderById(code);

        if(!foundLinkList.isEmpty())
        {
            foundLink = foundLinkList.get(0);
            return foundLink;
        }
        else
        {
            throw new ConstraintViolationException("Record not found with code: " + code, new HashSet<>());
        }
    }







}
