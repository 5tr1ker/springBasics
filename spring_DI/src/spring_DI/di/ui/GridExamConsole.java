package spring_DI.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring_DI.di.entity.Exam;

@Component("grid")
public class GridExamConsole implements ExamConsole {
	
	
	private Exam exam;
	
	public GridExamConsole() {
		
	}
	
	@Autowired(required = false)
	public GridExamConsole(@Qualifier("Test1")Exam exam) {
		this.exam = exam;
	}
	
	@Override
	public void print() {
		System.out.println("������������������������������������������");
		System.out.println("��  total  ��   avg   ��");
		System.out.println("������������������������������������������");
		System.out.printf("��   %3d   ��  %3.2f   ��\n",exam.total(),exam.avg());
		System.out.println("������������������������������������������ ");
	}
	
	
	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
	}

}
