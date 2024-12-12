package umc7.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc7.spring.validation.annotation.CheckPage;

@RequiredArgsConstructor
@Component
public class CheckPageArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //디버그용 출력
        System.out.println("supportsParameter");
        return parameter.hasParameterAnnotation(CheckPage.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  org.springframework.web.bind.support.WebDataBinderFactory binderFactory) throws Exception {
        //디버그용 출력
        System.out.println("resolveArgument");

        String pageParam = String.valueOf(webRequest);
        if (pageParam != null) {
            try {
                int page = Integer.parseInt(pageParam);
                return page - 1; // page 값을 -1로 변경
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid page parameter");
            }
        }
        return null; // 파라미터가 없을 경우 null 반환
    }
}


