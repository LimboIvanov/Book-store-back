package com.onlinebookstore.bookstoreback2.dto.search;

//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Predicate;
//import jakarta.persistence.criteria.Root;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import lombok.experimental.SuperBuilder;
//import org.apache.commons.lang3.StringUtils;
//
//import java.util.List;
//
//@Data
//@EqualsAndHashCode
//@SuperBuilder(toBuilder=true)
//@NoArgsConstructor
//public class AbstractOrganizationSearchDto<T  extends AbstractAuditableSearchDto<T> {
//
//    private String name;
//
//    protected void auditableWithFilters(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder, List<Predicate> filters) {
//        if(StringUtils.isNotBlank(name)){
//            Predicate organizationNamePredicate = criteriaBuilder
//                    .equal(root.get("name"), name );
//            filters.add(organizationNamePredicate);
//        }
//    }
//
//}
