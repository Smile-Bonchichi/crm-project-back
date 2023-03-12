package kg.china.crmprojectback.service.impl;

import kg.china.crmprojectback.dto.dictionary.JobTitleResponseDto;
import kg.china.crmprojectback.entity.dictionary.JobTitle;
import kg.china.crmprojectback.repository.dictionary.JobTitleRepository;
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
public class JobTitleServiceImpl extends BaseServiceImpl<JobTitle> implements JobTitleService {
    final JobTitleRepository jobTitleRepository;

    @Autowired
    public JobTitleServiceImpl(JobTitleRepository jobTitleRepository) {
        super(jobTitleRepository);
        this.jobTitleRepository = jobTitleRepository;
    }

    @Override
    public JobTitleResponseDto save(Long id, String name) {
        if (id == null) {
            return build(
                    saveOrUpdate(
                            JobTitle.builder()
                                    .name(name)
                                    .build()
                    )
            );
        }

        return build(
                saveOrUpdate(getById(id).name(name))
        );
    }

    @Override
    public List<JobTitleResponseDto> getAll() {
        return findAll().stream()
                .map(this::build)
                .collect(Collectors.toList());
    }

    @Override
    public JobTitleResponseDto deleteJobTitle(Long id) {
        return build(delete(id));
    }

    private JobTitleResponseDto build(JobTitle jobTitle) {
        return JobTitleResponseDto.builder()
                .id(jobTitle.getId())
                .name(jobTitle.name())
                .build();
    }
}
