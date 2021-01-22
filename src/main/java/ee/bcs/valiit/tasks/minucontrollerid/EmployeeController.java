package ee.bcs.valiit.tasks.minucontrollerid;

import ee.bcs.valiit.tasks.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("Katrin")
@RestController
public class EmployeeController {

    private List<Employee> employeeList = new ArrayList<>();

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    //http://localhost:8080/Katrin/employee?id=1&first=Katrin&last=Kutti&age=36&address=Tartu
    @GetMapping("testemployee")
    public Employee employee(@RequestParam("first") String firstName, @RequestParam("last") String lastName, @RequestParam("age") int age, @RequestParam("address") String address) {
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);
        employee.setAddress(address);
        return employee;
    }

    //http://localhost:8080/Katrin/employee
    @PostMapping("employeeIn")
    public void employeeIn(@RequestBody Employee employee) {
        String sql = "INSERT INTO employee (first, last)" + "VALUES (:firstNameParam. :lastNameParam)";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("first", employee.getFirstName());
        paramMap.put("last", employee.getLastName());
        jdbcTemplate.update(sql, paramMap);


        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getAge());
        System.out.println(employee.getAddress());
    }

    //http://localhost:8080/Katrin/employee
    @PostMapping("employee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeList.add(employee);
    }
    //http://localhost:8080/Katrin/employee

    @GetMapping("employee")
    public List<Employee> getEmployees() {
        return employeeList;
    }

    //http://localhost:8080/Katrin/employeeID/0
    @GetMapping("employeeID/{id}")
    public Employee employeeID(@PathVariable("id") int index) {
        return employeeList.get(index);
    }


    //http://localhost:8080/Katrin/employeeReplace/1
    @PutMapping("employeeReplace/{id}")
    public void employeeReplace(@PathVariable("id") int index, @RequestBody Employee employee) {
        employeeList.set(index, employee);
    }
    //http://localhost:8080/Katrin/employeeDelete/3
    @DeleteMapping("employeeDelete/{id}")
    public void employeeDelete(@PathVariable("id") int index) {
        employeeList.remove(index);
    }



}



