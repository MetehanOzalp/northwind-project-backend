package CampProject.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import CampProject.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
