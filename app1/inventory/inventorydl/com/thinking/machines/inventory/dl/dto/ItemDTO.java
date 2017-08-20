package com.thinking.machines.inventory.dl.dto;
import com.thinking.machines.inventory.dl.interfaces.*;
public class ItemDTO implements ItemDTOInterface
{
private int code;
private String name;
private String category;
private int price;
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setCategory(String category)
{
this.category=category;
}
public String getCategory()
{
return this.category;
}
public void setPrice(int price)
{
this.price=price;
}
public int getPrice()
{
return this.price;
}
public boolean equals(Object object)
{
if(!(object instanceof ItemDTOInterface)) return false;
ItemDTOInterface itemDTOInterface=(ItemDTOInterface) object;
return this.code==itemDTOInterface.getCode();
}
public int compareTo(ItemDTOInterface itemDTOInterface)
{
return this.name.compareToIgnoreCase(itemDTOInterface.getName());
}
}