package kg.china.crmprojectback.service.base.impl;

import jakarta.transaction.Transactional;
import kg.china.crmprojectback.exception.common.NotFoundException;
import kg.china.crmprojectback.service.base.BaseService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseServiceImpl<T> implements BaseService<T> {
    final CrudRepository<T, Long> crudRepository;

    @Override
    public T saveOrUpdate(T t) {
        return crudRepository.save(t);
    }

    @Override
    public T delete(Long id) {
        T t = getById(id);
        if (t != null) {
            crudRepository.delete(t);
        }

        return t;
    }

    @Override
    public T getById(Long id) {
        return crudRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("По ID=%d не найдена запись", id)));
    }

    @Override
    public List<T> findAll() {
        return (List<T>) crudRepository.findAll();
    }
}
