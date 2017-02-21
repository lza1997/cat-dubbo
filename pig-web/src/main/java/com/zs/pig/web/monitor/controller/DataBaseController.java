package com.zs.pig.web.monitor.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.github.abel533.database.Dialect;
import com.github.abel533.database.IntrospectedTable;
import com.github.abel533.database.SimpleDataSource;
import com.github.abel533.utils.DBMetadataUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zs.pig.common.sys.model.SysArea;
import com.zs.pig.common.utils.StringUtil;

@Controller
@RequestMapping("database")
public class DataBaseController {

	@RequestMapping
	public String toArea(Model model) throws SQLException {
		 DBMetadataUtils dbUtils = new DBMetadataUtils(
		            new SimpleDataSource(Dialect.MYSQL, "jdbc:mysql://localhost:3306/zsshop?useUnicode=true&characterEncoding=utf8", "root", "root"));
		    List<IntrospectedTable> tables = dbUtils.introspectTables(dbUtils.getDefaultConfig());
		    model.addAttribute("treeList", JSON.toJSONString(tables));
		return "database/database";
	}
	/**
	 * 分页显示区域table
	 * 
	 * @param params
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.POST)
	public String list(Model model,HttpServletRequest req) throws SQLException{
		String name=req.getParameter("id");
		 DBMetadataUtils dbUtils = new DBMetadataUtils(
		            new SimpleDataSource(Dialect.MYSQL, "jdbc:mysql://localhost:3306/zsshop?useUnicode=true&characterEncoding=utf8", "root", "root"));
		    List<IntrospectedTable> tables = dbUtils.introspectTables(dbUtils.getDefaultConfig());
		    if(StringUtil.isNotEmpty(name)){
		    	for(IntrospectedTable t : tables){
		    		if(t.getName().equals(name)){
		    			tables=new ArrayList<IntrospectedTable>();
		    			tables.add(t);
		    			 model.addAttribute("tables", tables);
		    		}
		    	}
		    	
		    }else{
		    	 model.addAttribute("tables", tables);
		    }
		   model.addAttribute("tables", tables);
		return "database/database-list";
	}
}
