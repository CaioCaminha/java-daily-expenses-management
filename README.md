# Java Daily-Expenses Manager

  ### Base Structure Action Items:

 - Implement Controller - Start with WebFlux Functional Web Framework - Reducing Annotations overhead ?
 - Implement UseCase and Domain base package with all ports and contracts
 - Finish OpenAI WebClient implementation
 - Implement configuration with database - Decide between postgres and mongodb (mongo would probably the easier one, also would be good to study also for work)
 - Implement Spring Transaction Manager ( Study Spring Framework transaction management)
 - Configure TestContainers 
 - Implement Unit and Integration tests


## Transaction API
| CSV / PDF Input                                                                                | JSON Input                                                               | WebHook Whatsapp API                                   |
|------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------|--------------------------------------------------------|
| Implement OpenAI Gateway to get Categories based on Transaction's description                  | Create RequestHandler and UseCase to receive TransactionDetails directly | To be Defined how to configure WebHook to Whatsapp API |
| Implement RequestHandler and UseCase to receive MultiPartFile or similar                       | Save details on mongoDB                                                  | ------                                                 |
| Implement MongoDB Gateway and save transactionDetails                                          | -------                                                                  | ------                                                 |
| Maybe export to GoogleWorkspace Spreadsheet once a month with a detailed statement of expenses | -------                                                                  | ------                                                 |

 ### Tech Debts / Improvements:
 - Replace Functional Web Client for Undertow - Performance Improvement.
   - Evaluate if it's actually a performance improvement

 ### Topics to study:

 - [Spring's Task Executor and @Async with virtual threads](https://docs.spring.io/spring-framework/reference/integration/scheduling.html#scheduling-task-executor-types)  - DONE
 - [Emmbracing Virtual Threads - Spring](https://spring.io/blog/2022/10/11/embracing-virtual-threads) - DONE
 - [Java Servlet Technology](https://docs.oracle.com/javaee/5/tutorial/doc/bnafd.html)
 - WebClient / WebFlux Configuration and core concepts
 - Spring IoC Container and Beans
 - Spring Data and Spring Data Mongo