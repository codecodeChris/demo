package Controller;

import Entity.Student;
import Service.IStudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService service;

    @RequestMapping("/enrol")
    public ModelAndView Fuck(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        ModelAndView m=new ModelAndView();
        List<Student> students = service.selectByCondition(new Student());
        String jsonResult = com.alibaba.fastjson.JSON.toJSONString(students);
        m.addObject("StuList",jsonResult);
        m.setViewName("show");
        return m;
    }
    @RequestMapping(value = "/changeRoom", method=RequestMethod.POST)
    @ResponseBody
    public Map recharge(@RequestParam("username") String name) {
        System.out.println("mapping success!");
        System.out.println(name);
        Map map=new HashMap<String,String>();
        //String type=data.get("username").trim();
        //RoomEntity roomEntity=roomService.findByType(type);
        Student student=service.selectByName(name);

        System.out.println(student.getName()+student.getAge());
        map.put("username",student.getName());
        map.put("age",student.getAge());
        return map;
    }
}