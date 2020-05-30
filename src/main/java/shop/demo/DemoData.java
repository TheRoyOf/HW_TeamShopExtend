package shop.demo;

import shop.Goods;
import shop.employee.StoreKeeper;
import shop.enums.EBrand;
import shop.enums.EDepartment;
import shop.enums.EGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class DemoData {

    public static void addGoodsToStorage(int count, StoreKeeper storeKeeper)
    {
        List<Goods> goods = new ArrayList<>();
        for (int i = 0; i<count; ++i)
        {
            goods.add(generateRandomGoods());
        }
        storeKeeper.receiveShipment(goods);
    }

    private static Goods generateRandomGoods()
    {
        String [] name = {"яблоко","груша","капуста","динамит","пуля","пистолет","наркотики","штаны","шорты","футболка","трусы","ноутбук"};

        EBrand eBrand = EBrand.values()[ThreadLocalRandom.current().nextInt(0,EBrand.values().length)];
        EGroup eGroup = EGroup.values()[ThreadLocalRandom.current().nextInt(0,EGroup.values().length)];
        EDepartment eDepartment = EDepartment.values()[ThreadLocalRandom.current().nextInt(0,EDepartment.values().length)];

        Goods goods = new Goods(name[ThreadLocalRandom.current().nextInt(0,name.length)],
                eBrand, eGroup,eDepartment,ThreadLocalRandom.current().nextInt(0,1000),"Информация о товаре");

        return goods;
    }
}
