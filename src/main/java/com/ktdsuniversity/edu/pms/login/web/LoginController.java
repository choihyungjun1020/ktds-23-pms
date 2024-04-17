package com.ktdsuniversity.edu.pms.login.web;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import org.springframework.ui.Model;

import com.ktdsuniversity.edu.pms.employee.vo.EmployeeVO;
import com.ktdsuniversity.edu.pms.login.service.LoginLogService;
import com.ktdsuniversity.edu.pms.utils.AjaxResponse;
import com.ktdsuniversity.edu.pms.utils.SessionUtil;
import com.ktdsuniversity.edu.pms.utils.Validator;
import com.ktdsuniversity.edu.pms.utils.Validator.Type;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginLogService loginLogService;

	@GetMapping("/employee/login")
	public String viewLoginPage() {
		return "login/login";
	}

	@GetMapping("/main/mainpage")
	public String viewMainPage(HttpSession session, Model model) {

		EmployeeVO employeeVO = (EmployeeVO) session.getAttribute("_LOGIN_USER_");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime pwdCnDt = LocalDateTime.parse(employeeVO.getPwdCnDt(), formatter);


		if (currentDate.compareTo(pwdCnDt.plusDays(90)) >= 0) {
			model.addAttribute("pwdMessage", "비밀번호를 변경한지 90일이 지났습니다. 비밀번호를 변경해주세요.");
			System.out.println("------------------------" + pwdCnDt);
		}
		return "main/mainpage";
	}

	@ResponseBody
	@PostMapping("/ajax/employee/login")
	public AjaxResponse doLogin(HttpSession session, EmployeeVO employeeVO,
								@RequestParam(defaultValue = "/main/mainpage") String nextUrl,
								Model model) {

		Validator<EmployeeVO> validator = new Validator<>(employeeVO);

		validator.add("empId", Type.NOT_EMPTY, "사원번호를 입력해 주세요.")
				.add("empId", Type.EMPID, "사원번호 형식으로 입력해 주세요.")
				.add("pwd", Type.NOT_EMPTY, "비밀번호를 입력해주세요.").start();

		if (validator.hasErrors()) {
			Map<String, List<String>> errors = validator.getErrors();
			return new AjaxResponse().append("errors", errors);
		}

		EmployeeVO employee = this.loginLogService.getOneEmployeeByEmpIdAndPwd(employeeVO);

		// 퇴사, 휴직 상태에 따른 로그인 제한 기능
		String loginCheck = employee.getWorkSts();
		if (loginCheck.equals("202")) {
			return new AjaxResponse().append("errorRestDt", "휴직 중인 사원입니다." + "휴직기간 : " + employee.getRestStDt() + " ~ " + employee.getRestEndDt());
		} else if (loginCheck.equals("204")) {
			return new AjaxResponse().append("errorEndDt", "퇴사한 사원입니다." + "퇴사일 : " + employee.getEndDt());
		}
		
		

		
//		if (employee.getLgnTry() > 5) {
//			return new AjaxResponse().append("errorCountFive", "5번 실패하였습니다 60분 이후에 시도해주세요.");
//		}else {
			if (!SessionUtil.wasLoginEmployee(employee.getEmpId())){
				session.setAttribute("_LOGIN_USER_", employee);
				session.setMaxInactiveInterval(20 * 60);
				SessionUtil.addSession(employee.getEmpId(), session);
				
				// 로그인 성공시 LGNYN을 Y로 변경
				employee = this.loginLogService.getOneEmpIdUseOtherPlace(employeeVO);
				return new AjaxResponse().append("next", nextUrl);
			}
			else {
				return new AjaxResponse().append("errorUseNow", "이미 로그인중인 사원번호입니다.");
			}
		}
		
		
		
		// 로그인 할때 lgnYN이 N일 경우 로그인 진행

		
	

		
//		if (!SessionUtil.wasLoginEmployee(employee.getEmpId()) && employee.getLgnTry() <= 5) {
////		if (employee.getLgnYn().equals("N")) {
//			session.setAttribute("_LOGIN_USER_", employee);
//			session.setMaxInactiveInterval(20 * 60);
//			SessionUtil.addSession(employee.getEmpId(), session);
//
//			// 로그인 성공시 LGNYN을 Y로 변경
//			employee = this.loginLogService.getOneEmpIdUseOtherPlace(employeeVO);
//			return new AjaxResponse().append("next", nextUrl);
//
//		}
		
			
		
		
//		else if(SessionUtil.wasLoginEmployee(employee.getEmpId())) {// 아닐경우 오류 발생
//		}
//		else if(employee.getLgnTry() > 5) {// 아닐경우 오류 발생
//			return new AjaxResponse().append("errorCountFive", "5번 실패하였습니다 60분 이후에 시도해주세요.");
//		}
//		else {
//			return new AjaxResponse().append("next", nextUrl);
//		}
	
	
	
	


	@GetMapping("/employee/logout")
	public String doLogout(HttpSession session, @SessionAttribute("_LOGIN_USER_") EmployeeVO employeeVO) {

		this.loginLogService.getOneEmpIdNotUseNow(employeeVO);
		this.loginLogService.updateEmpLogout(employeeVO);
		SessionUtil.removeSession(employeeVO.getEmpId());

		session.invalidate();

		return "redirect:/employee/login";
	}

}
