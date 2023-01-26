import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import tech.strategio.Product;
import tech.strategio.ProductNotFoundException;
import tech.strategio.ShoppingCart;

public class myTest {

    ShoppingCart cart;
    Product egg;
    Product milk;


    @BeforeEach
    public void createCartAndProducts(){
        cart = new ShoppingCart();
        egg = new Product("egg", 1.0);
        milk = new Product("milk", 2.0);
    }

    @Test
    public void emptyAfterCreated(){
        assertEquals(0, cart.getItemCount(),.001);
    }

    @Test
    public void rightNumberAfterAdded(){
        cart.addItem(egg);
        cart.addItem(egg);
        cart.addItem(milk);
        cart.addItem(milk);
        assertEquals(4, cart.getItemCount());
    }

    @Test
    public void rightCountAfterEmpty(){
        cart.addItem(egg);
        cart.addItem(milk);
        cart.addItem(milk);
        cart.empty();
        assertEquals(0, cart.getItemCount());
    }

    @Test
    public void rightBalanceAfterAdded(){
        cart.addItem(egg);
        cart.addItem(milk);
        cart.addItem(milk);
        assertEquals(5.0, cart.getBalance(),.001);
        cart.addItem(milk);
        cart.addItem(milk);
        assertEquals(9.0, cart.getBalance(),.001);
    }

    @Test
    public void rightNumberAfterRemoved(){
        cart.addItem(egg);
        cart.addItem(egg);
        cart.addItem(milk);
        cart.addItem(milk);
        assertEquals(4, cart.getItemCount());
        try{
            cart.removeItem(egg);
            cart.removeItem(milk);
        }catch(Exception e){
            e.printStackTrace();
        }
        assertEquals(2, cart.getItemCount(),.001);
    }

    @Test
    public void throwingProductNotFoundException(){
        cart.addItem(egg);
        cart.addItem(egg);
        Exception e = assertThrows(ProductNotFoundException.class, () -> {
            cart.removeItem(milk);
        }, "wat should be an expection here! why you're removing the inexist product?");

    }
/*
 *
 @Test
 public void anotherWayException(){
     cart.addItem(egg);
     cart.addItem(egg);
     try{
         cart.removeItem(milk);
         fail("You're trying to remove something inexist but you looks successfully removed! Fantasic!");
     }catch(Exception e){
         assertNotNull(e,"the exception thrown shouldn't be null");
     }
 }
 *
 */

    // @Test
    // public void sayHello(){
    //     System.out.println("yeah");
    // }
}
