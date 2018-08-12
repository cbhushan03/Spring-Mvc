package com.cbt.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class TwitterClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitterClientApplication.class, args);
	}
	
	protected SpringApplicationBuilder config(SpringApplicationBuilder application){
		return application.sources(TwitterClientApplication.class);
	}
}


@RestController
@RequestMapping(TwitterController.PATH)
class TwitterController {
	
	public static final String PATH="/tweets";
	
	@Autowired
	private Twitter twitter;
	
	@RequestMapping(value="{hashTag}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> getTweets(@PathVariable final String hashTag){
		return twitter.searchOperations().search(hashTag,20).getTweets();
		
	}
	
	@RequestMapping(path="/timeline",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> getTweets(){
		return twitter.timelineOperations().getUserTimeline("cbhusha00782");
	}
}

