package cn.edu.guet.service.impl;

import cn.edu.guet.mapper.LoginMapper;
import cn.edu.guet.model.Student;
import cn.edu.guet.model.Teacher;
import cn.edu.guet.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements ILoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public Object login(String username, String password) {
        System.out.println("事务处理"+username);
        System.out.println("事务处理"+password);
        if (username.length()==6){
            Teacher teacher=loginMapper.loginTeacher(username,password);
            return teacher;
        }
        else if (username.length()==10){
            Student student=loginMapper.loginStudent(username,password);
            return student;
        }
        else if ("17007".equals(username) && "17007".equals(password)){
            return "R003";
        }
        return null;
    }
}
