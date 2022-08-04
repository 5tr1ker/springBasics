package com.study.spring.program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.study.spring.base.MemberVO;
import com.study.spring.conf.appConf;
import com.study.spring.service.deleteid;
import com.study.spring.service.findId;
import com.study.spring.service.idpasswordHelper;
import com.study.spring.service.mainService;

public class program {

	public static void main(String[] args) throws IOException {
		int select = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(appConf.class);
		do {
			System.out.println("안녕하십니까. 작업을 선택해 주세요. 1 . Insert , 2 . View , 3 . Delete , 4 . Exit");
			select = Integer.parseInt(br.readLine());
			switch (select) {
			case 1:
				mainService ms = ctx.getBean("newInsert" , mainService.class);
				idpasswordHelper iph = new idpasswordHelper();
				System.out.println("아이디를 입력해주세요.");
				iph.setUserId(br.readLine());
				System.out.println("비밀번호를 입력해주세요.");
				iph.setUserPw(br.readLine());
				ms.newaccount(iph);
				System.out.println("입력 완료.");
				break;
			case 2:
				findId fi = ctx.getBean("finder" , findId.class);
				System.out.println("탐색할 아이디를 적어주세요.");
				MemberVO mv2 = fi.findIds(br.readLine());
				if(mv2 == null) {
					System.out.println("찾으시는 아이디는 없습니다.");
				} else {
					System.out.printf("아이디 : %s / 비밀번호 : %s", mv2.getUserId() , mv2.getUserPw());
				}
				break;
			case 3:
				deleteid di = ctx.getBean("delID" , deleteid.class);
				System.out.println("삭제할 아이디를 입력해주세요.");
				di.deletedID(br.readLine());
				System.out.println("삭제가 되었습니다.");
				break;
			case 4:
				System.out.println("안농~ :D");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		} while(select != 4);
		ctx.close();
	}
}