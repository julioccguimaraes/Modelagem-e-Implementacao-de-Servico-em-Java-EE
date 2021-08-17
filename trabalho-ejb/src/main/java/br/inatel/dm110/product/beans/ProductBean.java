package br.inatel.dm110.product.beans;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.inatel.dm110.api.product.ProductTO;
import br.inatel.dm110.product.entities.Product;
import br.inatel.dm110.interfaces.product.ProductLocal;

import java.util.stream.Collectors;

@Stateless
@Local(ProductLocal.class)
public class ProductBean implements ProductLocal {

	@PersistenceContext(unitName = "product_pu")
	private EntityManager em;
	
	private static Logger log = Logger.getLogger(ProductBean.class.getName());

	@Override
	public void saveProduct(ProductTO pTo) {
		Product product = new Product(pTo.getCode(), pTo.getName(), pTo.getDescription(), pTo.getPrice(), pTo.getCategory());
		 
		log.info("Salvando o produto " + product);
		 
		em.persist(product);
	}
	
	@Override
	public ProductTO findProductByCode(int code) {
		Product p = em.find(Product.class, code);
		
		ProductTO pTo = new ProductTO(p.getCode(), p.getName(), p.getDescription(), p.getPrice(), p.getCategory());
		
		return pTo;
	}
	
	@Override
	public List<ProductTO> listProducts() {
		TypedQuery<Product> query = em.createQuery("FROM Product p", Product.class);
		
		List<Product> productList = query.getResultList();
		
		return toCollectionAPIModel(productList);
	}
	
	@Override
	public void updateProduct(int code, ProductTO pTo) {
		Product p = em.find(Product.class, code);
		
		p.setName(pTo.getName());
		p.setDescription(pTo.getDescription());
		p.setPrice(pTo.getPrice());
		p.setCategory(pTo.getCategory());
		 
		log.info("Atualizando o produto " + p);
		 
		em.merge(p);
	}
	
	private List<ProductTO> toCollectionAPIModel(List<Product> productList) {
		return productList.stream().map(p -> {
			ProductTO pTo = new ProductTO(p.getCode(), p.getName(), p.getDescription(), p.getPrice(), p.getCategory());
			return pTo;
		}).collect(Collectors.toList());
	}
}
