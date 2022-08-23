package com.example.demo;

import com.example.demo.product.Category;
import com.example.demo.product.Product;
import com.example.demo.product.ProductId;
import com.example.demo.teacher.Course;
import com.example.demo.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Arrays;

@RestController
public class MyController {

    @Autowired
    private EntityManager entityManager;

    @PostMapping("/categories")
    @Transactional
    public void createCategory() {
        Category category = new Category();
        entityManager.persist(category);
        System.out.println(category);
    }

    @PostMapping("/products")
    @Transactional
    public void createProduct() {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
        Category category = new Category();
        category.setName("Sweeties");
        entityManager.persist(category);
        Product product1 = new Product("Mars", "Mars", BigDecimal.valueOf(10));
        product1.setCategories(Arrays.asList(category));
        Product product2 = new Product("Snickers", "Mars", BigDecimal.valueOf(15));
        product2.setCategories(Arrays.asList(category));
        entityManager.persist(product1);
        entityManager.persist(product2);
        System.out.println(product1);
        System.out.println(product2);
    }

    @GetMapping("/products")
    public void getProducts() {
        Product product = entityManager.find(Product.class, new ProductId("Mars", "Mars"));
        System.out.println("Product found!");
        System.out.println(product);
    }

    @PostMapping("/teachers")
    @Transactional
    public void createTeacher() {
        Teacher teacher = new Teacher();
        entityManager.persist(teacher);
        Course course1 = new Course();
        course1.setTeachers(teacher);
        entityManager.persist(course1);
        Course course2 = new Course();
        course2.setTeachers(teacher);
        entityManager.persist(course2);
        System.out.println(course1);
        System.out.println(course2);
        System.out.println(teacher);
    }

    @GetMapping("/teachers")
    public void getTeachers() throws InterruptedException {
        Teacher teacher = entityManager.find(Teacher.class, 1L);
        System.out.println("Teacher is read");
        Thread.sleep(2000L);
        teacher.getCourses();
        System.out.println("Courses are gotten");
        System.out.println("Class: " + teacher.getCourses().getClass());
        Thread.sleep(2000L);
        teacher.getCourses().size();
        System.out.println("Courses are read");
    }

}
