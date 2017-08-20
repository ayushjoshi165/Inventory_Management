package com.thinking.machines.inventory.dl.dao;
import com.thinking.machines.inventory.dl.dto.*;
import com.thinking.machines.inventory.dl.exceptions.*;
import com.thinking.machines.inventory.dl.interfaces.*;
import java.io.*;
import java.util.*;
public class ItemDAO implements ItemDAOInterface
{
private static final String dataFileName="item.data";
private static final String tempDataFileName="temp.data";
public void add(ItemDTOInterface itemDTOInterface) throws DAOException
{
try
{
File file= new File(dataFileName);
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
int code;
String name;
String category;
int price;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
code=Integer.parseInt(randomAccessFile.readLine());
name=randomAccessFile.readLine();
category=randomAccessFile.readLine();
price=Integer.parseInt(randomAccessFile.readLine());
if(code==itemDTOInterface.getCode())
{
randomAccessFile.close();
throw new DAOException("Code : "+itemDTOInterface.getCode()+" exists.");
}
if(name.equalsIgnoreCase(itemDTOInterface.getName()))
{
randomAccessFile.close();
throw new DAOException("Name : "+itemDTOInterface.getName()+" exists. ");
}
}
randomAccessFile.writeBytes(String.valueOf(itemDTOInterface.getCode()));
randomAccessFile.writeBytes("\n");
randomAccessFile.writeBytes(itemDTOInterface.getName());
randomAccessFile.writeBytes("\n");
randomAccessFile.writeBytes(itemDTOInterface.getCategory());
randomAccessFile.writeBytes("\n");
randomAccessFile.writeBytes(String.valueOf(itemDTOInterface.getPrice()));
randomAccessFile.writeBytes("\n");
randomAccessFile.close();
}catch(IOException ioException)
{
System.out.println("Package : com.thinking.machines.inventory.dl.dao");
System.out.println("Class : ItemDTO");
System.out.println("Method : public void add(ItemDTOIntarface itemDTOInterface) throws DAOEXception : "+ioException.toString());
}
}

public void update(ItemDTOInterface itemDTOInterface) throws DAOException
{
try
{
File file=new File(dataFileName);
if(file.exists()==false)
{ 
throw new DAOException("Invalid item : "+itemDTOInterface.getName());
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(dataFileName,"rw");
if(randomAccessFile.length()==0)
{
randomAccessFile.close();
throw new DAOException("Invalid item : "+itemDTOInterface.getName());
} 
int code;
String name;
String category;
int price;
boolean found=false;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{ 
code=Integer.parseInt(randomAccessFile.readLine());
name=randomAccessFile.readLine();
category=randomAccessFile.readLine();
price=Integer.parseInt(randomAccessFile.readLine());
if(found==false && code==itemDTOInterface.getCode())
{
found=true;
} 
if(code!=itemDTOInterface.getCode() && name.equalsIgnoreCase(itemDTOInterface.getName()))
{
randomAccessFile.close();
throw new DAOException("Name : "+itemDTOInterface.getName()+" exists.");
}
}
if(found==false)
{
randomAccessFile.close();
throw new DAOException("Invalid item code : "+itemDTOInterface.getCode());
}
randomAccessFile.seek(0);
File tempFile=new File(tempDataFileName);
if(tempFile.exists()) tempFile.delete();
RandomAccessFile tempRandomAccessFile;
tempRandomAccessFile=new RandomAccessFile(tempFile,"rw");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
code=Integer.parseInt(randomAccessFile.readLine());
name=randomAccessFile.readLine();
category=randomAccessFile.readLine();
price=Integer.parseInt(randomAccessFile.readLine());
if(code!=itemDTOInterface.getCode())
{
tempRandomAccessFile.writeBytes(code+"\n");
tempRandomAccessFile.writeBytes(name+"\n");
tempRandomAccessFile.writeBytes(category+"\n");
tempRandomAccessFile.writeBytes(price+"\n");
} 
else
{
tempRandomAccessFile.writeBytes(String.valueOf(itemDTOInterface.getCode()));
tempRandomAccessFile.writeBytes("\n");
tempRandomAccessFile.writeBytes(itemDTOInterface.getName());
tempRandomAccessFile.writeBytes("\n");
tempRandomAccessFile.writeBytes(itemDTOInterface.getCategory());
tempRandomAccessFile.writeBytes("\n");
tempRandomAccessFile.writeBytes(String.valueOf(itemDTOInterface.getPrice()));
tempRandomAccessFile.writeBytes("\n");
}
}
randomAccessFile.seek(0);
tempRandomAccessFile.seek(0);
while(tempRandomAccessFile.getFilePointer()<tempRandomAccessFile.length())
{
randomAccessFile.writeBytes(tempRandomAccessFile.readLine()+"\n");
}
randomAccessFile.setLength(tempRandomAccessFile.length());
tempRandomAccessFile.setLength(0);
randomAccessFile.close();
tempRandomAccessFile.close();
}catch(IOException ioException)
{
System.out.println("Package : com.thinking.machines.inventory.dl.dao");
System.out.println("Class : ItemDTO");
System.out.println("Method : public void update(ItemDTOInterface itemDTOInterface) throws DAOException");
}
}

