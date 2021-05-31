package CampProject.northwind.business.abstracts;

import CampProject.northwind.core.entities.User;
import CampProject.northwind.core.utilities.results.DataResult;
import CampProject.northwind.core.utilities.results.Result;

public interface UserService {

	Result add(User user);

	DataResult<User> getByEmail(String email);

}
