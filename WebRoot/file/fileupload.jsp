<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.wyl.env.spring.SpringContext"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

//业务类型
String transactionType=request.getParameter("transactionType");
//业务流水号
String transactionId=request.getParameter("transactionId");
//var editable="1"  // 1--可以加入新文档  0--不能加入，只能查看已有的文档  2更新已存在的文档
String editable=request.getParameter("editable")==null?"0":request.getParameter("editable");
//项目id
String pid=request.getParameter("pid");
//单位id
String unitid=request.getParameter("unitid");
//用户id
String userid=request.getParameter("userid");
//var compress="1" //压缩
String compress=request.getParameter("compress")==null?"1":request.getParameter("compress");
//创建时应用的功能模块
//String funCode=session.getAttribute(com.wyl.env.FUNLIST)==null?"":session.getAttribute(com.wyl.env.FUNLIST).toString();

String params = "transactionType="+transactionType+"&transactionId="+transactionId+"&editable="+editable
					+"&pid="+pid+"&unitid="+unitid+"&userid="+userid+"&compress="+compress;
	
 	JdbcTemplate jt = (JdbcTemplate) SpringContext.getBean("jdbcTemplate");
 	String sql = "select * from file_attach_list where transaction_type='" + transactionType 
 	+"' and transaction_id='" + transactionId + "' and pid='" + pid 
 	+"' and unit_id='" + unitid + "' and userid='" + userid + "'";
 	System.out.println(sql);
 	List<Map> dataList = jt.queryForList(sql);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'fileupload.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="JavaScript"> 
        function addFile() 
        { 
        var str = '<br/><INPUT style="border:1px #99ffcc solid" type="file" size="50" NAME="File">';
         document.getElementById('MyFile').insertAdjacentHTML("beforeEnd",str);
         }
         
    </script>

  </head>
  
  <body>
    This is my JSP page. <br>
    <table>
		<%
			for (Map rows : dataList) {
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
			}/**/
		%>
	</table>
	<br>
	  <form id="form1" action="<%=path %>/FileServlet?<%=params %>" method="post" encType="multipart/form-data" runat="server">
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
          <td>
          <input type=hidden id="transactionType" value="<%=transactionType %>"/>
          <input type=hidden id="transactionId" value="<%=transactionId %>"/>
          <input type=hidden id="editable" value="<%=editable %>"/>
          <input type=hidden id="pid" value="<%=pid %>"/>
          <input type=hidden id="unitid" value="<%=unitid %>"/>
          <input type=hidden id="userid" value="<%=userid %>"/>
          <input type=hidden id="compress" value="<%=compress %>"/>
          </td>
         </tr>
        </table>
      </form>
  </body>
</html>
