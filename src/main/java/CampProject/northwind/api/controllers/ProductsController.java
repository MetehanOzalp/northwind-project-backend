package CampProject.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import CampProject.northwind.business.abstracts.ProductService;
import CampProject.northwind.core.utilities.results.DataResult;
import CampProject.northwind.core.utilities.results.Result;
import CampProject.northwind.entities.concretes.Product;
import CampProject.northwind.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products/")
@CrossOrigin
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@PostMapping("add")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}

	@GetMapping("getall")
	public DataResult<List<Product>> getAll() {
		return productService.getAll();
	}

	@GetMapping("getAllByPage")
	public DataResult<List<Product>> getAll(@RequestParam int pageNo, @RequestParam int size) {
		return this.productService.getAll(pageNo, size);
	}

	@GetMapping("getAllSorted")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}

	@GetMapping("getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}

	@GetMapping("getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName,
			@RequestParam int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return productService.getProductWithCategoryDetails();
	}

}
