package com.example.luyenTapJ6_1.response;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NhanVienResponse {

    private Integer id;

    private String ma;

    private String hoTen;

    @JsonIgnore
    private String ho;

    @JsonIgnore
    private String tenDem;

    @JsonIgnore
    private String ten;

    private String gioiTinh;

    private String diaChi;

    @JsonIgnore
    private Integer idChucVu;

    private String tenChucVu;

    public String getHoTen() {
        return ho + (tenDem != null ? " " + tenDem : "") + (ten != null ? " " + ten : "");
    }
}