public void delete(int code) throws DAOException
{ 
try
{
File file=new File(dataFileName);
if(file.exists()==false)
{ 
throw new DAOException("Invalid item code : "+code);
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(dataFileName,"rw");
if(randomAccessFile.length()==0)
{
randomAccessFile.close();
throw new DAOException("Invalid item code : "+code);
}
int vCode;
boolean found=false;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vCode=Integer.parseInt(randomAccessFile.readLine());
randomAccessFile.readLine();
randomAccessFile.readLine();
randomAccessFile.readLine();
if(found==false && code==vCode)
{
found=true;
break;
}
} 
if(found==false)
{
randomAccessFile.close();
throw new DAOException("Invalid item code : "+code);
}
randomAccessFile.seek(0);
File tempFile=new File(tempDataFileName);
if(tempFile.exists()) tempFile.delete();
RandomAccessFile tempRandomAccessFile;
tempRandomAccessFile=new RandomAccessFile(tempFile,"rw");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vCode=Integer.parseInt(randomAccessFile.readLine());
if(code!=vCode)
{ 
tempRandomAccessFile.writeBytes(vCode+"\n");
for(int x=1;x<=3;x++) tempRandomAccessFile.writeBytes(randomAccessFile.readLine()+"\n");
}
else
{
for(int x=1;x<=3;x++) randomAccessFile.readLine();
}
}
randomAccessFile.seek(0);
tempRandomAccessFile.seek(0);
while(tempRandomAccessFile.getFilePointer()<tempRandomAccessFile.length())
{
randomAccessFile.writeBytes(tempRandomAccessFile.readLine()+"\n");
}
randomAccessFile.setLength(tempRandomAccessFile.length());
tempRandomAccessFile.setLength(0);
randomAccessFile.close();
tempRandomAccessFile.close();
}catch(IOException ioException)
{
System.out.println("Package : com.thinking.machines.inventory.dl.dao");
System.out.println("Class : ItemDTO");
System.out.println("Method : public void delete(int code) throws DAOException");
}
}

public ItemDTOInterface get(int code) throws DAOException
{ 
try
{
File file=new File(dataFileName);
if(file.exists()==false)
{ throw new DAOException("Invalid item code : "+code);
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()==0)
{
randomAccessFile.close();
throw new DAOException("Invalid item code : "+code);
} 
int vCode;
ItemDTOInterface itemDTOInterface;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vCode=Integer.parseInt(randomAccessFile.readLine());
if(vCode==code)
{ 
itemDTOInterface=new ItemDTO();
itemDTOInterface.setCode(code);
itemDTOInterface.setName(randomAccessFile.readLine());
itemDTOInterface.setCategory(randomAccessFile.readLine());
itemDTOInterface.setPrice(Integer.parseInt(randomAccessFile.readLine()));
randomAccessFile.close();
return itemDTOInterface;
} 
else
{
for(int x=1;x<=3;x++) randomAccessFile.readLine();
}
}
randomAccessFile.close();
}catch(IOException ioException)
{
System.out.println("Package : com.thinking.machines.inventory.dl.dao");
System.out.println("Class : ItemDTO");
System.out.println("Method : public ItemDTOInterface get(int code) throws DAOException");
}
throw new DAOException("Invalid item code : "+code);
}

