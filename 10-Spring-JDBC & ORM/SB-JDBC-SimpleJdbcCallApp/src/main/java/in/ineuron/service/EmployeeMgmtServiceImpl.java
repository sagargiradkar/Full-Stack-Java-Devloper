package in.ineuron.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.bo.EmployeeBO;
import in.ineuron.dao.IEmployeeDao;
import in.ineuron.dto.EmployeeDTO;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

    @Autowired
    private IEmployeeDao dao;

    @Override
    public List<EmployeeDTO> fetchEmployeesByDesg(String desg1, String desg2, String desg3) {
        List<EmployeeBO> employeeBOs = dao.fetchEmployeesByDesg(desg1, desg2, desg3);
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        employeeBOs.forEach(bo -> {
            EmployeeDTO dto = new EmployeeDTO();
            BeanUtils.copyProperties(bo, dto);
            employeeDTOs.add(dto);
        });

        return employeeDTOs;
    }

    @Override
    public String registeredEmployee(EmployeeDTO dto) {
        EmployeeBO bo = new EmployeeBO();
        BeanUtils.copyProperties(dto, bo);
        return dao.registeredEmployee(bo);
    }

    @Override
    public String fetchEmployeeByNo(int no) {
        return dao.getEmployeeByName(no);
    }
}
