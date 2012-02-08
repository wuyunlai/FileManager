<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.wyl.env.spring.SpringContext"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

JdbcTemplate jt = (JdbcTemplate) SpringContext.getBean("jdbcTemplate");
/*
System.out.println("drop table tbl1;");
jt.execute("drop table tbl1");
System.out.println("create table tbl1(name varchar2(20), salary number);");
jt.execute("create table tbl1(name varchar(20), salary number)");
System.out.println("insert into tbl1 values('LiSi',7800);");
jt.execute("insert into tbl1 values('LiSi',7800)");
System.out.println("insert into tbl1 values('WangWu',5800);");
jt.execute("insert into tbl1 values('WangWu',5800)" );
System.out.println("insert into tbl1 values('ZhaoLiu',9100);");
jt.execute("insert into tbl1 values('ZhaoLiu',9100)" );
*/
String sql = "select * from tbl1";
//System.out.println(sql);
List<Map> dataList = jt.queryForList(sql);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript"> 
	alert()
        function addFile() 
        { 
        var str = '<br/><INPUT style="border:1px #99ffcc solid" type="file" size="50" NAME="File">';
         document.getElementById('MyFile').insertAdjacentHTML("beforeEnd",str);
         }
         
function showFileWin(transactionType,transactionId,editable,pid,unitid,userid,compress){
	var params = "transactionType="+transactionType+"&transactionId="+transactionId+"&editable="+editable
					+"&pid="+pid+"&unitid="+unitid+"&userid="+userid+"&compress="+compress;
	window.showModalDialog("<%=path%>/file/fileupload.jsp"+"?"+params,"","width:100%;height:100%;")
}
function uploadFile(){
showFileWin("1","1","1","1","1","1","1")
}
    </script>
	
  </head>
  
  <body>
    This is my JSP page. <br>
	<table>
		<%
		/*for (Map rows : dataList) {
				String outStr = "<tr>";
				Iterator it = rows.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next().toString();
					if (key != null && rows.get(key) != null) {
						String val = rows.get(key).toString();
						outStr += "<td>" + val + "</td>";
					}
				}
				outStr += "</tr>";
				out.print(outStr);
			}*/
		%>
	</table>
	<div id="filepanel" style="display:none">
      <form id="form1" action="<%=path%>/FileServlet" method="post" encType="multipart/form-data" runat="server">
        <table cellSpacing="3" cellPadding="2" border="0">
         <tr>
          <td>
           <h3>多文件上传</h3>
          </td>
         </tr>
         <tr>
          <td>
           <div id="MyFile"><INPUT style="BORDER-RIGHT: #99ffcc 1px solid; BORDER-TOP: #99ffcc 1px solid; BORDER-LEFT: #99ffcc 1px solid; BORDER-BOTTOM: #99ffcc 1px solid"
             type="file" size="50" name="File"></div>
          </td>
         </tr>
         <tr>
          <td>
          <input onclick="addFile();" type="button" value="增加(Add)">
          <input onclick="this.form.reset();" type="button" value="重置(ReSet)">
          <input type="submit" value="上传">
          </td>
         </tr>
         <tr>
          <td><asp:label id="strStatus" runat="server" BorderColor="White" BorderStyle="None" Width="500px"
            Font-Size="9pt" Font-Bold="True" Font-Names="宋体"></asp:label></td>
         </tr>
        </table>
      </form>
      </div>
	<input type=button onclick=uploadFile() value="上传">
  </body>
</html>
