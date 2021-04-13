package ru.itsjava.services;

//@SpringBootTest
//@DisplayName("The class CoffeeServiceImpl should: ")
//public class CoffeeServiceImplTest {
//
//    @Autowired
//    CoffeeService coffeeService;
//
//    @Autowired
//    CoffeeDao coffeeDao;
//
//    @Configuration
//    static class CoffeeServiceConfiguration{


//        @Bean
//        public CoffeeServiceImpl coffeeService(){
//            return new CoffeeServiceImpl(coffeeDao());
//        }
//        @Bean
//        public CoffeeDao coffeeDao(){
//            CoffeeDao mock = Mockito.mock(CoffeeDao.class);
//            when (mock
//            .findByPrice(150.0))
//                    .thenReturn(new Coffee("Cappuccino", new Price(3L,150.0)));
//                    return mock;
//        }
//    }
//    @DisplayName("return the correct coffee name ")
//    @Test
//    public void shouldCorrectCoffeeName(){
//        String actualCoffeeName = coffeeService.getCoffeeByPrice(150.0).getName();
//        Assertions.assertEquals("Cappuccino", actualCoffeeName);
//    }
//}
