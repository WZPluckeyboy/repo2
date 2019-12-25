package com.project.Dao;
import com.project.POJO.Item;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ItemDao extends JpaRepository<Item,Long> {

}
