package com.diycomputersystem.controller;

import com.diycomputersystem.entity.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diy")
public class TextController {
    @GetMapping("/text")
    public R text(){
        return R.ok("nb");
    }
}
