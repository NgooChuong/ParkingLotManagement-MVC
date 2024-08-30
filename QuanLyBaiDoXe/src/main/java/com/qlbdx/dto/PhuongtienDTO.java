/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbdx.dto;

/**
 *
 * @author quang
 */
public class PhuongtienDTO {

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the loai
     */
    public String getLoai() {
        return loai;
    }

    /**
     * @param loai the loai to set
     */
    public void setLoai(String loai) {
        this.loai = loai;
    }

    private Integer id;
    private String loai;
    
    public PhuongtienDTO(Integer id, String loai){
        this.id = id;
        this.loai = loai;
    }

}
