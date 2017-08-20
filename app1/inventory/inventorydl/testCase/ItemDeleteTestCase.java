import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exceptions.*;
import com.thinking.machines.inventory.dl.dto.*;
import com.thinking.machines.inventory.dl.dao.*;
public class ItemDeleteTestCase
{
public static void main(String data[])
{
int code=Integer.parseInt(data[0]);
ItemDAOInterface itemDAOInterface;
itemDAOInterface=new ItemDAO();
try
{ 
itemDAOInterface.delete(code);
System.out.println("Item deleted");
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}