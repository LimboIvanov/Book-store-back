package com.onlinebookstore.bookstoreback2.dto.search;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlinebookstore.bookstoreback2.config.Constants;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder(toBuilder=true)
@NoArgsConstructor
@ToString
@Slf4j
public abstract class GenericSearchDto<T>{

    private Integer limit= Constants.DEFAULT_JPA_PAGE_SIZE;
    private Integer page=0;
    private String sort="id";
    private Sort.Direction dir=Sort.DEFAULT_DIRECTION;

    @JsonIgnore
    public Specification<T> getSpecification() {
        return (root, query, criteriaBuilder) -> {
            query.distinct(true);
            Predicate noFiltersApplied = criteriaBuilder.conjunction();
            List<Predicate> filters = new ArrayList<>();
            filters.add(noFiltersApplied);
            addFiltersInternal(root, query, criteriaBuilder,filters);
            return criteriaBuilder.and(filters.toArray(new Predicate[filters.size()]));
        };
    }

    @JsonIgnore
    public Pageable getPageable() {
        return PageRequest.of(
                (page != null) ? page : 0,
                (limit != null && limit >= 0) ? limit : Constants.DEFAULT_JPA_PAGE_SIZE,
                getSortSpec()
        );
    }

    @JsonIgnore
    public Sort getSortSpec() {
        if (sort == null) return Sort.unsorted();
        return (dir != null && dir == Sort.Direction.DESC) ?
                Sort.by(sort).descending() : Sort.by(sort).ascending();
    }

    protected void addFiltersInternal(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder, List<Predicate> filters){
        log.debug("No filters applied");
        System.out.println("No filters applied");
    }


}
