package pl.artur.poswiata.crudApplication1.controles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import pl.artur.poswiata.crudApplication1.domain.Product;
import pl.artur.poswiata.crudApplication1.repository.ProductsRepository;
import pl.artur.poswiata.crudApplication1.service.ProductsService;

@RestController
  
public class ProductController {
   
	@Autowired //Adnotacja która mówi, że w momencie gdy jest uruchamiana aplikacja kontekst springowy przeszukuej beany i szuka w nich takeigo który odpowaiada tpyem temu własnie zadlekarowanemu 
	private ProductsService productsService;
	
	@GetMapping("/hello")
	public String arturposwiata() 
	{
		
		return "Hello world";
		
	}
	
	@GetMapping("/products")
	public Iterable<Product> getAllProducts(){
		return productsService.getAllProducts();
	}
	
	
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable Long productId) {
		return productsService.getProduct(productId);
	}
	
	@PostMapping("/products") //przyjmuje dodatkowe jakies dane
	public Product createProduct(@RequestBody ProductsDto productsDto) {
	    return productsService.createProduct(productsDto);	
	}
	
	
	@DeleteMapping("/products/{productId}")
	public Product deleteProduct(@PathVariable Long productId) {
		 return productsService.deleteProduct(productId);
	   }
	
	// Put i post przyjmują więcej niz jednen element
	@PutMapping("/products/{productId}")
	public Product uptadeProduct(@RequestBody ProductsDto productsDto, @PathVariable Long productId) {
		 return productsService.updateProduct(productsDto, productId);
	}

}
