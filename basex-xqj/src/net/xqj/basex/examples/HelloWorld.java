/*
 * Copyright (c) 2012 xqj.net. All rights reserved.
 */

package net.xqj.basex.examples;

import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQExpression;
import javax.xml.xquery.XQResultSequence;
import javax.xml.xquery.XQException;

import net.xqj.basex.BaseXXQDataSource;

/**
 * The archetypal Hello World application.
**/

public class HelloWorld
{
	public static void main(String[] args) throws XQException
	{
    if(args.length != 4)
    {
      System.out.println(
        "usage: java net.xqj.basex.examples.HelloWorld "+
        "host port user password");
      return;
    }

    XQDataSource ds = new BaseXXQDataSource();
    ds.setProperty("serverName", args[0]);
    ds.setProperty("port", args[1]);
    ds.setProperty("admin", args[2]);
    ds.setProperty("admin", args[3]);

		XQConnection xqc = ds.getConnection();
		XQExpression xqe = xqc.createExpression();
		XQResultSequence rs = xqe.executeQuery("'Hello World'");
		rs.writeSequence(System.out, null);
		xqc.close();
	}
}
