import com.thinking.machines.inventory.dl.interfaces.*;
import com.thinking.machines.inventory.dl.exceptions.*;
import com.thinking.machines.inventory.dl.dao.*;
import com.thinking.machines.inventory.dl.*;
import java.util.*;
class ItemCodeExistsTestCase
{
public static void main(String data[])
{
int code=Integer.parseInt(data[0]);
try
{
ItemDAOInterface itemDAOInterface;
itemDAOInterface=new ItemDAO();
System.out.println(itemDAOInterface.codeExists(code));
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}