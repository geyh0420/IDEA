import org.apache.thrift.TException;

import java.util.Map;

/**
 * blog http://www.micmiu.com
 *
 * @author Michael
 *
 */
public class HelloWorldImpl implements HelloWorldService.Iface {

    public HelloWorldImpl() {
    }

    @Override
    public String sayHello(Map<Short, Long> m) throws TException {
        return "Hi," + m.toString() + " welcome to my blog www.micmiu.com";
    }
}