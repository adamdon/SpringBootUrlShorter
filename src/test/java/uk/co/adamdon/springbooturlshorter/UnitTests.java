//package uk.co.adamdon.springbooturlshorter;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import uk.co.adamdon.springbooturlshorter.utilities.CodeGenerator;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//class SpringBootUrlShorterApplicationTests
//{
//
//
//
//	@Test
//	public void testCodeGenerator()
//	{
//		CodeGenerator codeGenerator;
//		String urlString;
//		String expectedCodeString;
//		String actualCodeString;
//
//		codeGenerator = CodeGenerator.getInstance();
//		urlString = "https://gizmodo.com";
//		expectedCodeString = "uGlmsc6fKcxl_Us78GceXA==";
//		actualCodeString = codeGenerator.create(urlString);
//
//		assertEquals(expectedCodeString, actualCodeString);
//	}
//
//}
