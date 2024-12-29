package in.ineuron.service;

import in.ineuron.dao.IEmployeeDAO;
import in.ineuron.dto.EmplyeeDTO;
import in.ineuron.vo.EmployeeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "empService")
public class EmployeeServiceImpl implements IEmployeeService{

    static {
        System.out.println("EmployeeServiceImpl.class file is loading ...");
    }

    public EmployeeServiceImpl(){
        System.out.println("EmployeeServiceImpl :: 0 param contructor called ....");
    }
    @Autowired
   private IEmployeeDAO dao;
    @Override
    public EmployeeVo calculateHike(EmplyeeDTO id) {
        return null;
    }

    @Override
    public String toString() {
        return "EmployeeServiceImpl{" +
                "dao=" + dao +
                '}';
    }
}
