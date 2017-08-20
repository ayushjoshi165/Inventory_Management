import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exceptions.*;
import com.thinking.machines.inventory.dl.dao.*;
import com.thinking.machines.inventory.dl.*;
import java.util.*;
class ItemGetAllTestCase
{
public static void main(String data[])
{ 
try
{
ItemDTOInterface itemDTOInterface;
ItemDAOInterface itemDAOInterface;
itemDAOInterface=new ItemDAO();
List<ItemDTOInterface> items;
items=itemDAOInterface.getAll();
int x;
x=0;
while(x<items.size())
{
itemDTOInterface=items.get(x);
System.out.println("Code : "+itemDTOInterface.getCode());
System.out.println("Name : "+itemDTOInterface.getName());
System.out.println("Category : "+itemDTOInterface.getCategory());
System.out.println("Price : "+itemDTOInterface.getPrice());
System.out.println("-------------------------");
x++;
}
}
catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}