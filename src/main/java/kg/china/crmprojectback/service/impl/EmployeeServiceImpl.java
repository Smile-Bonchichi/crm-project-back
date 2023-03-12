package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.dto.user.EmployeeRequestDto;
import kg.china.crmprojectback.dto.user.EmployeeResponseDto;
import kg.china.crmprojectback.entity.user.Employee;
import kg.china.crmprojectback.repository.user.EmployeeRepository;
import kg.china.crmprojectback.service.EmployeeService;
import kg.china.crmprojectback.service.JobTitleService;
import kg.china.crmprojectback.service.base.impl.BaseServiceImpl;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {
    final EmployeeRepository employeeRepository;
    final JobTitleService jobTitleService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               JobTitleService jobTitleService) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
        this.jobTitleService = jobTitleService;
    }

    @Override
    public EmployeeResponseDto save(EmployeeRequestDto employeeRequestDto) {
        if (employeeRequestDto.getId() == null) {
            return build(
                    saveOrUpdate(
                            Employee.builder()
                                    .fullName(employeeRequestDto.getName())
                                    .jobTitle(jobTitleService.getById(employeeRequestDto.getJobTitleId()))
                                    .salary(employeeRequestDto.getSalary())
                                    .address(employeeRequestDto.getAddress())
                                    .phoneNumber(employeeRequestDto.getPhoneNumber())
                                    .build()
                    )
            );
        }

        Employee employee = getById(employeeRequestDto.getId());

        return build(saveOrUpdate(
                employee
                        .fullName(
                                employeeRequestDto.getName() != null ?
                                        employeeRequestDto.getName() :
                                        employee.fullName()
                        )
                        .jobTitle(
                                employeeRequestDto.getJobTitleId() != null ?
                                        jobTitleService.getById(employeeRequestDto.getJobTitleId()) :
                                        employee.jobTitle()
                        )
                        .salary(
                                employeeRequestDto.getSalary() != null ?
                                        employeeRequestDto.getSalary() :
                                        employee.salary()
                        )
                        .address(
                                employeeRequestDto.getAddress() != null ?
                                        employeeRequestDto.getAddress() :
                                        employee.address()
                        )
                        .phoneNumber(
                                employeeRequestDto.getPhoneNumber() != null ?
                                        employeeRequestDto.getPhoneNumber() :
                                        employee.phoneNumber()
                        )
        ));
    }

    @Override
    public List<EmployeeResponseDto> getAll() {
        return findAll().stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDto deleteEmployee(Long id) {
        return build(delete(id));
    }

    private EmployeeResponseDto build(Employee employee) {
        return EmployeeResponseDto.builder()
                .id(employee.getId())
                .name(employee.fullName())
                .jobTitleName(employee.jobTitle().name())
                .salary(employee.salary())
                .address(employee.address())
                .phoneNumber(employee.phoneNumber())
                .build();
    }
}
