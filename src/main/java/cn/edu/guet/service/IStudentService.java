package cn.edu.guet.service;

import cn.edu.guet.model.Course;
import cn.edu.guet.model.Major;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IStudentService {
    List<Course> getCourse(String majorid, String studentid);
    List<Major> getMajor();
    Boolean courseSelection(String courseid,String studentid);
}
