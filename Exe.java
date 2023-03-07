package NetworkProject;

import java.net.*;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Exe {

	public static void Bin() 

	{
		Binary Binary = new Binary();
		System.out.println("");
		Binary.getBin("alpr");
		Binary.getInput();  // 
		
	}
	
	public static int[] binbinSayýlar = new int[] {32768,16384,8192,4096,2048,1024,512,256,128,64,32,16,8,4,2,1}; // classical 8
	public static int[] binbinBölen = new int[16]; // classical 8
	public static int[] binbinKalan = new int[16]; // classical 8
	public static int[] binbinBinary = new int[16]; // classical 8
	public static int[] binbinMultipleBy2 = new int[16]; // classical 8

	public static int count=0;
	
	public void sayý(int sayý,int bölen) {
		
		try 
		{
			
			if(sayý<bölen) {
				binbinBölen[count] = 0;
				binbinKalan[count] = sayý;
				count++;
				sayý(sayý,bölen/2);
			}
			else {

				//System.out.println("Sayý % Bölen : "+ sayý%bölen); // sayý ile bölümden KALAN  = A
				//System.out.println("Sayý / Bölen : "+ sayý/bölen); // içinde kaç adet bu sayýdan var = B
				
				int A = sayý%bölen;
				int B = sayý/bölen;
				
				if(B==0 && A>0) {
					sayý(sayý,bölen/2);
				}
				
				System.out.println("Sayý : "+ ((B*bölen)+A));
				
				
				if(bölen!=1)
				{
					
					
					if (B>1) {
						binbinBölen[count] = bölen;
						binbinMultipleBy2[count] = 1;
						binbinKalan[count]= ((B*bölen)+A)-(bölen*2);
						count++;
						sayý(((B*bölen)+A)-(bölen*2),bölen/2);
					}
					else if(B==1) {
						binbinBölen[count] = bölen;
						binbinMultipleBy2[count] = 0;
						binbinKalan[count] = A;
						count++;
						sayý((A),bölen/2);
					}
					
					
					
					
				}
				else 
				{
					binbinBölen[count] = bölen;
					binbinKalan[count]= A;
					count++;
				}
			
				
				
				
				
			}
			}
		catch(Exception e) {
			System.out.println("E : "+e);
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Sayýlar : "+ Arrays.toString(binbinSayýlar));
		System.out.println("Bölen : "+ Arrays.toString(binbinBölen));
		System.out.println("Kalan : "+ Arrays.toString(binbinKalan));

	}
	public void TestCase(int girilenSay) {
		for(int i=0;i<binbinBölen.length;i++) {
		
		if(binbinBölen[i] == binbinSayýlar[i]) 
		{
			binbinBinary[i]= 1;
		}
		else {
			binbinBinary[i]=0;
		}
		
	}
	System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
	System.out.println("Sayýlar : "+ Arrays.toString(binbinSayýlar));
	System.out.println(" ");
	System.out.println("Binary Representation for Number (1) : "+Arrays.toString(binbinBinary));
	System.out.println("Ýki ile çarpýlanlar (2)              : "+ Arrays.toString(binbinMultipleBy2));
	System.out.println("");
	
	
	int TOTAL=0;
	for(int j=0;j<binbinBinary.length;j++) {
		if(binbinBinary[j]==1) 
		{
			if(binbinMultipleBy2[j]==1) {
				TOTAL+=binbinBölen[j]*2;
			}
			else {
				TOTAL+=binbinBölen[j];
			}
			
		}
	}
	System.out.println("TEST CASE : "+TOTAL);
	if(TOTAL == girilenSay) {
		System.out.println("Test Status : PASSED");
	}
	else {
		System.out.println("Test Status : FAILED");
	}
	}
	
	public static void main(String[] args) throws IOException 
	{
		
		Exe x = new Exe();
		Scanner scan = new Scanner(System.in);
		System.out.println("Bir sayý girin :");
		int girilenSayý = scan.nextInt();
		
		
		x.sayý(girilenSayý,32768); // max (131069,32768) for 4 byte storage can represent 131069 value
		
		x.TestCase(girilenSayý);
		
		
		
	}
}

