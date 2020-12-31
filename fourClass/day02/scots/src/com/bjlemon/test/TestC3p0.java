package com.bjlemon.test;

import com.bjlemon.utiles.C3p0Util;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestC3p0 {


/*
    public static void main(String[] args) throws SQLException {
        new TestC3p0().test();
    }
*/

    /**
     *
     */

      @Test
    public   void test() throws SQLException {
        Connection conn = C3p0Util.getConn();
        System.out.println(conn);

    }

}
