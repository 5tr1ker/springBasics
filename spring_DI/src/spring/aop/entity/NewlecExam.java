package spring.aop.entity;

public class NewlecExam implements Exam {

	
	private int kor;
	private int eng;
	private int math;
	private int com;
	
	
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
		// long start = System.currentTimeMillis();
		
		int result = kor+eng+math+com;
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// throw new IllegalArgumentException("예외 테스트");
		
		// long end = System.currentTimeMillis();
		
		// String message = (end - start) + "시간만큼 걸렸습니다.";
		// System.out.println(message);
		
		return result;
	}

	@Override
	public float avg() {
		float result = total() / 4.0f;
		return result;
	}

}
