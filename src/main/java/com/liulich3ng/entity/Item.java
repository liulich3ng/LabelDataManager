package com.liulich3ng.entity;

import com.liulich3ng.constant.ITEM_STATUS;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer pid;

    @Builder.Default
    private boolean hasChildren = false;

    private String info;

    @ElementCollection
    private List<String> children;

    @Builder.Default
    private ITEM_STATUS status = ITEM_STATUS.NEW;

    @Builder.Default
    private Integer confidence = 0;

    private Integer labeler;

    private Integer lastChecker;

    private Integer vendorId;
}
