package com.example.luyenTapJ6_1.controller;

import com.example.luyenTapJ6_1.entity.NhanVien;
import com.example.luyenTapJ6_1.repository.NhanVienRepository;
import com.example.luyenTapJ6_1.request.NhanVienRequest;
import com.example.luyenTapJ6_1.response.NhanVienResponse;
import com.example.luyenTapJ6_1.serivce.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nhan-vien/")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;


    @GetMapping("phan-trang")
    public ResponseEntity<?> phanTrang(@RequestParam(defaultValue = "0") Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<NhanVienResponse> nhanVienPage = nhanVienService.phanTrang(pageable);
        return ResponseEntity.ok(nhanVienPage);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<?> detail(@PathVariable("id") Integer id) {
        NhanVienResponse nhanVienResponse = nhanVienService.getOne(id);
        return ResponseEntity.ok(nhanVienResponse);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,@RequestBody  @Valid  NhanVienRequest nhanVienRequest, BindingResult result){
        if(result.hasErrors()){
          List<ObjectError> list = result.getAllErrors();
          return ResponseEntity.ok(list);
        }
        NhanVienRequest nhanVienRequestDetail = nhanVienService.update(id,nhanVienRequest);
        return ResponseEntity.ok(nhanVienRequestDetail);
    }
}
