<%--
  Created by IntelliJ IDEA.
  User: Mxia
  Date: 2016/12/6
  Time: 21:22
  To change this template use File | Settings | File Templates.
  词典 翻译
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mxia翻译</title>
</head>
<body>
    <input type="text" id="keyword">
    <button id="btn">query</button>
    <p id="result"></p>

    <script>
        //获取点击事件
        document.querySelector("#btn").onclick = function(){
            //获取文本内容
            var keyWord = document.querySelector("#keyword").value;
            //获取ajax引擎
            var xmlHttp = new XMLHttpRequest();
            //设置请求方式和请求地址
            xmlHttp.open("get","/dic?query="+keyWord);
            //设置回调函数
            xmlHttp.onreadystatechange = function(){
                //获取服务端状态吗
                var state = xmlHttp.readyState;

                if(state==4){
                    //获取http状态吗
                    if(xmlHttp.status==200){
                        //获取服务端的返回值（xml)
                        var xmlDoc = xmlHttp.responseXML;
                        //获取返回值中的errorCode 标签
                        var errorCode = xmlDoc.getElementsByTagName("errorCode")[0].childNodes[0].nodeValue;
                        if(errorCode==0){
                            //获取返回值中的ex标签
                            var ex = xmlDoc.getElementsByTagName("ex")[0].childNodes[0].nodeValue;
                            //获取p标签并且 赋予值
                            document.querySelector("#result").innerText = ex;
                        }else{
                            throw new RuntimeException("errorCode"+errorCode);
                        }
                    }
                }


            }
            //发送请求
            xmlHttp.send();
        }

    </script>

</body>
</html>
