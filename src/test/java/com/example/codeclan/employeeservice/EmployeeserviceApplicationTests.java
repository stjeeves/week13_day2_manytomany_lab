package com.example.codeclan.employeeservice;

import com.example.codeclan.employeeservice.models.Department;
import com.example.codeclan.employeeservice.models.Employee;
import com.example.codeclan.employeeservice.models.Project;
import com.example.codeclan.employeeservice.repositories.DepartmentRepository;
import com.example.codeclan.employeeservice.repositories.EmployeeRepository;
import com.example.codeclan.employeeservice.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeserviceApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateAndSaveAnEmployeeThatHasADepartment(){

		Project project = new Project("Dismisall Case",30);
		projectRepository.save(project);

		Department department = new Department("HR");
		departmentRepository.save(department);

		Employee employee = new Employee("John", "Thomas", 1234, department);
		employeeRepository.save(employee);

		employee.addProject(project);
		employeeRepository.save(employee);


	}

}
