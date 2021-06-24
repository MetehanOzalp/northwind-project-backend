package CampProject.northwind.entities.dtos;

import CampProject.northwind.entities.concretes.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddDto {

	private String productName;
	private double unitPrice;
	private short unitsInStock;
	private String quantityPerUnit;
	private int categoryId;

}
