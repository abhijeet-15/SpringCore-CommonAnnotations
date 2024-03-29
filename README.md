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

- **@Beans**
- Can be added to a method to return an object of a specific type in the configuration file i.e. return type of the method
- It can take a {} _name_ that is the id of the bean. In case no name is provided, the method name with the first letter
in lowercase becomes the id of the bean
- Sub dependencies can also be added.

*RazorpayPaymentGateway.java*
```java
package com.abhijeetsingh;

import org.springframework.stereotype.Component;

//@Component("razorpayObj")
public class RazorpayPaymentGateway implements PaymentGateWay{

    private BankAccount bankAccount;

    public RazorpayPaymentGateway(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
    @Override
    public void makePayment() {
        System.out.println("making payment using razorpay");
        System.out.println("Fetching bank account details");
        System.out.println("Account id is " + bankAccount.getAccountId());
    }

    @Override
    public void cancelPayment() {
        System.out.println("cancelling payment using razorpay");
    }
}
```

*BankAccount.java*
```java
package com.abhijeetsingh;

import org.springframework.beans.factory.annotation.Value;

public class BankAccount {

    @Value("${BANK_ACCOUNT_ID}")
    private long accountId;

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public long getAccountId() {
        return this.accountId;
    }

}
```

*PaymentGatewayConfig.java*
```java
package com.abhijeetsingh.config;

import com.abhijeetsingh.BankAccount;
import com.abhijeetsingh.PaymentGateWay;
import com.abhijeetsingh.RazorpayPaymentGateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan(basePackages = "com.abhijeetsingh")
@PropertySource("classpath:JDBC-Info.properties")

public class PaymentGatewayConfig {

    @Bean
    public BankAccount getBankAccountObj() {
        return new BankAccount();
    }
    @Bean(name = {"razorpayObj"})
    public PaymentGateWay getPaymentGatewayObj() {
        return new RazorpayPaymentGateway(getBankAccountObj());
    }

}
```
- Note in the above example we are using *@PropertySource("classpath:JDBC-Info.properties")* annotation to define the file 
from which the literal values should be picked and injected.

- If there are more than one implementation classes for an _interface_, **@Primary** annotation can be used to 
always select the one whose bean we want to create. Alternatively, **@Qualifier** annotation can be used to
select the implementation class object