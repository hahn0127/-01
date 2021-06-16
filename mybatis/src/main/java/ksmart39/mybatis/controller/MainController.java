package ksmart39.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	/**
	 * PSA(Portable Service Abstraction): 환경의 변화와 관계없이 일관된 방식의 기술접근환경을 제공하려는 추상화 구조 
	 * 
	 * Service Abstraction(서비스의 추상화)
	 * ex) spring 으로  servlet Application 을 만들고 있지마 servlet 코드를 기술하지않음
	 * -대신 annotation을 기술한다 
	 * Dynamic Web project : model 12(MVC) 구현시 httpSerlvet 상속 클래스에서 Http Request 처리 --->? web.xml
	 * spring에서 매핑 작없없이 Annotation 만으로 서블릿 구현
	 *
	 *Portable (코드를 건들지 않고 다른 기술로 바꿀수있음)
	 *ex) 톰캣, 제티, 네티, 언더토우와 같은 아예 다른 기술 Stack 을 소스코드 변경이 거의없이 개발가능
	 *
	 *
	 *@Controller 안에 Mapping Annotation(@GetMapping, @PostMapping etc)
	 *Mapping Annotation은  name, value, path, parmas, headers 등의 속성
	 *1. 요청에 대한 정보를 보유 -> Handler Mapping 을 통해 해당 컨트롤러 선택
	 *2. 이에 맵핑된는 요청일때만 해당 메소드가 처리 : Handler Adapter
	 *3. 해당  메서드는 view name 반환
	 *4. View Resolver("resources/templates/"+{view name}+"html"} 사용자가 요청한것에대한
	 *		응답 view 랜더링하는 역할
	 *
	 *5. 해당뷰 템플릿에서 전달된 model 속 객체 사용가능
	 *
	 */

	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView main(Model model) {
		//model.addAttribute("title","ksmart39 mybatis");
		ModelAndView mav = new ModelAndView();
		mav.addObject("title","ksmart39 mybatis");
		mav.setViewName("main");
		return mav;
	}
}
