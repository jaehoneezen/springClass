package controller;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/users/{id}")
public class CharacterInfoController {
	
	@RequestMapping("/characters/{characterId}")
	// 매개변수명이 다르면 명시해주면됨 @PathVariable(매개변수명)
	public String characterInfo(@PathVariable("id") String userId, @PathVariable int characterId, ModelMap model) {
		model.addAttribute("userId", userId);
		model.addAttribute("characterId", characterId);
		return "character/users/info";
	}
}
