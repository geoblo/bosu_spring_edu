package com.icia.start01.controller;

import com.icia.start01.dto.DataDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@Slf4j
public class HomeController {
    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "home";
    }

    @GetMapping("intro")
    public String intro(Model model){
        log.info("intro()");
        Date now = new Date();
        model.addAttribute("data", now);
        return "intro";
    }

    @GetMapping("t_output")
    public ModelAndView thymeleafOutput(){
        ModelAndView mv = new ModelAndView();
        //tag 데이터
        mv.addObject("testStr", "<h3>h3로 만든 문자열</h3>");

        //map 데이터 (묶음 데이터)
        Map<String, String> rmap = new HashMap<>();
        rmap.put("data1", "홍길동");
        rmap.put("data2", "20");
        rmap.put("data3", "인천시 미추홀구");

        mv.addObject("mapdata", rmap);

        //dto(또는 vo) 데이터
        DataDto dData = new DataDto();
        dData.setName("아무개");
        dData.setAge(30);
        dData.setAddress("인천시 동구");

        mv.addObject("dtoData", dData);

        //javascript 출력용 데이터
        mv.addObject("message", "서버로부터의 메시지");

        mv.setViewName("t_output");
        return mv;
    }

    @GetMapping("t_control")
    public ModelAndView thymeleafControl(){
        ModelAndView mv = new ModelAndView();

        mv.addObject("data", "이 문자열이 보입니다.");
        mv.addObject("age", 25);

        List<DataDto> d_list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            DataDto data = new DataDto();
            data.setName("이름" + i);
            data.setAge(25 + i);
            data.setAddress("주소" + i);
            d_list.add(data);
        }
        //mv.addObject("dList", d_list);

        mv.setViewName("t_control");
        return mv;
    }

    @GetMapping("sendData")
    public String sendData(){
        return "sendData";
    }

    @GetMapping("a_send")
    public ModelAndView aTagDataSend(String num1,
                                     @RequestParam("num2") int num2){
        //String으로 받을 경우 @RequestParam 필요 없음
        //대신 형변환 필요.
        System.out.println("num1 : " + num1 + ", num2 : " + num2);
        ModelAndView mv = new ModelAndView();
        int n1 = Integer.parseInt(num1);
        mv.addObject("result", n1 + num2);
        mv.setViewName("s_result");
        return mv;
    }
}
