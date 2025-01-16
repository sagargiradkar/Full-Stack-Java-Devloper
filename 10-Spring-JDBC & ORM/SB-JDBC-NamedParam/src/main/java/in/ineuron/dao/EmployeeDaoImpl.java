package in.ineuron.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import in.ineuron.bo.EmployeeBO;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

    @Autowired
    private NamedParameterJdbcTemplate template;

    @Override
    public List<EmployeeBO> fetchEmployeesByDesg(String desg1, String desg2, String desg3) {
        String query = "SELECT * FROM employee WHERE desg IN (:desg1, :desg2, :desg3)";
        Map<String, Object> params = new HashMap<>();
        params.put("desg1", desg1);
        params.put("desg2", desg2);
        params.put("desg3", desg3);

        return template.query(query, params, new BeanPropertyRowMapper<>(EmployeeBO.class));
    }

    @Override
    public String registeredEmployee(EmployeeBO bo) {
        String query = "INSERT INTO employee (ename, eage, eaddress, desg, salary) VALUES (:ename, :eage, :eaddress, :desg, :salary)";
        Map<String, Object> params = new HashMap<>();
        params.put("ename", bo.getEname());
        params.put("eage", bo.getEage());
        params.put("eaddress", bo.getEaddress());
        params.put("desg", bo.getDesg());
        params.put("salary", bo.geteSalary());

        int rows = template.update(query, params);
        return rows > 0 ? "Employee Registered Successfully" : "Registration Failed";
    }

    @Override
    public String getEmployeeByName(int no) {
        String query = "SELECT ename FROM employee WHERE eid = :eid";
        Map<String, Object> params = new HashMap<>();
        params.put("eid", no);

        return template.queryForObject(query, params, String.class);
    }
}
