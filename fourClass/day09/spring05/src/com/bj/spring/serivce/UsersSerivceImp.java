package com.bj.spring.serivce;

import com.bj.spring.dao.UsersDao;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class UsersSerivceImp  implements  UsersSerivce{
    private UsersDao   usersdao;
    private TransactionTemplate  transactionTemplate;

    @Override
    public void getTestSpring(Integer id1, Integer id2, Integer money) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                usersdao.addMoney(id1, money);
                //System.out.println(1 / 0);
                usersdao.updateMoney(id2, money);
            }
        });

    }

    public UsersDao getUsersdao() {
        return usersdao;
    }

    public void setUsersdao(UsersDao usersdao) {
        this.usersdao = usersdao;
    }

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }
}
