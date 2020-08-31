package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.FavoriteEntity;
import com.example.demo.service.impl.FavoriteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FavoriteController {

    @Autowired
    FavoriteServiceImpl favoriteService;

//    @GetMapping(value = "/favorite")
//    public String showFavorite(HttpServletRequest request) {
//        String userName = (String) request.getSession().getAttribute("userName");
//
//        return "favorite";
//    }

    @PostMapping(value = "/music/starMusic")
    @ResponseBody
    public String starMusic(HttpServletRequest request) {
        String userName = (String) request.getSession().getAttribute("userName");
        if (userName == null)
            return "false";
        try {
            if (Boolean.parseBoolean(request.getParameter("unFav")))
                favoriteService.remove(new QueryWrapper<FavoriteEntity>().eq("userName", userName)
                        .eq("musicID", Integer.parseInt(request.getParameter("musicID"))));
            else
                favoriteService.save(new FavoriteEntity(0, userName, Integer.parseInt(request.getParameter("musicID"))));
        } catch (Exception e) {
            e.printStackTrace();
            return "true";
        }
        return "true";
    }

}
