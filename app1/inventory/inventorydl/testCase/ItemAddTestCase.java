import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exceptions.*;
import com.thinking.machines.inventory.dl.dto.*;
import com.thinking.machines.inventory.dl.dao.*;
public class ItemAddTestCase
{
public static void main(String data[])
{ 
int code=Integer.parseInt(data[0]);
String name=data[1];
String category=data[2];
int price=Integer.parseInt(data[3]);
ItemDTOInterface itemDTOInterface;
itemDTOInterface=new ItemDTO();
itemDTOInterface.setCode(code);
itemDTOInterface.setName(name);
itemDTOInterface.setCategory(category);
itemDTOInterface.setPrice(price);
ItemDAOInterface itemDAOInterface;
itemDAOInterface=new ItemDAO();
try
{ 
itemDAOInterface.add(itemDTOInterface);
System.out.println("Item added");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}