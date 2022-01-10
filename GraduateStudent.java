public class GraduateStudent extends Student    {
	// Intialize all memebers

        private String supervisor;
        private boolean isPhD;
        private String undergraduateSchool;

	// Constructor to poulate members

	GraduateStudent(String program, int year, float averageGrade, String supervisor, boolean isPhD, String undergraduateSchool)   {
                super(program, year, averageGrade);
		this.supervisor = supervisor;
                this.isPhD = isPhD;
                this.undergraduateSchool = undergraduateSchool;
        }

	// May not need but this can be used to intialize induvisual memebers without a constortor

        public void setSup(String newSup)  {
                this.supervisor = newSup;
        }

        public void setPhD(boolean newisPhD)        {
                this.isPhD = newisPhD;
        }

        public void setund(String newUndergraduateSchool)   {
                this.undergraduateSchool = newUndergraduateSchool;
        }

	public String getSup() {
                return supervisor;
        }

        public String getPhD()    {
                if (isPhD == true)	{
			return "PhD";
		}
		else	{
			return "Masters";
        	}
	}

        public String getund()      {
                return undergraduateSchool;
        }

	@Override
        public String toString()        {
                return ("Program: " + getProg() + "\nYear: " + getYear() + "\nAverage Grade: " + getAvgGrade() + "\nSupervisor: " + getSup() + "\nPhD/Masters: " + getPhD() + "\nUndergraduate School: " + getund() + ".\n");
        }
}

