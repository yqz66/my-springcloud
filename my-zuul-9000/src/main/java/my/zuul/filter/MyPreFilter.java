package my.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * 实现自定义过滤器
 * Created by JingCai-Java on 2018/7/26.
 */
public class MyPreFilter extends ZuulFilter {

    /**
     *  指定过滤器类型
     *  zuul 一共有 4 种过滤器类型，分别是:
     public static final String ERROR_TYPE = "error";  // 发生错误时执行
     public static final String POST_TYPE = "post";    // 请求执行完成后执行，不管是中间出现错误，还是正确返回最终都会执行这个过滤器
     public static final String PRE_TYPE = "pre";      // 路由转发前执行
     public static final String ROUTE_TYPE = "route";  // 路由转发时执行
     *
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 过滤器启动级别，越小启动级别越高
     * @return
     */
    @Override
    public int filterOrder() {
        return -100;
    }

    /**
     * 是否启用过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        //获取同步请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();

        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        return null;
    }
}
