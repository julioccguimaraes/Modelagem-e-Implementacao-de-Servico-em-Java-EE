package br.inatel.dm110.interfaces.product;

import java.util.List;

import br.inatel.dm110.api.product.ProductTO;

public interface Product {

	String saveProduct(ProductTO product);
	
	ProductTO findProductByCode(int code);
	
	List<ProductTO> listProducts();
	
	void updateProduct(int code, ProductTO product);
}
