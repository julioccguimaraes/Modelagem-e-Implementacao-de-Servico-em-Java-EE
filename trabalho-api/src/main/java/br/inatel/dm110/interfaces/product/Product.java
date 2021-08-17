package br.inatel.dm110.interfaces.product;

import java.util.List;

import br.inatel.dm110.api.product.ProductTO;

public interface Product {

	public void saveProduct(ProductTO product);
	
	public ProductTO findProductByCode(int code);
	
	List<ProductTO> listProducts();
	
	public void updateProduct(int code, ProductTO product);
}
