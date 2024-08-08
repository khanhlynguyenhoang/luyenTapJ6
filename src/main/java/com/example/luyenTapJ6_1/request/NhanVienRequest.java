package com.example.luyenTapJ6_1.request;

import com.example.luyenTapJ6_1.entity.ChucVu;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienRequest {

    private Integer id;

    @NotBlank(message = "Khong duoc de trong ma")
    private String ma;

    private String ho;

    private String tenDem;

    private String ten;

    private String gioiTinh;

    private String diaChi;

    private Integer idChucVu;

    private String tenChucVu;

}
