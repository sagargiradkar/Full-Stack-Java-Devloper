package in.ineuron.dao;

import in.ineuron.bo.EmployeeBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository(value = "dao")
public class EmployeeDaoImpl implements IEmployeeDAO{

    static {
        System.out.println("EmployeeDaoImpl.class file is loading ...");
    }

    public EmployeeDaoImpl(){
        System.out.println("EmployeeDaoImpl :: 0 param contructor called ....");
    }
    @Autowired
    private DataSource dataSource;
    @Override
    public void save(EmployeeBO bo) {

    }

    @Override
    public String toString() {
        return "EmployeeDaoImpl{" +
                "dataSource=" + dataSource +
                '}';
    }
}
