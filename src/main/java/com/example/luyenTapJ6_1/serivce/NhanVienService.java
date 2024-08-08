package com.example.luyenTapJ6_1.serivce;

import com.example.luyenTapJ6_1.request.NhanVienRequest;
import com.example.luyenTapJ6_1.response.NhanVienResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface NhanVienService {
    List<NhanVienResponse> getAll() ;
    Page<NhanVienResponse> phanTrang(Pageable pageable);
    NhanVienResponse getOne(Integer id);
    NhanVienRequest update(Integer id,NhanVienRequest nhanVienRequest);
}
