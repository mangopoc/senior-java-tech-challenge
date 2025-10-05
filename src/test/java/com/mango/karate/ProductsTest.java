package com.mango.karate;

import com.mango.products.ProductsApplication;
import org.springframework.boot.test.context.SpringBootTest;
import com.intuit.karate.junit5.Karate;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = ProductsApplication.class)
class ProductsTest {

    @Karate.Test
    Karate testHealthEndpoint() {
        return Karate.run("health").relativeTo(getClass());
    }

    @Karate.Test
    Karate testProductsEndpoint() {
        return Karate.run("products").relativeTo(getClass());
    }
}
