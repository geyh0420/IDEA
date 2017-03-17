namespace java com.micmiu.thrift.demo

service  HelloWorldService {
  string sayHello(1:map<i16, i64> m)
}