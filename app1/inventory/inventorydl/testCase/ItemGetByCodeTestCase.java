import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exceptions.*;
import com.thinking.machines.inventory.dl.dto.*;
import com.thinking.machines.inventory.dl.dao.*;
public class ItemGetByCodeTestCase
{
public static void main(String data[])
{ 
int code=Integer.parseInt(data[0]);
ItemDTOInterface itemDTOInterface;
ItemDAOInterface itemDAOInterface;
itemDAOInterface=new ItemDAO();
try
{ 
itemDTOInterface=itemDAOInterface.get(code);
System.out.println("Name : "+itemDTOInterface.getName());
System.out.println("Category : "+itemDTOInterface.getCategory());
System.out.println("Price : "+itemDTOInterface.getPrice());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}