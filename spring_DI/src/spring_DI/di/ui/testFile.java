package spring_DI.di.ui;

import spring_DI.di.entity.Exam;

public class testFile implements ExamConsole {

	private Exam exam;
	private int a;
	@Override
	public void print() {
		System.out.printf("자 통합 점수는 %d 이고 평균은 %f 귀여운 숫자 : %d" , exam.total(), exam.avg() , a);
	}
	
	public testFile(Exam exam) {
		this.exam = exam;
	}
	
	public void setData(int a) {
		this.a = a;
	}
	
	public testFile() {
		
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	
}
