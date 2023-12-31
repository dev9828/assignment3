package in.co.vwits.ems.app;

import java.util.Optional;
import java.util.Scanner;

import in.co.vwits.ems.exceptions.EmployeeNotFoundException;
import in.co.vwits.ems.model.Employee;
import in.co.vwits.ems.service.EmployeeService;
import in.co.vwits.ems.service.impl.EmployeeServiceImpl;

public class EmpManagementTest {
	public static void main(String[] args) {
		EmployeeService service = new EmployeeServiceImpl();
		try (Scanner sc = new Scanner(System.in)) {
			int n ;
			do {
				System.out.println("Welcomt to Employee Management System");
				System.out.println("1. Create a Employee.");
				System.out.println("2. List all Employees.");
				System.out.println("3. Find a Employee by ID.");
				System.out.println("4. Update Employee Name");
				System.out.println("5. Update Employee Salary");
				System.out.println("6. Delete a Employee.");
				System.out.println("7. Sort Employees By Name in Ascending Order.");
				System.out.println("8. Sort Employees By Name in Descending Order.");
				System.out.println("9. Sort Employees By Salary in Ascending Order.");
				System.out.println("10. Sort Employees By Salary in Descending Order.");
				System.out.println("-1. Exit.");
				n = sc.nextInt();
				switch(n){

				case 1:
					System.out.println("Create new Employee");
					Employee emp = new Employee();
					System.out.print("Enter Name: ");
					String name = sc.next();
					emp.setName(name);
					System.out.print("Enter Salary: ");
					double salary = sc.nextDouble();
					emp.setSalary(salary);
					service.create(emp);
					System.out.println("Created");
					break;

				case 2:
					System.out.println(service.findAllEmployees());
					break;
					
				case 3:
					System.out.print("Enter the Empolyee's ID: ");
					System.out.println(service.findById(sc.nextInt()).get());
					break;
					
				case 4:
					System.out.println("Update Name....");
					System.out.print("Enter Id: ");
					int empId = sc.nextInt();
					Employee newEmp = Optional.ofNullable(service.findById(empId).get()).get();
					System.out.print("Enter New Name: ");
					String newName = sc.next();
					newEmp.setName(newName);
					service.updateEmployeeName(newEmp);
					System.out.println("Updated Sucessfully....");
					break;
					
				case 5:
					System.out.println("Update Salary....");
					System.out.print("Enter Id: ");
					int empId1 = sc.nextInt();
					Employee newEmp1 = Optional.ofNullable(service.findById(empId1).get()).get();
					System.out.print("Enter New Name: ");
					Double newSalary = sc.nextDouble();
					newEmp1.setSalary(newSalary);
					service.updateEmployeeSalary(newEmp1);
					System.out.println("Updated Sucessfully....");
					break;
					
				case 6:
					System.out.print("Enter Employee ID to delete: ");
					service.delete(sc.nextInt());
					System.out.println("Deleted Sucessfully ...");
					break;
					
				case 7:
					System.out.println("Sort By name in Ascending");
					System.out.println(service.sortEmployeeBySalaryInByAsc());
					break;
					
				case 8:
					System.out.println("Sort By name in Descending");
					System.out.println(service.sortEmployeesByNameInDesc());
					break;
					
				case 9:
					System.out.println("Sort By salay in Ascending");
					System.out.println(service.sortEmployeeBySalaryInByAsc());
					break;
					
				case 10:
					System.out.println("Sort By salary in Descending");
					System.out.println(service.sortEmployeesBySalaryInDesc());
					break;
					
				case -1:
					System.out.println("EXIT !");
					break;
					
				default:
					System.out.println("Enter Correct option ");
					break;
				}

			}while(n != -1);
			
		} catch (EmployeeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}