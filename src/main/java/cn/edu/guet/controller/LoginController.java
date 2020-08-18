package cn.edu.guet.controller;

import cn.edu.guet.model.Menu;
import cn.edu.guet.service.IMenuService;
import cn.edu.guet.util.Result;
import cn.edu.guet.service.ILoginService;
import cn.edu.guet.util.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    ILoginService loginService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Object login(@RequestBody UserDto userDto){
        String username=userDto.getUsername();
        String password=userDto.getPassword();
        System.out.println("登陆控制器"+username);
        System.out.println("控制器"+password);
        Object user=loginService.login(username,password);
        Result result=new Result();
        if (user==null){
            return result.fail("用户名或密码不正确");
        }
        else{
            return result.succ(200,"登陆成功",user);
        }
    }

    @Autowired
    IMenuService menuService;

    @RequestMapping(value = "index",method = RequestMethod.GET)
    @ResponseBody
    public Result getMenus(){
        List<Menu> menuList=menuService.getMenu();
        Result result=new Result();
        if (menuList==null){
            return result.fail("用户名或密码不正确");
        }
        else{
            return result.succ(menuList);
        }
    }
}
