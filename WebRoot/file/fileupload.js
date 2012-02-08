var extFileWin
var _fileType
var _filePK
var _fileDept
var _fileDate
var _fileEdit

function showFileWin(transactiontype,transactionid,editable,pid,unitid,userid,compress){
	var params = "transactiontype="+transactiontype+"&transactionid="+transactionid+"&editable="+editable
					+"&pid="+pid+"&unitid="+unitid+"&userid="+userid+"&compress="+compress;
	window.showModalDialog("<%=path%>/file/fileupload.jsp"+"?"+params,"","width:100%;height:100%;")
}

function loadFileGrid() {
	var fileDeptThis 
	if(_fileDept == "all")
	{
		fileDeptThis = ""
	} else
	{
		fileDeptThis = _fileDept
	}
	//var sql = "select file_lsh,file_name,unitname,template_id,sgcc_ini_unit.unitid from sgcc_attach_list,sgcc_ini_unit "
	//		+ "where sgcc_attach_list.file_type=sgcc_ini_unit.unitid(+) and transaction_type='"
	//		+ _fileType + "' and transaction_id='" + _filePK + "'"
	var sql = "select file_lsh,file_name,tab1.unitname,template_id,tab1.unitid from sgcc_attach_list,"
			+ "(select property_code as unitid,property_name as unitname from property_code where type_name='专业部门类别' order by property_code)tab1 "
			+ "where sgcc_attach_list.file_type=tab1.unitid(+) and transaction_type='"
			+ _fileType + "' and transaction_id='" + _filePK + "'"
	if(fileDeptThis && fileDeptThis!="") {
		sql += " and dept_id='" + fileDeptThis + "'"
	}
	//Ext.getCmp('debugText').setValue(sql);
	db2Json.selectData(sql, function (jsonData) {
		var ds = Ext.getCmp('fileGrid').getStore()
		ds.loadData(eval(jsonData),false)
	});
}

function fileSubmit() {
	window.frames["fileFrm"].doSubmit()
}

function closeUploadWin() {
	uploadWin.close()
}

function openTemplet() {
	var frm = window.frames["templetFrm"]
	if(frm.docTemplet.value=="") {
		alert("请选择模板")
	}
	else if(frm.fileName.value=="") {
		alert("文件名不能为空")
	}
	else {
		var param = new Object()
		param.date = _fileDate
		param.templet_id = frm.docTemplet.value
		param.file_id = ""
		param.file_name = frm.fileName.value
		param.file_pk = _filePK
		param.file_type = _fileType
		param.file_dept = _fileDept
		param.upper = ""
		closeTempletWin()
		window.showModalDialog(g_path+"/masterPlan/templet/docView.jsp", param, "dialogWidth:" + screen.availWidth + ";dialogHeight:" + screen.availHeight + ";center:yes;resizable:yes;" )
		loadFileGrid()
	}
}

function editFile() {
	var r = Ext.getCmp('fileGrid').getSelectionModel().getSelected()
	if(r) {
		var param = new Object()
		param.date = _fileDate
		param.templet_id = r.get('template_id')
		param.file_id = r.get('file_lsh')
		param.file_name = r.get('file_name')
		param.file_pk = _filePK
		param.file_type = _fileType
		param.file_dept = _fileDept
		param.upper = r.get('unitid')
		window.showModalDialog(g_path+"/masterPlan/templet/docView.jsp", param, "dialogWidth:" + screen.availWidth + ";dialogHeight:" + screen.availHeight + ";center:yes;resizable:yes;" )
		loadFileGrid()
	}
	else {
		alert("请选择需要编辑的文档")
	}
}

function closeTempletWin() {
	templetWin.close()
}

function delFile() {
	var arr = Ext.getCmp('fileGrid').getSelectionModel().getSelections()
	if(arr.length && confirm("确认删除已选中的文件？")) {
		var  sql = ""
		for(var i=0;i<arr.length;i++) {
			var fid = arr[i].get('file_lsh')
			sql += "delete from sgcc_attach_list where file_lsh='" + fid + "';delete from system_longdata where file_lsh='" + fid + "';"
		}
		if(sql!="") {
			db2Json.execute(sql,function(b){
				if(b) {
					loadFileGrid()
				}
			});
		}
	}
}