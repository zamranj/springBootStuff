package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SkillsController {

   @GetMapping()
   @ResponseBody
   public String listLanguages(){

       return "<h1> Skills Tracker</h1>"+
               "<h2>We have a few skills we would like to learn.Here is the list!</h2>"+
               "<ol>"+
               "<li>Java</li>"+
               "<li>JavaScript</li>"+
               "<li>Python</li>"+
               "</ol>";
   }

   @GetMapping("form")
    @ResponseBody
    public String getForm(){
       return "<form method='post'>"
               +"<h3>Name:</h3>"
               +"<input name ='name'/>"
               +"<h3>My first favorite language</h3>"
               +"<select name= 'firstChoice'>"
                   +"<option value='Java'>Java</option>"
                   +"<option value='JavaScript'>JavaScript</option>"
                   +"<option value='Python'>Python</option>"
               +"</select>"
               +"<h3>My second favorite language</h3>"
               +"<select name= 'secondChoice'>"
                   +"<option value='Java'>Java</option>"
                   +"<option value='JavaScript'>JavaScript</option>"
                   +"<option value='Python'>Python</option>"
               +"</select>"
               +"<h3>My third favorite language</h3>"
               +"<select name= 'thirdChoice'>"
                   +"<option value='Java'>Java</option>"
                   +"<option value='JavaScript'>JavaScript</option>"
                   +"<option value='Python'>Python</option>"
               +"</select>"
               +"<br>"
               +"<br>"
               +"<input type='submit' value='Submit'/>"
               +"</form>"
               ;
   }
   @PostMapping("form")
    public String submitForm(@RequestParam String name, @RequestParam String firstChoice,
                             @RequestParam String secondChoice,@RequestParam String thirdChoice){
        return "redirect:/results/" + name+"/"+firstChoice+"/"+secondChoice+"/"+thirdChoice;

   }

   @GetMapping("results/{name}/{firstChoice}/{secondChoice}/{thirdChoice}")
    @ResponseBody
    public String displayResults(@PathVariable String name, @PathVariable String firstChoice, @PathVariable String secondChoice,
                                @PathVariable String thirdChoice){

       return "<h2>"+name+"'s favorite programing languages"+"</h2>"+
               "<ol>" +
               "<table border='1'>" +
                "<tr>" +
                    "<th>Choice</th>" +
                    "<th>Language</th>" +
                "</tr>" +
                "<tr>" +
                   "<th>1</th>" +
                   "<th>"+firstChoice+"</th>" +
               "</tr>" +
               "<tr>" +
                   "<th>2</th>" +
                   "<th>"+secondChoice+"</th>" +
               "</tr>" +
               "<tr>" +
                   "<th>3</th>" +
                   "<th>"+thirdChoice+"</th>" +
               "</tr>" +
               "</table>";


   }


}
