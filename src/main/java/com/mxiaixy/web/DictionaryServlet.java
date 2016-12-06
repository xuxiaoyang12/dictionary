package com.mxiaixy.web;

import com.mxiaixy.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Mxia on 2016/12/6.
 */
@WebServlet("/dic")
public class DictionaryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取ajax请求值
        String query = req.getParameter("query");
        //设置字符编码
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //设置要请求的url
        String url = "http://fanyi.youdao.com/openapi.do?keyfrom=kaishengit&key=1587754017&type=data&doctype=xml&version=1.1&q="+query;

        //获得求结果result
        String result = HttpUtil.sendHttpGetRequest(url);

        //输出
        PrintWriter out = resp.getWriter();

        out.write(result);

        out.flush();
        out.close();




    }
}
