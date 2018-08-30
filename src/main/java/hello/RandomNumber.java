package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DAO.UserDAO;

@RestController
public class RandomNumber {

	@RequestMapping("/randomNumber")
	public Map<String, List<Dice>> generateRandomDice() {

		List<Dice> dice = new ArrayList<Dice>();
		
		Map<String, List<Dice>> map =new HashMap<String, List<Dice>>();
		
		for(int i = 1; i <= 3; i++) {
			Random r = new Random();
			Dice d = new Dice();
			d.setName("Dice " + i);
			d.setNumber(r.nextInt(6)+1);
			dice.add(d);
		}
		
		UserDAO UserDAO = new UserDAO();
		
		UserDAO.insertDice(dice);
		
		map.put("dice", dice);
		
		return map;
	}
}
