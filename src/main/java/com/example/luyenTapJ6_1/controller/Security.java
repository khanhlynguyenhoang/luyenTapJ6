package com.example.luyenTapJ6_1.controller;

import com.example.luyenTapJ6_1.response.NhanVienResponse;
import com.example.luyenTapJ6_1.serivce.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/security/")
public class Security {
    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("hien-thi")
    public ResponseEntity<List> getAll() {
        List<NhanVienResponse> listNhanVien = nhanVienService.getAll();
        return ResponseEntity.ok(listNhanVien);
    }
}
