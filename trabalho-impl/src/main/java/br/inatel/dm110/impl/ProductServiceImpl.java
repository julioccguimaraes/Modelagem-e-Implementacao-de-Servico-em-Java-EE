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
    private ProductLocal productBean;
    
	@Override
	public String saveProduct(ProductTO product) {
		return productBean.saveProduct(product);
	}

	@Override
	public ProductTO findProductByCode(int code) {
		return productBean.findProductByCode(code);
	}

	@Override
	public List<ProductTO> listProducts() {
		return productBean.listProducts();
	}

	@Override
	public void updateProduct(int code, ProductTO product) {
		productBean.updateProduct(code, product);
	}

}
