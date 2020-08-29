package com.infosys.learning.threads.synchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TokenGeneratorMain {

	public static void main(String[] args) throws InterruptedException {
		TokenGenerator tokenGenerator = new TokenGenerator();
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		for(int i=1; i<=10; i++) {
			executor.submit(()-> {tokenGenerator.generateToken();});
		}
		executor.awaitTermination(20, TimeUnit.MILLISECONDS);
		System.out.println(tokenGenerator.getToken());
		
		for(int i=1; i<=10; i++) {
			executor.submit(()-> {TokenGenerator.generateStaticToken();});
		}
		executor.awaitTermination(20, TimeUnit.MILLISECONDS);
		System.out.println(TokenGenerator.staticToken);
		
		/*
		 * Random random = new Random(); IntStream.range(0, 20).forEach(count->{
		 * System.out.println(random.nextInt(10)); });
		 */
		executor.shutdown();
	}
}