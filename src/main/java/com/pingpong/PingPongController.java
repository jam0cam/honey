package com.pingpong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * User: jitse
 * Date: 7/23/13
 * Time: 9:36 PM
 */
@Controller
@RequestMapping("/tt")
public class PingPongController {

    @Autowired
    private PingPongDao dao;


    @RequestMapping(value="/newGame", method = RequestMethod.GET)
    public @ResponseBody
    ModelAndView main () {
        Game command = new Game();

        List<Player> players = dao.getPlayers();

        command.setPlayer1(players.get(1));
        command.setPlayer2(players.get(0));

        return new ModelAndView("pingpong/pingpong", "command", command);
    }


    @InitBinder
    public void registerDateBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value= "/save", method=RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("command")Game command, BindingResult result) {

        if (result.hasErrors()) {
            return new ModelAndView("pingpong/pingpong", "command", command);
        }

        //by this point, we know the input is numeric
        if (command.getPlayer1Score() + command.getPlayer2Score() != 5) {
            result.rejectValue("player1Score", "invalid.scores.total");
            return new ModelAndView("pingpong/pingpong", "command", command);
        }

        dao.insertGame(command);
        return new ModelAndView("redirect:/tt");
    }

}
