package com.project.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class StoreGoodsMapping {

    @Id @GeneratedValue
    @Column(name = "goods_id")
    // 상품 ID
    private Long id;

    @Id
    @ManyToOne
    @Embedded
    @JoinColumn(name = "store_id")  // 외래키
    private Store store;

    @OneToOne
    @JoinColumn(name = "category_id")    // 외래키
    private Category category;

    @Column(name = "sys_reg_id")
    // 등록자
    private int sysRegId;

    @Column(name = "sys_reg_at")
    // 등록일
    private int sysRegAt;

    @Column(name = "sys_upd_id")
    // 수정자
    private int sysUpdId;

    @Column(name = "sys_upd_at")
    // 수정일
    private int sysUpdAt;

}