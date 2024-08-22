package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVo;


@Controller		//이걸 달고있는것만 조사함(주소가 여기에 있다!라는 의미) (dao나 vo엔 안넣어줌)
public class PhonebookController {	//제어권을 갖고있음 내가 줄게
	
	//필드
	//dao를 메모리에 올린다 (밑에 여러번 쓰이니까 필드로 만듬)
	//private PhonebookDao phonebookDao = new PhonebookDao(); 원래는 이거지만 이건 내가 할게임 스프링의 장점 사용안하는거임
	//@Autowired		// 자동으로 연결해줘 -> dao에 @Repository 넣어주기 (스프링의 장점 사용하기)
	//private PhonebookDao phonebookDao;
	
	@Autowired		// 자동으로 연결해줘 -> Service에 @Service 넣어주기
	private PhonebookService phonebookService;
	
	//생성자
	//메소드gs
	
	
	//메소드일반 //////////////// (메소드 하나 하나 따로 작동 (메소드하나를 나눈게 아님))
	
	
	// ---------------------------------------------------------------------------------
	// http://localhost:8888/phonebook3/list
	/* 리스트 */
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {	//import할때 뭐뜨면 밑에꺼
		System.out.println("PhonebookController.list()");
		
		//dao를 메모리에 올린다 (위에 필드로 만들었음)
		
		//phonebookDao의 메소드를 이용해서 데이터를 가져온다 (vo에 PersonList 만들어놨음)
		//List<PersonVo> personList = phonebookDao.getPersonList();
		//System.out.println(personList);
		
		List<PersonVo> personList = phonebookService.exeGetPerson();
		
		// 한다리 건너서 넣기 (데이터 보내기)
		model.addAttribute("personList", personList);
		
		// 화면 보내기 (포워드) (/WEB-INF/views/  .jsp 는 application 에 만들어놔서 생략해야함)
		return "list";
		
	}
	
	
	// ---------------------------------------------------------------------------------
	// http://localhost:8888/phonebook3/writeform
	/* 등록폼				주소							get 방식			post 방식 */
	@RequestMapping(value="/writeform", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		
		System.out.println("PhonebookController.writeForm()");
				
		return "writeForm";		//포워드(웹에서만 일어나는) -> 대신 return
		
	}
	
	// ---------------------------------------------------------------------------------
	// http://localhost:8888/phonebook3/write?name=~&hp=~&company=~
	/* 등록  보통 이걸 사용 vo로 받을때(파라미터 2개 이상) */
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {//default 생성자가 있어야함(기본생성자) set~생성자도 사용
		System.out.println("PhonebookController.write()");
		
		System.out.println(personVo);
		
		//dao를 메모리에 올린다 (위에 필드로 만들었음)
		
		
		//phonebookDao의 메소드를 이용해서 저장한다
		//int count = phonebookDao.insertPerson(personVo);
		//System.out.println(count);
		
		phonebookService.exeWritePerson(personVo);
		
		//리스트로 리다이렉트(redirect:인터넷주소)
		// "redirect:http://localhost:8888/phonebook3/list" 생략가능
		return "redirect:/list";
		
		
	}
	
	
	/* 등록  파라미터 1개씩 받을때 */
	@RequestMapping(value="/write2", method= {RequestMethod.GET, RequestMethod.POST})
	public String write2(@RequestParam(value="name") String name, 
						@RequestParam(value="hp") String hp, 
						@RequestParam(value="company") String company ) {
		//String name = request.getParameter("name") 이게 여기선 작동하지 않음 (위에 @requestparam~로 표현)
		
		System.out.println("PhonebookController.write2()");
		
		/* 확인차
		System.out.println("name: " + name);
		System.out.println("hp: " + hp );
		System.out.println("company: " +company);
		*/
		
		//Vo 만들고 하기 (오류시 ctrl+shift+o 잊지말기)
		PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		
		return "";
		
	}
	
	// ---------------------------------------------------------------------------------
	// http://localhost:8888/phonebook3/delete?no=~
	/* 삭제 */
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value="no") int no) {// Dispatcher 여기에 담아줘!
		
		System.out.println("PhonebookController.delete()");
		// 확인차 System.out.println(no);
		
		//dao를 메모리에 올린다 (위에 필드로 만들었음)
		
		//phonebookDao의 메소드를 이용해서 데이터를 삭제한다
		//int count = phonebookDao.deletePerson(no);
		
		phonebookService.exeDeletePerson(no);
		
		//리스트로 리다이렉트(redirect:인터넷주소)
		return "redirect:/list";
		
	}
	
	// ---------------------------------------------------------------------------------
	// http://localhost:8888/phonebook3/editform?no=~
	/* 수정폼 */
	@RequestMapping(value="/editform", method= {RequestMethod.GET, RequestMethod.POST})
	public String editForm(@RequestParam(value="no") int no, Model model ) {
		
		System.out.println("PhonebookController.editForm()");
		System.out.println(no);
		
		//PersonVo personVo = phonebookDao.getPersonOne(no);
		//System.out.println(personVo);
		
		PersonVo personVo = phonebookService.exeEditForm(no);
		
		model.addAttribute("personVo", personVo);
		
		// 화면 보내기 (포워드) (/WEB-INF/views/  .jsp 는 application 에 만들어놔서 생략해야함)
		return "editForm";
		
	}
	
	
	// http://localhost:8888/phonebook3/editform2?no=~
	/* 수정폼2 DB에서 MAP으로 데이터 보내줌 */
	@RequestMapping(value="/editform2", method= {RequestMethod.GET, RequestMethod.POST})
	public String editForm2(@RequestParam("no") int no, Model model) {
		System.out.println("PhonebookController.editForm2()");
		//System.out.println(no);
		
		Map<String, Object> personMap = phonebookService.exeEditForm2(no);
		//System.out.println(personMap);
		
		model.addAttribute("personMap", personMap);
		
		return "editForm2";
	}
	
	
	
	

	// ---------------------------------------------------------------------------------
	// http://localhost:8888/phonebook3/edit 확인이 안됨 그냥 하는 행동
	/* 수정 */
	@RequestMapping(value="/edit", method= {RequestMethod.GET, RequestMethod.POST})
	public String edit(@ModelAttribute PersonVo personVo) {
		
		System.out.println("PhonebookController.edit()");
		
		//dao를 메모리에 올린다 (위에 필드로 만들었음)
		
		System.out.println(personVo);
		
		//phonebookDao의 메소드를 이용해서 저장한다
		//int count = phonebookDao.updatePerson(personVo);
		//System.out.println(count);
		
		phonebookService.exeEditPerson(personVo);
		
		//리스트로 리다이렉트(redirect:인터넷주소)
		return "redirect:/list";
		
		
	}
	

	
}
	

