package uk.co.adamdon.springbooturlshorter.services;

import uk.co.adamdon.springbooturlshorter.models.Link;
import uk.co.adamdon.springbooturlshorter.repositories.LinkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class LinkService
{
    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository)
    {
        this.linkRepository = linkRepository;
    }



    public Link createLink(Link link)
    {
        return linkRepository.save(link);
    }


	public Link getLinkById(Long LinkId) throws Exception
    {
		Optional<Link> foundLinkOptional = this.linkRepository.findById(LinkId);

		if(foundLinkOptional.isPresent())
        {
			return foundLinkOptional.get();
		}
        else
        {
			throw new Exception("Record not found with id: " + LinkId);
		}
	}


    public List<Link> getAllLinks()
    {
        return this.linkRepository.findAll();
    }




}
