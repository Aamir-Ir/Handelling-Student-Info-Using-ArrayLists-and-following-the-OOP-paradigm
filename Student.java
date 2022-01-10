public class Student	{
	// Intialize all memebers

	private String program;
	private int year;
	private float averageGrade;

	// Constructor to poulate members

	Student(String program, int year, float averageGrade)	{
		this.program = program;
		this.year = year;
		this.averageGrade = averageGrade;
	}

	// May not need but this can be used to intialize induvisula memebers without a constortor

	public void setProg(String newProgram)	{
		this.program = newProgram;
	}

	public void setYear(int newYear)	{
		this.year = newYear;
	}

	public void setAvgGrg(float newGrade)	{
		this.averageGrade = newGrade;
	}

	// Meathod to Return induvisual memebers

	public String getProg()	{
		return program;
	}

	public int getYear()	{
		return year;
	}

	public float getAvgGrade()	{
		return averageGrade;
	}

	// Meathod for output

	public String toString()	{
		return ("Program: " + this.getProg() + "\nYear: " + this.getYear() + "\nAverage Grade: " + this.getAvgGrade() + "\n");
	}
}
