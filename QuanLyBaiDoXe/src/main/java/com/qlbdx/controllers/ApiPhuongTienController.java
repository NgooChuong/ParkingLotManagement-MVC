/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbdx.controllers;

import com.qlbdx.Mapper.ListMapper;
import com.qlbdx.Mapper.PhuongTienMapper;
import com.qlbdx.dto.PhuongtienDTO;
import com.qlbdx.pojo.Phuongtien;
import com.qlbdx.service.PhuongTienService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author quang
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiPhuongTienController {
    
    @Autowired
    private PhuongTienService ptSer;
    
    @GetMapping(path = "/phuongtien", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<List<PhuongtienDTO>> getPicBaiDoXe() {
        List<Phuongtien> cds = this.ptSer.getPhuongTien();
        List<PhuongtienDTO> pics = ListMapper.mapList(cds, PhuongTienMapper::toDTO);
        return new ResponseEntity<>(pics, HttpStatus.OK);
    }
}
