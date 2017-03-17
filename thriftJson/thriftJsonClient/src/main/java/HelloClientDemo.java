import org.apache.thrift.TException;
import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.util.*;

/**
 * blog http://www.micmiu.com
 *
 * @author Michael
 *
 */
public class HelloClientDemo {

    public static final String SERVER_IP = "localhost";
    public static final int SERVER_PORT = 8090;
    public static final int TIMEOUT = 30000;
    HashMap<Short, Long> m = new HashMap<Short, Long>();

    /**
     *
     * @param m2
     */
    public void startClient(Map<Short, Long> m2) {
        TTransport transport = null;
        try {
            transport = new TSocket(SERVER_IP, SERVER_PORT, TIMEOUT);
            // 协议要和服务端一致
//            TProtocol protocol = new TBinaryProtocol(transport);
            // TProtocol protocol = new TCompactProtocol(transport);
             TProtocol protocol = new TJSONProtocol(transport);
            HelloWorldService.Client client = new HelloWorldService.Client(protocol);
            transport.open();
            String result = client.sayHello(m2);
            System.out.println("Thrify client result =: " + result);
        } catch (TTransportException e) {
            e.printStackTrace();
        } catch (TException e) {
            e.printStackTrace();
        } finally {
            if (null != transport) {
                transport.close();
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Map<Short, Long> m1 = new HashMap<Short, Long>();
        HelloClientDemo client = new HelloClientDemo();
        m1.put((short)1,(long)2);
        m1.put((short)3,(long)4);
        client.startClient(m1);

    }

}