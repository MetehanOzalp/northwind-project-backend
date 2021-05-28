package CampProject.northwind.business.abstracts;

import java.util.List;

import CampProject.northwind.core.utilities.results.DataResult;
import CampProject.northwind.core.utilities.results.Result;
import CampProject.northwind.entities.concretes.Product;

public interface ProductService {

	DataResult<List<Product>> getAll();

	Result add(Product product);

	DataResult<Product> getByProductName(String name);

	DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIn(int... categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
}
