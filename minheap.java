import java.util.Scanner;
public class minheap 
{
 int i = 0, j = 0;
 String a;
 int height = 0;
 int temp;
 int newvalue, deletevalue;
 int[] min = new int[100];
 Scanner sc = new Scanner(System.in);
 // taking input from user 
 void input() 
{
   System.out.println("-------------------------------------------------------");
   System.out.println("enter the Min heap :-");
   //taken a whole line as a input  \s to remve blank space
   a = sc.nextLine().replaceAll("\\s{2,}", " ").trim();
   //split string into array of string on the basis of blank space 
   String[] aa = a.split(" ");
   //convert array of string into array of integer 
   try 
   {
    for (i = 0; i < aa.length; i++) 
	{
     min[i] = Integer.parseInt(aa[i]);
     j++; //j++ is used to store the length of  array 
    }
   } 
   catch (Exception e) 
   {
    System.out.println("enter integer only like 1 2 3 3 ");
   }
   System.out.println("ending input Phase");
   System.out.println("-------------------------------------------------------");
}
  //validate min heap
 void validate() 
{
   int flag = 0;
   System.out.println("-------------------------------------------------------");
   System.out.println("into validate Phase");
   height = ((int)(j - 1)) / 2;
   for (int i = 0; i < height; i++)
    {
    //((2*i+1)<=j )  check availability of left child 
    //((2*i+2)<=j )  check availability of right child 
    if (((2 * i + 1) <= j) && (min[i] <= min[2 * i + 1]) && ((2 * i + 2) <= j) && (min[i] <= min[2 * i + 2]))
	{
     System.out.println("valid " + i);
    } 
	else 
	{
     System.out.println("invalid " + i);
     flag = 1;
    }
   }
   if (flag == 1) 
   {
    System.out.println("validation is failed");
   } 
   else 
   {
    System.out.println("validating is correct");
   }
   System.out.println("-------------------------------------------------------");
}
  // correcting invalid heap
 void validating() 
{
   System.out.println("-------------------------------------------------------");
   System.out.println("into validating Phase ");
   for (i = j - 1; i > 0; i--) 
   {
    if (min[i] < min[(i - 1) / 2]) 
	 {
     //swaping the element 
     temp = min[i];
     min[i] = min[(i - 1) / 2];
     min[(i - 1) / 2] = temp;
     }
   }
   System.out.println("Ending validating Phase");
   System.out.println("-------------------------------------------------------");
  }
  //printng min heap
void printheap() 
{
   System.out.println("-------------------------------------------------------");
   System.out.println("Printing the min heap ");
   System.out.println("-------------------------------------------------------");
   for (i = 0; i < j; i++)
    System.out.print("  " + min[i]);
   System.out.println("\n-------------------------------------------------------");
}
  //inserting an element into heap
void inputheap() 
{
   System.out.println("-------------------------------------------------------");
   System.out.println("Enter integer value ");
   newvalue = sc.nextInt();
   min[j] = newvalue;
   j++;
   System.out.println("-------------------------------------------------------");
}
  //deleting the element from heap
 void delete() 
{
  int pos = 0;
  System.out.println("-------------------------------------------------------");
  System.out.println("Enter the element to delete");
  deletevalue = sc.nextInt();
  //search element position in array
  for (i = 0; i < j; i++) 
  {
   if (min[i] == deletevalue) 
    {
    pos = i;
    break;
    }
  }
  //delete that element from array
  for (i = pos; i < j - 1; i++) 
  {
   min[i] = min[i + 1];
  }
  //delete length of an array 
  j--;
  System.out.println("Element is deleted :- " + deletevalue);
  System.out.println("-------------------------------------------------------");
}
 public static void main(String ar[])
{
  Scanner sss = new Scanner(System.in);
  int ch;
  minheap mh = new minheap();
  while (true) 
  {
   System.out.println("Enter your choice \n");
   System.out.println("1 enter the min heap ");
   System.out.println("2 validate the min heap");
   System.out.println("3 correct the heap");
   System.out.println("4 insert into min heap ");
   System.out.println("5 delete from min heap ");
   System.out.println("6 print the min heap");
   System.out.println("7 Exit ");
   System.out.println("-------------------------------------------------------");
   ch = sss.nextInt();
   switch (ch)
   {
    case 1:
     mh.input();
     break;
    case 2:
     mh.validate();
     break;
    case 3:
     mh.validating();
     break;
    case 4:
     mh.inputheap();
     break;
    case 5:
     mh.delete();
     break;
    case 6:
     mh.printheap();
     break;
	 case 7:
     System.exit(0);
     break;
    default:
     System.out.println(" choose valid choice ");
   } //switch
  } //while
 } //main method
} //public class