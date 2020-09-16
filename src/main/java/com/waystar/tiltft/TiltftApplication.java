package com.waystar.tiltft;
import com.waystar.tiltft.service.*;
import org.json.JSONException;
import org.json.JSONObject;
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

	@GetMapping("/tft-summoner-name")
	public TftSummonerV1 getSummonerName(
			@RequestParam(value = "summonerName") String summonerName,
			@RequestParam(value = "region") String region
	) {
		return RiotClient.getTFTSummonerInfo(summonerName, region);
	}

	@GetMapping("/tft-summoner-match-ids")
	public String[] getTftSummonerMatchIds(
			@RequestParam(value = "puuid") String puuid,
			@RequestParam(value = "region") String region
	) {
		return RiotClient.getTftSummonerMatchIds(puuid, region);
	}

	@GetMapping("/tft-match-info")
	public TftMatchStats getTftMatchInfo(
			@RequestParam(value = "matchId") String matchId,
			@RequestParam(value = "region") String region
	) {
		return RiotClient.getTftMatchInfo(matchId, region);
	}

	@GetMapping("/tft-summoner-rating")
	public String getTiltftSummonerHistory(
			@RequestParam(value = "summonerName") String summonerName,
			@RequestParam(value = "region") String region
	) throws JSONException {
		Double rating = TiltftData.getTiltftRating(summonerName, region);
		JSONObject jsonString = new JSONObject();
		jsonString.put("rating", rating);

		return jsonString.toString();
	}
}