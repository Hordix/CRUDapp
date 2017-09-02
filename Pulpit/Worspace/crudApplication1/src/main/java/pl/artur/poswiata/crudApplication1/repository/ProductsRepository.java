package pl.artur.poswiata.crudApplication1.repository;

import org.springframework.data.repository.CrudRepository;

import pl.artur.poswiata.crudApplication1.domain.Product;

public interface ProductsRepository extends CrudRepository<Product, Long> {

}
