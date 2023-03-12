package kg.china.crmprojectback.service;

import kg.china.crmprojectback.dto.dictionary.JobTitleResponseDto;
import kg.china.crmprojectback.entity.dictionary.JobTitle;
import kg.china.crmprojectback.service.base.BaseService;

import java.util.List;

public interface JobTitleService extends BaseService<JobTitle> {
    JobTitleResponseDto save(Long id, String name);

    List<JobTitleResponseDto> getAll();

    JobTitleResponseDto deleteJobTitle(Long id);
}
