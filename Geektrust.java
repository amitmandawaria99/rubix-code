import java.io.*;
import java.util.*;
class Pair<U, V>{
	public final U first;
	public final V second;

	public Pair(U first, V second){
	this.first = first;
	this.second = second;
	}
	public static <U, V> Pair <U, V> of(U a, V b){
	return new Pair<>(a, b);
	}
}
public class Geektrust{

public static void main(String[] args) {
	String filePath = args[0];
	try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
	{
		  Set<Pair<Integer,Integer>> hash_Set = new HashSet<Pair<Integer,Integer>>();
		  Integer lineno = 1;
		  Integer r1=0,r2=0;
		for(String line; (line = br.readLine()) != null;) {
			//process each line from the input file
			if(lineno==1)
			{
				for (Integer i = 0; i < line.length(); i+=5) 
				{
					Integer x = Character.getNumericValue( line.charAt(i));
					Integer y = Character.getNumericValue( line.charAt(i+2));
					hash_Set.add(Pair.of(x,y));
		        }
			}
			else 
			{
				if(line.charAt(4) == '1')
				{
					Integer x1 = Character.getNumericValue(line.charAt(6)),y1= Character.getNumericValue(line.charAt(8));
					Character dir = line.charAt(10);
					if(!hash_Set.contains(Pair.of(x1,y1)))
						r1++;
					for (Integer i = 12; i < line.length(); i++) 
					{
					   if(line.charAt(i)=='L')
					   {
						   if(dir=='E') 
							   dir = 'N';
						   else if(dir=='W')
							   dir = 'S';
						   else if(dir=='N')
							   dir = 'W';
						   else
							   dir = 'E';
					   }
					   else if(line.charAt(i)=='R')
					   {
						   if(dir=='E') 
							   dir = 'S';
						   else if(dir=='W')
							   dir = 'N';
						   else if(dir=='N')
							   dir = 'E';
						   else
							   dir = 'W';
					   }
					   else
					   {
						   if(dir=='E') 
						   {
							   if(y1<6)
								   y1++;
						   }
						   else if(dir=='W')
						   {
							   if(y1>0)
								   y1--;
						   }
						   else if(dir=='N')
						   {
							   if(x1<6)
								   x1++;
						   }
						   else
						   {
							   if(x1>0)
								   x1--;
						   }
					   }
					   
					   if(!hash_Set.contains(Pair.of(x1,y1)))
							r1++;
			        }
					
					System.out.println("Robo1 " + x1 + " " + y1 + " " + dir + " " + r1);
				}
				else
				{
					Integer x1 = Character.getNumericValue(line.charAt(6)),y1= Character.getNumericValue(line.charAt(8));
					Character dir = line.charAt(10);
					if(!hash_Set.contains(Pair.of(x1,y1)))
						r2++;
					for (Integer i = 12; i < line.length(); i++) 
					{
					   if(line.charAt(i)=='L')
					   {
						   if(dir=='E') 
							   dir = 'N';
						   else if(dir=='W')
							   dir = 'S';
						   else if(dir=='N')
							   dir = 'W';
						   else
							   dir = 'E';
					   }
					   else if(line.charAt(i)=='R')
					   {
						   if(dir=='E') 
							   dir = 'S';
						   else if(dir=='W')
							   dir = 'N';
						   else if(dir=='N')
							   dir = 'E';
						   else
							   dir = 'W';
					   }
					   else
					   {
						   if(dir=='E') 
						   {
							   if(y1<6)
								   y1++;
						   }
						   else if(dir=='W')
						   {
							   if(y1>0)
								   y1--;
						   }
						   else if(dir=='N')
						   {
							   if(x1<6)
								   x1++;
						   }
						   else
						   {
							   if(x1>0)
								   x1--;
						   }
					   }
					   
					   if(!hash_Set.contains(Pair.of(x1,y1)))
							r2++;
			        }
					System.out.println("Robo2 " + x1 + " " + y1 + " " + dir + " " + r1);
				}
			}
			lineno++;
		}
		if(r1==r2)
		{
			System.out.println("TIE");
		}
		else if(r1 > r2)
		{
			System.out.println("Robo1 WINS");
		}
		else
			System.out.println("Robo2 WINS");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}
	}
}
