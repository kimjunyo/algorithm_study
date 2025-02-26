package com.ssafy.minji;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P34_1744_수묶기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		List<Integer> negList = new ArrayList<>();
		List<Integer> posList = new ArrayList<>();
		int sum = 0;
		boolean zero = false;
		int temp = 0;
		for (int i = 0; i < N; i++) {
			temp = Integer.parseInt(br.readLine().trim());
			if (temp > 1) {
				posList.add(temp);
			} else if(temp == 1) {
				sum += temp;
			} else if(temp == 0){
				zero = true;
			}else {
				negList.add(temp);
			}
		}
		
		Collections.sort(negList);
        Collections.sort(posList, Comparator.reverseOrder());
		
        if (negList.size() % 2 == 1) {
			for (int i = 0; i < negList.size() - 1; i += 2) {
				sum += negList.get(i) * negList.get(i + 1);
			}
			if(!zero) {
				sum += negList.get(negList.size() - 1);
			}
		} else {
			for (int i = 0; i < negList.size(); i += 2) {
				sum += negList.get(i) * negList.get(i + 1);
			}
		}

		if (posList.size() % 2 == 1) {
			for (int i = 0; i < posList.size() - 1; i += 2) {
				sum += posList.get(i) * posList.get(i + 1);
			}
			sum += posList.get(posList.size() - 1);
		} else {
			for (int i = 0; i < posList.size(); i += 2) {
				sum += posList.get(i) * posList.get(i + 1);
			}
		}
		System.out.println(sum);
	}
}
