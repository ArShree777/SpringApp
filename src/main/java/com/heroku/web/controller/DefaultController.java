/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heroku.web.controller;

import com.heroku.web.entity.Skill;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author aryas
 */
@Controller
@RequestMapping(value = "/home")
public class DefaultController {

    @Autowired
    private JdbcTemplate jdbcTemplate; //@Autowired=already create bhako obj. sanga hami sidai mapping gardinxa.. "Dependency injection garna sakxumm" 

    @RequestMapping(method = RequestMethod.GET)
    //@ResponseBody //yo chai view deykhhauney hoena.. Screen ma print matra garna lako bhaneyko
    public String index(Model model) {
        //return "/WEB-INF/views/index.jsp"; without using viewResolver
        //return "<h1>Hello World</h1>";//by default yesley view page khojxa
        // model.addAttribute("name","Roronora Zoro");
        String sql = "select * from mst_skills";
        List<Skill> skills = jdbcTemplate.query(sql, new RowMapper<Skill>() {

            public Skill mapRow(ResultSet rs, int i) throws SQLException {
                return new Skill(rs.getInt("id"), rs.getString("name"));
            }
        });
        model.addAttribute("skills",skills);
        return "index";//using viewResolver

    }
    
    @RequestMapping(value="/about", method=RequestMethod.GET)
    @ResponseBody
     public String about(){
     return "About us...";
     }
        
     @RequestMapping(value="/table", method=RequestMethod.GET)
    @ResponseBody
     public String table(){
     String sql="create table mst_skills(id serial primary key,name varchar(50))";
     int result=jdbcTemplate.update(sql);
     return result + "";
     } 
    

}
