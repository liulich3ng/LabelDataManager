package com.liulich3ng.service;

import com.liulich3ng.entity.Item;
import com.liulich3ng.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    /**
     * 对一个条目的操作包括了：
     * 新建
     * 暂存
     * 真的完成
     * 跳过
     * 放弃
     * 通过
     * 不通过
     */

    public void newItemWithoutChildren(int pid, String info){
        Item item = Item.builder()
                .pid(pid)
                .info(info)
                .build();
        itemRepository.save(item);
    }

    public void newItemWithChildren(int pid, List<String> children){
        Item item = Item.builder()
                .pid(pid)
                .children(children)
                .build();
        itemRepository.save(item);
    }

    public Item getItemById(int itemId){
        return itemRepository.findById(itemId).orElseThrow();
    }
}
