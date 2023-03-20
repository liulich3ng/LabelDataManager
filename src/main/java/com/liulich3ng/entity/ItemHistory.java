package com.liulich3ng.entity;

import com.liulich3ng.constant.ITEM_STATUS;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ItemHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer itemId;

    private Integer userId;

    private ITEM_STATUS status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date opTime;

    private Integer confidence;
}
