package CampProject.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CampProject.northwind.business.abstracts.ProductService;
import CampProject.northwind.core.utilities.results.DataResult;
import CampProject.northwind.core.utilities.results.Result;
import CampProject.northwind.core.utilities.results.SuccessDataResult;
import CampProject.northwind.core.utilities.results.SuccessResult;
import CampProject.northwind.dataAccess.abstracts.ProductDao;
import CampProject.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(productDao.findAll(), "Ürünler listelendi");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String name) {
		return new SuccessDataResult<Product>(productDao.getByProductName(name), "Ürünler listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(
				productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(
				productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), "Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(int... categories) {
		return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories), "Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName),
				"Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(productDao.getByProductNameStartsWith(productName),
				"Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory(productName, categoryId),
				"Ürünler listelendi");
	}

}
