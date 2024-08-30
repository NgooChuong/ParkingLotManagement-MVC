/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbdx.Mapper;

import com.qlbdx.dto.PhuongtienDTO;
import com.qlbdx.pojo.Phuongtien;

/**
 *
 * @author quang
 */
public class PhuongTienMapper {
    public static PhuongtienDTO toDTO(Phuongtien b) {
        if (b == null) {
            return null;
        }

        // Chuyển đổi User entity sang UserDTO
        return new PhuongtienDTO(
                b.getId(), // Chuyển đổi thuộc tính id
                   b.getLoai()
        );
    }
}
