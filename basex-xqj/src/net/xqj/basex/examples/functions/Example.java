package net.xqj.basex.examples.functions;
import javax.xml.namespace.QName;
import javax.xml.xquery.*;
import java.util.*;
import net.xqj.basex.BaseXXQDataSource;

    public class Example{
      public static void main(String[] args) throws Exception {
        XQDataSource xqs = new BaseXXQDataSource();
        xqs.setProperty("serverName", "localhost");
        xqs.setProperty("port", "1984");
        Scanner teclat = new Scanner(System.in);
        // Change USERNAME and PASSWORD values
        XQConnection conn = xqs.getConnection("admin", "admin");

        XQPreparedExpression xqe = conn.prepareExpression(
                "for $religio in collection('DB200') "+
                   "where contains(document-uri($religio),'mondial.xml') "+
                   "return "+
                   "insert node <religions percentatge=\"0\">Pastafari</religions> " +
                   "before $religio//country[name=\"Spain\"]/languages[1]"
        );

        /*try {
          xqe.bindAtomicValue(new QName("lletra"),
                  lletra,
                  conn.createAtomicType(XQItemType.XQBASETYPE_STRING)
          );
          xqe.bindAtomicValue(new QName("continent"),
                  continent,
                  conn.createAtomicType(XQItemType.XQBASETYPE_STRING)
          );
        } catch (XQException e){
          throw new Exception("El número introdueix és erroni");
        }*/
        XQResultSequence rs = xqe.executeQuery();

        while(rs.next())
          System.out.println(rs.getItemAsString(null));
    
        conn.close();
      }
    }