public List<ItemDTOInterface> getAll() throws DAOException
{
List<ItemDTOInterface> items=null;
try
{
File file=new File(dataFileName);
if(file.exists()==false)
{ 
throw new DAOException("No items");
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
if(randomAccessFile.length()==0)
{
randomAccessFile.close();
throw new DAOException("No items");
}
ItemDTOInterface itemDTOInterface;
items=new ArrayList<ItemDTOInterface>();
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{ 
itemDTOInterface=new ItemDTO();
itemDTOInterface.setCode(Integer.parseInt(randomAccessFile.readLine()));
itemDTOInterface.setName(randomAccessFile.readLine());
itemDTOInterface.setCategory(randomAccessFile.readLine());
itemDTOInterface.setPrice(Integer.parseInt(randomAccessFile.readLine()));
items.add(itemDTOInterface);
}
randomAccessFile.close();
}catch(IOException ioException)
{
System.out.println("Package : com.thinking.machines.inventory.dl.dao");
System.out.println("Class : ItemDTO");
System.out.println("Method : public List<ItemDTOInterface> getAll() throws DAOException");
}
return items;
}

public int getCount() throws DAOException
{ 
int count=0;
try
{
File file=new File(dataFileName);
if(file.exists()==false) return count;
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
randomAccessFile.readLine();
count++;
}
randomAccessFile.close();
count=count/4;
}catch(IOException ioException)
{
System.out.println("Package : com.thinking.machines.inventory.dl.dao");
System.out.println("Class : ItemDTO");
System.out.println("Method : public int getCount() throws DAOException");
}
return count;
}


public boolean codeExists(int code) throws DAOException
{ 
try
{
File file=new File(dataFileName);
if(file.exists()==false)
{
return false;
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(dataFileName,"rw");
if(randomAccessFile.length()==0)
{
randomAccessFile.close();
return false;
}
int vCode;
String name;
String category;
int price;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{
vCode=Integer.parseInt(randomAccessFile.readLine());
name=randomAccessFile.readLine();
category=randomAccessFile.readLine();
price=Integer.parseInt(randomAccessFile.readLine());
if(code==vCode)
{
randomAccessFile.close();
return true;
}
}
randomAccessFile.close();
return false;
}catch(IOException ioException)
{
System.out.println("Package : com.thinking.machines.inventory.dl.dao");
System.out.println("Class : ItemDTO");
System.out.println("Method : public boolean codeExists(int code) throws DAOException");
}
return false;
}

public boolean nameExists(String name) throws DAOException
{ 
try
{
File file=new File(dataFileName);
if(file.exists()==false)
{
return false;
}
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(dataFileName,"rw");
if(randomAccessFile.length()==0)
{
randomAccessFile.close();
return false;
} 
int code;
String vName;
String category;
int price;
while(randomAccessFile.getFilePointer()<randomAccessFile.length())
{ 
code=Integer.parseInt(randomAccessFile.readLine());
vName=randomAccessFile.readLine();
category=randomAccessFile.readLine();
price=Integer.parseInt(randomAccessFile.readLine());
if(name.equalsIgnoreCase(vName))
{
randomAccessFile.close();
return true;
}
}
randomAccessFile.close();
return false;
}catch(IOException ioException)
{
System.out.println("Package : com.thinking.machines.inventory.dl.dao");
System.out.println("Class : ItemDTO");
System.out.println("Method : public boolean nameExists(String name) throws DAOException");
}
return false;
}
}