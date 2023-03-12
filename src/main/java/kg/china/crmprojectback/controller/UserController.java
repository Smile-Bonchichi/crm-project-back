package kg.china.crmprojectback.controller;

import kg.china.crmprojectback.dto.user.EmployeeRequestDto;
import kg.china.crmprojectback.dto.user.EmployeeResponseDto;
import kg.china.crmprojectback.service.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {
    final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponseDto save(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.save(employeeRequestDto);
    }

    @GetMapping
    public List<EmployeeResponseDto> getAll() {
        return employeeService.getAll();
    }

    @DeleteMapping
    public EmployeeResponseDto delete(@RequestParam("id") Long id) {
        return employeeService.deleteEmployee(id);
    }
}
