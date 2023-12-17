package com.cumtb.bank.service;

import com.cumtb.bank.entity.*;
import com.cumtb.bank.repository.*;

import java.time.LocalDateTime;

public class AccountService {
    private CardRepository cardRepository;
    private User_AccoutRepository userAccoutRepository;
    private CardActiveRepository cardActiveRepository;
    private TradeInfoRepository tradeInfoRepository;
    private UserRepository userRepository;
    //创建用户
    public Card CreateCard(Card card,Integer uid) {
        // 检查是否存在具有相通carid的用户
        Card existingUser = cardRepository.findByCid(card.getCid());
        Card existingUser1 = cardRepository.findByCardID(card.getCardID());
        // 保存
        if (existingUser == null&& existingUser1 ==null) {
            cardRepository.save(card);
            userAccoutRepository.save(new User_Account(uid,card.getCid()));
            return card;
        }
        return null;
    }
    //取款
    public CardActive withdrawal(Integer cid,float money){
        CardActive cardActive=cardActiveRepository.findByCid(cid);
        if(cardActive==null)return null;
        float NowMoney=cardActive.getBalance();
        if(NowMoney<money)return null;
        cardActive.setBalance(NowMoney - money);
        return cardActiveRepository.save(cardActive);
        }
    //活期存款
    public CardActive current_deposit(Integer cid,float money){
        CardActive cardActive=cardActiveRepository.findByCid(cid);
        if(cardActive==null)return null;
        float NowMoney=cardActive.getBalance();
        cardActive.setBalance(NowMoney + money);
        return cardActiveRepository.save(cardActive);

    }
    //修改密码
    public Card change_password(String cardid, String newPassword) {
        Card card = cardRepository.findByCardID(cardid);
        if (card != null && !card.getPassword().equals(newPassword)) {
            card.setPassword(newPassword);
            return cardRepository.save(card);
        }
        return null;
    }
    public TradeInfo transfer(String cardid1, String cardid2, float money) {
        Card card1 = cardRepository.findByCardID(cardid1);
        Card card2 = cardRepository.findByCardID(cardid2);
        if (card2 == null || card1 == null) return null;

        User_Account userAccount1 = userAccoutRepository.findByCid(card1.getCid());
        User_Account userAccount2 = userAccoutRepository.findByCid(card2.getCid());
        User user1 = userRepository.findByUid(userAccount1.getUid());
        User user2 = userRepository.findByUid(userAccount2.getUid()); // 修正此处的拼写错误

        LocalDateTime tradeTime = LocalDateTime.now(); // 当前时间戳
        // 假设 TradeInfo 有一个构造函数或设置方法
        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setFromName(user1.getName());
        tradeInfo.setFromCard(card1.getCardID());
        tradeInfo.setToName(user2.getName());
        tradeInfo.setToCard(card2.getCardID());
        tradeInfo.setMoney(money);
        tradeInfo.setTime(tradeTime);
        tradeInfo.setType(1);

        tradeInfo = tradeInfoRepository.save(tradeInfo);
        return tradeInfo;
    }


}
