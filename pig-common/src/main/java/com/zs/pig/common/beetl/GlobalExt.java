package com.zs.pig.common.beetl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.ext.web.WebRenderExt;

import com.zs.pig.common.constant.ZsCatConstant;

public class GlobalExt implements WebRenderExt{

        static long version = System.currentTimeMillis();
        @Override
        public void modify(Template template, GroupTemplate arg1, HttpServletRequest arg2, HttpServletResponse arg3) {
                //js,css 的版本编号
                template.binding("sysVersion",version);
                template.binding("imgServer", ZsCatConstant.IMGSERVER);
        }

}