package com.customshop.back.model.entity;

import com.customshop.back.model.auditable.AuditableSession;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "cart_records")
@EqualsAndHashCode(callSuper = true)
public class CartRecord extends AuditableSession {

    @Id
    // TODO: figure out how does it work
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "uuid-char")
    @Column(name = "cart_record_id", columnDefinition = "uniqueidentifier")
    private UUID cartRecordId;

    @Column(name = "cart_id")
    private UUID cartId;

    @Column(name = "product_type_id")
    private UUID productTypeId;

    @Column(name = "count")
    private Integer count;

}
