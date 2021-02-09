//package com.example.demo.model.repo;
//
//import com.example.demo.model.entity.ProductType;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.UUID;
//
//@Repository
//public interface ProductTypeRepo extends CrudRepository<ProductType, Long> {
//
//    @Query("SELECT pt FROM PRODUCT_TYPES pt " +
//            "WHERE (:productTypeCategory IS NULL OR :productTypeCategory = PRODUCT_TYPE_CATEGORY_ID) " +
//            "AND (:hasSale IS NULL OR :hasSale = (SALE_ID IS NOT NULL)) " +
//            "AND (:lowestPrise IS NULL OR :lowestPrise >= PRICE) " +
//            "AND (:highestPrice IS NULL OR :highestPrice <= PRICE)")
//    public List<ProductType> getCatalogBySearchCriteria(
//            @Param("productTypeCategory") UUID productTypeCategory,
//            @Param("hasSale") Boolean hasSale,
//            @Param("lowestPrise") BigDecimal lowestPrise,
//            @Param("highestPrice") BigDecimal highestPrice);
//}
