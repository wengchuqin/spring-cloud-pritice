package top.chuqin.cloud.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


public class AccessFilter extends ZuulFilter {
    public static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        LOGGER.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        String accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            LOGGER.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
        } else if ("wengchuqin".equals(accessToken)) {
            LOGGER.info("access token is ok");
        } else {
            LOGGER.warn("access token is wrong");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
        }

        return null;
    }
}
