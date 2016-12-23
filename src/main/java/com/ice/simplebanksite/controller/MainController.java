package com.ice.simplebanksite.controller;

import com.ice.simplebanksite.dao.TransactionDAO;
import com.ice.simplebanksite.dao.TransactionDAOImpl;
import com.ice.simplebanksite.model.Balance;
import com.ice.simplebanksite.model.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartek on 2016-12-14.
 */
@Controller
public class MainController {

    @Autowired
    TransactionDAO transactionDAO;

    @RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("title", "Welcome");
        model.addAttribute("message", "This is welcome page!");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model ) {

        return "loginPage";
    }
//--------------------------------------------------------------------------------
    @RequestMapping(value = "/transactions", method =  RequestMethod.GET)
    public String transactionPage(Model model, Authentication auth)
    {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>(auth.getAuthorities());
        boolean user = true;
        for(GrantedAuthority ga : authorities)
        {
            if(ga.getAuthority().compareTo("ROLE_ADMIN") == 0)
            {
                List<Transactions> transactions = transactionDAO.getAllUsersTransactionsList();
                model.addAttribute("transactions", transactions);
                return "transactionsAdmin";
            }
        }

        List<Transactions> transactions = transactionDAO.getTransactionsList(auth.getName());
        model.addAttribute("transactions", transactions);

        return "transactions";
    }

    @RequestMapping(value = "/transactionsAdmin/{id}", method =  RequestMethod.GET)
    public String transactionAdminPage(@PathVariable("id") String id, Model model)
    {
        transactionDAO.changeTransactionStatus(id);
        return "redirect:/transactions";
    }

    @RequestMapping(value = "/addTransaction", method =  RequestMethod.GET)
    public String addTransactionPageGET(Model model, Authentication auth)
    {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>(auth.getAuthorities());

        for(GrantedAuthority ga : authorities)
        {
            if(ga.getAuthority().compareTo("ROLE_ADMIN") == 0) return "transactionsAdmin";
        }
        model.addAttribute("transaction", new Transactions());
        return "addTransaction";
    }

    @RequestMapping(value = "/addTransaction", method =  RequestMethod.POST)
    public String addTransaction(@ModelAttribute("transaction") Transactions transaction, Model model, Authentication auth)
    {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>(auth.getAuthorities());

        for(GrantedAuthority ga : authorities)
        {
            if(ga.getAuthority().compareTo("ROLE_ADMIN") == 0) return "transactionsAdmin";
        }
        transaction.setUser(auth.getName());
        System.out.println(transactionDAO.createTransaction(transaction));
        return "redirect:/transactions";
    }
//--------------------------------------------------------------------------------
    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        String userName = principal.getName();
        Balance balance = transactionDAO.getBalance(userName);

        model.addAttribute("username", userName);
        model.addAttribute("balance", balance);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "403";
    }
}