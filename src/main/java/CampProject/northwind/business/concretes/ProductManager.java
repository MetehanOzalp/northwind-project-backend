package CampProject.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import CampProject.northwind.business.abstracts.ProductService;
import CampProject.northwind.core.utilities.results.DataResult;
import CampProject.northwind.core.utilities.results.Result;
import CampProject.northwind.core.utilities.results.SuccessDataResult;
import CampProject.northwind.core.utilities.results.SuccessResult;
import CampProject.northwind.dataAccess.abstracts.ProductDao;
import CampProject.northwind.entities.concretes.Category;
import CampProject.northwind.entities.concretes.Product;
import CampProject.northwind.entities.dtos.ProductAddDto;
import CampProject.northwind.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {

	private ProductDao productDao;

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public Result add(ProductAddDto productAddDto) {
		Product product = new Product(0, productAddDto.getProductName(), productAddDto.getUnitPrice(),
				productAddDto.getUnitsInStock(), productAddDto.getQuantityPerUnit(),
				new Category(productAddDto.getCategoryId(), null, null));
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(productDao.findAll(), "Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getAll(int pageNo, int size) {
		Pageable pageable = PageRequest.of(pageNo - 1, size);
		return new SuccessDataResult<List<Product>>(productDao.findAll(pageable).getContent(), "Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "productName");
		return new SuccessDataResult<List<Product>>(productDao.findAll(sort), "Ürünler listelendi");
	}

	@Override
	public DataResult<Product> getById(int id) {
		return new SuccessDataResult<Product>(productDao.findById(id).get());
	}

	@Override
	public DataResult<Product> getByProductName(String name) {
		return new SuccessDataResult<Product>(productDao.getByProductName(name), "Ürünler listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(
				productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), "Ürünler listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
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

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(productDao.getProductWithCategoryDetails(),
				"Ürünler listelendi");
	}

}
