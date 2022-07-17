package spring_DI.di.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("data01")
public class NewlecExam implements Exam {

	//@Value("20")
	private int kor;
	//@Value("50")
	private int eng;
	//@Value("40")
	private int math;
	//@Value("80")
	private int com;
	
	public void init() {
		System.out.println("시작!");
	}
	public void dest() {
		System.out.println("FUCK! YOU!");
	}
	
	public NewlecExam(int kor, int eng, int math, int com) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}
	
	public NewlecExam() {
		
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {
		return kor+eng+math+com;
	}

	@Override
	public float avg() {
		return total() / 4.0f;
	}

}
