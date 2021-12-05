import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList 
{
	public static void main(String[] args)
	{

//		Check arguments
		if (args.length!=1 )
		 {
			System.out.println("No argument passed , please enter a | r | c | ? | +");
		 }
		else if(args[0].equals("a"))
		 {
			System.out.println("Loading data ...");			
			try
			 {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String Linereader = reader.readLine();
				String Names[] = Linereader.split(",");			
				for(String name : Names)
				 { 
					 System.out.println(name);
				 }
			} catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try
			 {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String Linereader = reader.readLine();
				String Names[] = Linereader.split(",");	
				Random random_number = new Random();
				int size=Names.length;
				int index =Math.abs(random_number.nextInt()%size) ;
				System.out.println(Names[index]);
			} catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+"))
		{
			System.out.println("Loading data ...");			
			try 
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt", true));
				String t = args[0].substring(1);
	        	Date date = new Date();
	        	String date_time = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(date_time);
	        	String dateformate= dateFormat.format(date);
				writer.write(", "+t+"\nList last updated on "+dateformate);
				writer.close();
			} catch (Exception e)
			{

			}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try 
			{
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String Linereader = reader.readLine();
				String Names[] = Linereader.split(", ");	
				boolean done = false;
				String argument = args[0].substring(1);
				for(int index = 0; index<Names.length && !done; index++)
				 {
					if(Names[index].equals(argument)) 
					{
						System.out.println("We found it!");
						done=true;
					}
				 }
			} catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try
			 {
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
				String Linereader = reader.readLine();
				char Words[] = Linereader.toCharArray();			
				boolean in_word = false;
				int count=0;
				for(char character:Words)
				 {
					if(character ==' ') 
					{
						if (!in_word) 
						{
							count++; in_word =true;	
						}
						else 
						{ 
							in_word=false;
						}			
					}
			}
			System.out.println(count +" word(s) found " + Words.length);
			} catch (Exception e)
			{

			} 
			System.out.println("Data Loaded.");	 			
		}
		
		else
		{
			System.out.println("Wrong argument passed , please enter a | r | c | ? | +");
		}
	}
}
