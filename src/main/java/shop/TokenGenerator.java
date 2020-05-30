package shop;

import java.util.List;

public class TokenGenerator {
    public static String generateToken(List<Goods> cart){
        StringBuilder token = new StringBuilder();
        for (Goods goods : cart)
        {
            token.append(goods.getBrand().toString());
            token.insert(0, goods.getUniqueName());
            token.insert(0, goods.getDepartment());
            token.append(cart.hashCode());
        }
        return token.toString();
    }
}
