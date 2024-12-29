package in.ineuron.service;

import in.ineuron.dto.EmplyeeDTO;
import in.ineuron.vo.EmployeeVo;

public interface IEmployeeService {
    public EmployeeVo calculateHike(EmplyeeDTO id);
}
