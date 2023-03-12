package kg.china.crmprojectback.service;

import kg.china.crmprojectback.dto.user.EmployeeRequestDto;
import kg.china.crmprojectback.dto.user.EmployeeResponseDto;
import kg.china.crmprojectback.entity.user.Employee;
import kg.china.crmprojectback.service.base.BaseService;

import java.util.List;

public interface EmployeeService extends BaseService<Employee> {
    EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto);

    List<EmployeeResponseDto> getAll();

    EmployeeResponseDto deleteEmployee(Long id);
}
