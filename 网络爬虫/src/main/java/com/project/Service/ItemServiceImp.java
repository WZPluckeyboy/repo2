package com.project.Service;
import com.project.Dao.ItemDao;
import com.project.POJO.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ItemServiceImp implements ItemService {
    @Autowired
    private  ItemDao itemDao;
    @Override
    @Transactional
    public void save(Item item) {
       this. itemDao.save(item);
    }

    @Override
    public List<Item> findAll(Item item) {
        Example<Item> example=Example.of(item);
     List<Item> list= this.itemDao.findAll(example);
     return list;
    }
}
