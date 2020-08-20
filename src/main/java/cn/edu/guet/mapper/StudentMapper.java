package cn.edu.guet.mapper;

import cn.edu.guet.model.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Course> getCourse(@Param("majorid")String majorid, @Param("studentid")String studentid);
    Boolean courseSelection(@Param("courseid")String courseid,@Param("studentid")String studentid);
    List<Course> getCourseAll(String teacherid);
}
