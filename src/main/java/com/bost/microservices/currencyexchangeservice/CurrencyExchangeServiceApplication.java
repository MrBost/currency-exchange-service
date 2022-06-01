package com.bost.microservices.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
//		List<Integer> nums1 = new ArrayList<>();
//		nums1.add(2);
//		List<Integer> nums2 = new ArrayList<>();
//		nums2.add(3);
//		nums2.add(7);
//		nums2.add(4);
//		List<Integer> items = items(nums1, nums2);
//		System.out.println(items.toString());
//		System.out.println("123Array "+_123Array(new int[]{1,2,3},3));
//		System.out.println("fibonacci "+closestFibonacci(12));
//		System.out.println("isOnion "+isOnionArray(new int[]{1,2,19,4,5}));
	}

	public static int isOnionArray(int[] a){
		int result = 0;

//		for(int j=0,k=1; j<a.length && k<a.length;j++,k++){
		for(int j=0; j<a.length ;j++){
			int k = a[a.length-j-1];
//			System.out.println("j "+a[j]+" ");
//			System.out.println(" ");
//			System.out.println("k "+a[k]);
			int sum = j+k+1;
			System.out.println("sum "+sum);
			if(j>=0 && k>=0 && j+k+1==a.length && j!=k){
				boolean b = a[j] + a[k] <= 10;
				if(b){
					result = 1;
					System.out.println("less than 10 "+a[j] + a[k]);
				}

			}
		}
		return result;
	}
	public static int closestFibonacci(int n){
		int result =0;
		if(n<1) return result;
		for(int i=0;i<n;i++){
			int fib = i - 2 + i - 1;

			if(fib<=n){
				result = fib;
			}

		}
		return result;
	}

	public static int _123Array(int a[], int len){
		int result = 0;
		for(int i=0;i<len;i++){
			int firstEl = a[0];
			int secondEl = a[1];
			int thirdEl = a[2];
			if(firstEl == 1 && secondEl == 2 && thirdEl == 3){
				result = 1 ;
			}else if(firstEl+3 == firstEl &&
					secondEl+3 ==secondEl && thirdEl+3 == thirdEl){
				result = 1 ;
			}else{
				result = 0;
			}

		}
		return result;
	}

	public static List<Integer> items(List<Integer> nums1,List<Integer> nums2){
		List<Integer> finalList = new ArrayList<>();
		for(int i=nums1.size();i<nums2.size();i++){
			nums1.add(0);
		}
		System.out.println("nums1 "+nums1.toString());
		finalList.addAll(nums1);
		for(int i=nums2.size();i<nums1.size();i++){
			nums2.add(0);
		}
		System.out.println("nums2 "+nums2.toString());
		finalList.addAll(nums2);
		return finalList;
	}
}
