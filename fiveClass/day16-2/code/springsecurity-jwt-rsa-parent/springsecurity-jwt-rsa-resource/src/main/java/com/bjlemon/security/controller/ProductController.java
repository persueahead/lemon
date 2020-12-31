package com.bjlemon.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/findAll")
    public String findAll() {
        return "商品列表";
    }
}
