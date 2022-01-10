import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.File;

public class Lab3Exc	{
	// Main meathod

	public static void main(String args[])	{
		// Intialization of Variables, Scanner obj, ArrayList

		int myInput;
		String prog;
		String info;
		String info2;
		boolean b;
		String[] s;
		String[] ss;
		String loadInfo;
		String delim = " ";
		Scanner key = new Scanner(System.in);
		ArrayList<Student> students = new ArrayList<Student>();

		// Inital Greeting + input

		System.out.println("(1) Enter information of a new student");
		System.out.println("(2) Enter information for a new GraduateStudent");
		System.out.println("(3) Show all student information with program, year, and average grade on separate lines");
		System.out.println("(4) Print the average of the average grades for class and the total number of students.");
		System.out.println("(5) Enter a specific program and show all student information for that program");
		System.out.println("(6) Load student information from an input file.");
		System.out.println("(7) Save all student information to an output file");
		System.out.println("(8) End the program.");
		myInput = key.nextInt();

		// Command Loop for diffrent options + error check

		while (myInput != 8)	{

			// 1st branch correct range 2nd miss input

			if ((myInput >= 1) && (myInput <= 8))	{

				// Option 1

				if (myInput == 1)	{

					// User input for student program

					System.out.println("Enter the program followed by the year (grade optional)");
                                        info = key.nextLine();
                                        info = key.nextLine();
					StringTokenizer size = new StringTokenizer(info);
					int count = size.countTokens();

					if (count == 2)	{
						info = info + " 0.0";
					}

					// Removes extra whitespace

					while(info.contains("  "))	{
						info = info.replaceAll("  ", " ");
					}

					// Splits program, year, and average grade in diffrent indexes in String array

					s = info.split(" ");

					// Creation of student object using constructor to populate members + add student to ArrayList

					Student s1 = new Student(s[0], Integer.parseInt(s[1]), Float.parseFloat(s[2]));
                                        students.add(s1);
				}

				// Option 2

				else if (myInput == 2)	{
					// User input for student program

                                        System.out.println("Enter the program followed by the year (grade optional)");
                                        info = key.nextLine();
                                        info = key.nextLine();

					// This checks if average was entered else 0.0

					StringTokenizer size = new StringTokenizer(info);
                                        int count = size.countTokens();

                                        if (count == 2) {
                                                info = info + " 0.0";
                                        }

                                        // Removes extra whitespace

                                        while(info.contains("  "))      {
                                                info = info.replaceAll("  ", " ");
                                        }

					// This checks size to see if the school was added otherwise assign none

					System.out.println("Now enter the supervisor followed by isPhD (undergraduateschool optional)");
					info2 = key.nextLine();
					StringTokenizer size2 = new StringTokenizer(info2);
                                        int count2 = size2.countTokens();

                                        if (count2 == 2) {
                                                info2 = info2 + " None";
                                        }

                                        // Removes extra whitespace

                                        while(info.contains("  "))      {
                                                info = info.replaceAll("  ", " ");
                                        }


                                        // Removes extra whitespace

                                        while(info.contains("  "))      {
                                                info = info.replaceAll("  ", " ");
                                        }

					while(info2.contains("  "))      {
                                                info2 = info2.replaceAll("  ", " ");
                                        }

                                        // Splits program, year, and average grade in diffrent indexes in String array

                                        s = info.split(" ");

					// Splits supervisor, status, and school

					ss = info2.split(" ");

					// Assign boolean for phd or masters

					if (ss[1].equals("1"))	{
						b = true;
					}
					else	{
						b = false;
					}

                                        // Creation of student object using constructor to populate members + add student to ArrayList

                                        GraduateStudent s1 = new GraduateStudent(s[0], Integer.parseInt(s[1]), Float.parseFloat(s[2]), ss[0], b, ss[2]);

                                      	students.add(s1);

				}

				// Option 3

				else if (myInput == 3)	{

					// Print info for every student

					for (int i = 0; i < students.size(); ++i)	{
						System.out.println(students.get(i));
					}
				}

				// Option 4

				else if (myInput == 4)	{

					// Intialize + find the average of average grade for class for all students

					float avg = 0;

					for (int i = 0; i < students.size(); ++i)	{
						avg += students.get(i).getAvgGrade();
					}

					avg = avg / (float) students.size();
					System.out.println("The average of the grades is " + avg + ". The total number of students is " + students.size() + ".");
	                        }

				// Option 5

				else if (myInput == 5)	{
					// User input for program choice

					System.out.println("Input the program you wish to find the number of students for:");
	                        	prog = key.next();

					// compare and show all info

					for (int i = 0; i < students.size(); ++i)	{
						if (students.get(i).getProg().equalsIgnoreCase(prog))	{
							System.out.println(students.get(i));
						}
					}
				}

				// Option 6

				else if (myInput == 6)	{
					int i = 0;
					int j = 0;

					// Check to see if file is found

					try {
						File f = new File("/home/undergrad/1/irfan/Cis 2430/Lab 3/students.txt");
						Scanner scanner = new Scanner(f);

						// Check to see if file empty

						if (scanner.hasNextLine() == false)	{
							System.out.println("File Empty");
						}

						// go through whole file and populate arraylist

						while (scanner.hasNextLine()) {
		                                        loadInfo = scanner.nextLine();

							StringTokenizer size = new StringTokenizer(loadInfo);
							int count = size.countTokens();

                                        		if (count == 2) {
                                                		loadInfo = loadInfo + " 0.0";
                                        		}

							if (count == 5)	{
								loadInfo = loadInfo + " None";
							}

                                                        s = loadInfo.split(" ");

                                       			// Creation of student object using constructor to populate members + add student to ArrayList

							if (count == 3)	{
								Student s1 = new Student(s[0], Integer.parseInt(s[1]), Float.parseFloat(s[2]));
								students.add(s1);
							}
							else if (count == 6)	{
                                       				GraduateStudent s1 = new GraduateStudent(s[0], Integer.parseInt(s[1]), Float.parseFloat(s[2]), s[3], Boolean.parseBoolean(s[4]), s[5]);
								students.add(s1);
							}
						}
					}
					catch (Exception e) {
						System.out.println("Could not open file.");
					}
				}

				// Option 7

				else if (myInput == 7)	{
					int j = 0;

					//Create a new file

					try {

						// Let user know if they are overriding file

						if (j != 0)	{
							System.out.println("Warning: File about to be overwritten");
						}

						PrintWriter fileWriter = new PrintWriter("SavedStudentInfo.txt", "UTF-8");
						for (int i = 0; i < students.size(); ++i)       {
                		                	fileWriter.println(students.get(i));
		                                }
						fileWriter.close();
						++j;
					}
					catch (Exception e) {
						System.out.println("Failed to write.");
					}

				}

				// Next Greeting until exit

				System.out.println("(1) Enter information of a new student");
				System.out.println("(2) Enter information for a new GraduateStudent");
		                System.out.println("(3) Show all student information with program, year, and average grade on separate lines");
	        	        System.out.println("(4) Print the average of the average grades for class and the total number of students.");
	                	System.out.println("(5) Enter a specific program and show all student information for that program");
	        	        System.out.println("(6) Load student information from an input file.");
                                System.out.println("(7) Save all student information to an output file");
				System.out.println("(8) End the program.");
	                	myInput = key.nextInt();
			}
			else	{

				// Error Message + input

				System.out.println("ERROR TRY AGAIN");
				System.out.println("(1) Enter information of a new student");
				System.out.println("(2) Enter information for a new GraduateStudent");
                                System.out.println("(3) Show all student information with program, year, and average grade on separate lines");
                                System.out.println("(4) Print the average of the average grades for class and the total number of students.");
                                System.out.println("(5) Enter a specific program and show all student information for that program");
				System.out.println("(6) Load student information from an input file.");
		                System.out.println("(7) Save all student information to an output file");
                                System.out.println("(8) End the program.");
                                myInput = key.nextInt();
			}
		}
	}
}
