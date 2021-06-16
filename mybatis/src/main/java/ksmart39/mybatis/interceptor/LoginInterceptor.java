package ksmart39.mybatis.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		String  sessionId = (String)session.getAttribute("SID");//SID로그인 할때 setAttribute로했기때문에 getAttribute메서드를 통해 SID값을 가지고온다
		String  sessionLevel = (String) session.getAttribute("SLEVEL");
		if(sessionId == null) {
			response.sendRedirect("/login");
			return false; //루프가걸리니까 false로해주기
			
		} /* 상품 등록, 상품리스트 까지 만들고 합시당.
			 * else { //1.세션 회원레벨을 가지고오기 (sessionLevel !==1){
			 * response.sendRedirect("/login");
			 * 
			 * } //2. request.getRequestURI() == "memberList" 관리자라를 제외한 나머지 등급 은
			 * response.sendRedirect("/login"); }
			 */
		
		return HandlerInterceptor.super.preHandle(request, response, handler);//controller 가는 true
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
