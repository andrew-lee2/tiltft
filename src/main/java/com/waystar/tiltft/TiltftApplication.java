package com.waystar.tiltft;
import com.waystar.tiltft.service.RiotClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//FIXME add base api path here
@SpringBootApplication
@RestController
public class TiltftApplication {
//	@Value("${tiltft.riot-api-key}")
//	private String test;

	public static void main(String[] args) {
		SpringApplication.run(TiltftApplication.class, args);
	}

//	@GetMapping("/api/hello")
//	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return String.format("Hello %s %s! ", name, test);
//	}

	@GetMapping("/api/v1/tft-summoner-name")
	public void getSummonerName(@RequestParam(value = "summonerName") String summonerName) {
		RiotClient.getTFTSummonerInfo(summonerName);
	}
}