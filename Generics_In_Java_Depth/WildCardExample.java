package Generics_In_Java_Depth;

import utils.Basket;
import utils.Fruits;
import utils.Vegetables;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Print{
    public void setPrintValue(List<Basket> basketList){

    }

    //Upper bound wild card
    public void setPrintValueUpperboundWildCard(List<? extends Basket> baskets){

    }

    //Lower bound wild card
    public void setPrintValueLowerBoundWildCard(List<? super Fruits> fruits){

    }

    //Wildcard type Method
    public void computeListWildCardType(List<? extends Number> source, List<? extends Number> destination){

    }

    //Generic Type Method
    public <T extends Number> void computeListGenericType(List<T> source , List<T> destination){

    }
    //Generic Type with Multiple Parameters
    public <T,K,V> void computeListGenericType(List<T> source , List<K> destination,List<V> mediate){

    }

    //InWildCard Type we can have super keyword LowerBound
    public void computeListWildCardTypeLowerBound(List<? super Number> source, List<? super Number> destination){

    }

    //Generic  Type we can't  have super keyword or LowerBound
    //comile time error
//    public <T super Number> computeListGenericTypeLowerBound(List<? super Number> source, List<? super Number> destination){
//
//    }
}



public class WildCardExample {
    public static void main(String[] args){
        List<Basket> basketList = new ArrayList<>();
        basketList.add(new Fruits("fruit","mango"));
        basketList.add(new Vegetables("vegetables","lady finger"));

        List<Fruits> fruitsList = new ArrayList<>();
        fruitsList.add(new Fruits("fruit","Banana"));

        //basketList=fruitsList; not allowed   time error

        List<Vegetables> vegetablesList = new ArrayList<>();
        vegetablesList.add(new Vegetables("vegetable","culi flower"));

        //basketList=vegetablesList;not allowed

        Print print = new Print();
        print.setPrintValue(basketList);//aloowed
        //print.setPrintValue(vegetablesList); not allowed
        //print.setPrintValue(fruitsList); not allowed

        //upperbound wildcard example, Basket class itself or it's lower class
        print.setPrintValueUpperboundWildCard(basketList);//allow
        print.setPrintValueUpperboundWildCard(fruitsList);//allow
        print.setPrintValueUpperboundWildCard(vegetablesList);//allow
        List<Object> objectList = new ArrayList<>();
        //print.setPrintValueUpperboundWildCard(objectList);not allowed Object is parent of Basket and which is upper class or parent class of Basket .

        //LowerBound wildcard example, Basket class itself or it's Upper class.
        print.setPrintValueLowerBoundWildCard(basketList); //allowed
        print.setPrintValueLowerBoundWildCard(fruitsList);//allowed
        //print.setPrintValueLowerBoundWildCard(vegetablesList); not allowed because Vegetables not inherited Class Fruit
        print.setPrintValueLowerBoundWildCard(objectList);

        Basket basket = new Vegetables("vege","potato");//totally allowed
        Basket basket2 = new Fruits("fruit","apple");//totally allowed


        //Difference Between WildCard type and Generic Type
        List<Integer> integerList = new ArrayList<>();
        List<Float> floatList = new ArrayList<>();

        print.computeListWildCardType(integerList,floatList);

       //1. print.computeListGenericType(integerList,floatList); not alowwed it only take one of the type whther it is float or integer

    }
}
