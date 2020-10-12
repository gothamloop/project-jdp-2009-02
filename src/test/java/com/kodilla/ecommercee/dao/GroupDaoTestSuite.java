package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.dao.GroupDao;
import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GroupDaoTestSuite {
    @Autowired
    private GroupDao groupDao;

    @Test
    public void testGroupDaoSave() {
        //Given
        Group group = new Group("Exotic fruits", "Pineapple, mango, kiwi etc.");

        //When
        groupDao.save(group);

        //Then
        long id = group.getId();

        Optional<Group> groupOptional = groupDao.findById(id);
        Assert.assertTrue(groupOptional.isPresent());
        Assert.assertEquals(0, groupOptional.get().getProductsList().size());
    }

    @Test
    public void testCartDaoSave_withProducts() {
        //Given
        Group group = new Group("Exotic fruits", "Pineapple, mango, kiwi etc.");

        Product product1 = new Product("Pineapple", "Fruit LTD.", new BigDecimal("8.8"));
        Product product2 = new Product("Apple", "Fruit LTD.", new BigDecimal("1.45"));

        List<Product> products = new ArrayList<>();
        Collections.addAll(products, product1, product2);

        product1.setGroup(group);
        product2.setGroup(group);

        group.setProductsList(products);

        //When
        groupDao.save(group);

        //Then
        long groupId = group.getId();
        Optional<Group> groupOptional = groupDao.findById(groupId);

        Assert.assertTrue(groupOptional.isPresent());
        Assert.assertEquals(2, groupOptional.get().getProductsList().size());
        Assert.assertEquals("Pineapple", groupOptional.get().getProductsList().get(0).getName());
        Assert.assertEquals("Fruit LTD.", groupOptional.get().getProductsList().get(0).getDescription());
        Assert.assertEquals(BigDecimal.valueOf(1.45), groupOptional.get().getProductsList().get(1).getPrice());
    }
}