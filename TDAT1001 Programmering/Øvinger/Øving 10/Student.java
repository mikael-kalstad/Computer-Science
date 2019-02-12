class Student {
	private String navn;
	private int antOppg;

	Student(String navn, int antOppg) {
		this.navn = navn;
		this.antOppg = antOppg;
	}

	public String getNavn() {
		return this.navn;
	}

	public int getAntOppg() {
		return this.antOppg;
	}

	public void okAntOppg(int okning) {
		this.antOppg += okning;
	}

	public String toString() {
		return 
		"Navn: " + getNavn() + " | " +
		"Antall opggaver godkjent: " + getAntOppg() + "\n";
	}

	public static void main(String[] args) {
		// Test klient for Student
		Student testStudent = new Student("Mikael Kalstad", 0);

		if (testStudent.getNavn() == "Mikael Kalstad") {
			System.out.println("Student getNavn() OK");
		} else {
			System.out.println("Student getNavn() FEIL");
		}

		if (testStudent.getAntOppg() == 0) {
			System.out.println("Student getAntOppg() OK");
		} else {
			System.out.println("Student getAntOppg() FEIL");
		}

		//Test for oppgaveroversikt
		Student per = new Student("Per Pernelius", 2);
		Student[] studenter = {new Student("bob bobby", 0), per};
		Oppgaveoversikt testOversikt = new Oppgaveoversikt(studenter);

		testOversikt.nyStudent("per bobby", 3);
		testOversikt.nyStudent("per bob", 6);

		System.out.println(testOversikt);
		testOversikt.okAntOppg(per, 2);
		System.out.println(testOversikt.antallOppgaverStudent(per));
	}
}

class Oppgaveoversikt {
	private Student[] studenter;
	private int antStud = 0;

	Oppgaveoversikt(Student[] studenter) {
		this.studenter = studenter;
 		antStud = studenter.length;
	}

	public int antallStudenter() {
		return this.antStud;
	}

	public int antallOppgaverStudent(Student obj) {
		return obj.getAntOppg();
	}

	public void nyStudent(String studentNavn, int antOppg) {
		Student student = new Student(studentNavn, antOppg);
		Student[] nyStudenter = new Student[studenter.length+1]; 

		for (int i = 0; i < studenter.length; i++) {
			nyStudenter[i] = studenter[i]; 
		}
		nyStudenter[nyStudenter.length-1] = student;
		studenter = nyStudenter;
	}

	public void okAntOppg(Student obj, int okning) {
		obj.okAntOppg(okning);
	}

	public String toString() {
		String msg = "";
		for (int i = 0; i < studenter.length; i++) {
			msg += studenter[i].toString();
		}

		return 
		"Antall studenter: " + antallStudenter() + "\n" + msg;
	}
}
