package cn.edu.guet;

import cn.edu.guet.mapper.MenuMapper;
import cn.edu.guet.mapper.StudentMapper;
import cn.edu.guet.model.Course;
import cn.edu.guet.model.Major;
import cn.edu.guet.model.Menu;
import cn.edu.guet.service.IMenuService;
import cn.edu.guet.service.IStudentService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class SpringTest {
    @Autowired
    IMenuService menuService;

    @Test
    public void Test(){
        List<Menu> menuList=menuService.getMenuById("007001");
        for (int i=0; i<menuList.size(); i++){
            System.out.println(menuList.get(i).getMenuId()+menuList.get(i).getMenuName());
        }
    }


    @Autowired
    IStudentService studentService;
    @Test
    public void testCourse(){
        List<Course> courseList=studentService.getCourse("200","1700720133");
        for (int i=0; i<courseList.size(); i++){
            System.out.println(courseList.get(i).getCourseName()+courseList.get(i).getTeacher().getTeacherName());
        }
        Gson gson=new Gson();
        System.out.println(gson.toJson(courseList));

    }

    @Test
    public void testMajor(){
        List<Major> majorList=studentService.getMajor();
        for (int i=0; i<majorList.size(); i++){
            System.out.println(majorList.get(i).getMajorId());
        }
        Gson gson=new Gson();
        System.out.println(gson.toJson(majorList));

    }

    @Test
    public void testCourseSelection(){
        System.out.println(studentService.courseSelection("002", "1700720133"));
    }

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testCourseAll(){
        List<Course> courseList=studentMapper.getCourseAll("007001");
        for (Course course:courseList){
            System.out.println(course.getMajor().getMajorId());
            System.out.println(course.getMajor().getSchool().getSchoolName());
        }
    }

}