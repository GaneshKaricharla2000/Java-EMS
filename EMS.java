import java.lang.*;
import java.util.*;
import java.io.*;

class Details
{
	static int employeeId =201900;
	int  employeePhone;
	double employeeSalary;
	String employeeName;
	String employeeAddress;
	void getDetails()
	{
		System.out.print("This wont print because of overriding");
	}
}
class EmployeeC extends Details
{
	EmployeeC()
	{
		employeeId=employeeId+1;
	}
	void getDetails()
	{
		Scanner sc=new Scanner(System.in);

		System.out.printf("Enter the Name of the Employee");
		employeeName=sc.nextLine();
		System.out.printf("Enter the Salary of the Employee");
		employeeSalary=sc.nextDouble();
		System.out.printf("Enter the Phone of the Employee");
		employeePhone=sc.nextInt();
		System.out.printf("Enter the Address of the Employee(Only City)");
		employeeAddress=sc.next();	
		
		//Newly added employee will be saved into file 
		try{
			File f=new File("NewEmployee.txt");
			f.createNewFile();
			Scanner sf=new  Scanner(f);
			FileWriter fw=new FileWriter(f,true);
			fw.write("\nEmployee ID:"+employeeId);
			fw.write("\nEmployee name ="+employeeName);
			fw.write("\nEmployee Salary:"+employeeSalary);
			fw.write("\nEmployee Phone:"+employeePhone);
			fw.write("\nEmployee Address:"+employeeAddress);
			
			fw.close();
		}
		catch(IOException ie)
		{
			System.out.println("Error");
		}
	}
	void displayDetails()
	{
		System.out.println("\n\n=========================\n\n");
		System.out.printf("EmployeeID         :%d\n",employeeId);		
		System.out.printf("EmployeeName       :%s\n",employeeName);		
		System.out.printf("EmployeeSalary     :%f\n",employeeSalary);		
		System.out.printf("EmployeePhone      :%d\n",employeePhone);	
		System.out.printf("EmployeeAddress    :%s\n\n",employeeAddress);	
	}
}


class EMS
{	
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		EmployeeC E[] = new EmployeeC[15];
		
		E[1] = new EmployeeC();
		E[2] = new EmployeeC();
		E[3] = new EmployeeC();
		E[4] = new EmployeeC();
		E[5] = new EmployeeC();
		E[1].employeeName="Ganesh Karicharla";
		E[2].employeeName="Ramesh Maimerla";
		E[3].employeeName="Karthik Ravula";
		E[4].employeeName="RamaKrishna Sharma";
		E[5].employeeName="Pratyusha";
		
		E[1].employeeSalary=70000.0;
		E[2].employeeSalary=45000.0;
		E[3].employeeSalary=46000.0;
		E[4].employeeSalary=63500.0;
		E[5].employeeSalary=60000.0;
		
		E[1].employeePhone=28568;
		E[2].employeePhone=28567;
		E[3].employeePhone=28744;
		E[4].employeePhone=28774;
		E[5].employeePhone=23335;
		
		E[1].employeeAddress="Andhra";
		E[2].employeeAddress="Karnataka";
		E[3].employeeAddress="Andhra";	
		E[4].employeeAddress="UttarPradesh";	
		E[5].employeeAddress="Punjab";
			
		int Temp;
		System.out.println("1.ADD Employee");
		System.out.println("2.Delete Employee");
		System.out.println("3.Update Employee");
		System.out.println("Select The options");
		Temp=sc.nextInt();
		if(Temp >3 ||Temp <0)
		{
			throw new ArithmeticException("Invalid Input");
		}
		EMS a=new EMS();
		switch(Temp)
		{
			case 1:
			{
				int numEmp;
				System.out.printf("Enter the Number of Employees to add");
				numEmp=sc.nextInt();
				for(int i=6;i<=numEmp+5;i++)
				{
					E[i]=new EmployeeC();
					E[i].getDetails();
				}
				System.out.printf("%d Employees Added",numEmp);
				for(int i=1;i<numEmp+6;i++)
				{
					E[i].displayDetails();
				}
				break;
			}
			case 2:
			{
				for(int i=1;i<=5;i++)
				{
					E[i].displayDetails();
				}
				System.out.printf("\n\n\nEnter the Number You want to Delete---->");
				int temp=sc.nextInt();
				int p=1;
				for(int i=temp;i<5;i++)
				{
					E[i].employeeName=E[(i+1)].employeeName;
					E[i].employeeId=E[(i+1)].employeeId;
					E[i].employeeSalary=E[(i+1)].employeeSalary;
					E[i].employeePhone=E[(i+1)].employeePhone;
					E[i].employeeAddress=E[(i+1)].employeeAddress;
					p=i+1;
				}
				E[p] = null;
				for(int i=1;i<=4;i++)
				{
					E[i].displayDetails();
				}
				break;
			}
			case 3:
			{
				for(int i=1;i<=5;i++)
				{
					E[i].displayDetails();
				}
				System.out.printf("\n\n enter the number you want to update");
				int temp=sc.nextInt();
				E[temp].getDetails();
				System.out.printf("\n\n Values Succesfully Updated \n\n");
				System.out.printf("\nS.no   EmployeeID    EmployeeName            EmployeeSalary    EmployeePhone    EmployeeAddress\n");
				for(int i=1;i<=5;i++)
				{
					E[i].displayDetails();
				}
				break;
			}
		}
	}
}
