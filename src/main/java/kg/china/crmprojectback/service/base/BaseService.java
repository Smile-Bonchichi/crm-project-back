package kg.china.crmprojectback.service.base;

import java.util.List;

public interface BaseService<T> {
    T saveOrUpdate(T t);

    T delete(Long id);

    T getById(Long id);

    List<T> findAll();
}
