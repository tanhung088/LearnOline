using OnlineShop_CoreMVC_TongHop.Models;
using OnlineShop_CoreMVC_TongHop.Reponsitory.Admin;

namespace OnlineShop_CoreMVC_TongHop.Reponsitory
{
	public class AdminImp : IAdmin
	{
		private DatabaseContext _dbContext;

		//khoi tao ham dung constructor non parm
		public AdminImp(DatabaseContext dbContext)
		{
			_dbContext = dbContext;
		}
		public void CreateUser(User user)
		{
			_dbContext.Users.Add(user);
			_dbContext.SaveChanges();
		}

		public void DeleteUser(int id)
		{
			var user = _dbContext.Users.SingleOrDefault(u => u.User_Id.Equals(id));
			if (user != null)
			{
				_dbContext.Users.Remove(user);
				_dbContext.SaveChanges();
			}
			else
			{
				Console.WriteLine("Khong tim thay product de delete!!!");
			}
		}

		public List<User> GetAllUsers()
		{
			var listPro = _dbContext.Users.ToList();
			return listPro;
		}

		public User GetUser(int id)
		{
			var user = _dbContext.Users.SingleOrDefault(u => u.User_Id.Equals(id));
			return user;
		}

		public void UpdateUser(User userUpdate)
		{
			//dua tren 1 product da lay va tao 1 product tu trong db ma co id giong voi product lay ben view
			var user = _dbContext.Users.SingleOrDefault(u => u.User_Id.Equals(userUpdate.User_Id));
			if (user != null)
			{
				user.User_Name = userUpdate.User_Name;
				user.Email = userUpdate.Email;
				user.Password = userUpdate.Password;
				user.Role = userUpdate.Role;
				_dbContext.SaveChanges();
			}
		}
	}
}
