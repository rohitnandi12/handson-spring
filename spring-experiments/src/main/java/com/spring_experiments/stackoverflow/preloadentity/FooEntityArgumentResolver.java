package com.spring_experiments.stackoverflow.preloadentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Map;

@Component
public class FooEntityArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private FooService fooService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(PreloadedFoo.class) != null
                && parameter.getParameterType().equals(FooEntity.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory
    ) throws Exception {
        // Extract path variable from the request attributes
        @SuppressWarnings("unchecked")
        Map<String, String> pathVariables = (Map<String, String>) webRequest.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, RequestAttributes.SCOPE_REQUEST);

        String fooIdParam = pathVariables != null ? pathVariables.get("fooId") : null;

        // use getParameter() if you want to pass the fooId as requestParam
        // webRequest.getParameter("requestParam");
        System.out.println(webRequest.getParameter("requestParam"));
        if (fooIdParam != null) {
            Long fooId = Long.parseLong(fooIdParam);
            return fooService.getFooById(fooId);
        }
        throw new IllegalArgumentException("fooId parameter is required");
    }
}
