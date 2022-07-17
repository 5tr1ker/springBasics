package spring_DI.di.ui;

import spring_DI.di.entity.Exam;

public class InlineExamConsole implements ExamConsole {

	private Exam exam;
	
	public InlineExamConsole() {
		// TODO Auto-generated constructor stub
	}
	
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf("total is %d , avg is %.2f \n" , exam.total() , exam.avg());
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
