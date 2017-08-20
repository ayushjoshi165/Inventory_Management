package com.thinking.machines.inventory.dl.interfaces;
public interface ItemDTOInterface extends Comparable<ItemDTOInterface>,java.io.Serializable
{
public void setCode(int code);
public int getCode();
public void setName(String name);
public String getName();
public void setCategory(String category);
public String getCategory();
public void setPrice(int price);
public int getPrice();
}