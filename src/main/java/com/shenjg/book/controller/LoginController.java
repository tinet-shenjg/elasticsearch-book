package com.shenjg.book.controller;

import com.shenjg.book.common.ResponseModel;
import com.shenjg.book.model.LoginModel;
import com.shenjg.book.service.LoginService;
import com.shenjg.book.utils.CsvUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录相关控制器
 *
 * @author shenjg
 * @date 2019/07/20
 **/
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseModel login(@RequestBody LoginModel loginModel) {

        String token = loginService.login(loginModel.getUsername(),
                loginModel.getPassword());

        return new ResponseModel(HttpStatus.OK, token);
    }

    @GetMapping("/export")
    public void export(HttpServletResponse response) {


        // 构造导出数据结构
        String titles = "组号,组名,时间";  // 设置表头
        String keys = "no,name,time";  // 设置每列字段

        // 构造导出数据
        List<Map<String, Object>> datas = new ArrayList<>();
        Map<String, Object> map = null;
        map = new HashMap<>();
        map.put("no", "222");
        map.put("name", 222);
        map.put("time", 22222);
        datas.add(map);


        // 设置导出文件前缀
        String fName = "data_";

        // 文件导出
        try {
            OutputStream os = response.getOutputStream();
            CsvUtils.responseSetProperties(fName, response);
            CsvUtils.doExport(datas, titles, keys, os);
            os.close();
        } catch (Exception e) {
            System.out.println("error");

        }
    }

}
