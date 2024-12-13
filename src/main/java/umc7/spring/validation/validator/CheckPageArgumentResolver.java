package umc7.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc7.spring.apiPayload.code.status.ErrorStatus;
import umc7.spring.apiPayload.exception.handler.PageHandler;
import umc7.spring.validation.annotation.CheckPage;

@RequiredArgsConstructor
@Component
public class CheckPageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //디버그용 출력
        System.out.println("supportsParameter");
        return parameter.hasParameterAnnotation(CheckPage.class)&&
                parameter.getParameterType().equals(Integer.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  org.springframework.web.bind.support.WebDataBinderFactory binderFactory) throws Exception {
        //디버그용 출력
        System.out.println("resolveArgument");

        String pageParam = webRequest.getParameter("page");
        if (pageParam == null || pageParam.isEmpty()) {
            throw new PageHandler(ErrorStatus.INVALID_PAGE_NUMBER); //입력값이 없으면 에러
        }

        int page = Integer.parseInt(pageParam);
        if (page < 1) {
            throw new PageHandler(ErrorStatus.INVALID_PAGE_NUMBER); // 1보다 작은 경우 에러
        }

        return page - 1;
    }
}


