package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

	@Autowired
	@Qualifier("RESTFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println(">> TennisCoach : inside default constructor");
	}
	
	@PostConstruct
	public void doMyStartStuff() {
		System.out.println(">> TennisCoach : inside of doMyStartStuff()");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> TennisCoach : inside of doMyCleanupStuff()");
	}

	/*
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService")FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside constructor using @autowired and @qualifier");
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	/*
	@Autowired
	public void doSomeCrazyStuff(@Qualifier("happyFortuneService")FortuneService fortuneService) {
		System.out.println(">> TennisCoach : inside doSomeCrazyStuff() method");
		this.fortuneService = fortuneService;
	}
	*/

}
