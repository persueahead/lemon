package com.bj.spring.serivce;

import com.bj.spring.dao.UsersDao;
import org.hamcrest.core.Is;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 夜神
 */
public class UsersSerivceImp03 implements  UsersSerivce{
    private UsersDao   usersdao;
 /*   private TransactionTemplate  transactionTemplate;
    private TransactionTemplate  transactionTemplate;*/

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation =  Propagation.REQUIRED,readOnly = false)
    public void getTestSpring(Integer id1, Integer id2, Integer money) {

                usersdao.addMoney(id1,money);
               //System.out.println(1 / 0);
                usersdao.updateMoney(id2,money);

    }

    public UsersDao getUsersao() {
        return usersdao;
    }

    public void setUsersdao(UsersDao usersdao) {
        this.usersdao = usersdao;
    }

 /*   public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }*/
}
