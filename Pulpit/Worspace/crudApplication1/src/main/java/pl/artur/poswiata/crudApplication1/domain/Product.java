package pl.artur.poswiata.crudApplication1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Product {

	@Id //"Klucz głowny"
	@GeneratedValue(strategy = GenerationType.IDENTITY)// adnotacja która okresla sposób generowania wartości , strategy to jest sposób generowanie klucza głownego
	public Long id;
			
	
	public String name;
	
	
	public String destripciton;
	
	
	public Integer price;
	
	
	
}
