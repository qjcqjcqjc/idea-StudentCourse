package cn.edu.guet.controller;

import cn.edu.guet.model.Course;
import cn.edu.guet.model.Major;
import cn.edu.guet.model.Menu;
import cn.edu.guet.service.IStudentService;
import cn.edu.guet.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    IStudentService studentService;
    Result result=new Result();



    @RequestMapping("ChooseCourse")
    @ResponseBody
    public Result ChooseCourse(String majorid,HttpSession httpSession){
        String studentid= (String) httpSession.getAttribute("username");
        System.out.println("学生控制器");
        System.out.println("获取到用户id"+studentid);
        List<Course> courseList=studentService.getCourse(majorid,studentid);
        if (courseList==null){
            return result.fail("失败");
        }
        else{
            return result.succ(courseList);
        }
    }

    @RequestMapping("ChooseMajor")
    @ResponseBody
    public Result ChooseMajor(){
        List<Major> majorList=studentService.getMajor();
        if (majorList==null){
            return result.fail("失败");
        }
        else{
            return result.succ(200,"成功",majorList);
        }
    }

    @RequestMapping("CourseSelection")
    @ResponseBody
    public Result CourseSelection(String courseid,HttpSession httpSession){
        String studentid= (String) httpSession.getAttribute("username");
        Boolean status=studentService.courseSelection(courseid,studentid);
        if (status==false){
            return result.fail("失败");
        }
        else{
            return result.succ(200,"成功",status);
        }
    }
}
