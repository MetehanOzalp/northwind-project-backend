package CampProject.northwind.business.abstracts;

import java.util.List;

import CampProject.northwind.core.utilities.results.DataResult;
import CampProject.northwind.core.utilities.results.Result;
import CampProject.northwind.entities.concretes.Product;

public interface ProductService {

	DataResult<List<Product>> getAll();

	Result add(Product product);
}
