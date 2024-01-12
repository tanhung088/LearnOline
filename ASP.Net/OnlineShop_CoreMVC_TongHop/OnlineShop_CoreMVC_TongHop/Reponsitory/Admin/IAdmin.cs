using OnlineShop_CoreMVC_TongHop.Models;

namespace OnlineShop_CoreMVC_TongHop.Reponsitory.Admin
{
	public interface IAdmin
	{
		List<User> GetAllUsers();

		//
		User GetUser(int id);
		void CreateUser(User user);

		void UpdateUser(User user);

		void DeleteUser(int id);
	}
}
