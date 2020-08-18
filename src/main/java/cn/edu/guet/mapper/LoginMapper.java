package cn.edu.guet.mapper;

import cn.edu.guet.model.Student;
import cn.edu.guet.model.Teacher;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
    Student loginStudent(@Param("username") String username, @Param("password") String password);
    Teacher loginTeacher(@Param("username") String username, @Param("password") String password);
}
