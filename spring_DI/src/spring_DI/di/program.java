package spring_DI.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring_DI.di.ui.ExamConsole;

public class program {

	public static void main(String[] args) {
		
		/* �� �ڵ带 ���������� ���� (setting.xml)
		Exam exam = new NewlecExam();
		ExamConsole console = new InlineExamConsole(exam); ������ DI
		ExamConsole console = new GridExamConsole(exam);
		
		console.print();
		*/
		
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring_DI/di/setting.xml");  XML ���ü� �б�
		ApplicationContext context = new AnnotationConfigApplicationContext(NewlecDIConfig.class);
		
		ExamConsole console = (ExamConsole)context.getBean("grid");
		// ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
	}

}