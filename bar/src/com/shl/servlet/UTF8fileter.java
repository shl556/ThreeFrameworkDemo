package com.shl.servlet;
import java.io.IOException;  
	  
	import javax.servlet.Filter;  
	import javax.servlet.FilterChain;  
	import javax.servlet.FilterConfig;  
	import javax.servlet.ServletException;  
	import javax.servlet.ServletRequest;  
	import javax.servlet.ServletResponse;  
public class UTF8fileter implements Filter{  
	  
	    protected FilterConfig filterConfig;  
	    protected String encoding;  
	    protected boolean enable;  
	  
	    @Override  
	    public void destroy() {  
	       this.encoding=null;
	       this.enable=false;
	          
	    }  
	  
//	    public UTF8fileter() {  
//	        this.encodingName="gb2312";  
//	        this.enable=false;  
//	    }  
	  
	    @Override  
	    public void doFilter(ServletRequest request, ServletResponse response,  
	            FilterChain chain) throws IOException, ServletException {  
	        if(this.enable){  
	            request.setCharacterEncoding(this.encoding);  
	        }  
	        chain.doFilter(request,response);  
	    }  
	  
	    @Override  
	    public void init(FilterConfig filterConfig) throws ServletException {  
	        this.filterConfig=filterConfig;  
	        this.encoding=this.filterConfig.getInitParameter("encoding");  
	        String strIgnoreFlag=this.filterConfig.getInitParameter("enable");  
	        if(strIgnoreFlag.equalsIgnoreCase("true")){  
	            this.enable=true;  
	        }else{  
	            this.enable=false;  
	        }   
	    }  
	}  