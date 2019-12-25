package com.project.Service;
import com.project.POJO.Item;

import java.util.List;

public interface ItemService {
    public void save(Item item);
    public List<Item > findAll(Item item);
}
