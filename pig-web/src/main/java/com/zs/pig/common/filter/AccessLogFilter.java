package com.zs.pig.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zs.pig.web.sys.utils.LogUtils;

/**
 * 记录访问日志
 */
public class AccessLogFilter extends BaseFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		LogUtils.logAccess(request);
		chain.doFilter(request, response);
	}

}