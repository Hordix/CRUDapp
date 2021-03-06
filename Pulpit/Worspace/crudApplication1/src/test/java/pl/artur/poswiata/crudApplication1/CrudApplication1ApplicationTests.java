package pl.artur.poswiata.crudApplication1;

import org.aspectj.lang.annotation.Before;
import org.hamcrest.core.Is;
import org.hibernate.validator.internal.constraintvalidators.bv.AssertTrueValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import antlr.collections.List;
import junit.framework.Assert;
import pl.artur.poswiata.crudApplication1.controles.ProductsDto;
import pl.artur.poswiata.crudApplication1.domain.Product;
import pl.artur.poswiata.crudApplication1.repository.ProductsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class CrudApplication1ApplicationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate; //restowy 
    
	@Autowired
	private ProductsRepository productRepository;
	
	@org.junit.Before
	public void before () {
	    	
       productRepository.deleteAll();   
    		
	}
	
	
	@Test
	public void contextLoads() {
	}
     
	
	@Test
	public void shouldAddTwoNumbers() {
		
		//given
		long a = 3;
		long b = 6;
		
		//when
		long wynik = a + b;
		
		//then
		
		Assert.assertEquals(wynik, 9);
		
		
	}
	
	
	@Test
	public void shouldGetAllProducts() {
		//spring mocmvc 
		
		
		//when
		Product[] products = restTemplate.getForObject("http://localhost:"+ port +  "/products",Product[].class);
		
	
		
		
		//then
		org.junit.Assert.assertThat(products.length, Is.is(0));
		
		
	};
	
	@Test
	public void shuldAddProducts() {
		//given
		ProductsDto product = new ProductsDto();
		  product.name = "samsung";
		  product.destripciton = "a5";
		  product.price = 1231;
		  
		//when
		  Product productresponse = restTemplate.postForObject("http://localhost:" + port + "/products", product, Product.class);
		  
		 //then
		  org.junit.Assert.assertThat(productRepository.findOne(productresponse.id).name, Is.is("samsung")  );
		  org.junit.Assert.assertThat(productRepository.findOne(productresponse.id).price, Is.is(1231)  );
		  org.junit.Assert.assertThat(productRepository.findOne(productresponse.id).destripciton, Is.is("a5")  );
        }
	
	@Test
	public void shouldDeleteProducts() {
	    //given	
		ProductsDto product = new ProductsDto();
		  product.name = "samsung";
		  product.destripciton = "a5";
		  product.price = 1231;
		  
		//when  
		
		 
		
	}
	}

}
