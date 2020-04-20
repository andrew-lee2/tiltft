package com.waystar.tiltft;
import com.waystar.tiltft.service.RiotClient;
import com.waystar.tiltft.service.TftSummonerMatchIds;
import com.waystar.tiltft.service.TftSummonerV1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@RequestMapping("/api/v1")
public class TiltftApplication {
	public static void main(String[] args) {
		SpringApplication.run(TiltftApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hello!!!!!";
	}

	@GetMapping("/tft-summoner-name")
	public TftSummonerV1 getSummonerName(@RequestParam(value = "summonerName") String summonerName) {
		return RiotClient.getTFTSummonerInfo(summonerName);
	}

	@GetMapping("/tft-summoner-match-ids")
	public TftSummonerMatchIds getTftSummonerMatchIds(@RequestParam(value = "puuid") String puuid) {
		return RiotClient.getTftSummonerMatchIds(puuid);
	}
}