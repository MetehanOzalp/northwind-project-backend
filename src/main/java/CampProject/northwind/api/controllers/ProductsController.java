package CampProject.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CampProject.northwind.business.abstracts.ProductService;
import CampProject.northwind.core.utilities.results.DataResult;
import CampProject.northwind.core.utilities.results.Result;
import CampProject.northwind.entities.concretes.Product;

@RestController
@RequestMapping("/api/products/")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("getall")
	public DataResult<List<Product>> getAll() {
		return productService.getAll();
	}

	@PostMapping("add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}
}
