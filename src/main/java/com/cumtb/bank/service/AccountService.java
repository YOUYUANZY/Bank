package com.cumtb.bank.service;

import com.cumtb.bank.entity.Card;
import com.cumtb.bank.entity.CardActive;
import com.cumtb.bank.entity.user_account;
import com.cumtb.bank.repository.CardActiveRepository;
import com.cumtb.bank.repository.CardRepository;
import com.cumtb.bank.repository.User_AccoutRepository;

public class AccountService {
    private CardRepository cardRepository;
    private User_AccoutRepository userAccoutRepository;
    private CardActiveRepository cardActiveRepository;
    //创建用户
    public Card CreateCard(Card card,Integer uid) {
        // 检查是否存在具有相通carid的用户
        Card existingUser = cardRepository.findByCid(card.getCid());
        Card existingUser1 = cardRepository.findByCardID(card.getCardID());
        // 保存
        if (existingUser == null&& existingUser1 ==null) {
            cardRepository.save(card);
            userAccoutRepository.save(new user_account(uid,card.getCid()));
            return card;
        }
        return null;
    }
    //取款
    public boolean withdrawal(Integer cid,float money){
        CardActive cardActive=cardActiveRepository.findByCid(cid);
        float NowMoney=cardActive.getBalance();
        if(money>NowMoney)return false;
        else {
            cardActive.setBalance(NowMoney - money);
            cardActiveRepository.save(cardActive);
            return  true;
        }
    }
    //活期存款
    public boolean current_deposit(Integer cid,float money){
        CardActive cardActive=cardActiveRepository.findByCid(cid);
        float NowMoney=cardActive.getBalance();
            cardActive.setBalance(NowMoney + money);
            cardActiveRepository.save(cardActive);
            return  true;
    }
}
