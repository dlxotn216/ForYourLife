package com.taesu.fyl.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/**
 * Created by dlxot on 2016-12-20.
 */

@Component
@Slf4j
public class RequestBodyPrintFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        printRequestLog(httpServletRequest);

        HttpRequestWrapper requestWrapper = new HttpRequestWrapper(httpServletRequest);
//        String body = IOUtils.toString(requestWrapper.getInputStream());
//        printRequestBody(body);

        filterChain.doFilter(requestWrapper, servletResponse);
    }

    private void printRequestBody(String body) {
        if (StringUtils.isNotBlank(body)) {
            log.info("[BODY] \n {}", body);
        }
    }

    @Override
    public void destroy() {

    }

    class HttpRequestWrapper extends HttpServletRequestWrapper {

        private byte[] bodyData;

        public HttpRequestWrapper(HttpServletRequest request) throws IOException {
            super(request);
            InputStream is = super.getInputStream();
        }

        @Override
        public ServletInputStream getInputStream() throws IOException {
            final ByteArrayInputStream bis = new ByteArrayInputStream(bodyData);
            return new ServletImpl(bis);
        }
    }

    class ServletImpl extends ServletInputStream {

        private InputStream is;

        public ServletImpl(InputStream bis) {
            is = bis;
        }

        @Override
        public int read() throws IOException {
            return is.read();
        }

        @Override
        public int read(byte[] bytes) throws IOException {
            return is.read(bytes);
        }

        @Override
        public boolean isFinished() {
            return false;
        }

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setReadListener(ReadListener readListener) {

        }
    }


    /**
     * Request 로그 출력 함수
     *
     * @param request 요청 정보
     */
    private void printRequestLog(HttpServletRequest request) {
        try {
            StringBuffer sb = new StringBuffer();
            sb.append("[" + request.getMethod() + "]");
            sb.append("_IP_[" + request.getRemoteAddr() + "]");
            sb.append("_REQURL_[" + request.getRequestURI() + "]");
            sb.append("_PARAM_[");

            // parameter
            Enumeration<?> eNames = request.getParameterNames();
            while (eNames.hasMoreElements()) {
                String name = (String) eNames.nextElement();
                String[] values = request.getParameterValues(name);
                String paramIngo = "[" + name + " : ";
                for (int x = 0; x < values.length; x++) {
                    if (x == 0) {
                        paramIngo += values[x];
                    } else {
                        paramIngo += ", " + values[x];
                    }
                }

                if (!StringUtils.isEmpty((name))) {
                    if (name.equals("passWd")) {
                        paramIngo = "[password : xxxx ]";
                    } else {
                        paramIngo += "]";

                    }
                }

                if (eNames.hasMoreElements()) {
                    sb.append(paramIngo + ",");
                } else {
                    sb.append(paramIngo);
                }
            }
            sb.append("]");
            log.info("{}", sb);
        } catch (Exception e) {

        }
    }
}