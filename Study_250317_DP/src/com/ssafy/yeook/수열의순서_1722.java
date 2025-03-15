package com.ssafy.yeook;
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class 수열의순서_1722 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		LinkedList<BigInteger>list = new LinkedList<>(); //1부터 n까지 저장.
		for(int i = 1;i<=n;i++) {
			list.add(new BigInteger(String.valueOf(i)));
		}
		st= new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());//소문제 번호
		
		BigInteger [] fac = new BigInteger[21]; //20까지의 팩토리얼 저장. 
		fac[0] = BigInteger.ZERO;
		fac[1] = BigInteger.ONE;
		for(int i = 2;i<=20;i++) {
			fac[i] = fac[i-1].multiply(new BigInteger(String.valueOf(i)));
		}
		
		StringBuilder result = new StringBuilder();
		
		if(num==1) {
			
			BigInteger k = new BigInteger(st.nextToken()).subtract(BigInteger.ONE); //k=k-1
		
				
			while(k.compareTo(BigInteger.ZERO)==1) { //k>0;
				BigInteger facn=fac[list.size()-1];
				if(k.compareTo(facn)==1||k.compareTo(facn)==0) {//k>=(list.size()-1)!;
					int i=k.divide(facn).intValue();
					k=k.mod(facn);
					result.append(list.remove(i)).append(" ");
				}else {
					result.append(list.removeFirst()).append(" ");
				}
			}
			while(list.size()>0){
				result.append(list.removeFirst()).append(" ");
			}

			//n==2
		}else {
			BigInteger k = BigInteger.ONE; //몇번째인지.
			BigInteger facn;
			while(st.hasMoreTokens()) {
				facn=fac[list.size()-1];
				BigInteger value = new BigInteger(st.nextToken());
				BigInteger index = new BigInteger(String.valueOf(list.indexOf(value)));
				k=k.add(facn.multiply(index));
				list.remove(value);
			}
			result.append(k.toString());
		}
		bw.write(result.toString().trim());
		bw.flush();
		
		
		
	}

}

