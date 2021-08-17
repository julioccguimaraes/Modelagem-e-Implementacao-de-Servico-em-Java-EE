package br.inatel.dm110.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.api.product.ProductService;
import br.inatel.dm110.api.product.ProductTO;
import br.inatel.dm110.interfaces.product.ProductLocal;

@RequestScoped
public class ProductServiceImpl implements ProductService {

    @EJB
    private ProductLocal ProductBean;
    
	@Override
	public void saveProduct(ProductTO product) {
		ProductBean.saveProduct(product);
	}

	@Override
	public ProductTO findProductByCode(int code) {
		return ProductBean.findProductByCode(code);
	}

	@Override
	public List<ProductTO> listProducts() {
		return ProductBean.listProducts();
	}

	@Override
	public void updateProduct(int code, ProductTO product) {
		ProductBean.updateProduct(code, product);
	}

}
