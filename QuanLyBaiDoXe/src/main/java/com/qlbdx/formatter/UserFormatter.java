/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbdx.formatter;

import com.qlbdx.pojo.User;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author quang
 */
public class UserFormatter implements Formatter<User>{
     @Override
    public String print(User object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public User parse(String text, Locale locale) throws ParseException {
        User c = new User();
        c.setId(Long.parseLong(text));
        return c;
    }
}