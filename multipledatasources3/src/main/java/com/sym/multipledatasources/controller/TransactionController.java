package com.sym.multipledatasources.controller;

import java.util.UUID;

import com.sym.multipledatasources.service.ServiceComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sym.multipledatasources.bean.TeachersBean;
import com.sym.multipledatasources.bean.TestBean;
import com.sym.multipledatasources.service.TransactionService1;
import com.sym.multipledatasources.service.TransactionService2;

/**
 * 多数据源事务测试 配置上jta-atomikos 之后事务变得正常 无论是test、test2还是test3，两个对象都是存不进去的
 * 
 * @author acer
 *
 */
@RestController
public class TransactionController {
	@Autowired
	private TransactionService1 ts1;
	@Autowired
	private TransactionService2 ts2;

	@Autowired
	private ServiceComponent serviceComponent;

	@RequestMapping("/savetest.do")
	public String savetest() {
		TestBean tb = new TestBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setScore(70);
		tb.setClassid("1");
		tb.setUserid("a");
		ts1.savetestBean(tb);
		return "success";
	}

	@RequestMapping("/saveteacher.do")
	public String saveteacher() {
		TeachersBean tb = new TeachersBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setTeachername("王老师");
		tb.setClassid("1");
		ts2.saveTeacher(tb);
		return "success";
	}

	// ########################开始事务测试##########################

	@RequestMapping("/test.do")
	public String test() {
		TestBean tb = new TestBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setScore(70);
		tb.setClassid("1");
		tb.setUserid("a");
		ts1.savetestBean2(tb);
		return "success";
	}

	@RequestMapping("/test2.do")
	public String test2() {
		TestBean tb = new TestBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setScore(70);
		tb.setClassid("1");
		tb.setUserid("a");
		ts1.savetestBean3(tb);
		return "success";
	}

	@RequestMapping("/test3.do")
	public String test3() {
		TestBean tb = new TestBean();
		tb.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		tb.setScore(70);
		tb.setClassid("1");
		tb.setUserid("a");
		ts1.savetestBean4(tb);
		return "success";
	}

	@RequestMapping("/doSomething")
	public String doSomething(){
		serviceComponent.doSomething();
		return "success";
	}

	/**
	 * XA实现 spring多数据源事务问题
	 * @return
	 */
	@RequestMapping("/XATransationTest")
	public String XATransationTest(){
		serviceComponent.XATransationTest();
		return "success";
	}


}
