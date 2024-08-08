package com.example.luyenTapJ6_1.repository;

import com.example.luyenTapJ6_1.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {

    @Query("select nv from NhanVien nv join fetch nv.chucVu ")
    List<NhanVien> getAll();

    @Query("select  nv from NhanVien  nv join fetch  nv.chucVu")
    Page<NhanVien> phanTrang(Pageable pageable);

}
