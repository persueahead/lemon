package com.bjlemon.utiles;

/**
 * 描述状态码的
 */
public class ThisCode {


    // OBJ_CODE="0",可用的数据     在职
    // NO_CODE="1";  不可用的数据  删除 (离职)
public  static final   String  OBJ_CODE="0", NO_CODE="1";

	/*

				<option value="3" ${expense.expenseState=='3'?'selected':'' }>经理审核通过</option>
				<option value="4" ${expense.expenseState=='4'?'selected':'' }>财务审核通过</option>
				<option value="-3" ${ea.expenseState=='-3'?'selected':'' }>经理审核未通过</option>
				<option value="-4" ${expense.expenseState=='-4'?'selected':''}>财务审核未通过</option>
				<option value="0" ${ea.expenseState=='0'?'selected':'' }>保存未提交</option>
				<option value="1" ${expense.expenseState=='1'?'selected':''}>保存已提交</option>*/

	public static final String SAVE_OK="1",SAVE_NO="0",MANAGER_NOT_VIEW="2",MANAGER_OK="3",MANAGER_NO="-3",
                                    FINANCE_OK="4",FINANCE_NO="-4";
}
