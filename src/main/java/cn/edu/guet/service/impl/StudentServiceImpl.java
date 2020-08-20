package cn.edu.guet.service.impl;

import cn.edu.guet.mapper.MajorMapper;
import cn.edu.guet.mapper.StudentMapper;
import cn.edu.guet.model.Course;
import cn.edu.guet.model.Major;
import cn.edu.guet.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;

public class StudentServiceImpl implements IStudentService {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    MajorMapper majorMapper;



    @Override
    public List<Course> getCourse(String majorid,String studentid) {
        List<Course> courseList=studentMapper.getCourse(majorid,studentid);
        return courseList;
    }

    @Override
    public List<Major> getMajor() {
        List<Major> majorList=majorMapper.getMajor();
        return majorList;
    }

    @Override
    public Boolean courseSelection(String courseid, String studentid) {
        Boolean status=studentMapper.courseSelection(courseid,studentid);
        return status;
    }
}
