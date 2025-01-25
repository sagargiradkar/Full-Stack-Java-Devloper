package in.ineuron.controller;

import in.ineuron.controller.service.IWishMessageService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class WishMessageController {

    @Autowired
    private IWishMessageService service;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String showHomePage(){
        return "home";//String ----> LVN
    }

    /*@RequestMapping(value = "/wish",method = RequestMethod.GET)
    public ModelAndView showWishMessage(){
        //call service to get the information
        String msg = service.generateWishMessage();
        //Send the data from controller to view
        ModelAndView mav = new ModelAndView();
        mav.addObject("msg",msg);
        mav.setViewName("display");

        return mav; //ViewName ---> LVN
    }*/
/*
    @RequestMapping(value = "/wish",method = RequestMethod.GET)
    public String showWishMessage(Model model){
        System.out.println("Implementation class name is :: "+model.getClass().getName());
        String msg = service.generateWishMessage();
        model.addAttribute(msg);
        return "display";
    }*/
/*

    @RequestMapping(value = "/wish",method = RequestMethod.GET)
    public String showWishMessage(Map<String, Objects> model){
        System.out.println("Implementation class name is :: "+model.getClass().getName());
        String msg = service.generateWishMessage();
        model.put("msg",msg);
        return "display";
    }
*/
/*

    @RequestMapping(value = "/wish",method = RequestMethod.GET)
    public void showWishMessage(Map<String, Objects> model){
        System.out.println("Implementation class name is :: "+model.getClass().getName());
        Object msg = service.generateWishMessage();
        model.put("msg",msg);
        return ;
    }
*/
  /*
    @RequestMapping(value = "/wish",method = RequestMethod.GET)
    public void generateMessage(HttpServletResponse response) throws IOException {
        String wmg = service.generateWishMessage();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<b> Wish Message ::"+wmg+"<br>");
    }

*/


    @RequestMapping(value = "/wish",method = RequestMethod.GET)
    public Map<String,Object> generateMessage() throws IOException {
        Object msg = service.generateWishMessage();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("msg",msg);
        return map;
    }


}
