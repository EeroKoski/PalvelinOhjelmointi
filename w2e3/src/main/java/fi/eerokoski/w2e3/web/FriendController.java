package fi.eerokoski.w2e3.web;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import fi.eerokoski.w2e3.domain.Friend;

@Controller
public class FriendController {
	
	
	@GetMapping("/index")
	public String addNewFriend(Model model) {
		model.addAttribute("friend", new Friend(""));
		return "addFriend";
				
	}
	

	
	
	public String showFriends(Model model) {
		
		ArrayList<Friend> friendList = new ArrayList<Friend>();

		friendList.add(new Friend(""));
		
		
		System.out.println(friendList);
	
		model.addAttribute("friends", friendList);
		return "friends";
		}
	}
		
	

