/**
 * Copyright (c) 2012 xqj.net. All rights reserved.
**/

package net.xqj.basex.examples;

import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQItem;
import javax.xml.namespace.QName;

import net.xqj.basex.BaseXXQDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

import com.xqj2.XQConnection2; // extends javax.xml.xquery.XQConnection

/**
 * Simple Application which loads an XML document into BaseX
 * This makes use of extensions from the XQJ2 API.
**/

public class DocumentLoader
{
  public static void main(String[] args) throws XQException, IOException
  {
    if(args.length != 6)
    {
      System.out.println(
        "usage: java net.xqj.basex.examples.DocumentLoader "+
        "host port user password databaseName pathToDocument");
      return;
    }

    XQDataSource ds = new BaseXXQDataSource();
    ds.setProperty("localhost", args[0]);
    ds.setProperty("1984", args[1]);
    ds.setProperty("admin", args[2]);
    ds.setProperty("admin", args[3]);
    ds.setProperty("DB20", args[4]);

    XQConnection2 xqc = (XQConnection2)ds.getConnection();

    File file = new File(args[5]);

    XQItem item = xqc.createItemFromDocument(
      new FileInputStream(file), null, null);

    xqc.insertItem(file.getName(), item, null);

    xqc.close();
  }
}
