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
	
	public static int[] binbinSay�lar = new int[] {32768,16384,8192,4096,2048,1024,512,256,128,64,32,16,8,4,2,1}; // classical 8
	public static int[] binbinB�len = new int[16]; // classical 8
	public static int[] binbinKalan = new int[16]; // classical 8
	public static int[] binbinBinary = new int[16]; // classical 8
	public static int[] binbinMultipleBy2 = new int[16]; // classical 8

	public static int count=0;
	
	public void say�(int say�,int b�len) {
		
		try 
		{
			
			if(say�<b�len) {
				binbinB�len[count] = 0;
				binbinKalan[count] = say�;
				count++;
				say�(say�,b�len/2);
			}
			else {

				//System.out.println("Say� % B�len : "+ say�%b�len); // say� ile b�l�mden KALAN  = A
				//System.out.println("Say� / B�len : "+ say�/b�len); // i�inde ka� adet bu say�dan var = B
				
				int A = say�%b�len;
				int B = say�/b�len;
				
				if(B==0 && A>0) {
					say�(say�,b�len/2);
				}
				
				System.out.println("Say� : "+ ((B*b�len)+A));
				
				
				if(b�len!=1)
				{
					
					
					if (B>1) {
						binbinB�len[count] = b�len;
						binbinMultipleBy2[count] = 1;
						binbinKalan[count]= ((B*b�len)+A)-(b�len*2);
						count++;
						say�(((B*b�len)+A)-(b�len*2),b�len/2);
					}
					else if(B==1) {
						binbinB�len[count] = b�len;
						binbinMultipleBy2[count] = 0;
						binbinKalan[count] = A;
						count++;
						say�((A),b�len/2);
					}
					
					
					
					
				}
				else 
				{
					binbinB�len[count] = b�len;
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
		System.out.println("Say�lar : "+ Arrays.toString(binbinSay�lar));
		System.out.println("B�len : "+ Arrays.toString(binbinB�len));
		System.out.println("Kalan : "+ Arrays.toString(binbinKalan));

	}
	public void TestCase(int girilenSay) {
		for(int i=0;i<binbinB�len.length;i++) {
		
		if(binbinB�len[i] == binbinSay�lar[i]) 
		{
			binbinBinary[i]= 1;
		}
		else {
			binbinBinary[i]=0;
		}
		
	}
	System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
	System.out.println("Say�lar : "+ Arrays.toString(binbinSay�lar));
	System.out.println(" ");
	System.out.println("Binary Representation for Number (1) : "+Arrays.toString(binbinBinary));
	System.out.println("�ki ile �arp�lanlar (2)              : "+ Arrays.toString(binbinMultipleBy2));
	System.out.println("");
	
	
	int TOTAL=0;
	for(int j=0;j<binbinBinary.length;j++) {
		if(binbinBinary[j]==1) 
		{
			if(binbinMultipleBy2[j]==1) {
				TOTAL+=binbinB�len[j]*2;
			}
			else {
				TOTAL+=binbinB�len[j];
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
		System.out.println("Bir say� girin :");
		int girilenSay� = scan.nextInt();
		
		
		x.say�(girilenSay�,32768); // max (131069,32768) for 4 byte storage can represent 131069 value
		
		x.TestCase(girilenSay�);
		
		
		
	}
}

