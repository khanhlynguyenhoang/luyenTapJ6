package com.example.luyenTapJ6_1.serivce;

import com.example.luyenTapJ6_1.entity.ChucVu;
import com.example.luyenTapJ6_1.entity.NhanVien;
import com.example.luyenTapJ6_1.repository.ChucVuRepository;
import com.example.luyenTapJ6_1.repository.NhanVienRepository;
import com.example.luyenTapJ6_1.request.NhanVienRequest;
import com.example.luyenTapJ6_1.response.NhanVienResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class NhanVienServiceImp implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Autowired
    private ChucVuRepository chucVuRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<NhanVienResponse> getAll() {
        List<NhanVien> nhanVienList = nhanVienRepository.getAll();
        return nhanVienList.stream().map(nhanVien -> modelMapper.map(nhanVien, NhanVienResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<NhanVienResponse> phanTrang(Pageable pageable) {
        Page<NhanVien> nhanVienPage = nhanVienRepository.phanTrang(pageable);
        List<NhanVienResponse> nhanVienResponseList = nhanVienPage.getContent().stream().map(nhanVien ->
                modelMapper.map(nhanVien, NhanVienResponse.class)).collect(Collectors.toList());
        return new PageImpl<>(nhanVienResponseList, pageable, nhanVienPage.getTotalElements());
    }

    @Override
    public NhanVienResponse getOne(Integer id) {
        NhanVien nhanVien = nhanVienRepository.getReferenceById(id);
        NhanVienResponse nhanVienResponse = modelMapper.map(nhanVien, NhanVienResponse.class);
        return nhanVienResponse;
    }

    @Override
    public NhanVienRequest update(Integer id, NhanVienRequest nhanVienRequest) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Khong tim thay id"));
        ChucVu chucVu = chucVuRepository.findById(nhanVienRequest.getIdChucVu()).orElseThrow(() ->
                new IllegalArgumentException("Khong tim thay id chuc vu"));
        nhanVien.setHo(nhanVienRequest.getHo());
        nhanVien.setTenDem(nhanVienRequest.getTenDem());
        nhanVien.setTen(nhanVienRequest.getTen());
        nhanVien.setDiaChi(nhanVienRequest.getDiaChi());
        nhanVien.setGioiTinh(nhanVienRequest.getGioiTinh());
        nhanVien.setMa(nhanVienRequest.getMa());
        nhanVien.setChucVu(chucVu);
        NhanVien nhanVienUpdate = nhanVienRepository.save(nhanVien);
        return modelMapper.map(nhanVienUpdate, NhanVienRequest.class);
    }

}
