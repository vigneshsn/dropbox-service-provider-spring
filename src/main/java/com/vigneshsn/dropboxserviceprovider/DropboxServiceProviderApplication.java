package com.vigneshsn.dropboxserviceprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DropboxServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DropboxServiceProviderApplication.class, args);
	}

}

//@Component
//class AppRunner implements ApplicationRunner {
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		DropBoxService dbService = new DropBoxService();
//		//dbService.testApi();
//		Random random = new Random();
//		dbService.uploadFile("/test_v"+ random.nextInt());
//	}
//}
