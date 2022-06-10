package uk.co.adamdon.springbooturlshorter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uk.co.adamdon.springbooturlshorter.utilities.CodeGenerator;


@SpringBootApplication
public class SpringBootUrlShorterApplication
{
	private final static Logger logger = LoggerFactory.getLogger(SpringBootUrlShorterApplication.class);

	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootUrlShorterApplication.class, args);
		logger.info("SpringBootUrlShorterApplication START UP... (╯°□°)╯︵ ┻━┻");

//		logger.info("code gen test start");
//		String test = CodeGenerator.getInstance().create("https://www.google.co.uk/search?q=test");
//		logger.info(test);
//		logger.info("code gen test end");


	}




}
