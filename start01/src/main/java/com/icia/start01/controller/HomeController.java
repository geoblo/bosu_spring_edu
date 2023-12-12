package com.icia.start01.controller;

import com.icia.start01.dto.DataDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class HomeController {
    //시작 페이지 보이기
    @GetMapping("/")
    public String home(){
        return "home";//html 문서 파일의 이름만 작성.
    }

    //페이지 이동 및 Server -> Client 데이터 전송(텍스트)
    @GetMapping("intro")
    public String intro(Model model){
        
        return "intro";
    }

    @GetMapping("t_output")
    public ModelAndView thymeleafOutput(){
        ModelAndView mv = new ModelAndView();
        //tag 데이터
        
        //map 데이터 (묶음 데이터)
        
        //dto(또는 vo) 데이터
        
        //javascript 출력용 데이터
        
        return mv;
    }

    @GetMapping("t_control")
    public ModelAndView thymeleafControl(){
        ModelAndView mv = new ModelAndView();

        return mv;
    }

    @GetMapping("sendData")
    public String sendData(){
        return "sendData";
    }

    @GetMapping("a_send")
    public ModelAndView aTagDataSend(){
        
        ModelAndView mv = new ModelAndView();
        
        return mv;
    }

    @GetMapping("noneDtoSend")
    public String noneDtoSend(){
        
        return "s_result";
    }

    @PostMapping("dtoSend")
    public String dtoSend(){
        
        return "s_result";
    }
}
