package pl.artur.poswiata.crudApplication1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.artur.poswiata.crudApplication1.controles.ProductsDto;
import pl.artur.poswiata.crudApplication1.domain.Product;
import pl.artur.poswiata.crudApplication1.repository.ProductsRepository;

@Service // adnotacja, działa wspólnie z autowire 
public class ProductsService {

	@Autowired
	public ProductsRepository productsRepository;
	
	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productsRepository.findAll();
	}

	public Product getProduct(Long productId) {
		// TODO Auto-generated method stub
		return productsRepository.findOne(productId);
	}

	public  Product createProduct(ProductsDto productsDto) {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.name = productsDto.name;
		product.price = productsDto.price;
		product.destripciton = productsDto.destripciton;
		
		
		product = productsRepository.save(product);
		
		return product;
	}

	public Product deleteProduct(Long productId) {
		
		productsRepository.delete(productId);
		return null; 
	}

	public Product updateProduct(ProductsDto productsDto, Long productId) {
		
		Product product = productsRepository.findOne(productId);
		product.name = productsDto.name;
		product.price = productsDto.price;
		product.destripciton = productsDto.destripciton;
		productsRepository.save(product);
		
		return product;
		
	}
    
	
	
}
