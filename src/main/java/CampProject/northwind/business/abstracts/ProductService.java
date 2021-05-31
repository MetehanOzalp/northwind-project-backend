package CampProject.northwind.business.abstracts;

import java.util.List;

import CampProject.northwind.core.utilities.results.DataResult;
import CampProject.northwind.core.utilities.results.Result;
import CampProject.northwind.entities.concretes.Product;
import CampProject.northwind.entities.dtos.ProductWithCategoryDto;

public interface ProductService {

	Result add(Product product);

	DataResult<List<Product>> getAll();

	DataResult<List<Product>> getAll(int pageNo, int size);

	DataResult<List<Product>> getAllSorted();

	DataResult<Product> getByProductName(String name);

	DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

	DataResult<List<Product>> getByCategoryIn(int... categories);

	DataResult<List<Product>> getByProductNameContains(String productName);

	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
