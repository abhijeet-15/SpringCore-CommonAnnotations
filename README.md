### Common Annotations

- **@Component**
This annotation tells Spring to create a bean of the class to which it is added. It scans all the classes 
mentioned in the base-package and if *@Component* annotation is used, it creates a 
bean for it.
- 
```java
import org.springframework.stereotype.Component;

@Component("razorpayObj")
public class RazorpayPaymentGateway implements PaymentGateWay{
    @Override
    public void makePayment() {
        System.out.println("making payment using razorpay");
    }
```
Add the below in *beans.xml*:
```xml
 <context:component-scan base-package="com.abhijeetsingh" />
```

- To define the base package using Java and not XML, create a configuration class.
- In this class, use the annotation **@Configuration** and **@ComponentScan(base package)
```java
package com.abhijeetsingh.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.abhijeetsingh")
public class PaymentGatewayConfig {
}
```
- Update the Client class to use:
```java
//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(PaymentGatewayConfig.class);
```